package cn.kgc.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.dao.UserDao;
import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.utils.PageBean;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	// ��ҳ��ѯ --���÷�ҳ����
	public PageBean<User> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("����ִ�з�ҳ��ѯ......");
		List<User> list = userDao.selectAll();
		System.out.println(list);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// ����һ��pageBean����
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override // ������ҳ��ѯ
	public PageBean<User> queryByCondition(Integer pageNo, Integer pageSize,
			String name) {
		System.out.println("����ִ��������ҳ��ѯ......");
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userDao.selectLikeName(name);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// ����һ��pageBean����
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<User> selectAll() {
		System.out.println("���ڲ�ѯUser����������Ϣ......");
		List<User> users = userDao.selectAll();
		return users;
	}

	@Override
	public List<User> selectById(Integer id) {
		System.out.println("����ͨ��id��ѯUser������Ϣ......");
		List<User> users = userDao.selectById(id);
		return users;
	}

	@Override
	public List<User> selectLikeName(String name) {
		System.out.println("����ͨ��userNameģ����ѯUser����������Ϣ......");
		List<User> users = userDao.selectLikeName(name);
		return users;
	}

	@Override
	public void addIntoUser(User user) {
		System.out.println("�������user��Ϣ��User����......");
		userDao.addIntoUser(user);
		User queryUser = userDao.queryByUserName(user.getUserName());
		userDao.addUserRole(queryUser.getId(), 2);
		System.out.println(user.getUserName()+"��ӳɹ�");
	}

	@Override
	public void updateFromUser(User user) {
		System.out.println("���ڸ���user��Ϣ��User����......");
		List<User> us=userDao.selectById(user.getId());
		for(User u:us){
			System.out.println("����ǰ:"+u);
		}
		userDao.updateFromUser(user);
		us=userDao.selectById(user.getId());
		for(User u:us){
			System.out.println("���º�:"+u);
		}
	}

	@Override
	public void delFromUser(Integer id) {
		System.out.println("����ͨ��id��User����ɾ��user��Ϣ......");
		userDao.delFromUser(id);
		List<User> us=userDao.selectById(id);
		String msg="�ɹ�";
		for(User u:us){
			System.out.println(u+"ɾ������δ֪����");
			msg="ʧ��";
		}
		System.out.println("ɾ��"+msg);
	}

	@Override
	public User queryByUserName(String UserName) {
		System.out.println("���ڲ�ѯ"+UserName+"�������Ϣ......");
		User user = userDao.queryByUserName(UserName);
		return user;
	}

	@Override
	public Set<String> queryRoles(String UserName) {
		System.out.println("���ڲ�ѯ"+UserName+"�Ľ�ɫ��Ϣ......");
		Set<String> roles = userDao.queryRoles(UserName);
		return roles;
	}

	@Override
	public Set<String> queryPermissions(String UserName) {
		System.out.println("���ڲ�ѯ"+UserName+"��Ȩ����Ϣ......");
		Set<String> permissions = userDao.queryPermissions(UserName);
		return permissions;
	}
}
