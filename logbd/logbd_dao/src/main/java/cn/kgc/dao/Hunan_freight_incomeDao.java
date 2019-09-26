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
 * @author Administrator hunan_freight_income��ĳ־ò�
 */
public interface Hunan_freight_incomeDao {
	// ��ѯ��������
	@Select("select id,city,income from hunan_freight_income")
	public List<Hunan_freight_income> selectAll();

	// ͨ��������ģ����ѯ��Ϣ
	@Select("select id,city,income from hunan_freight_income "
			+ " where instr(city,#{city})>0")
	public List<Hunan_freight_income> selectLikeCity(@Param("city")String city);

	// ����id��ѯ����
	@Select("select id,city,income from hunan_freight_income where id=#{id}")
	public List<Hunan_freight_income> selectById(@Param("id") Integer id);

	// ��������
	@Insert("insert into hunan_freight_income values(#{id},#{city},#{income})")
	public void addIntoHunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// �޸�����
	@Update("update hunan_freight_income set city=#{city},income=#{income} where id=#{id}")
	public void updateFromHunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// ɾ������
	@Delete(" delete from hunan_freight_income where id=#{id}")
	public void delFromHunan_freight_income(@Param("id") Integer id);
}
