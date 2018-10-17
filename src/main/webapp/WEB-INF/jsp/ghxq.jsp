<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/inc.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<script type="text/javascript">
		$(function(){
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
	<div class="container" style="background: #eee;margin-top: 30px">
	<div>
		<span style="font-size: 20px;float: left">
			问诊记录
		</span>
	</div>
			
					<div style="float: right;">
					<form action="ghxq">
						<table>
						<tr>
							<td>
						
							<input type="text" name="mohu" value="${mohu }" placeholder="请输入病历单号">
							<button type="submit" class="btn btn-info">按病历单号查询</button>
							</td>
						</tr>
						</table>
					</form>
					</div>
			
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
			<c:forEach items="${pager.datas }" var="bn">
			<tr>
				
				<td>${bn.bname }</td>
				<td>${bn.sex==0?'女':'男' }</td>
				<td>${bn.kx.kname }</td>
				<td>${bn.wy.yname }</td>
				<td id="status">${bn.status==1?'已就诊':'未就诊' }</td>
				<td>
				${bn.g_date }
				</td>
				<td>${bn.g_time }</td>
				<td><button class="btn btn-success"   type="button">${bn.status==1?'已就诊':'未就诊'  }</button></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="10">
					<jsp:include page="/resources/inc/pager.jsp">
						<jsp:param value="${pager.total }" name="items"/>
						<jsp:param value="ghxq" name="url"/>
					</jsp:include>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>