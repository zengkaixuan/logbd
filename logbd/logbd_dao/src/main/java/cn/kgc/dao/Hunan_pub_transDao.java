package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_pub_trans;

/**
 * 
 * @author Administrator hunan_pub_trans�ĳ־ò�
 */
public interface Hunan_pub_transDao {
	// ��ѯ��������
	@Select("select * from hunan_pub_trans")
	public List<Hunan_pub_trans> selectAll();

	// ����years��ѯ����
	@Select("select * from hunan_pub_trans where years=#{years}")
	public List<Hunan_pub_trans> selectByYears(@Param("years") Integer years);

	// ��������
	@Insert("insert into hunan_pub_trans values(#{years},#{total_operations_num},#{total_transline_length},"
			+ "#{total_passengers})")
	public void addIntoHunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// �޸�����
	@Update("update hunan_pub_trans set total_operations_num=#{total_operations_num},"
			+ "total_transline_length=#{total_transline_length},"
			+ "total_passengers=#{total_passengers}" + "where years=#{years}")
	public void updateFromHunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// ɾ������
	@Delete(" delete from hunan_pub_trans where years=#{years}")
	public void delFromHunan_pub_trans(@Param("years") Integer years);
}
