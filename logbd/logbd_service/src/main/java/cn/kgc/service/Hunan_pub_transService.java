package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_pub_trans;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_pub_trans�ĳ־ò�
 */
public interface Hunan_pub_transService {
	// ��ҳ��ѯ
	PageBean<Hunan_pub_trans> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_pub_trans> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Hunan_pub_trans> selectAll();

	// ����years��ѯ����
	public List<Hunan_pub_trans> selectByYears(Integer years);

	// ��������
	public void addIntohunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// �޸�����
	public void updateFromhunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// ɾ������
	public void delFromhunan_pub_trans(Integer years);
}
