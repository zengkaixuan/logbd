package cn.kgc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.Hunan_pub_transDao;
import cn.kgc.entity.Hunan_pub_trans;
import cn.kgc.service.Hunan_pub_transService;
import cn.kgc.utils.PageBean;

@Service
public class Hunan_pub_transServiceImpl implements Hunan_pub_transService {

	@Resource
	private Hunan_pub_transDao hunan_pub_transDao;

	@Override
	public PageBean<Hunan_pub_trans> queryByPage(Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<Hunan_pub_trans> list = hunan_pub_transDao.selectAll();
		System.out.println(list);
		PageInfo<Hunan_pub_trans> pageInfo = new PageInfo<Hunan_pub_trans>(list);
		// ����һ��pageBean����
		PageBean<Hunan_pub_trans> pageBean = new PageBean<Hunan_pub_trans>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Hunan_pub_trans> queryByCondition(Integer pageNo, Integer pageSize,
			Integer years) {
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<Hunan_pub_trans> list = hunan_pub_transDao.selectByYears(years);
		PageInfo<Hunan_pub_trans> pageInfo = new PageInfo<Hunan_pub_trans>(list);
		// ����һ��pageBean����
		PageBean<Hunan_pub_trans> pageBean = new PageBean<Hunan_pub_trans>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<Hunan_pub_trans> selectAll() {
		System.out.println("���ڲ�ѯHunan_pub_trans����������Ϣ......");
		List<Hunan_pub_trans> list = hunan_pub_transDao.selectAll();
		return list;
	}

	@Override
	public List<Hunan_pub_trans> selectByYears(Integer years) {
		System.out.println("����ͨ��years��ѯHunan_pub_trans������Ϣ......");
		List<Hunan_pub_trans> list = hunan_pub_transDao.selectByYears(years);
		return list;
	}

	@Override
	public void addIntohunan_pub_trans(Hunan_pub_trans hunan_pub_trans) {
		System.out.println("�������hunan_pub_trans��Ϣ��hunan_pub_trans����......");
		hunan_pub_transDao.addIntoHunan_pub_trans(hunan_pub_trans);
		System.out.println(hunan_pub_trans.getYears()+"����Ϣ��ӳɹ�");
	}

	@Override
	public void updateFromhunan_pub_trans(Hunan_pub_trans hunan_pub_trans) {
		System.out.println("���ڸ���hunan_pub_trans��Ϣ��hunan_pub_trans����......");
		List<Hunan_pub_trans> list=hunan_pub_transDao.selectByYears(hunan_pub_trans.getYears());
		for(Hunan_pub_trans i:list){
			System.out.println("����ǰ:"+i);
		}
		hunan_pub_transDao.updateFromHunan_pub_trans(hunan_pub_trans);
		list=hunan_pub_transDao.selectByYears(hunan_pub_trans.getYears());
		for(Hunan_pub_trans i:list){
			System.out.println("���º�:"+i);
		}
	}

	@Override
	public void delFromhunan_pub_trans(Integer years) {
		System.out.println("����ͨ��years��hunan_business_volume����ɾ��hunan_business_volume��Ϣ......");
		hunan_pub_transDao.delFromHunan_pub_trans(years);
		List<Hunan_pub_trans> list=hunan_pub_transDao.selectByYears(years);
		String msg="�ɹ�";
		for(Hunan_pub_trans i:list){
			System.out.println(i+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}

}
