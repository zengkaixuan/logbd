package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_business_volumeDao;
import cn.kgc.entity.Hunan_business_volume;
import cn.kgc.service.Hunan_business_volumeService;
import cn.kgc.utils.PageBean;

@Service
public class Hunan_business_volumeServiceImpl implements
		Hunan_business_volumeService {

	@Resource
	private Hunan_business_volumeDao hunan_business_volumeDao;
	
	@Override// 分页查询 --配置分页助手
	public PageBean<Hunan_business_volume> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_business_volume> pageInfo = new PageInfo<Hunan_business_volume>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_business_volume> pageBean = new PageBean<Hunan_business_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_business_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectByYears(years);
		PageInfo<Hunan_business_volume> pageInfo = new PageInfo<Hunan_business_volume>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_business_volume> pageBean = new PageBean<Hunan_business_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_business_volume> selectByYears(Integer years) {
		System.out.println("正在通过years查询hunan_business_volume表中信息......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_business_volume> selectAll() {
		System.out.println("正在查询hunan_business_volume表中所有信息......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectAll();
		return list;
	}

	@Override
	public void addIntohunan_business_volume(
			Hunan_business_volume hunan_business_volume) {
		System.out.println("正在添加hunan_business_volume信息至hunan_business_volume表中......");
		hunan_business_volumeDao.addIntoHunan_business_volume(hunan_business_volume);
		System.out.println(hunan_business_volume.getYears()+"年信息添加成功");
	}

	@Override
	public void updateFromhunan_business_volume(
			Hunan_business_volume hunan_business_volume) {
		System.out.println("正在更新hunan_business_volume信息至hunan_business_volume表中......");
		List<Hunan_business_volume> list=hunan_business_volumeDao.selectByYears(hunan_business_volume.getYears());
		for(Hunan_business_volume i:list){
			System.out.println("更新前:"+i);
		}
		hunan_business_volumeDao.updateFormHunan_business_volume(hunan_business_volume);
		list=hunan_business_volumeDao.selectByYears(hunan_business_volume.getYears());
		for(Hunan_business_volume i:list){
			System.out.println("更新后:"+i);
		}
	}

	@Override
	public void delFromhunan_business_volume(Integer years) {
		System.out.println("正在通过years从hunan_business_volume表中删除hunan_business_volume信息......");
		hunan_business_volumeDao.delFormHunan_business_volume(years);
		List<Hunan_business_volume> list=hunan_business_volumeDao.selectByYears(years);
		String msg="成功";
		for(Hunan_business_volume i:list){
			System.out.println(i+"删除出现未知错误");
			msg="失败";
		}
		System.out.println("删除"+msg);
	}

}
