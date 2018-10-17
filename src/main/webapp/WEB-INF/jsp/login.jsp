<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/inc.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/resources/js/angular.js"></script>
<title>登录</title>
		<script>
		
		$(function(){
			$("#lj").blur(function(){
				var username=$("[name='username']").val();
				$.post(
					"yz",
					{username:username},
					function(obj)
					{
						if(obj==false)
						{
							alert("对不起,用户不存在");
						}else
							if(obj==true)
						{
							$(".btn-success").click(function(){
							var username=$("[name='username']").val();
							var password=$("[name='password']").val();
							var jz=0;
							if($("[name='jz']").prop("checked"))
							{
								jz=1;
							} 
							$.post(
								"login",
								{username:username,password:password,jz:jz},
								function(obj)
								{
									if(obj!=null)
									{
										alert("登录成功")
										//location="list?username="+obj.username;
										location="test";
									}else
									{
										alert("登录失败")
									}	
								},
								"json"
							);
						});
					}
				},"json"
			);
				
		});
		
	});
		</script>
</head>
<body>
		<div class="container" align="center" style="margin-top: 200px;background-color: #eee;width: 300px;height:350px">
			<div style="margin-top: 20px">
				<span style="font-size: 30px;font-weight: bolder;">医院门诊系统</span>
			</div>
			<div style="margin-top: 60px">
				<input type="text" name="username" id="lj" placeholder="用户名" style="width: 250px;height: 40px">
			</div>
			<div style="margin-top: 10px">
				<input type="text" name="password"  placeholder="密码" width="250px" height="20px" style="width: 250px;height: 40px">
			</div>
			<div style="margin-top: 10px;margin-right: 110px">
				<input type="checkbox" name="jz" value="1">&nbsp;&nbsp;保持我的登录状态
			</div>
			<div>
				<button type="button" class="btn btn-success" style="margin-top:45px;width: 200px;height: 50px">登录</button>
			</div>
		</div>
</body>
</html>