package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_transline_length;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_transline_length的持久层
 */
public interface Hunan_transline_lengthService {
	// 分页查询
	PageBean<Hunan_transline_length> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_transline_length> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 查询所有数据
	public List<Hunan_transline_length> selectAll();

	// 根据years查询数据
	public List<Hunan_transline_length> selectByYears(Integer years);

	// 增加数据
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// 修改数据
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length);

	// 删除数据
	public void delFromHunan_transline_length(Integer years);
}
