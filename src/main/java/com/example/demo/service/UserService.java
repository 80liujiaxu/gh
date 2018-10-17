package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.ServletContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.User;
import com.example.demo.dto.Wy;
import com.example.demo.dto.Xq;
import com.example.demo.utils.Pager;

@Transactional
public interface UserService {

	User findMing(String username);

	User findUser(User user,ServletContext application,int jz,HttpSession session);

	Map<String,Object> getAll();

	List<Wy> getWy(int kid);

	Wy getPrice(int yid);

	int addGua(Xq xq);

	List<Xq> getXq();

	Xq getName(int hid);

	int wy(int hid);

	Pager<Xq> getGhxq(String mohu);


}
