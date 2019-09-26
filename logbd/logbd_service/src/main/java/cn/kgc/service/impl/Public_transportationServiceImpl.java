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
	// ��ҳ��ѯ --���÷�ҳ����
	public PageBean<Public_transportation> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Public_transportation> list = Public_transportationDao.selectAll();
		System.out.println(list);
		PageInfo<Public_transportation> pageInfo = new PageInfo<Public_transportation>(
				list);
		// ����һ��pageBean����
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
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		PageInfo<Public_transportation> pageInfo = new PageInfo<Public_transportation>(
				list);
		// ����һ��pageBean����
		PageBean<Public_transportation> pageBean = new PageBean<Public_transportation>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Public_transportation> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯPublic_transportation������Ϣ......");
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		return list;
	}

	@Override
	public List<Public_transportation> selectAll() {
		System.out.println("���ڲ�ѯPublic_transportation����������Ϣ......");
		List<Public_transportation> list = Public_transportationDao.selectAll();
		return list;
	}

	@Override
	public void addIntoPublic_transportation(
			Public_transportation public_transportation) {
		System.out
				.println("�������Public_transportation��Ϣ��Public_transportation����......");
		Public_transportationDao
				.addIntoPublic_transportation(public_transportation);
		System.out.println(public_transportation.getYears() + "����Ϣ��ӳɹ�");
	}

	@Override
	public void updateFromPublic_transportation(
			Public_transportation public_transportation) {
		System.out
				.println("���ڸ���Public_transportation��Ϣ��Public_transportation����......");
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(public_transportation.getYears());
		for (Public_transportation i : list) {
			System.out.println("����ǰ:" + i);
		}
		Public_transportationDao
				.updateFromPublic_transportation(public_transportation);
		list = Public_transportationDao.selectByYears(public_transportation
				.getYears());
		for (Public_transportation i : list) {
			System.out.println("���º�:" + i);
		}
	}

	@Override
	public void delFromPublic_transportation(Integer years) {
		System.out
				.println("����ͨ��years��Public_transportation����ɾ��Public_transportation��Ϣ......");
		Public_transportationDao.delFromPublic_transportation(years);
		List<Public_transportation> list = Public_transportationDao
				.selectByYears(years);
		String msg = "�ɹ�";
		for (Public_transportation i : list) {
			System.out.println(i + "ɾ������δ֪����");
			msg = "ʧ��";
		}
		System.out.println("ɾ��" + msg);
	}

}
