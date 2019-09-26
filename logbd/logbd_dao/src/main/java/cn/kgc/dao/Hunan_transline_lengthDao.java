package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_transline_length;

/**
 * 
 * @author Administrator hunan_transline_length的持久层
 */
public interface Hunan_transline_lengthDao {
	// 查询所有数据
	@Select("select * from hunan_transline_length")
	public List<Hunan_transline_length> selectAll();

	// 根据years查询数据
	@Select("select * from hunan_transline_length where years=#{years}")
	public List<Hunan_transline_length> selectByYears(
			@Param("years") Integer years);

	// 增加数据
	@Insert("insert into hunan_transline_length values(#{years},#{railway_mileage}"
			+ ",#{highway_mileage},#{classified_highway},#{highway},"
			+ "#{primary_road},#{secondary_road},#{other_road})")
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// 修改数据
	@Update("update hunan_transline_length set railway_mileage=#{railway_mileage},"
			+ "highway_mileage=#{highway_mileage},"
			+ "classified_highway=#{classified_highway},highway=#{highway},"
			+ "primary_road=#{primary_road},secondary_road=#{secondary_road},other_road=#{other_road}"
			+ "where years=#{years}")
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// 删除数据
	@Delete(" delete from hunan_transline_length where years=#{years}")
	public void delFromHunan_transline_length(@Param("years") Integer years);
}
