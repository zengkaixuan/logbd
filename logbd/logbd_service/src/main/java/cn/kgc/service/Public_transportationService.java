package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Public_transportation;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator public_transportation的持久层
 */
public interface Public_transportationService {
	// 分页查询
	PageBean<Public_transportation> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Public_transportation> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 查询所有数据
	public List<Public_transportation> selectAll();

	// 根据years查询数据
	public List<Public_transportation> selectByYears(Integer years);

	// 增加数据
	public void addIntoPublic_transportation(
			Public_transportation public_transportation);

	// 修改数据
	public void updateFromPublic_transportation(
			Public_transportation public_transportation);

	// 删除数据
	public void delFromPublic_transportation(Integer years);
}
