package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_freight_turnover_volume;

/**
 * 
 * @author Administrator hunan_freight_turnover_volume表的持久层
 */
public interface Hunan_freight_turnover_volumeDao {
	// 查询所有数据
	@Select("select * from hunan_freight_turnover_volume")
	public List<Hunan_freight_turnover_volume> selectAll();

	// 根据years查询数据
	@Select("select * from hunan_freight_turnover_volume where years=#{years}")
	public List<Hunan_freight_turnover_volume> selectByYears(
			@Param("years") Integer years);

	// 增加数据
	@Insert("insert into hunan_freight_turnover_volume values(#{years},#{total_railway},#{national_railway},"
			+ "#{local_railway},#{joint_venture_railway},#{highway},#{waterway})")
	public void addIntoHunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// 修改数据
	@Update("update hunan_freight_turnover_volume set total_railway=#{total_railway},national_railway=#{national_railway},"
			+ "local_railway=#{local_railway},joint_venture_railway=#{joint_venture_railway},highway=#{highway},waterway=#{waterway} where years=#{years}")
	public void updateFromHunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// 删除数据
	@Delete(" delete from hunan_freight_turnover_volume where years=#{years}")
	public void delFromHunan_freight_turnover_volume(
			@Param("years") Integer years);
}
