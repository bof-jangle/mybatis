package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年2月18日 上午10:33:39
 * 
 */
public interface BsDemoMapper {
	
	@Select("select * from bs_demo")
	List<BsDemo> selectAll();

}
