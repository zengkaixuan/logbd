package cn.kgc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.entity.Hunan_business_volume;
import cn.kgc.entity.Hunan_freight_income;
import cn.kgc.entity.Hunan_freight_turnover_volume;
import cn.kgc.entity.Hunan_freight_volume;
import cn.kgc.entity.Hunan_pub_trans;
import cn.kgc.entity.Hunan_traffic_employment;
import cn.kgc.entity.Hunan_transline_length;
import cn.kgc.entity.Public_transportation;
import cn.kgc.entity.User;
import cn.kgc.service.Hunan_business_volumeService;
import cn.kgc.service.Hunan_freight_incomeService;
import cn.kgc.service.Hunan_freight_turnover_volumeService;
import cn.kgc.service.Hunan_freight_volumeService;
import cn.kgc.service.Hunan_pub_transService;
import cn.kgc.service.Hunan_traffic_employmentService;
import cn.kgc.service.Hunan_transline_lengthService;
import cn.kgc.service.Public_transportationService;
import cn.kgc.service.UserService;

@Controller
public class ShowController {
	
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
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("login");
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/detail")
	public String todetail(@RequestParam(value="id",required=false)Integer id){
		System.out.println(id);
		return "detail";
	}
	
/*	@RequestMapping(value="/detail")
	public String detail(@RequestParam(value="id",required=false)Integer id){
		System.out.println(id);
		String url="redirect:detail?"+id;
		return url;
	}*/
	
	
	@RequestMapping("/toLogin")
	public String toLogin(User user,HttpSession session,Model model){
		System.out.println(user);
		List<User> users = userService.selectAll();
		if(users.contains(user)){
			//登录成功
			System.out.println("登录成功");
			//将用户对象放到session
			session.setAttribute("user", user);
			//重定向到员工列表
			return "redirect:index";
		}else{
			//登陆失败
			//绑定错误消息
			System.out.println("登录错误");
			model.addAttribute("msg","用户名或密码错误");
			//转发回登录页面
			return "login";
		}
	}
	
	@RequestMapping("/ajax_index")
	@ResponseBody
	public List<Object> ajaxIndex(){
		System.out.println("ajax请求");
		List<Object> list=new ArrayList<Object>();
		List<Hunan_business_volume> business_volumes = hunan_business_volumeService.selectAll();
		List<Hunan_freight_income> freight_incomes = hunan_freight_incomeService.selectAll();
		List<Hunan_freight_turnover_volume> freight_turnover_volumes = hunan_freight_turnover_volumeService.selectAll();
		List<Hunan_freight_volume> freight_volumes = hunan_freight_volumeService.selectAll();
		List<Hunan_pub_trans> hunan_pub_trans = hunan_pub_transService.selectAll();
		List<Hunan_traffic_employment> employments = hunan_traffic_employmentService.selectAll();
		List<Hunan_transline_length> hunan_transline_lengths = hunan_transline_lengthService.selectAll();
		List<Public_transportation> public_transportations = public_transportationService.selectAll();
		list.add(business_volumes);
		list.add(freight_incomes);
		list.add(freight_turnover_volumes);
		list.add(freight_volumes);
		list.add(hunan_pub_trans);
		list.add(employments);
		list.add(hunan_transline_lengths);
		list.add(public_transportations);
		return list;
	}
}
