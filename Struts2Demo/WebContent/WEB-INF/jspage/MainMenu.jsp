<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>  
  <head>  
<%--     <a href="${pageContext.request.contextPath}/menu.action?url=1" target="_blank">aaa</a>     --%>
    <title>MainMenu</title>
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
			<h2>博客分类</h2>
			<p></p><h5>blog.sciencenet.cn</h5><p></p> 
		</div>
	</div>
	<div class="container">

		<div class="row">
			<div class="col-lg-4">
			  <h2>36小时精选</h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=1" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>一周精选</h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=2" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>一月精选</h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=3" target="_blank" role="button">详&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
			  <h2>科研笔记</h2>

			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=4" target="_blank"role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>教学心得</h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=5" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>论文交流 </h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=6" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
			  <h2>观点评述 </h2>
			  <p class="text-danger">
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=7" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>人文社科</h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=8" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>海外观察 </h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=9" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
			  <h2>科普集锦 </h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=10" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>人物纪事 </h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=11" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
			<div class="col-lg-4">
			  <h2>图片百科 </h2>
			  <p><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/menu.action?url=12" target="_blank" role="button">详&nbsp&nbsp&nbsp情&nbsp&nbsp&nbsp »</a></p>
			</div>
		</div>
		<hr>
    </div> 
    

  </body>  
</html>  