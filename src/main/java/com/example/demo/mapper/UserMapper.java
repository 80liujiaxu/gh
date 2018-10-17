package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.KX;
import com.example.demo.dto.User;
import com.example.demo.dto.Wy;
import com.example.demo.dto.Xq;

public interface UserMapper {
	@Select("select * from us where username=#{username}")
	User findMing(@Param("username")String username);
	@Select("select * from us where username=#{username} and password=#{password}")
	User findUser(User user);
	
	@Select("select * from gk")
	List<KX> getKx();
	
	@Select("select * from wy")
	List<Wy> getWy();
	
	@Select("select * from wy where  kid=#{kid}")
	List<Wy> getWyy(@Param("kid")int kid);
	@Select("select * from wy where  yid=#{yid}")
	Wy getPrice(@Param("yid")int yid);
	@Insert("insert into ghxq values(null,#{bname},#{sex},#{kx.kid},#{wy.yid},0,#{g_date},#{g_time},#{dh})")
	int addGua(Xq xq);
	
	List<Xq> getXq();
	@Select("select * from ghxq where hid=#{hid}")
	Xq getName(@Param("hid")int hid);
	@Update("update ghxq set status=#{status} where hid=#{hid}")
	int wz(@Param("status")int status, @Param("hid")int hid);
	
	long getCount(@Param("mohu")String mohu);
	
	List<Xq> getGhxq(@Param("offset")int offset, @Param("pageSize")int pageSize,@Param("mohu")String mohu);

}
