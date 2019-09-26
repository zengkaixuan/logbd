package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import cn.kgc.entity.Hunan_freight_income;

/**
 * 
 * @author Administrator hunan_freight_income表的持久层
 */
public interface Hunan_freight_incomeDao {
	// 查询所有数据
	@Select("select id,city,income from hunan_freight_income")
	public List<Hunan_freight_income> selectAll();

	// 通过城市名模糊查询信息
	@Select("select id,city,income from hunan_freight_income "
			+ " where instr(city,#{city})>0")
	public List<Hunan_freight_income> selectLikeCity(@Param("city")String city);

	// 根据id查询数据
	@Select("select id,city,income from hunan_freight_income where id=#{id}")
	public List<Hunan_freight_income> selectById(@Param("id") Integer id);

	// 增加数据
	@Insert("insert into hunan_freight_income values(#{id},#{city},#{income})")
	public void addIntoHunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// 修改数据
	@Update("update hunan_freight_income set city=#{city},income=#{income} where id=#{id}")
	public void updateFromHunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// 删除数据
	@Delete(" delete from hunan_freight_income where id=#{id}")
	public void delFromHunan_freight_income(@Param("id") Integer id);
}
