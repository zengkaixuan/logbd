package cn.kgc.service;

import java.util.List;
import java.util.Set;

import cn.kgc.entity.User;
import cn.kgc.utils.PageBean;

/**
 * user表的持久层
 */
public interface UserService {
	// 分页查询
	PageBean<User> queryByPage(Integer pageNo, Integer pageSize);

	// 条件分页查询
	PageBean<User> queryByCondition(Integer pageNo, Integer pageSize,
			String name);

	// 查询所有数据
	public List<User> selectAll();

	// 根据id查询数据
	public List<User> selectById(Integer id);

	// 通过name模糊查询
	public List<User> selectLikeName(String name);

	// 增加数据(默认为client)
	public void addIntoUser(User user);

	// 修改数据
	public void updateFromUser(User user);

	// 删除数据
	public void delFromUser(Integer id);
	
	//登录
	// 依据用户名查找用户
	User queryByUserName(String UserName);

	// 依据用户名查询用户所有的角色
	// 返回值类型是Shiro框架定义的
	Set<String> queryRoles(String UserName);

	// 依据用户名查询用户所有的权限
	Set<String> queryPermissions(String UserName);
}
