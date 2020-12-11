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
		$(".setCart").click(function() {
			var game_id = $(this).next().val();
			var amount = $(this).prev().val();
			$.ajax({
				type : "post",
				url : "insertCart",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				data : {game_id:game_id,amount:amount},
				async : true,
				success : function(result) {
					alert("加入成功！");
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
			$(this).prev().val("");
		})
	})
</script>
</head>
<body>
	<div>
		<div style="width: 60%; margin: 0 auto;">

			<div align="center">当前用户: ${LoginUser.username} 余额：${LoginUser.money}</div>

			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr>
						<td>商品编号</td>
						<td>商品名</td>
						<td>商品价格</td>
						<td>商品数量</td>
						<td>购买</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="game" varStatus="st">
						<tr>
							<td>${game.game_id}</td>
							<td>${game.name}</td>
							<td>${game.originalPrice}</td>
							<td>${game.stock}</td>
							<td>数量
							<input class="form-control" class="amount" type="number" name="amount">
							<input class="setCart" type="submit" value="购买">
							<input type="hidden"  value="${game.game_id}" name="game_id">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="cartShow" method='post' style="width: 10%; margin: 0 auto;">
				<input type="submit" class="btn btn-primary" id=upCart value="购物车">
			</form>
			<a href="listGame">游戏管理</a>
		</div>
	</div>
</body>
</html>
