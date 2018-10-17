package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.ServletContext;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.User;
import com.example.demo.dto.Wy;
import com.example.demo.dto.Xq;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService  userService;
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }
	
	
	@RequestMapping("/")
	public String index()
	{
		return "login";
	}
	
	//验证用户名是否存在
	@RequestMapping("yz")
	@ResponseBody
	public boolean yz(String username)
	{
		return this.userService.findMing(username)!=null;
	}
	
	//登录
	@RequestMapping("login")
	@ResponseBody
	public User login(User user,int jz,HttpSession session,HttpServletRequest request)
	{
		ServletContext application =(ServletContext) request.getSession().getServletContext();
		return this.userService.findUser(user,application,jz,session);
	}
	
	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}
	
	//挂号
	@RequestMapping("list")
	public String list(String username,Model model)
	{
		model.addAttribute("username", username);
		return "list";
	}
	
	//获取所有科室
	@RequestMapping("getKx")
	@ResponseBody
	public Map<String,Object> getAll()
	{
		return this.userService.getAll();
	}
	//获取科室的医生
	@RequestMapping("getWy")
	@ResponseBody
	public List<Wy> getWy(int kid)
	{
		System.out.println(kid);
		List<Wy> list = this.userService.getWy(kid);
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(object);
		}
		return list;
	}
	
	//获取单个医生的出诊费
	@RequestMapping("getPrice")
	@ResponseBody
	public Wy getPrice(int yid)
	{
		System.out.println(yid);
		return this.userService.getPrice(yid);
	}
	
	//挂号
	@RequestMapping("addGua")
	@ResponseBody
	public boolean addGua(Xq xq)
	{
		return this.userService.addGua(xq)>0;
	}
	
	//查询所有的挂号单
	@RequestMapping("getAll")
	public String getAll(Model model)
	{
		model.addAttribute("list",this.userService.getXq());
		return "list";
	}
	
	//问诊病人
	@RequestMapping("getName")
	@ResponseBody
	public Xq getName(int hid)
	{
		System.out.println(hid);
		return this.userService.getName(hid);
	}
	
	//修改状态
	@RequestMapping("wz")
	@ResponseBody
	public boolean wz(int hid)
	{
		return  this.userService.wy(hid)>0;
	}
	
	//挂号详情
	@RequestMapping("ghxq")
	public String ghxq(String mohu,Model model,HttpSession session)
	{
		if(mohu!=null)
		{
			System.out.println(mohu);
			session.setAttribute("mohu", mohu);
		}
		mohu=(String)session.getAttribute("mohu");
		model.addAttribute(this.userService.getGhxq(mohu));
		return "ghxq";
	}
	
	
}
