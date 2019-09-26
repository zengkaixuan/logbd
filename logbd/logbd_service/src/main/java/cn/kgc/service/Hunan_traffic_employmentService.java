package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_traffic_employment;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_traffic_employment�ĳ־ò�
 */
public interface Hunan_traffic_employmentService {
	// ��ҳ��ѯ
	PageBean<Hunan_traffic_employment> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_traffic_employment> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Hunan_traffic_employment> selectAll();

	// ����years��ѯ����
	public List<Hunan_traffic_employment> selectByYears(Integer years);

	// ��������
	public void addIntoHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// �޸�����
	public void updateFromHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// ɾ������
	public void delFromHunan_traffic_employment(Integer years);
}
