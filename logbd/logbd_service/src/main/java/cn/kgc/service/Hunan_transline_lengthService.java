package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_transline_length;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_transline_length�ĳ־ò�
 */
public interface Hunan_transline_lengthService {
	// ��ҳ��ѯ
	PageBean<Hunan_transline_length> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<Hunan_transline_length> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// ��ѯ��������
	public List<Hunan_transline_length> selectAll();

	// ����years��ѯ����
	public List<Hunan_transline_length> selectByYears(Integer years);

	// ��������
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// �޸�����
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// ɾ������
	public void delFromHunan_transline_length(Integer years);
}
