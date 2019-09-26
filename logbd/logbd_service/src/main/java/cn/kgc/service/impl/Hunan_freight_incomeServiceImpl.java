package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_freight_incomeDao;
import cn.kgc.entity.Hunan_freight_income;
import cn.kgc.service.Hunan_freight_incomeService;
import cn.kgc.utils.PageBean;

@Service
public class Hunan_freight_incomeServiceImpl implements
		Hunan_freight_incomeService {

	@Resource
	private Hunan_freight_incomeDao hunan_freight_incomeDao;

	@Override
	public PageBean<Hunan_freight_income> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_freight_income> pageInfo = new PageInfo<Hunan_freight_income>(
				list);
		// 创建一个pageBean对象
		PageBean<Hunan_freight_income> pageBean = new PageBean<Hunan_freight_income>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_freight_income> queryByCondition(Integer pageNo,
			Integer pageSize, String city) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectLikeCity(city);
		PageInfo<Hunan_freight_income> pageInfo = new PageInfo<Hunan_freight_income>(
				list);
		// 创建一个pageBean对象
		PageBean<Hunan_freight_income> pageBean = new PageBean<Hunan_freight_income>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_freight_income> selectAll() {
		System.out.println("正在查询hunan_freight_income表中所有信息......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao.selectAll();
		return list;
	}

	@Override
	public List<Hunan_freight_income> selectLikeCity(String city) {
		System.out.println("正在通过城市名模糊查询Hunan_freight_income表中所有信息......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectLikeCity(city);
		return list;
	}

	@Override
	public List<Hunan_freight_income> selectById(Integer id) {
		System.out.println("正在通过id查询Hunan_freight_income表中所有信息......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectById(id);
		return list;
	}

	@Override
	public void addIntohunan_freight_income(
			Hunan_freight_income hunan_freight_income) {
		System.out.println("正在添加hunan_freight_income信息至Hunan_freight_income表中......");
		hunan_freight_incomeDao.addIntoHunan_freight_income(hunan_freight_income);
		System.out.println(hunan_freight_income.getCity()+"添加成功");
	}

	@Override
	public void updateFromhunan_freight_income(
			Hunan_freight_income hunan_freight_income) {
		System.out.println("正在更新hunan_freight_income信息至Hunan_freight_income表中......");
		List<Hunan_freight_income> list=hunan_freight_incomeDao.selectById(hunan_freight_income.getId());
		for(Hunan_freight_income i:list){
			System.out.println("更新前:"+i);
		}
		hunan_freight_incomeDao.updateFromHunan_freight_income(hunan_freight_income);
		list=hunan_freight_incomeDao.selectById(hunan_freight_income.getId());
		for(Hunan_freight_income i:list){
			System.out.println("更新后:"+i);
		}
	}

	@Override
	public void delFromhunan_freight_income(Integer id) {
		System.out.println("正在通过id从hunan_freight_income表中删除hunan_freight_income信息......");
		hunan_freight_incomeDao.delFromHunan_freight_income(id);
		List<Hunan_freight_income> list=hunan_freight_incomeDao.selectById(id);
		String msg="成功";
		for(Hunan_freight_income i:list){
			System.out.println(i+"删除出现未知错误");
			msg="失败";
		}
		System.out.println("删除"+msg);
	}

}
