<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<jsp:include page="common-js.jsp"></jsp:include>
<script>
	$(function() {
		$("#buy").click(function() {
			$.ajax({
				type : "post",
				url : "buyCheck",
				contentType : "application/json;charset=UTF-8",
				async : true,
				success : function(result) {
					if(result==2){
						alert("没钱");
					}else{
						alert("支付成功！");
						window.location.href = "gameShow";
					}
				},
				error: function (jqXHR, textStatus, errorThrown) {
		            /*弹出jqXHR对象的信息*/
		            alert(jqXHR.responseText);
		            alert(jqXHR.status);
		            alert(jqXHR.readyState);
		            alert(jqXHR.statusText);
		            /*弹出其他两个参数的信息*/
		            alert(textStatus);
		            alert(errorThrown);
		        }
			});

		})
	})
</script>
</head>
<body>
	<div>
		<div style="width: 60%; margin: 0 auto;">

			<div align="center">当前用户: ${LoginUser.username}</div>

			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr>
						<td>商品名</td>
						<td>数量</td>
						<td>单价</td>
						<td>总价</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="cart" varStatus="st">
						<tr>
							<td>${cart.game.name}</td>
							<td>${cart.amount}</td>
							<td>${cart.game.originalPrice}元</td>
							<td>${cart.amount*cart.game.originalPrice}元</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td id="priceCount">${priceCount}</td>
					</tr>
				</tbody>
			</table>
			
				<input id="buy" type="submit" value="付款">
			<a href="gameShow">游戏购买</a>
		</div>
	</div>
</body>
</html>
