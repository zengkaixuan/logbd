package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_transline_lengthDao;
import cn.kgc.entity.Hunan_transline_length;
import cn.kgc.service.Hunan_transline_lengthService;
import cn.kgc.utils.PageBean;
@Service
public class Hunan_transline_lengthServiceImpl implements
		Hunan_transline_lengthService {
	@Resource
	private Hunan_transline_lengthDao hunan_transline_lengthDao;

	@Override
	// 分页查询 --配置分页助手
	public PageBean<Hunan_transline_length> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_transline_length> pageInfo = new PageInfo<Hunan_transline_length>(
				list);
		// 创建一个pageBean对象
		PageBean<Hunan_transline_length> pageBean = new PageBean<Hunan_transline_length>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_transline_length> queryByCondition(Integer pageNo,
			Integer pageSize, Integer years) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		PageInfo<Hunan_transline_length> pageInfo = new PageInfo<Hunan_transline_length>(
				list);
		// 创建一个pageBean对象
		PageBean<Hunan_transline_length> pageBean = new PageBean<Hunan_transline_length>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_transline_length> selectByYears(Integer years) {
		System.out.println("正在通过years查询Hunan_transline_length表中信息......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_transline_length> selectAll() {
		System.out.println("正在查询Hunan_transline_length表中所有信息......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectAll();
		return list;
	}

	@Override
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length) {
		System.out
				.println("正在添加Hunan_transline_length信息至Hunan_transline_length表中......");
		hunan_transline_lengthDao.addIntoHunan_transline_length(hunan_transline_length);
		System.out.println(hunan_transline_length.getYears() + "年信息添加成功");
	}

	@Override
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length) {
		System.out
				.println("正在更新Hunan_transline_length信息至Hunan_transline_length表中......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(hunan_transline_length.getYears());
		for (Hunan_transline_length i : list) {
			System.out.println("更新前:" + i);
		}
		hunan_transline_lengthDao.updateFromHunan_transline_length(hunan_transline_length);
		list = hunan_transline_lengthDao
				.selectByYears(hunan_transline_length.getYears());
		for (Hunan_transline_length i : list) {
			System.out.println("更新后:" + i);
		}
	}

	@Override
	public void delFromHunan_transline_length(Integer years) {
		System.out
				.println("正在通过years从Hunan_transline_length表中删除Hunan_transline_length信息......");
		hunan_transline_lengthDao.delFromHunan_transline_length(years);
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		String msg = "成功";
		for (Hunan_transline_length i : list) {
			System.out.println(i + "删除出现未知错误");
			msg = "失败";
		}
		System.out.println("删除" + msg);
	}

}
