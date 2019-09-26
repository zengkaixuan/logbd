package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_freight_income;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_freight_income��ĳ־ò�
 */
public interface Hunan_freight_incomeService {
	// ��ҳ��ѯ
	PageBean<Hunan_freight_income> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_freight_income> queryByCondition(Integer pageNo,
			Integer pageSize, String city);

	// ��ѯ��������
	public List<Hunan_freight_income> selectAll();

	// ͨ��������ģ����ѯ��Ϣ
	public List<Hunan_freight_income> selectLikeCity(String city);

	// ����id��ѯ����
	public List<Hunan_freight_income> selectById(Integer id);

	// ��������
	public void addIntohunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// �޸�����
	public void updateFromhunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// ɾ������
	public void delFromhunan_freight_income(Integer id);
}
