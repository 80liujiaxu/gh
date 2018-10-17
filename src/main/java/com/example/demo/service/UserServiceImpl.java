package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.ServletContext;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KX;
import com.example.demo.dto.User;
import com.example.demo.dto.Wy;
import com.example.demo.dto.Xq;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.Pager;
import com.example.demo.utils.SystemContext;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	//验证是否有用户名
	public User findMing(String username) {
		return this.userMapper.findMing(username);
	}

	public User findUser(User user,ServletContext application,int jz,HttpSession session) {
		User us = this.userMapper.findUser(user);
		System.out.println(jz);
		if(us!=null)
		{
			if(jz==1)
			{
				
				application.setAttribute("us", us);
			}else
			{
				session.setAttribute("us", us);
				//session.invalidate();
			}	
		}
		return us;
	}

	@Override
	public Map<String,Object> getAll() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<KX> klist = this.userMapper.getKx();
		List<Wy> wlist = this.userMapper.getWy();
		map.put("klist", klist);
		map.put("wlist", wlist);
		return map;
	}

	@Override
	public List<Wy> getWy(int kid) {
		return this.userMapper.getWyy(kid);
	}

	@Override
	public Wy getPrice(int yid) {
		return this.userMapper.getPrice(yid);
	}

	@Override
	public int addGua(Xq xq) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(new Date());
		String b =d.substring(0, 11);
		xq.setG_date(b);
		String c = d.substring(11,19);
		xq.setG_time(c);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = sdf1.format(new Date());
		xq.setDh(s);
		return this.userMapper.addGua(xq);
	}

	@Override
	public List<Xq> getXq() {
		return this.userMapper.getXq();
	}

	@Override
	public Xq getName(int hid) {
		return this.userMapper.getName(hid);
	}

	@Override
	public int wy(int hid) {
		int status =1;
		return this.userMapper.wz(status,hid);
	}

	@Override
	public Pager<Xq> getGhxq(String mohu) {
		Pager<Xq> pager = new Pager<Xq>();
		long total = this.userMapper.getCount(mohu);
		int offset =SystemContext.getOffset();
		int pageSize = SystemContext.getPageSize();
		List<Xq> datas =this.userMapper.getGhxq(offset,pageSize,mohu);
		pager.setDatas(datas);
		pager.setTotal(total);
		return pager;
	}
}
