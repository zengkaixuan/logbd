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
	
	@Override// ��ҳ��ѯ --���÷�ҳ����
	public PageBean<Hunan_traffic_employment> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_traffic_employment> pageInfo = new PageInfo<Hunan_traffic_employment>(list);
		// ����һ��pageBean����
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
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectByYears(years);
		PageInfo<Hunan_traffic_employment> pageInfo = new PageInfo<Hunan_traffic_employment>(list);
		// ����һ��pageBean����
		PageBean<Hunan_traffic_employment> pageBean = new PageBean<Hunan_traffic_employment>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_traffic_employment> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯHunan_traffic_employment������Ϣ......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_traffic_employment> selectAll() {
		System.out.println("���ڲ�ѯHunan_traffic_employment����������Ϣ......");
		List<Hunan_traffic_employment> list = hunan_traffic_employmentDao.selectAll();
		return list;
	}

	@Override
	public void addIntoHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println("�������Hunan_traffic_employment��Ϣ��Hunan_traffic_employment����......");
		hunan_traffic_employmentDao.addIntoHunan_traffic_employment(hunan_traffic_employment);
		System.out.println(hunan_traffic_employment.getYears()+"����Ϣ��ӳɹ�");
	}

	@Override
	public void updateFromHunan_traffic_employment(
			Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println("���ڸ���Hunan_traffic_employment��Ϣ��Hunan_traffic_employment����......");
		List<Hunan_traffic_employment> list=hunan_traffic_employmentDao.selectByYears(hunan_traffic_employment.getYears());
		for(Hunan_traffic_employment i:list){
			System.out.println("����ǰ:"+i);
		}
		hunan_traffic_employmentDao.updateFromHunan_traffic_employment(hunan_traffic_employment);
		list=hunan_traffic_employmentDao.selectByYears(hunan_traffic_employment.getYears());
		for(Hunan_traffic_employment i:list){
			System.out.println("���º�:"+i);
		}
	}

	@Override
	public void delFromHunan_traffic_employment(Integer years) {
		System.out.println("����ͨ��years��Hunan_traffic_employment����ɾ��Hunan_traffic_employment��Ϣ......");
		hunan_traffic_employmentDao.delFromHunan_traffic_employment(years);
		List<Hunan_traffic_employment> list=hunan_traffic_employmentDao.selectByYears(years);
		String msg="�ɹ�";
		for(Hunan_traffic_employment i:list){
			System.out.println(i+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}


}
