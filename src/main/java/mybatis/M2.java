package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * 从XML中构建SqlSessionFactory
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年2月18日 下午1:07:39
 * 
 */
public class M2 {

	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			try {
				BsDemoMapper mapper = session.getMapper(BsDemoMapper.class);
				List<BsDemo> list = mapper.selectAll();
				System.out.println(list.size());
			} finally {
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
