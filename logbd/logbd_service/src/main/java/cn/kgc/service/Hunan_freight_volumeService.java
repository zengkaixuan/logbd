package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_freight_volume;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_freight_volume��ĳ־ò�
 */
public interface Hunan_freight_volumeService {
	// ��ҳ��ѯ
	PageBean<Hunan_freight_volume> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_freight_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Hunan_freight_volume> selectAll();

	// ����years��ѯ����
	public List<Hunan_freight_volume> selectByYears(Integer years);

	// ��������
	public void addIntohunan_freight_volume(
			Hunan_freight_volume hunan_freight_volume);

	// �޸�����
	public void updateFromhunan_freight_turnover_volume(
			Hunan_freight_volume hunan_freight_volume);

	// ɾ������
	public void delFromhunan_freight_volume(Integer years);
}
