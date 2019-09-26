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
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_freight_income> pageInfo = new PageInfo<Hunan_freight_income>(
				list);
		// ����һ��pageBean����
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
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectLikeCity(city);
		PageInfo<Hunan_freight_income> pageInfo = new PageInfo<Hunan_freight_income>(
				list);
		// ����һ��pageBean����
		PageBean<Hunan_freight_income> pageBean = new PageBean<Hunan_freight_income>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_freight_income> selectAll() {
		System.out.println("���ڲ�ѯhunan_freight_income����������Ϣ......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao.selectAll();
		return list;
	}

	@Override
	public List<Hunan_freight_income> selectLikeCity(String city) {
		System.out.println("����ͨ��������ģ����ѯHunan_freight_income����������Ϣ......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectLikeCity(city);
		return list;
	}

	@Override
	public List<Hunan_freight_income> selectById(Integer id) {
		System.out.println("����ͨ��id��ѯHunan_freight_income����������Ϣ......");
		List<Hunan_freight_income> list = hunan_freight_incomeDao
				.selectById(id);
		return list;
	}

	@Override
	public void addIntohunan_freight_income(
			Hunan_freight_income hunan_freight_income) {
		System.out.println("�������hunan_freight_income��Ϣ��Hunan_freight_income����......");
		hunan_freight_incomeDao.addIntoHunan_freight_income(hunan_freight_income);
		System.out.println(hunan_freight_income.getCity()+"��ӳɹ�");
	}

	@Override
	public void updateFromhunan_freight_income(
			Hunan_freight_income hunan_freight_income) {
		System.out.println("���ڸ���hunan_freight_income��Ϣ��Hunan_freight_income����......");
		List<Hunan_freight_income> list=hunan_freight_incomeDao.selectById(hunan_freight_income.getId());
		for(Hunan_freight_income i:list){
			System.out.println("����ǰ:"+i);
		}
		hunan_freight_incomeDao.updateFromHunan_freight_income(hunan_freight_income);
		list=hunan_freight_incomeDao.selectById(hunan_freight_income.getId());
		for(Hunan_freight_income i:list){
			System.out.println("���º�:"+i);
		}
	}

	@Override
	public void delFromhunan_freight_income(Integer id) {
		System.out.println("����ͨ��id��hunan_freight_income����ɾ��hunan_freight_income��Ϣ......");
		hunan_freight_incomeDao.delFromHunan_freight_income(id);
		List<Hunan_freight_income> list=hunan_freight_incomeDao.selectById(id);
		String msg="�ɹ�";
		for(Hunan_freight_income i:list){
			System.out.println(i+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}

}
