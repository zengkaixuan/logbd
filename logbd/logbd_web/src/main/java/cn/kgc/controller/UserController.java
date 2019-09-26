package cn.kgc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.entity.*;
import cn.kgc.service.*;
import cn.kgc.utils.PageBean;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private Hunan_business_volumeService hunan_business_volumeService;
	@Resource
	private Hunan_freight_incomeService hunan_freight_incomeService;
	@Resource
	private Hunan_freight_turnover_volumeService hunan_freight_turnover_volumeService;
	@Resource
	private Hunan_freight_volumeService hunan_freight_volumeService;
	@Resource
	private Hunan_pub_transService hunan_pub_transService;
	@Resource
	private Hunan_traffic_employmentService hunan_traffic_employmentService;
	@Resource
	private Hunan_transline_lengthService hunan_transline_lengthService;
	@Resource
	private Public_transportationService public_transportationService;

	@RequestMapping("/to/bg")
	public String toIndex() {
		return "bg2";
	}

	// user��ķ�ҳ��ѯ
	@RequestMapping(value = "/ajax/div1", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<User> ajaxDiv1(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false, defaultValue = "") String name,
			HttpSession session) {
		PageBean<User> pageBean = userService.queryByCondition(pageNo,
				pageSize, name);
		return pageBean;
	}

	// hunan_business_volume��ķ�ҳ��ѯ
	@RequestMapping(value = "/ajax/div2", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_business_volume> ajaxDiv2(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_business_volume> pageBean = hunan_business_volumeService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_business_volume> pageBean = hunan_business_volumeService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}
	//����ʡ���л�������
	@RequestMapping(value = "/ajax/div3", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_freight_income> ajaxDiv3(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String city,
			HttpSession session) {
		PageBean<Hunan_freight_income> pageBean = hunan_freight_incomeService
				.queryByCondition(pageNo, pageSize, city);
		return pageBean;
	}

	/*
	 * @RequestMapping(value = "/ajax/div4", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<Hunan_freight_turnover_volume> ajaxDiv4(
	 * 
	 * @RequestParam(value = "pageNo", required = false, defaultValue = "1")
	 * Integer pageNo,
	 * 
	 * @RequestParam(value = "pageSize", required = false, defaultValue = "5")
	 * Integer pageSize, HttpSession session) {
	 * PageBean<Hunan_freight_turnover_volume> page =
	 * hunan_freight_turnover_volumeService .queryByPage(pageNo, pageSize);
	 * List<Hunan_freight_turnover_volume> list = page.getList();
	 * session.setAttribute("pageBean", page); return list; }
	 */
	//����ʡ������
	@RequestMapping(value = "/ajax/div4", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_freight_volume> ajaxDiv4(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_freight_volume> pageBean = hunan_freight_volumeService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_freight_volume> pageBean = hunan_freight_volumeService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}
	//����ʡ������ת��
	@RequestMapping(value = "/ajax/div5", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_freight_turnover_volume> ajaxDiv5(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_freight_turnover_volume> pageBean = hunan_freight_turnover_volumeService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_freight_turnover_volume> pageBean = hunan_freight_turnover_volumeService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}

	//����ʡ������ͨ
	@RequestMapping(value = "/ajax/div6", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_pub_trans> ajaxDiv6(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_pub_trans> pageBean = hunan_pub_transService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_pub_trans> pageBean = hunan_pub_transService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}
	
	//���Ͻ�ͨ��ҵ��
	@RequestMapping(value = "/ajax/div7", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_traffic_employment> ajaxDiv7(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_traffic_employment> pageBean = hunan_traffic_employmentService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_traffic_employment> pageBean = hunan_traffic_employmentService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}
	
	//����ʡ�����߳���
	@RequestMapping(value = "/ajax/div8", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Hunan_transline_length> ajaxDiv8(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Hunan_transline_length> pageBean = hunan_transline_lengthService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Hunan_transline_length> pageBean = hunan_transline_lengthService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}

	//���Ϲ�·Ӫ������
	@RequestMapping(value = "/ajax/div9", method = RequestMethod.GET)
	@ResponseBody
	public PageBean<Public_transportation> ajaxDiv9(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "condition", required = false) String years,
			HttpSession session) {
		if (years != null) {
			PageBean<Public_transportation> pageBean = public_transportationService
					.queryByCondition(pageNo, pageSize, Integer.valueOf(years));
			return pageBean;
		} else {
			PageBean<Public_transportation> pageBean = public_transportationService
					.queryByPage(pageNo, pageSize);
			return pageBean;
		}
	}

	/*
	 * �û���
	 */
	// �����û�������
	@RequestMapping(value = "/ajax/addUser")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		System.out.println(user);
		userService.addIntoUser(user);
		return "add success";
	}

	// ɾ���û�������
	@RequestMapping(value = "/ajax/delUser")
	@ResponseBody
	public String delUser(@RequestParam("id") String id) {
		System.out.println(id);
		userService.delFromUser(Integer.valueOf(id));
		return "delete success";
	}

	// �޸��û�������
	@RequestMapping(value = "/ajax/updateUser")
	@ResponseBody
	public String updateUser(@RequestBody User user) {
		System.out.println(user);
		userService.updateFromUser(user);
		return "update success";
	}

	/*
	 * ����ʡҵ������
	 */
	// ���Ӻ���ʡҵ����������
	@RequestMapping(value = "/ajax/addHunan_business_volume")
	@ResponseBody
	public String addHunanBusinessVolume(
			@RequestBody Hunan_business_volume hunan_business_volume) {
		System.out.println(hunan_business_volume);
		hunan_business_volume.setTotal_volume(hunan_business_volume
				.getOther_provinces()
				+ hunan_business_volume.getProvince()
				+ hunan_business_volume.getInternational());
		hunan_business_volumeService
				.addIntohunan_business_volume(hunan_business_volume);
		return "add success";
	}

	// ɾ������ʡҵ����������
	@RequestMapping(value = "/ajax/delHunan_business_volume")
	@ResponseBody
	public String delHunan_business_volume(@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_business_volumeService.delFromhunan_business_volume(years);
		return "delete success";
	}

	// �޸ĺ���ʡҵ����������
	@RequestMapping(value = "/ajax/updateHunan_business_volume")
	@ResponseBody
	public String updateHunan_business_volume(
			@RequestBody Hunan_business_volume hunan_business_volume) {
		System.out.println(hunan_business_volume);
		hunan_business_volume.setTotal_volume(hunan_business_volume
				.getOther_provinces()
				+ hunan_business_volume.getProvince()
				+ hunan_business_volume.getInternational());
		hunan_business_volumeService
				.updateFromhunan_business_volume(hunan_business_volume);
		return "update success";
	}

	/*
	 * ����ʡ���������
	 */
	// ���Ӻ���ʡ�������������
	@RequestMapping(value = "/ajax/addHunan_freight_income")
	@ResponseBody
	public String addHunanFreightIncome(
			@RequestBody Hunan_freight_income hunan_freight_income) {
		System.out.println(hunan_freight_income);
		hunan_freight_incomeService
				.addIntohunan_freight_income(hunan_freight_income);
		return "add success";
	}

	// ɾ������ʡ�������������
	@RequestMapping(value = "/ajax/delHunan_freight_income")
	@ResponseBody
	public String delHunanFreightIncome(@RequestParam("id") Integer id) {
		hunan_freight_incomeService.delFromhunan_freight_income(id);
		return "delete success";
	}

	// �޸ĺ���ʡ������������
	@RequestMapping(value = "/ajax/updateHunan_freight_income")
	@ResponseBody
	public String updateHunanFreightIncome(
			@RequestBody Hunan_freight_income hunan_freight_income) {
		System.out.println(hunan_freight_income);
		hunan_freight_incomeService
				.updateFromhunan_freight_income(hunan_freight_income);
		return "update success";
	}

	/*
	 * ����ʡ��������
	 */
	// ���Ӻ���ʡ������������
	@RequestMapping(value = "/ajax/addHunan_freight_volume")
	@ResponseBody
	public String addHunanFreightVolume(
			@RequestBody Hunan_freight_volume hunan_freight_volume) {
		System.out.println(hunan_freight_volume);
		hunan_freight_volume.setTotal_railway(hunan_freight_volume
				.getNational_railway()
				+ hunan_freight_volume.getLocal_railway()
				+ hunan_freight_volume.getJoint_venture_railway());
		hunan_freight_volume.setTotal(hunan_freight_volume.getTotal_railway()
				+ hunan_freight_volume.getHighway()
				+ hunan_freight_volume.getWaterway());
		hunan_freight_volumeService
				.addIntohunan_freight_volume(hunan_freight_volume);
		return "add success";
	}

	// ɾ������ʡ������������
	@RequestMapping(value = "/ajax/delHunan_freight_volume")
	@ResponseBody
	public String delHunan_freight_volume(@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_freight_volumeService.delFromhunan_freight_volume(years);
		return "delete success";
	}

	// �޸ĺ���ʡҵ����������
	@RequestMapping(value = "/ajax/updateHunan_freight_volume")
	@ResponseBody
	public String updateHunan_freight_volume(
			@RequestBody Hunan_freight_volume hunan_freight_volume) {
		System.out.println(hunan_freight_volume);
		hunan_freight_volume.setTotal_railway(hunan_freight_volume
				.getNational_railway()
				+ hunan_freight_volume.getLocal_railway()
				+ hunan_freight_volume.getJoint_venture_railway());
		hunan_freight_volume.setTotal(hunan_freight_volume.getTotal_railway()
				+ hunan_freight_volume.getHighway()
				+ hunan_freight_volume.getWaterway());
		hunan_freight_volumeService
				.updateFromhunan_freight_turnover_volume(hunan_freight_volume);
		return "update success";
	}

	/*
	 * ����ʡ������ת����
	 */
	// ���Ӻ���ʡ������ת��������
	@RequestMapping(value = "/ajax/addHunan_freight_turnover_volume")
	@ResponseBody
	public String addHunanFreightTurnoverVolume(
			@RequestBody Hunan_freight_turnover_volume hunan_freight_turnover_volume) {
		System.out.println(hunan_freight_turnover_volume);
		hunan_freight_turnover_volume
				.setTotal_railway(hunan_freight_turnover_volume
						.getNational_railway()
						+ hunan_freight_turnover_volume.getLocal_railway()
						+ hunan_freight_turnover_volume
								.getJoint_venture_railway());
		hunan_freight_turnover_volumeService
				.addIntohunan_freight_turnover_volume(hunan_freight_turnover_volume);
		return "add success";
	}

	// ɾ������ʡ������ת��������
	@RequestMapping(value = "/ajax/delHunan_freight_turnover_volume")
	@ResponseBody
	public String delHunanFreightTurnoverVolume(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_freight_turnover_volumeService
				.delFromhunan_freight_turnover_volume(years);
		return "delete success";
	}

	// �޸ĺ���ʡ������ת��������
	@RequestMapping(value = "/ajax/updateHunan_freight_turnover_volume")
	@ResponseBody
	public String updateHunanFreightTurnoverVolume(
			@RequestBody Hunan_freight_turnover_volume hunan_freight_turnover_volume) {
		System.out.println(hunan_freight_turnover_volume);
		hunan_freight_turnover_volume
				.setTotal_railway(hunan_freight_turnover_volume
						.getNational_railway()
						+ hunan_freight_turnover_volume.getLocal_railway()
						+ hunan_freight_turnover_volume
								.getJoint_venture_railway());
		hunan_freight_turnover_volumeService
				.updateFromhunan_freight_turnover_volume(hunan_freight_turnover_volume);
		return "update success";
	}
	
	/*
	 * ����ʡ������ͨ
	 */
	// ���Ӻ���ʡ������ͨ������
	@RequestMapping(value = "/ajax/addHunan_pub_trans")
	@ResponseBody
	public String addHunanPubTrans(
			@RequestBody Hunan_pub_trans hunan_pub_trans) {
		System.out.println(hunan_pub_trans);
		hunan_pub_transService.addIntohunan_pub_trans(hunan_pub_trans);
		return "add success";
	}

	// ɾ������ʡ������ͨ������
	@RequestMapping(value = "/ajax/delHunan_pub_trans")
	@ResponseBody
	public String delHunanPubTrans(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_pub_transService.delFromhunan_pub_trans(years);
		return "delete success";
	}

	// �޸ĺ���ʡ������ͨ������
	@RequestMapping(value = "/ajax/updateHunan_pub_trans")
	@ResponseBody
	public String updateHunanPubTrans(
			@RequestBody Hunan_pub_trans hunan_pub_trans) {
		System.out.println(hunan_pub_trans);
		hunan_pub_transService.updateFromhunan_pub_trans(hunan_pub_trans);
		return "update success";
	}
	
	/*
	 * ���Ͻ�ͨ��ҵ��
	 */
	// ���Ӻ��Ͻ�ͨ��ҵ��������
	@RequestMapping(value = "/ajax/addHunan_traffic_employment")
	@ResponseBody
	public String addHunanTrafficEmployment(
			@RequestBody Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println(hunan_traffic_employment);
		hunan_traffic_employmentService.addIntoHunan_traffic_employment(hunan_traffic_employment);
		return "add success";
	}

	// ɾ�����Ͻ�ͨ��ҵ��������
	@RequestMapping(value = "/ajax/delHunan_traffic_employment")
	@ResponseBody
	public String delHunanTrafficEmployment(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_traffic_employmentService.delFromHunan_traffic_employment(years);
		return "delete success";
	}

	// �޸ĺ��Ͻ�ͨ��ҵ��������
	@RequestMapping(value = "/ajax/updateHunan_traffic_employment")
	@ResponseBody
	public String updateHunanTrafficEmployment(
			@RequestBody Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println(hunan_traffic_employment);
		hunan_traffic_employmentService.updateFromHunan_traffic_employment(hunan_traffic_employment);
		return "update success";
	}
	
	/*
	 * ����ʡ�����߳��ȱ�
	 */
	// ���Ӻ���ʡ�����߳��ȱ�����
	@RequestMapping(value = "/ajax/addHunan_transline_length")
	@ResponseBody
	public String addHunanTranslineLength(
			@RequestBody Hunan_transline_length hunan_transline_length) {
		System.out.println(hunan_transline_length);
		hunan_transline_length.setHighway_mileage(hunan_transline_length.getClassified_highway()+hunan_transline_length.getOther_road());
		hunan_transline_lengthService.addIntoHunan_transline_length(hunan_transline_length);
		return "add success";
	}

	// ɾ������ʡ�����߳��ȱ�����
	@RequestMapping(value = "/ajax/delHunan_transline_length")
	@ResponseBody
	public String delHunanTranslineLength(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_transline_lengthService.delFromHunan_transline_length(years);
		return "delete success";
	}

	// �޸ĺ���ʡ�����߳��ȱ�����
	@RequestMapping(value = "/ajax/updateHunan_transline_length")
	@ResponseBody
	public String updateHunanTranslineLength(
			@RequestBody Hunan_transline_length hunan_transline_length) {
		System.out.println(hunan_transline_length);
		hunan_transline_length.setHighway_mileage(hunan_transline_length.getClassified_highway()+hunan_transline_length.getOther_road());
		hunan_transline_lengthService.updateFromHunan_transline_length(hunan_transline_length);
		return "update success";
	}
	
	/*
	 * ���Ϲ�·Ӫ��������
	 */
	// ���Ӻ��Ϲ�·Ӫ������������
	@RequestMapping(value = "/ajax/addPublic_transportation")
	@ResponseBody
	public String addPublicTransportation(
			@RequestBody Public_transportation public_transportation) {
		System.out.println(public_transportation);
		public_transportation.setTotal_vehicles(public_transportation.getOperating_passenger_capacity()+public_transportation.getOperating_cargo_capacity());
		public_transportationService.addIntoPublic_transportation(public_transportation);
		return "add success";
	}

	// ɾ�����Ϲ�·Ӫ������������
	@RequestMapping(value = "/ajax/delPublic_transportation")
	@ResponseBody
	public String delPublicTransportation(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		public_transportationService.delFromPublic_transportation(years);
		return "delete success";
	}

	// �޸ĺ��Ϲ�·Ӫ������������
	@RequestMapping(value = "/ajax/updatePublic_transportation")
	@ResponseBody
	public String updatePublicTransportation(
			@RequestBody Public_transportation public_transportation) {
		System.out.println(public_transportation);
		public_transportation.setTotal_vehicles(public_transportation.getOperating_passenger_capacity()+public_transportation.getOperating_cargo_capacity());
		public_transportationService.updateFromPublic_transportation(public_transportation);
		return "update success";
	}
}
