package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_freight_turnover_volume;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_freight_turnover_volume表的持久层
 */
public interface Hunan_freight_turnover_volumeService {
	// 分页查询
	PageBean<Hunan_freight_turnover_volume> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_freight_turnover_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 查询所有数据
	public List<Hunan_freight_turnover_volume> selectAll();

	// 根据years查询数据
	public List<Hunan_freight_turnover_volume> selectByYears(Integer years);

	// 增加数据
	public void addIntohunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// 修改数据
	public void updateFromhunan_freight_turnover_volume(
			Hunan_freight_turnover_volume hunan_freight_turnover_volume);

	// 删除数据
	public void delFromhunan_freight_turnover_volume(Integer years);
}
