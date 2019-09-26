package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Public_transportationDao;
import cn.kgc.entity.Public_transportation;
import cn.kgc.service.Public_transportationService;
import cn.kgc.utils.PageBean;
@Service
public class Public_transportationServiceImpl implements
		Public_transportationService {
	@Resource
	private Public_transportationDao Public_transportationDao;

	@Override
	// 分页查询 --配置分页助手
	public PageBean<Public_transportation> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Public_transportation> list = Public_transportationDao.selectAll();
		System.out.println(list);
		PageInfo<Public_transportation> pageInfo = new PageInfo<Public_transportation>(
				list);
		// 创建一个pageBean对象
		PageBean<Public_transportation> pageBean = new PageBean<Public_transportation>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Public_transportation> queryByCondition(Integer pageNo,
			Integer pageSize, Integer years) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		PageInfo<Public_transportation> pageInfo = new PageInfo<Public_transportation>(
				list);
		// 创建一个pageBean对象
		PageBean<Public_transportation> pageBean = new PageBean<Public_transportation>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Public_transportation> selectByYears(Integer years) {
		System.out.println("正在通过years查询Public_transportation表中信息......");
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		return list;
	}

	@Override
	public List<Public_transportation> selectAll() {
		System.out.println("正在查询Public_transportation表中所有信息......");
		List<Public_transportation> list = Public_transportationDao.selectAll();
		return list;
	}

	@Override
	public void addIntoPublic_transportation(
			Public_transportation public_transportation) {
		System.out
				.println("正在添加Public_transportation信息至Public_transportation表中......");
		Public_transportationDao
				.addIntoPublic_transportation(public_transportation);
		System.out.println(public_transportation.getYears() + "年信息添加成功");
	}

	@Override
	public void updateFromPublic_transportation(
			Public_transportation public_transportation) {
		System.out
				.println("正在更新Public_transportation信息至Public_transportation表中......");
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(public_transportation.getYears());
		for (Public_transportation i : list) {
			System.out.println("更新前:" + i);
		}
		Public_transportationDao
				.updateFromPublic_transportation(public_transportation);
		list = Public_transportationDao.selectByYears(public_transportation
				.getYears());
		for (Public_transportation i : list) {
			System.out.println("更新后:" + i);
		}
	}

	@Override
	public void delFromPublic_transportation(Integer years) {
		System.out
				.println("正在通过years从Public_transportation表中删除Public_transportation信息......");
		Public_transportationDao.delFromPublic_transportation(years);
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		String msg = "成功";
		for (Public_transportation i : list) {
			System.out.println(i + "删除出现未知错误");
			msg = "失败";
		}
		System.out.println("删除" + msg);
	}

}
