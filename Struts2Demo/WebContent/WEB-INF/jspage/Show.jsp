<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SHOW</title>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/Chart.js/2.1.4/Chart.bundle.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse ">
		  <div class="container">
			<div class="navbar-header">
				<a class="navbar-brand">情感倾向分析</a>
			</div>
		  </div>
	</nav>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
		<h2>情感分析详情</h2>
		<p><h5>blog.sciencenet.cn</h5></p> 
		<p><h5>更新时间:<s:property value="date"/></h5></P>
	</div>
	
	
	
	<ul id="myTab" class="nav nav-tabs nav-justified">
		<li class="active" >
			<a href="#page" data-toggle="tab">
				博文
			</a>
		</li>
		<li ><a href="#count" data-toggle="tab">统计</a></li>
		<li ><a href="#classify" data-toggle="tab">评论分类</a></li>
		
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="page">
			<div class="embed-responsive embed-responsive-4by3">
				<iframe class="embed-responsive-item" src ="<s:property value="url"/>"  width="100%" height="1000"></iframe>
			</div>
		</div>
		<div class="tab-pane fade" id="classify">
			<table class="table table-hover table-bordered">
						    <div ><p></p><p></p><p></p></div>
			<div class="btn-toolbar"> 
			  <button type="button" class="btn btn-lg btn-default" onClick="showAll()">所有评论</button>
			  <button type="button" class="btn btn-lg btn-default" onClick="showPos()">正面</button>
			  <button type="button" class="btn btn-lg btn-default" onClick="showNeu()">中立</button>
			  <button type="button" class="btn btn-lg btn-default" onClick="showNeg()">负面</button>
			</div>
			   <caption><h3>情感倾向分析</h3></caption>
			   <thead>
				  <tr>
					 <th>评论</th>
					 <th>情感倾向</th>
				  </tr>
			   </thead>
			   <tbody>
				<c:forEach items="${listCommentsData}" var="a" varStatus="vs"> 
				  <tr id="${vs.index}">
					 <td>${a.comment}</td>
					 <td>${a.sentiment}</td>
				  </tr>
				</c:forEach> 
			   </tbody>
			</table>		
		</div>
		<div class="tab-pane fade" id="count">
			<div style="width:35% ; float:left">
				<canvas id="chart-area" width="150" height="150" />
			</div>
			<div  style="width:65% ; float:left" height="350">
			    <div ><p></p><p></p><p></p></div>
				<table class="table table-hover">
				   <thead >
					  <tr>
						 <th>情感倾向</th>
						 <th>评论数量</th>
						 <th>百分比</th>
					  </tr>
				   </thead>
				   <tbody>
					  <tr>
						 <td>正面</td>
						 <td><s:property value="numPos"/></td>
						 <td><s:property value="percentagePos"/></td>
					  </tr>
					  <tr>
						 <td>中立</td>
						 <td><s:property value="numNeu"/></td>
						 <td><s:property value="percentageNeu"/></td>
					  </tr>
					  <tr>
						 <td>负面</td>
						 <td><s:property value="numNeg"/></td>
						 <td><s:property value="percentageNeg"/></td>
					  </tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<script>
function showAll(){
	$("tr").css("display","table-row");
}

function showNeu(){
	$("tr").css("display","table-row");
	$("td").each(function(){
	   if($(this).text()=="negative"||$(this).text()=="positive")
			$(this).parent().css("display","none");
	});			 
}

function showPos(){
	$("tr").css("display","table-row");
	$("td").each(function(){
	   if($(this).text()=="negative"||$(this).text()=="neutral")
			$(this).parent().css("display","none");
	});			 
}

function showNeg(){
	$("tr").css("display","table-row");
	$("td").each(function(){
	   if($(this).text()=="neutral"||$(this).text()=="positive")
			$(this).parent().css("display","none");
	});			 
}
var NumNeg = <s:property value="numNeg"/>;
var NumNeu = <s:property value="numNeu"/>;
var NumPos = <s:property value="numPos"/>;

//画pie图
var config = {
    type: 'pie',
    data: {
        datasets: [{
            data: [
                NumNeg,
                NumNeu,
                NumPos,

            ],
            backgroundColor: [
                "#F7464A",
                "#46BFBD",
                "#FDB45C",
            ],
        }], 
        labels: [
            "负面",
            "中立",
            "正面",

        ]
    },
    options: {
        responsive: true
    }
};

//   window.onload = function() {
    var ctx = document.getElementById("chart-area").getContext("2d");
    window.myPie = new Chart(ctx, config);
//  };
	
</script>
</body>
</html>