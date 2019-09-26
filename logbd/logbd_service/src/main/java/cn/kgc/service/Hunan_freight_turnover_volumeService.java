package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_freight_turnover_volume;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_freight_turnover_volume��ĳ־ò�
 */
public interface Hunan_freight_turnover_volumeService {
	// ��ҳ��ѯ
	PageBean<Hunan_freight_turnover_volume> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_freight_turnover_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Hunan_freight_turnover_volume> selectAll();

	// ����years��ѯ����
	public List<Hunan_freight_turnover_volume> selectByYears(Integer years);

	// ��������
	public void addIntohunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// �޸�����
	public void updateFromhunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// ɾ������
	public void delFromhunan_freight_turnover_volume(Integer years);
}
