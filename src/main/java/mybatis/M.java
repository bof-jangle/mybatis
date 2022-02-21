package mybatis;

import java.util.List;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * 不使用xml文件构造SqlSessionFactory
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年2月17日 下午3:34:50
 * 
 */
public class M {

	public static void main(String[] args) {
		
		// 1、数据源
		DataSource dataSource = new DataSource();
		dataSource.setUrl("jdbc:mysql://mysql.jangle.xyz:10071/demo?characterEncoding=UTF8");
		dataSource.setUsername("jangle");
		dataSource.setPassword("2");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		/* 不使用xml文件构造SqlSessionFactory   */
		// 2、事务工厂
		JdbcTransactionFactory factory = new JdbcTransactionFactory();
		// 3、环境
		Environment environment = new Environment("dev", factory, dataSource);
		// 4、
		Configuration conf = new Configuration(environment);
		conf.addMapper(BsDemoMapper.class);
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = builder.build(conf);
		SqlSession session = sessionFactory.openSession();
		try {
			BsDemoMapper mapper = session.getMapper(BsDemoMapper.class);
			List<BsDemo> list = mapper.selectAll();
			System.out.println(list.size());
		} finally {
			session.close();
		}
	}

}
