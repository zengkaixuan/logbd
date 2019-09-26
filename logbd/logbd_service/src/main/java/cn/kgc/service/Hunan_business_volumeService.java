package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_business_volume;
import cn.kgc.utils.PageBean;

public interface Hunan_business_volumeService {
	// ��ҳ��ѯ
	PageBean<Hunan_business_volume> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_business_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ����years��ѯ����
	public List<Hunan_business_volume> selectByYears(Integer years);

	// ��ѯ��������
	public List<Hunan_business_volume> selectAll();

	// ��������
	public void addIntohunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// �޸�����
	public void updateFromhunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// ɾ������
	public void delFromhunan_business_volume(Integer years);
}
