package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_traffic_employmentDao;
import cn.kgc.entity.Hunan_traffic_employment;
import cn.kgc.service.Hunan_traffic_employmentService;
import cn.kgc.utils.PageBean;
@Service
public class Hunan_traffic_employmentServiceImpl implements
		Hunan_traffic_employmentService {

	@Resource
	private Hunan_traffic_employmentDao hunan_traffic_employmentDao;
	
	@Override// 分页查询 --配置分页助手
	public PageBean<Hunan_traffic_employment> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_traffic_employment> pageInfo = new PageInfo<Hunan_traffic_employment>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_traffic_employment> pageBean = new PageBean<Hunan_traffic_employment>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_traffic_employment> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectByYears(years);
		PageInfo<Hunan_traffic_employment> pageInfo = new PageInfo<Hunan_traffic_employment>(list);
		// 创建一个pageBean对象
		PageBean<Hunan_traffic_employment> pageBean = new PageBean<Hunan_traffic_employment>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_traffic_employment> selectByYears(Integer years) {
		System.out.println("正在通过years查询Hunan_traffic_employment表中信息......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_traffic_employment> selectAll() {
		System.out.println("正在查询Hunan_traffic_employment表中所有信息......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectAll();
		return list;
	}

	@Override
	public void addIntoHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println("正在添加Hunan_traffic_employment信息至Hunan_traffic_employment表中......");
		hunan_traffic_employmentDao.addIntoHunan_traffic_employment(hunan_traffic_employment);
		System.out.println(hunan_traffic_employment.getYears()+"年信息添加成功");
	}

	@Override
	public void updateFromHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println("正在更新Hunan_traffic_employment信息至Hunan_traffic_employment表中......");
		List<Hunan_traffic_employment> list=hunan_traffic_employmentDao.selectByYears(hunan_traffic_employment.getYears());
		for(Hunan_traffic_employment i:list){
			System.out.println("更新前:"+i);
		}
		hunan_traffic_employmentDao.updateFromHunan_traffic_employment(hunan_traffic_employment);
		list=hunan_traffic_employmentDao.selectByYears(hunan_traffic_employment.getYears());
		for(Hunan_traffic_employment i:list){
			System.out.println("更新后:"+i);
		}
	}

	@Override
	public void delFromHunan_traffic_employment(Integer years) {
		System.out.println("正在通过years从Hunan_traffic_employment表中删除Hunan_traffic_employment信息......");
		hunan_traffic_employmentDao.delFromHunan_traffic_employment(years);
		List<Hunan_traffic_employment> list=hunan_traffic_employmentDao.selectByYears(years);
		String msg="成功";
		for(Hunan_traffic_employment i:list){
			System.out.println(i+"删除出现未知错误");
			msg="失败";
		}
		System.out.println("删除"+msg);
	}


}
