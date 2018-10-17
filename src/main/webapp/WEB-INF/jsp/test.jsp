<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<script type="text/javascript">
		var lev =function()
		{
			return "我打";
		}
		/* function Parent()
		{
			var Child = new Object();
			Child.name="李小龙";
			Child.age=25;
			Child.lev=lev;
			return Child;
		}
		var x=Parent();
		alert(x.name);
		alert(x.age);
		alert(x.lev()); */
		/* function Parent()
		{
			this.name="李小龙";
			this.age=38;
			this.sex="男";
			this.lev=lev;
		}
		var x = new Parent();
		alert(x.name);
		alert(x.age);
		alert(x.sex);
		alert(x.lev()); */
		/* JS推荐创建对象的方法混合构造函数 原型方法
		function Parent()
		{
			this.name="李小龙";
			this.age=25;
		}
		Parent.prototype.lev=function()
		{
			return "姓名:"+this.name+"          年龄:"+this.age;
		}
		var x = new Parent();
		alert(x.lev()); */
</script>
</head>
<body>

</body>
</html>