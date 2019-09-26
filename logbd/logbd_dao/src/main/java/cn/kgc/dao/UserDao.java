package cn.kgc.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.entity.User;

/**
 * user��ĳ־ò�
 */
public interface UserDao {
	// ��ѯ��������
	@Select(" select id,UserName,Password from user ")
	@Results(id = "userMapper", value = {
			@Result(column = "id", property = "id"),
			@Result(column = "UserName", property = "UserName"),
			@Result(column = "Password", property = "Password"), })
	public List<User> selectAll();

	// ����id��ѯ����
	@Select(" select id,UserName,Password from user where id=#{id} ")
	@ResultMap("userMapper")
	public List<User> selectById(@Param("id") Integer id);

	// ͨ��nameģ����ѯ
	@Select(" select id,UserName,Password "
			+ " from user where instr(UserName,#{name})>0 ")
	@ResultMap("userMapper")
	public List<User> selectLikeName(@Param("name") String name);

	// ��������
	@Insert("insert into user values(null,#{UserName},#{Password})")
	public void addIntoUser(User user);
	
	// �޸�����
	@Update("update user set UserName=#{UserName},"
			+ "Password=#{Password} where id=#{id}")
	public void updateFromUser(User user);

	// ɾ������
	@Delete(" delete from user where id=#{id}")
	public void delFromUser(@Param("id") Integer id);

	//��¼
	// �����û��������û�
	@Select("select id,UserName,Password "
			+ "  from user where UserName=#{UserName} ")
	User queryByUserName(@Param("UserName") String UserName);

	// �����û�����ѯ�û����еĽ�ɫ
	// ����ֵ������Shiro��ܶ����
	@Select(" select r.role_name "
			+ " from user u inner join user_role ur "
			+ " on u.id = ur.user_id " + " inner join role r "
			+ " on ur.role_id = r.id" + " where u.UserName=#{UserName}")
	Set<String> queryRoles(@Param("UserName") String UserName);

	// �����û�����ѯ�û����е�Ȩ��
	@Select(" select distinct p.permission_name "
			+ " from user u inner join user_role ur "
			+ " on u.id = ur.user_id " + " inner join role r "
			+ " on ur.role_id = r.id " + " inner join role_permission rp "
			+ " on r.id=rp.role_id " + " inner join permission p"
			+ " on rp.permission_id=p.id " + " where u.UserName=#{UserName} ")
	Set<String> queryPermissions(@Param("UserName") String UserName);
	
	// ��ӽ�ɫ
	@Insert("insert into user_role values(#{user_id},#{role_id})") 
	public void addUserRole(@Param("user_id")Integer user_id,@Param("role_id")Integer role_id);
}
