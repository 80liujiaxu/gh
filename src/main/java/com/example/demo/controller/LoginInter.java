package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInter implements HandlerInterceptor{

	public List<String> values = new ArrayList<String>();

	public LoginInter()
	{
		this.values.add("/");
		this.values.add("yz");
		this.values.add("login");
	}  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		for (String s : this.values) {
			if(url.endsWith(s))
			{
				return true;
			}	
		}
		ServletContext application = request.getSession().getServletContext();
		
		if(application.getAttribute("us")!=null)
		{
			return true;
		}  
		HttpSession session = request.getSession();
		if(session.getAttribute("us")!=null)
		{
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/");
		return false;
	}

	
}
