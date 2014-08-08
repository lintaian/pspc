<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>登陆</title>
	<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
	<link rel="stylesheet" href="css/jquery.mobile-1.4.3.css">
	<link rel="stylesheet" href="css/main.css">
	<!-- <script src="js/lib/jquery.js"></script>
	<script src="js/lib/jquery.mobile-1.4.3.js"></script> -->
</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="header">
		  <h1>登陆</h1>
		</div>
		<div class="content">
			<div class="testTouch" style="width: 100%; height: 50px;">
				<img alt="" src="img/chrome.png">
			</div>
			<a href="extent.html">baidu</a>
			<a href="extent2.html">hehe</a>
		</div>
		
		<div data-role="footer" data-theme="e">
		  <h1>Insert Footer Text Here</h1>
		  <div data-role="navbar">
		    <ul>
		      <li><a href="#" data-icon="home" data-theme="b">Button 1</a></li>
		      <li><a href="#" data-icon="arrow-r">Button 2</a></li>
		      <li><a href="#" data-icon="arrow-r">Button 3</a></li>
		      <li><a href="#" data-icon="search" data-theme="a" >Button 4</a></li>
		    </ul>
		  </div> 
		</div>
	</div>
	<script data-main="js/require/login" src="js/lib/require.js"></script>
</body>
</html>