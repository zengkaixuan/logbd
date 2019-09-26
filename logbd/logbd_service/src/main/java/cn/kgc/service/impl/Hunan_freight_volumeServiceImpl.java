package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_freight_volumeDao;
import cn.kgc.entity.Hunan_freight_volume;
import cn.kgc.service.Hunan_freight_volumeService;
import cn.kgc.utils.PageBean;
@Service
public class Hunan_freight_volumeServiceImpl implements
		Hunan_freight_volumeService {
	
	@Resource
	private Hunan_freight_volumeDao hunan_freight_volumeDao;

	@Override
	public PageBean<Hunan_freight_volume> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_freight_volume> pageInfo = new PageInfo<Hunan_freight_volume>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_freight_volume> pageBean = new PageBean<Hunan_freight_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_freight_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectByYears(years);
		PageInfo<Hunan_freight_volume> pageInfo = new PageInfo<Hunan_freight_volume>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_freight_volume> pageBean = new PageBean<Hunan_freight_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_freight_volume> selectAll() {
		System.out.println("正在查询Hunan_freight_volume表中所有信息......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectAll();
		return list;
	}

	@Override
	public List<Hunan_freight_volume> selectByYears(Integer years) {
		System.out.println("正在通过years查询Hunan_freight_volume表中信息......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectByYears(years);
		return list;
	}

	@Override
	public void addIntohunan_freight_volume(
			Hunan_freight_volume hunan_freight_volume) {
		System.out.println("正在添加hunan_freight_volume信息至hunan_freight_volume表中......");
		hunan_freight_volumeDao.addIntoHunan_freight_volume(hunan_freight_volume);
		System.out.println(hunan_freight_volume.getYears()+"年信息添加成功");
	}

	@Override
	public void updateFromhunan_freight_turnover_volume(
			Hunan_freight_volume hunan_freight_volume) {
		System.out.println("正在更新hunan_freight_volume信息至hunan_freight_volume表中......");
		List<Hunan_freight_volume> list=hunan_freight_volumeDao.selectByYears(hunan_freight_volume.getYears());
		for(Hunan_freight_volume i:list){
			System.out.println("更新前:"+i);
		}
		hunan_freight_volumeDao.updateFormHunan_freight_turnover_volume(hunan_freight_volume);
		list=hunan_freight_volumeDao.selectByYears(hunan_freight_volume.getYears());
		for(Hunan_freight_volume i:list){
			System.out.println("更新后:"+i);
		}
	}

	@Override
	public void delFromhunan_freight_volume(Integer years) {
		System.out.println("正在通过years从hunan_freight_volume表中删除hunan_freight_volume信息......");
		hunan_freight_volumeDao.delFormHunan_freight_volume(years);
		List<Hunan_freight_volume> list=hunan_freight_volumeDao.selectByYears(years);
		String msg="成功";
		for(Hunan_freight_volume i:list){
			System.out.println(i+"删除出现未知错误");
			msg="失败";
		}
		System.out.println("删除"+msg);
	}


}
