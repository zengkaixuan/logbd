package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Public_transportation;

/**
 * 
 * @author Administrator public_transportation的持久层
 */
public interface Public_transportationDao {
	// 查询所有数据
	@Select("select * from public_transportation")
	public List<Public_transportation> selectAll();

	// 根据years查询数据
	@Select("select * from public_transportation where years=#{years}")
	public List<Public_transportation> selectByYears(
			@Param("years") Integer years);

	// 增加数据
	@Insert("insert into public_transportation values(#{years},#{total_vehicles}"
			+ ",#{operating_passenger_capacity},#{operating_cargo_capacity})")
	public void addIntoPublic_transportation(
			Public_transportation public_transportation);

	// 修改数据
	@Update("update public_transportation set total_vehicles=#{total_vehicles},"
			+ "operating_passenger_capacity=#{operating_passenger_capacity},"
			+ "operating_cargo_capacity=#{operating_cargo_capacity} where years=#{years}")
	public void updateFromPublic_transportation(
			Public_transportation public_transportation);

	// 删除数据
	@Delete(" delete from public_transportation where years=#{years}")
	public void delFromPublic_transportation(@Param("years") Integer years);
}
