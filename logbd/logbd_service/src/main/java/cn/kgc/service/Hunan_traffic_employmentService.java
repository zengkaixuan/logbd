package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_traffic_employment;
import cn.kgc.utils.PageBean;

/**
 * 
 * @author Administrator hunan_traffic_employment的持久层
 */
public interface Hunan_traffic_employmentService {
	// 分页查询
	PageBean<Hunan_traffic_employment> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_traffic_employment> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 查询所有数据
	public List<Hunan_traffic_employment> selectAll();

	// 根据years查询数据
	public List<Hunan_traffic_employment> selectByYears(Integer years);

	// 增加数据
	public void addIntoHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// 修改数据
	public void updateFromHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment);

	// 删除数据
	public void delFromHunan_traffic_employment(Integer years);
}
