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
	
	@Override// ��ҳ��ѯ --���÷�ҳ����
	public PageBean<Hunan_business_volume> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_business_volume> pageInfo = new PageInfo<Hunan_business_volume>(list);
		// ����һ��pageBean����
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
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectByYears(years);
		PageInfo<Hunan_business_volume> pageInfo = new PageInfo<Hunan_business_volume>(list);
		// ����һ��pageBean����
		PageBean<Hunan_business_volume> pageBean = new PageBean<Hunan_business_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_business_volume> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯhunan_business_volume������Ϣ......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectByYears(years);
		return list;
	}

	@Override
	public List<Hunan_business_volume> selectAll() {
		System.out.println("���ڲ�ѯhunan_business_volume����������Ϣ......");
		List<Hunan_business_volume> list = hunan_business_volumeDao.selectAll();
		return list;
	}

	@Override
	public void addIntohunan_business_volume(
			Hunan_business_volume hunan_business_volume) {
		System.out.println("�������hunan_business_volume��Ϣ��hunan_business_volume����......");
		hunan_business_volumeDao.addIntoHunan_business_volume(hunan_business_volume);
		System.out.println(hunan_business_volume.getYears()+"����Ϣ��ӳɹ�");
	}

	@Override
	public void updateFromhunan_business_volume(
			Hunan_business_volume hunan_business_volume) {
		System.out.println("���ڸ���hunan_business_volume��Ϣ��hunan_business_volume����......");
		List<Hunan_business_volume> list=hunan_business_volumeDao.selectByYears(hunan_business_volume.getYears());
		for(Hunan_business_volume i:list){
			System.out.println("����ǰ:"+i);
		}
		hunan_business_volumeDao.updateFormHunan_business_volume(hunan_business_volume);
		list=hunan_business_volumeDao.selectByYears(hunan_business_volume.getYears());
		for(Hunan_business_volume i:list){
			System.out.println("���º�:"+i);
		}
	}

	@Override
	public void delFromhunan_business_volume(Integer years) {
		System.out.println("����ͨ��years��hunan_business_volume����ɾ��hunan_business_volume��Ϣ......");
		hunan_business_volumeDao.delFormHunan_business_volume(years);
		List<Hunan_business_volume> list=hunan_business_volumeDao.selectByYears(years);
		String msg="�ɹ�";
		for(Hunan_business_volume i:list){
			System.out.println(i+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}

}
