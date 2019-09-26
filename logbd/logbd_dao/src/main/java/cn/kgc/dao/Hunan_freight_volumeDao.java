package cn.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.Hunan_freight_volume;

/**
 * 
 * @author Administrator hunan_freight_volume��ĳ־ò�
 */
public interface Hunan_freight_volumeDao {
	// ��ѯ��������
	@Select("select * from hunan_freight_volume")
	public List<Hunan_freight_volume> selectAll();

	// ����years��ѯ����
	@Select("select * from hunan_freight_volume where years=#{years}")
	public List<Hunan_freight_volume> selectByYears(
			@Param("years") Integer years);

	// ��������
	@Insert("insert into hunan_freight_volume values(#{years},#{total},#{total_railway},"
			+ "#{national_railway},#{local_railway},#{joint_venture_railway},#{highway},#{waterway})")
	public void addIntoHunan_freight_volume(
			Hunan_freight_volume hunan_freight_volume);

	// �޸�����
	@Update("update hunan_freight_volume set total=#{total},total_railway=#{total_railway},"
			+ "national_railway=#{national_railway},local_railway=#{local_railway},"
			+ "joint_venture_railway=#{joint_venture_railway},highway=#{highway},waterway=#{waterway} where years=#{years}")
	public void updateFormHunan_freight_turnover_volume(
			Hunan_freight_volume hunan_freight_volume);

	// ɾ������
	@Delete(" delete from hunan_freight_volume where years=#{years}")
	public void delFormHunan_freight_volume(@Param("years") Integer years);
}
