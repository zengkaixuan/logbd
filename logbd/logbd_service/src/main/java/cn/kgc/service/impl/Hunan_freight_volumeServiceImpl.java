package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_freight_volumeDao;
import cn.kgc.entity.Hunan_freight_volume;
import cn.kgc.service.Hunan_freight_volumeService;
import cn.kgc.utils.PageBean;
@Service
public class Hunan_freight_volumeServiceImpl implements
		Hunan_freight_volumeService {
	
	@Resource
	private Hunan_freight_volumeDao hunan_freight_volumeDao;

	@Override
	public PageBean<Hunan_freight_volume> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_freight_volume> pageInfo = new PageInfo<Hunan_freight_volume>(list);
		// ����һ��pageBean����
		PageBean<Hunan_freight_volume> pageBean = new PageBean<Hunan_freight_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_freight_volume> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years) {
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectByYears(years);
		PageInfo<Hunan_freight_volume> pageInfo = new PageInfo<Hunan_freight_volume>(list);
		// ����һ��pageBean����
		PageBean<Hunan_freight_volume> pageBean = new PageBean<Hunan_freight_volume>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_freight_volume> selectAll() {
		System.out.println("���ڲ�ѯHunan_freight_volume����������Ϣ......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectAll();
		return list;
	}

	@Override
	public List<Hunan_freight_volume> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯHunan_freight_volume������Ϣ......");
		List<Hunan_freight_volume> list = hunan_freight_volumeDao.selectByYears(years);
		return list;
	}

	@Override
	public void addIntohunan_freight_volume(
			Hunan_freight_volume hunan_freight_volume) {
		System.out.println("�������hunan_freight_volume��Ϣ��hunan_freight_volume����......");
		hunan_freight_volumeDao.addIntoHunan_freight_volume(hunan_freight_volume);
		System.out.println(hunan_freight_volume.getYears()+"����Ϣ��ӳɹ�");
	}

	@Override
	public void updateFromhunan_freight_turnover_volume(
			Hunan_freight_volume hunan_freight_volume) {
		System.out.println("���ڸ���hunan_freight_volume��Ϣ��hunan_freight_volume����......");
		List<Hunan_freight_volume> list=hunan_freight_volumeDao.selectByYears(hunan_freight_volume.getYears());
		for(Hunan_freight_volume i:list){
			System.out.println("����ǰ:"+i);
		}
		hunan_freight_volumeDao.updateFormHunan_freight_turnover_volume(hunan_freight_volume);
		list=hunan_freight_volumeDao.selectByYears(hunan_freight_volume.getYears());
		for(Hunan_freight_volume i:list){
			System.out.println("���º�:"+i);
		}
	}

	@Override
	public void delFromhunan_freight_volume(Integer years) {
		System.out.println("����ͨ��years��hunan_freight_volume����ɾ��hunan_freight_volume��Ϣ......");
		hunan_freight_volumeDao.delFormHunan_freight_volume(years);
		List<Hunan_freight_volume> list=hunan_freight_volumeDao.selectByYears(years);
		String msg="�ɹ�";
		for(Hunan_freight_volume i:list){
			System.out.println(i+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}


}
