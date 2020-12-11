<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
	
	//替代 ${pageContext.request.contextPath }写法；
	//js和css是不能放在WEB-INFX下的。否则会访问不到
%>
<html>
<head>
<meta charset="utf-8">
<link href="<%=contextPath%>/static/css/login.css" rel="stylesheet">
<jsp:include page="common-js.jsp"></jsp:include>
<style>
body {
	background-image: url(<%=contextPath%>/static/img/acct_creation_bg.jpg)
}
</style>
<script>
	$(function() {
		$("#login").click(function() {
			var username = $("#username").val();
			var password = $("#password").val();
			if (username == "") {
				alert(" 用户名不能为空!");
			} else if (password == "") {
				alert(" 密码不能为空！!");
			} else {
				$.ajax({
					type : "post",
					url : "loginCheck",
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					async : true,
					data : JSON.stringify({
						"username" : $("#username").val(),
						"password" : $("#password").val()
					}),
					success : function(result) {
						if (result == "1") {
							alert(" 用户名不存在!");
						} else if (result == "2") {
							alert(" 密码错误!");
						} else if (result == "3") {
							window.location.href = "gameShow";
						}
					},
					error : function() {
						alert("error");
					}
				});
			}
		})
	})
</script>


</head>
<body>
	<header>
		<div class="header_center">
			<div class="logo">
				<span><a href=""><img style="width: 176px; height: 44px;"
						src="<%=contextPath%>/static/img/logo_steam.svg"></a></span>
			</div>
			<div class="supernav">
				<a class="menuitem">商店</a> <a class="menuitem">社区</a> <a
					class="menuitem">关于</a> <a class="menuitem">客服</a>
			</div>
			<div></div>
		</div>
	</header>
	<div class="main">
		<div class="main_center">
			<div class="login_div">
				<div class="loginbox_content">
					<div class="login_title">
						<span>登录</span>
					</div>
					<div id="error_display" style="display: none;"></div>
					<form class="login_form">
						<div class="login_row">
							<div style="width: 274px; height: 20px; padding-bottom: 5px;">Steam账户名称</div>
							<input id="username" name="username" type="text" />
						</div>

						<div class="login_row">
							<div style="width: 274px; height: 20px; padding-bottom: 5px;">密码</div>
							<input id="password" name="password" type="password" />
						</div>

						<div class="login_row">
							<input type="checkbox" name="remember_login" /> <label
								style="font-size: 14px;" for="remember_login">在这台电脑上记住我</label>
						</div>


					</form>
					<div class="login_btn_ctn">
						<div class="login_btn_signin">
							<button type="submit" id="login"
								class="btn_blue_steamui btn_medium login_btn">
								<span>登录</span>
							</button>
							<a href="resiste">注册</a>
						</div>
					</div>
				</div>
			</div>
			<div class="resiste_div"></div>
		</div>
	</div>
	<footer></footer>

</body>
</html>
