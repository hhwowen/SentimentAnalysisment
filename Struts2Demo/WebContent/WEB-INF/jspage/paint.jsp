<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>test</title>
   <link rel="stylesheet" type="text/css" href="https://as.alipayobjects.com/g/datavis/g2-static/0.0.11/doc.css" />

   <script src="https://a.alipayobjects.com/jquery/jquery/1.11.1/jquery.js"></script>
   <script src="https://a.alipayobjects.com/alipay-request/3.0.3/index.js"></script>
   <script src="https://as.alipayobjects.com/g/datavis/g2/1.2.5/index.js"></script>
</head>
<body>
	<div id="c1"></div>
    <!-- G2 code start -->
</body>
<script>

	$.getJSON("${pageContext.request.contextPath}/test.json",function(data){
		var chart = new G2.Chart({
			id:'c1',
		    width: 1700,
		    height: 700,
		});
		var defs = {
			'date':{
				alias : 'date',
				nice : false,
				type : 'time',
				mask : 'yyyy-mm-dd HH:MM:ss'
			}, 
		   'temp':{
		       type:'linear',
		    }
		};
		console.info(data);
		chart.source(data,defs);
		chart.line().position('date*temp').color('red');
		chart.render();
		
	})
//	alert("here");
</script>
</html>