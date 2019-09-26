package cn.kgc.service;

import java.util.List;
import java.util.Set;

import cn.kgc.entity.User;
import cn.kgc.utils.PageBean;

/**
 * user��ĳ־ò�
 */
public interface UserService {
	// ��ҳ��ѯ
	PageBean<User> queryByPage(Integer pageNo, Integer pageSize);

	// ������ҳ��ѯ
	PageBean<User> queryByCondition(Integer pageNo, Integer pageSize,
			String name);

	// ��ѯ��������
	public List<User> selectAll();

	// ����id��ѯ����
	public List<User> selectById(Integer id);

	// ͨ��nameģ����ѯ
	public List<User> selectLikeName(String name);

	// ��������(Ĭ��Ϊclient)
	public void addIntoUser(User user);

	// �޸�����
	public void updateFromUser(User user);

	// ɾ������
	public void delFromUser(Integer id);
	
	//��¼
	// �����û��������û�
	User queryByUserName(String UserName);

	// �����û�����ѯ�û����еĽ�ɫ
	// ����ֵ������Shiro��ܶ����
	Set<String> queryRoles(String UserName);

	// �����û�����ѯ�û����е�Ȩ��
	Set<String> queryPermissions(String UserName);
}
