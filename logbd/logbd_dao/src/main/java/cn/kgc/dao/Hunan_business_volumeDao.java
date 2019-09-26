package cn.kgc.dao;

/**
 * 
 * @author Administrator
 *hunan_business_volume表的持久层
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_business_volume;

public interface Hunan_business_volumeDao {

	// 根据years查询数据
	@Select("select * from hunan_business_volume where years=#{years}")
	public List<Hunan_business_volume> selectByYears(
			@Param("years") Integer years);

	// 查询所有数据
	@Select("select * from hunan_business_volume")
	public List<Hunan_business_volume> selectAll();

	// 增加数据
	@Insert("insert into hunan_business_volume values(#{years},#{total_volume},#{other_provinces},#{province},#{international})")
	public void addIntoHunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// 修改数据
	@Update("update hunan_business_volume set total_volume=#{total_volume},other_provinces=#{other_provinces},"
			+ "province=#{province},international=#{international} where years=#{years}")
	public void updateFormHunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// 删除数据
	@Delete(" delete from hunan_business_volume where years=#{years}")
	public void delFormHunan_business_volume(@Param("years") Integer years);
}