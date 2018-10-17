package com.example.demo.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

@Component
@ServletComponentScan
@WebFilter("/*")
@WebInitParam(name="pager.offset",value="0")
public class SystemContextFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		int offset=0;
		
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			SystemContext.setOffset(offset);
			SystemContext.setPageSize(5);
			chain.doFilter(request, response);
		} finally {
			// TODO: handle finally clause
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
