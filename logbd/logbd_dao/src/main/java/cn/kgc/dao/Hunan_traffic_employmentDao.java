package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_traffic_employment;

/**
 * 
 * @author Administrator hunan_traffic_employment�ĳ־ò�
 */
public interface Hunan_traffic_employmentDao {
	// ��ѯ��������
	@Select("select * from hunan_traffic_employment")
	public List<Hunan_traffic_employment> selectAll();

	// ����years��ѯ����
	@Select("select * from hunan_traffic_employment where years=#{years}")
	public List<Hunan_traffic_employment> selectByYears(
			@Param("years") Integer years);

	// ��������
	@Insert("insert into hunan_traffic_employment values(#{years},#{railway_transportation}"
			+ ",#{highway_transportation},#{waterway_transportation},#{air_transportation},"
			+ "#{pipage_transportation}," + "#{others})")
	public void addIntoHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// �޸�����
	@Update("update hunan_traffic_employment set railway_transportation=#{railway_transportation},"
			+ "highway_transportation=#{highway_transportation},"
			+ "waterway_transportation=#{waterway_transportation},air_transportation=#{air_transportation},"
			+ "pipage_transportation=#{pipage_transportation},others=#{others}"
			+ "where years=#{years}")
	public void updateFromHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// ɾ������
	@Delete(" delete from hunan_traffic_employment where years=#{years}")
	public void delFromHunan_traffic_employment(@Param("years") Integer years);
}
