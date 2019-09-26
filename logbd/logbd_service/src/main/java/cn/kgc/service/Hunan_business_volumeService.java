package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Hunan_business_volume;
import cn.kgc.utils.PageBean;

public interface Hunan_business_volumeService {
	// 分页查询
	PageBean<Hunan_business_volume> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<Hunan_business_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years);

	// 根据years查询数据
	public List<Hunan_business_volume> selectByYears(Integer years);

	// 查询所有数据
	public List<Hunan_business_volume> selectAll();

	// 增加数据
	public void addIntohunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// 修改数据
	public void updateFromhunan_business_volume(
			Hunan_business_volume hunan_business_volume);

	// 删除数据
	public void delFromhunan_business_volume(Integer years);
}
