<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/inc.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号单</title>
<script type="text/javascript">
	$(function(){
		$("#te").hide();
		$.post(
			"getKx",
			function(obj)
			{
				var klist =obj.klist;
				for (var i in klist) {
					$("#kid").append("<option value='"+klist[i].kid+"' style='font-size:30px'>"+klist[i].kname+"</option>");
				}
			},"json"
		);
		$("#kid").change(function(){
			$("#yid").empty();
			var kid = $(this).val();
			$.post(
				"getWy",
				{kid:kid},
				function(obj)
				{
					$("#yid").append("<option>-----------请选择医生----------</option>");
					for(var i in obj)
					{
						$("#yid").append("<option value='"+obj[i].yid+"' style='font-size:30px'>"+obj[i].yname+"</option>");
					}
				},"json"
			);
		});
		$("#yid").change(function(){
			var yid = $(this).val();
			$.post(
					"getPrice",
					{yid:yid},
					function(obj)
					{
						$("#fy").text(obj.price)
					},"json"
				);
		})
		$(".btn-danger").click(function(){
			if(confirm("您确认挂号么?"))
			{
				$.post(
					"addGua",
					$("form").serialize(),
					function(obj)
					{
						if(obj)
						{
							alert("挂号成功")
							location="getAll";
						}else
						{
							alert("挂号失败")
						}	
					},
					"json"
				);
				
			}
		
		});
			
		$(".btn-success").click(function(){
			$("#tab").hide();
			$("#te").fadeIn(2000);	
			var hid =$(this).val();
			$.post(
					"getName",
					{hid:hid},
					function(obj)
					{
							$(".h").val(obj.hid);
							$("#bl").text(obj.dh);
							$("#br").text(obj.bname);
					}
				);
		});
		$(".btn-info").click(function(){
			var hid = $(".h").val();
			$.post(
				"wz",
				{hid:hid},
				function(obj)
				{
					if(obj)
					{
						alert("问诊完成")
						location="ghxq";
					}else
					{
						alert("问诊失败")
					}
				}
			);
		});
		$(".btn-success").map(function(){
			
			if($(this).text()=="已就诊")
		{
			$(this).attr({"disabled":"disabled"})
			}
		});
	});
</script>
</head>
<body>
		<div class="container" >
		<form>
			<div style="background: #5BBEEE;height: 40px">
				<p style="font-size: 16px;padding-top: 10px">挂单号</p>
			</div>
			
			<div style="margin-top: 20px;margin-left: 30px">
				<label style="font-size: 30px;margin-top:20px">病人姓名 :</label>
				<input type="text" name="bname"  value="${username }" style="height: 40px;width: 200px">
				<div style="float: right;margin-top: 10px">
				<label style="font-size: 30px;margin-top: 10px">挂号科室 :</label>
				<select id="kid" name="kx.kid" style="height: 40px;width: 250px;" >
					<option style="margin-bottom:20px;text-align: center;font-size: 30px;">-------请选择科室--------</option>
				</select>
				</div>
			</div>	
				<div style="margin-top: 50px;float: left;margin-left: 30px">
					<label style="font-size: 30px">病人性别 :</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="0">女&nbsp;&nbsp;
					<input type="radio" name="sex" value="1">男
				</div>
					<div style="float: right;margin-top: 50px">
				<label style="font-size: 30px;margin-top: 10px">挂号医生 :</label>
				<select id="yid" name="wy.yid" style="height: 40px;width: 250px;margin-top: -20px" >
					<option style="margin-bottom:20px;text-align: center;font-size: 30px;">-------请选择医生--------</option>
				</select>
				</div>
				<div style="margin-top: 200px;margin-left: 30px">
				<label style="font-size: 30px">联系电话 :</label>
				<input type="text" name="tel" style="height: 40px;width: 200px;padding-top: 20px">
				<div style="float: right;margin-right: 150px;margin-top: 10px">
					<label  style="font-size: 30px">挂号费用 :</label>
					<span id="fy" style="font-size: 30px"></span><span  style="font-size: 30px">元</span>
				</div>
				</div>
				
				<div align="center" style="margin-top: 30px">
					<button class="btn btn-danger" type="button" style="width: 300px;height: 60px;font-size: 20px">挂号</button>
				</div>
		</form>
		<table id="tab" class="table table-bordered">
			<tr>
				<td>病人姓名</td>
				<td>病人性别</td>
				<td>科室名称</td>
				<td>主治医师</td>
				<td>门诊挂号状态</td>
				<td>挂号日期</td>
				<td>挂号时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="bn">
			<tr>
				<input type="hidden" value="${bn.hid }">
				<td>${bn.bname }</td>
				<td>${bn.sex==0?'女':'男' }</td>
				<td>${bn.kx.kname }</td>
				<td>${bn.wy.yname }</td>
				<td>${bn.status==1?'已就诊':'未就诊' }</td>
				<td>
				${bn.g_date }
				</td>
				<td>${bn.g_time }</td>
				<td><button class="btn btn-success" value="${bn.hid }" type="button">${bn.status==1?'已就诊':'未就诊' }</button></td>
			</tr>
			</c:forEach>
		</table>
			<div id="te" style="margin-top: 100px">
				<div style="float: left;font-size: 30px">
					<label>病例编号 :</label>
					<span id="bl" name="bl"></span>
				</div>
				<div style="float: right;font-size: 30px">
					<label>就诊病人 :</label>
					<span id="br"></span>
				</div>
				<div style="float:left; font-size: 30px;margin-top: 50px">
				<input type="hidden" name="hid" class="h" >
					<label>病人病历 :</label>
					<textarea rows="10px" cols="50px"></textarea>
					<div style="font-size: 30px" align="center">
					<button class="btn btn-info" type="button" style="width: 300px;height: 60px;font-size: 20px">确认</button>
				</div>
				</div>
				
			</div>
		</div>
</body>
</html>