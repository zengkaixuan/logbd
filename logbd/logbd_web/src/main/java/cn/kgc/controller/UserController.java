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

	// user表的分页查询
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

	// hunan_business_volume表的分页查询
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
	//湖南省各市货运收入
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
	//湖南省货运量
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
	//湖南省货运周转量
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

	//湖南省公共交通
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
	
	//湖南交通就业量
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
	
	//湖南省运输线长度
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

	//湖南公路营运汽车
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
	 * 用户表
	 */
	// 增加用户表数据
	@RequestMapping(value = "/ajax/addUser")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		System.out.println(user);
		userService.addIntoUser(user);
		return "add success";
	}

	// 删除用户表数据
	@RequestMapping(value = "/ajax/delUser")
	@ResponseBody
	public String delUser(@RequestParam("id") String id) {
		System.out.println(id);
		userService.delFromUser(Integer.valueOf(id));
		return "delete success";
	}

	// 修改用户表数据
	@RequestMapping(value = "/ajax/updateUser")
	@ResponseBody
	public String updateUser(@RequestBody User user) {
		System.out.println(user);
		userService.updateFromUser(user);
		return "update success";
	}

	/*
	 * 湖南省业务量表
	 */
	// 增加湖南省业务量表数据
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

	// 删除湖南省业务量表数据
	@RequestMapping(value = "/ajax/delHunan_business_volume")
	@ResponseBody
	public String delHunan_business_volume(@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_business_volumeService.delFromhunan_business_volume(years);
		return "delete success";
	}

	// 修改湖南省业务量表数据
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
	 * 湖南省货运收入表
	 */
	// 增加湖南省货运收入表数据
	@RequestMapping(value = "/ajax/addHunan_freight_income")
	@ResponseBody
	public String addHunanFreightIncome(
			@RequestBody Hunan_freight_income hunan_freight_income) {
		System.out.println(hunan_freight_income);
		hunan_freight_incomeService
				.addIntohunan_freight_income(hunan_freight_income);
		return "add success";
	}

	// 删除湖南省货运收入表数据
	@RequestMapping(value = "/ajax/delHunan_freight_income")
	@ResponseBody
	public String delHunanFreightIncome(@RequestParam("id") Integer id) {
		hunan_freight_incomeService.delFromhunan_freight_income(id);
		return "delete success";
	}

	// 修改湖南省货运收入数据
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
	 * 湖南省货运量表
	 */
	// 增加湖南省货运量表数据
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

	// 删除湖南省货运量表数据
	@RequestMapping(value = "/ajax/delHunan_freight_volume")
	@ResponseBody
	public String delHunan_freight_volume(@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_freight_volumeService.delFromhunan_freight_volume(years);
		return "delete success";
	}

	// 修改湖南省业务量表数据
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
	 * 湖南省货运周转量表
	 */
	// 增加湖南省货运周转量表数据
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

	// 删除湖南省货运周转量表数据
	@RequestMapping(value = "/ajax/delHunan_freight_turnover_volume")
	@ResponseBody
	public String delHunanFreightTurnoverVolume(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_freight_turnover_volumeService
				.delFromhunan_freight_turnover_volume(years);
		return "delete success";
	}

	// 修改湖南省货运周转量表数据
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
	 * 湖南省公共交通
	 */
	// 增加湖南省公共交通表数据
	@RequestMapping(value = "/ajax/addHunan_pub_trans")
	@ResponseBody
	public String addHunanPubTrans(
			@RequestBody Hunan_pub_trans hunan_pub_trans) {
		System.out.println(hunan_pub_trans);
		hunan_pub_transService.addIntohunan_pub_trans(hunan_pub_trans);
		return "add success";
	}

	// 删除湖南省公共交通表数据
	@RequestMapping(value = "/ajax/delHunan_pub_trans")
	@ResponseBody
	public String delHunanPubTrans(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_pub_transService.delFromhunan_pub_trans(years);
		return "delete success";
	}

	// 修改湖南省公共交通表数据
	@RequestMapping(value = "/ajax/updateHunan_pub_trans")
	@ResponseBody
	public String updateHunanPubTrans(
			@RequestBody Hunan_pub_trans hunan_pub_trans) {
		System.out.println(hunan_pub_trans);
		hunan_pub_transService.updateFromhunan_pub_trans(hunan_pub_trans);
		return "update success";
	}
	
	/*
	 * 湖南交通就业量
	 */
	// 增加湖南交通就业量表数据
	@RequestMapping(value = "/ajax/addHunan_traffic_employment")
	@ResponseBody
	public String addHunanTrafficEmployment(
			@RequestBody Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println(hunan_traffic_employment);
		hunan_traffic_employmentService.addIntoHunan_traffic_employment(hunan_traffic_employment);
		return "add success";
	}

	// 删除湖南交通就业量表数据
	@RequestMapping(value = "/ajax/delHunan_traffic_employment")
	@ResponseBody
	public String delHunanTrafficEmployment(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_traffic_employmentService.delFromHunan_traffic_employment(years);
		return "delete success";
	}

	// 修改湖南交通就业量表数据
	@RequestMapping(value = "/ajax/updateHunan_traffic_employment")
	@ResponseBody
	public String updateHunanTrafficEmployment(
			@RequestBody Hunan_traffic_employment hunan_traffic_employment) {
		System.out.println(hunan_traffic_employment);
		hunan_traffic_employmentService.updateFromHunan_traffic_employment(hunan_traffic_employment);
		return "update success";
	}
	
	/*
	 * 湖南省运输线长度表
	 */
	// 增加湖南省运输线长度表数据
	@RequestMapping(value = "/ajax/addHunan_transline_length")
	@ResponseBody
	public String addHunanTranslineLength(
			@RequestBody Hunan_transline_length hunan_transline_length) {
		System.out.println(hunan_transline_length);
		hunan_transline_length.setHighway_mileage(hunan_transline_length.getClassified_highway()+hunan_transline_length.getOther_road());
		hunan_transline_lengthService.addIntoHunan_transline_length(hunan_transline_length);
		return "add success";
	}

	// 删除湖南省运输线长度表数据
	@RequestMapping(value = "/ajax/delHunan_transline_length")
	@ResponseBody
	public String delHunanTranslineLength(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		hunan_transline_lengthService.delFromHunan_transline_length(years);
		return "delete success";
	}

	// 修改湖南省运输线长度表数据
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
	 * 湖南公路营运汽车表
	 */
	// 增加湖南公路营运汽车表数据
	@RequestMapping(value = "/ajax/addPublic_transportation")
	@ResponseBody
	public String addPublicTransportation(
			@RequestBody Public_transportation public_transportation) {
		System.out.println(public_transportation);
		public_transportation.setTotal_vehicles(public_transportation.getOperating_passenger_capacity()+public_transportation.getOperating_cargo_capacity());
		public_transportationService.addIntoPublic_transportation(public_transportation);
		return "add success";
	}

	// 删除湖南公路营运汽车表数据
	@RequestMapping(value = "/ajax/delPublic_transportation")
	@ResponseBody
	public String delPublicTransportation(
			@RequestParam("years") Integer years) {
		System.out.println(years);
		public_transportationService.delFromPublic_transportation(years);
		return "delete success";
	}

	// 修改湖南公路营运汽车表数据
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
