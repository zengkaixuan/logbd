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
	// ��ҳ��ѯ --���÷�ҳ����
	public PageBean<Hunan_transline_length> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_transline_length> pageInfo = new PageInfo<Hunan_transline_length>(
				list);
		// ����һ��pageBean����
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
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		PageInfo<Hunan_transline_length> pageInfo = new PageInfo<Hunan_transline_length>(
				list);
		// ����һ��pageBean����
		PageBean<Hunan_transline_length> pageBean = new PageBean<Hunan_transline_length>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_transline_length> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯHunan_transline_length������Ϣ......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_transline_length> selectAll() {
		System.out.println("���ڲ�ѯHunan_transline_length����������Ϣ......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectAll();
		return list;
	}

	@Override
	public void addIntoHunan_transline_length(
			Hunan_transline_length hunan_transline_length) {
		System.out
				.println("��������Hunan_transline_length��Ϣ��Hunan_transline_length����......");
		hunan_transline_lengthDao.addIntoHunan_transline_length(hunan_transline_length);
		System.out.println(hunan_transline_length.getYears() + "����Ϣ���ӳɹ�");
	}

	@Override
	public void updateFromHunan_transline_length(
			Hunan_transline_length hunan_transline_length) {
		System.out
				.println("���ڸ���Hunan_transline_length��Ϣ��Hunan_transline_length����......");
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(hunan_transline_length.getYears());
		for (Hunan_transline_length i : list) {
			System.out.println("����ǰ:" + i);
		}
		hunan_transline_lengthDao.updateFromHunan_transline_length(hunan_transline_length);
		list = hunan_transline_lengthDao
				.selectByYears(hunan_transline_length.getYears());
		for (Hunan_transline_length i : list) {
			System.out.println("���º�:" + i);
		}
	}

	@Override
	public void delFromHunan_transline_length(Integer years) {
		System.out
				.println("����ͨ��years��Hunan_transline_length����ɾ��Hunan_transline_length��Ϣ......");
		hunan_transline_lengthDao.delFromHunan_transline_length(years);
		List<Hunan_transline_length> list = hunan_transline_lengthDao
				.selectByYears(years);
		String msg = "�ɹ�";
		for (Hunan_transline_length i : list) {
			System.out.println(i + "ɾ������δ֪����");
			msg = "ʧ��";
		}
		System.out.println("ɾ��" + msg);
	}

}