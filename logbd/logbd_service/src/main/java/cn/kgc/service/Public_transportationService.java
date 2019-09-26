package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Public_transportation;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator public_transportation�ĳ־ò�
 */
public interface Public_transportationService {
	// ��ҳ��ѯ
	PageBean<Public_transportation> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Public_transportation> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Public_transportation> selectAll();

	// ����years��ѯ����
	public List<Public_transportation> selectByYears(Integer years);

	// ��������
	public void addIntoPublic_transportation(
			Public_transportation public_transportation);

	// �޸�����
	public void updateFromPublic_transportation(
			Public_transportation public_transportation);

	// ɾ������
	public void delFromPublic_transportation(Integer years);
}
