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
	// 分页查询 --配置分页助手
	public PageBean<User> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("正在执行分页查询......");
		List<User> list = userDao.selectAll();
		System.out.println(list);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// 创建一个pageBean对象
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override // 条件分页查询
	public PageBean<User> queryByCondition(Integer pageNo, Integer pageSize,
			String name) {
		System.out.println("正在执行条件分页查询......");
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userDao.selectLikeName(name);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// 创建一个pageBean对象
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int) pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public List<User> selectAll() {
		System.out.println("正在查询User表中所有信息......");
		List<User> users = userDao.selectAll();
		return users;
	}

	@Override
	public List<User> selectById(Integer id) {
		System.out.println("正在通过id查询User表中信息......");
		List<User> users = userDao.selectById(id);
		return users;
	}

	@Override
	public List<User> selectLikeName(String name) {
		System.out.println("正在通过userName模糊查询User表中所有信息......");
		List<User> users = userDao.selectLikeName(name);
		return users;
	}

	@Override
	public void addIntoUser(User user) {
		System.out.println("正在添加user信息至User表中......");
		userDao.addIntoUser(user);
		User queryUser = userDao.queryByUserName(user.getUserName());
		userDao.addUserRole(queryUser.getId(), 2);
		System.out.println(user.getUserName()+"添加成功");
	}

	@Override
	public void updateFromUser(User user) {
		System.out.println("正在更新user信息至User表中......");
		List<User> us=userDao.selectById(user.getId());
		for(User u:us){
			System.out.println("更新前:"+u);
		}
		userDao.updateFromUser(user);
		us=userDao.selectById(user.getId());
		for(User u:us){
			System.out.println("更新后:"+u);
		}
	}

	@Override
	public void delFromUser(Integer id) {
		System.out.println("正在通过id从User表中删除user信息......");
		userDao.delFromUser(id);
		List<User> us=userDao.selectById(id);
		String msg="成功";
		for(User u:us){
			System.out.println(u+"删除出现未知错误");
			msg="失败";
		}
		System.out.println("删除"+msg);
	}

	@Override
	public User queryByUserName(String UserName) {
		System.out.println("正在查询"+UserName+"的相关信息......");
		User user = userDao.queryByUserName(UserName);
		return user;
	}

	@Override
	public Set<String> queryRoles(String UserName) {
		System.out.println("正在查询"+UserName+"的角色信息......");
		Set<String> roles = userDao.queryRoles(UserName);
		return roles;
	}

	@Override
	public Set<String> queryPermissions(String UserName) {
		System.out.println("正在查询"+UserName+"的权限信息......");
		Set<String> permissions = userDao.queryPermissions(UserName);
		return permissions;
	}
}
