package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_pub_trans;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_pub_trans的持久层
 */
public interface Hunan_pub_transService {
	// 分页查询
	PageBean<Hunan_pub_trans> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_pub_trans> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 查询所有数据
	public List<Hunan_pub_trans> selectAll();

	// 根据years查询数据
	public List<Hunan_pub_trans> selectByYears(Integer years);

	// 增加数据
	public void addIntohunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// 修改数据
	public void updateFromhunan_pub_trans(Hunan_pub_trans hunan_pub_trans);

	// 删除数据
	public void delFromhunan_pub_trans(Integer years);
}
