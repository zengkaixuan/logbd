package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_freight_income;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_freight_income表的持久层
 */
public interface Hunan_freight_incomeService {
	// 分页查询
	PageBean<Hunan_freight_income> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_freight_income> queryByCondition(Integer pageNo,
			Integer pageSize, String city);

	// 查询所有数据
	public List<Hunan_freight_income> selectAll();

	// 通过城市名模糊查询信息
	public List<Hunan_freight_income> selectLikeCity(String city);

	// 根据id查询数据
	public List<Hunan_freight_income> selectById(Integer id);

	// 增加数据
	public void addIntohunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// 修改数据
	public void updateFromhunan_freight_income(
			Hunan_freight_income hunan_freight_income);

	// 删除数据
	public void delFromhunan_freight_income(Integer id);
}
