<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>物流数据平台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style2.0.css">
<style type="text/css">
ul li {
	font-size: 30px;
	color: #2ec0f6;
}

.tyg-div {
	z-index: -1000;
	float: left;
	position: absolute;
	left: 5%;
	top: 20%;
}

.tyg-div-denglv {
	z-index: 1000;
	float: right;
	position: absolute;
	right: 3%;
	top: 10%;
}

.tyg-div-form {
	background-color: #23305a;
	width: 300px;
	height: auto;
	margin: 120px auto 0 auto;
	color: #2ec0f6;
}

.tyg-div-form form {
	padding: 10px;
}

.tyg-div-form form input[type="text"] {
	width: 270px;
	height: 30px;
	margin: 25px 10px 0px 0px;
}

.tyg-div-form form button {
	cursor: pointer;
	width: 270px;
	height: 44px;
	margin-top: 25px;
	padding: 0;
	background: #2ec0f6;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #2ec0f6;
	-moz-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px 7px
		0 rgba(0, 0, 0, .2);
	-webkit-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px
		7px 0 rgba(0, 0, 0, .2);
	box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: 700;
	color: #fff;
	text-shadow: 0 1px 2px rgba(0, 0, 0, .1);
	-o-transition: all .2s;
	-moz-transition: all .2s;
	-webkit-transition: all .2s;
	-ms-transition: all .2s;
}
</style>
</head>

<body>
	<div class="tyg-div">
		<ul>
			<li>让</li>
			<li><div style="margin-left:20px;">数</div></li>
			<li><div style="margin-left:40px;">据</div></li>
			<li><div style="margin-left:60px;">改</div></li>
			<li><div style="margin-left:80px;">变</div></li>
			<li><div style="margin-left:100px;">生</div></li>
			<li><div style="margin-left:120px;">活</div></li>
		</ul>
	</div>
	<div id="contPar" class="contPar">
		<div id="page1" style="z-index:1;">
			<div class="title0">物流数据平台</div>
			<div class="title1">运输量 运输线 大数据</div>
			<div class="imgGroug">
				<ul>
					<img alt="" class="img0 png" src="./img/page1_0.png">
					<img alt="" class="img1 png" src="./img/page1_1.png">
					<img alt="" class="img2 png" src="./img/page1_2.png">
				</ul>
			</div>
			<img alt="" class="img3 png" src="${pageContext.request.contextPath}/img/page1_3.png">
		</div>
	</div>
	<div class="tyg-div-denglv">
		<div class="tyg-div-form">
			<form action="${pageContext.request.contextPath}/toLogin"
				method="post">
				<div
					style="width: 270px ;height: 60px;text-align: center;font-size: 30px">登录</div>
				<div style="text-align: center;font-size:18px">欢迎访问 智慧能力</div>
				<span style="color:red;font-size: 18px">${msg}</span>
				<div style="margin:5px 0px;">
					<input type="text" placeholder="请输入账号" name="UserName" />
				</div>
				<div>
					<br>
				</div>
				<div style="margin:5px 0;">
					<input type="password" style="height: 31px;width: 270px"
						placeholder="请输入密码" name="Password" />
				</div>
				<button type="submit">
					登<span style="width:20px;"></span>录
				</button>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/com.js"></script>
</body>
</html>
