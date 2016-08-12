<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MENU</title>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse ">
		  <div class="container">
			<div class="navbar-header">
				<a class="navbar-brand">情感倾向分析</a>
			</div>
		  </div>
	</nav>
	<div class="container">
		<div class="jumbotron">
		<h2>博客列表</h2>
		<p><h5>blog.sciencenet.cn</h5></p> 
		<p><h5>更新时间:<s:property value="date"/></h5></P>
	</div>
	<table class="table table-hover table-bordered">
	   <caption><h3>列表</h3></caption>
	   <thead>
		  <tr>
			 <th>题目</th>
			 <th>作者</th>
			 <th>点击</th>
			 <th>评论</th>
			 <th>日期</th>
		  </tr>
	   </thead>
	   <tbody>
	    <c:forEach items="${listData}" var="a" varStatus="vs">  
		  <tr id="${vs.index}">
			 <td><a href="${pageContext.request.contextPath}/getUrlAndReturnPage.action?url1=${a.href}" target="_blank">${a.title}</a></td>
			 <td>${a.anthor}</td>
			 <td>${a.clickSum}</td>
			 <td>${a.commentSum}</td>
			 <td>${a.date}</td>
		  </tr>
		</c:forEach> 
	   </tbody>
	</table>
</body>
</html>