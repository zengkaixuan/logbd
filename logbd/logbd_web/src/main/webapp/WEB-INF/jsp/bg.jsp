<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bg_page.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bg_table.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bg_lt.js"></script>
<style type="text/css">

	
</style>
</head>
<body>

<div>
	<div class="left">
		<div class="bigTitle">物流大数据后台管理系统</div>
		<div class="lines">
			<div onclick="pageClick(this)" class="active" >
				<img src="${pageContext.request.contextPath}/img/icon-3.png" />用户信息
			</div>
			<div onclick="pageClick(this)"  class="div2">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />湖南省商业量
			</div>
			<div onclick="pageClick(this)"  class="div3">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />湖南省货运收入
			</div>
			<div onclick="pageClick(this)"  class="div4">
				<img src="${pageContext.request.contextPath}/img/icon-5.png"/>湖南省货运量
			</div>
			<div onclick="pageClick(this)"  class="div5">
				<img src="${pageContext.request.contextPath}/img/icon-4.png" />湖南省货运周转量
			</div>
			<div onclick="pageClick(this)"  class="div6">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />湖南省交通
			</div>
			<div onclick="pageClick(this)"  class="div7">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />湖南省交通就业人员
			</div>
			<div onclick="pageClick(this)"  class="div8">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />湖南省运输线长度
			</div>
			<div onclick="pageClick(this)"  class="div9">
				<img src="${pageContext.request.contextPath}/img/icon-5.png" />公共交通
			</div>
		</div>
	</div>
	<div class="top">
		<div class="leftTiyle" id="flTitle">用户信息</div>
		<div class="thisUser">当前用户:${user.userName}</div>
	</div>
	<div class="content">
	    <div class="xiaLaXuan"><!-- 下拉框 --></div>
		<table  class="tables" cellspacing="0"><!-- 表格中内容有ajax渲染 --></table>
		<div class="fenYe">
				
		</div>
	</div>
	
	
	 <!--  restful删除请求表单 -->
    <div style="display:none">
        <form name="delForm" action="${pageContext.request.contextPath}/delete/user" method="POST">
           <input type="hidden" name="_method" value="DELETE"/>
        </form>
    </div>
</div>
</body>
</html>