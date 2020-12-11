
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
	//替代 ${pageContext.request.contextPath }写法；
	//js和css是不能放在WEB-INFX下的。否则会访问不到
%>

<script src="<%=contextPath %>/static/js/jquery/2.0.0/jquery.min.js"></script>
<link href="<%=contextPath %>/static/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="<%=contextPath %>/static/js/bootstrap/3.3.6/bootstrap.min.js"></script>
