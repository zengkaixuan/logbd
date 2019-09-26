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
 * @author Administrator hunan_transline_length�ĳ־ò�
 */
public interface Hunan_transline_lengthDao {
	// ��ѯ��������
	@Select("select * from hunan_transline_length")
	public List<Hunan_transline_length> selectAll();

	// ����years��ѯ����
	@Select("select * from hunan_transline_length where years=#{years}")
	public List<Hunan_transline_length> selectByYears(
			@Param("years") Integer years);

	// ��������
	@Insert("insert into hunan_transline_length values(#{years},#{railway_mileage}"
			+ ",#{highway_mileage},#{classified_highway},#{highway},"
			+ "#{primary_road},#{secondary_road},#{other_road})")
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// �޸�����
	@Update("update hunan_transline_length set railway_mileage=#{railway_mileage},"
			+ "highway_mileage=#{highway_mileage},"
			+ "classified_highway=#{classified_highway},highway=#{highway},"
			+ "primary_road=#{primary_road},secondary_road=#{secondary_road},other_road=#{other_road}"
			+ "where years=#{years}")
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// ɾ������
	@Delete(" delete from hunan_transline_length where years=#{years}")
	public void delFromHunan_transline_length(@Param("years") Integer years);
}
