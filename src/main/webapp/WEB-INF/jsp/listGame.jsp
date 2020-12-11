<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
	String imagePath = request.getServletContext().getRealPath("/static/img/gameimg");

	//替代 ${pageContext.request.contextPath }写法；
	//js和css是不能放在WEB-INFX下的。否则会访问不到
%>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="common-js.jsp"></jsp:include>
<script>
	$(function() {
		$("#addGame")
				.click(
						function() {
							var name = $("#addGameTr>td:eq(1)>input").val();
							var subTitle = $("#addGameTr>td:eq(2)>input").val();
							var originalPrice = $("#addGameTr>td:eq(3)>input")
									.val();
							var promotePrice = $("#addGameTr>td:eq(4)>input")
									.val();
							var stock = $("#addGameTr>td:eq(5)>input").val();
							var category_id = $("#test option:selected").val();
							if (name == "") {
								alert("名称不能为空！");
							} else if (subTitle == "") {
								alert("描述不能为空！");
							} else if (originalPrice == "") {
								alert("原价不能为空！");
							} else if (promotePrice == "") {
								alert("折扣价不能为空！");
							} else if (stock == "") {
								alert("库存不能为空！");
							} else {
								$.ajax({
											type : "post",
											url : "addGame",
											contentType : "application/x-www-form-urlencoded;charset=UTF-8",
											async : true,
											data : {
												name : name,
												subTitle : subTitle,
												originalPrice : originalPrice,
												promotePrice : promotePrice,
												stock : stock,
												category_id : category_id
											},
											success : function(result) {
												alert("添加成功");
												window.location.href = "listGame";
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
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
							}
						})
		$(".editGame").click(function() {
			var tr = $(this).parent().parent();
			tr.find(".hiddenInput").show();
			tr.find(".showInput").hide();
		})
		$(".submitGame")
				.click(
						function() {
							var tr = $(this).parent().parent();
							var game_id = parseInt(tr.find("td:eq(0)").text());
							var name = tr.find("td:eq(2)>input").val();
							var subTitle = tr.find("td:eq(4)>input").val();
							var originalPrice = tr.find("td:eq(6)>input").val();
							var promotePrice = tr.find("td:eq(8)>input").val();
							var stock = tr.find("td:eq(10)>input").val();
							var category_id = tr.find("select option:selected")
									.val();
							$
									.ajax({
										type : "post",
										url : "updateGame",
										contentType : "application/x-www-form-urlencoded;charset=UTF-8",
										async : true,
										data : {
											game_id : game_id,
											name : name,
											subTitle : subTitle,
											originalPrice : originalPrice,
											promotePrice : promotePrice,
											stock : stock,
											category_id : category_id
										},
										success : function(result) {
											alert("编辑成功！");
											window.location.href = "listGame";
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
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
		$(".delGame")
				.click(
						function() {
							var tr = $(this).parent().parent();
							$
									.ajax({
										type : "post",
										url : "deleteGame",
										contentType : "application/x-www-form-urlencoded;charset=UTF-8",
										async : true,
										data : {
											game_id : parseInt(tr.find(
													"td:eq(0)").text()),
										},
										success : function(result) {
											alert("删除成功！");
											window.location.href = "listGame";
										},
										error : function() {
											alert("error");
										}
									});
						})
		$(".uploadbutton").click(function(){
			var tr = $(this).parent().parent();
			var game_id = parseInt(tr.find("td:eq(0)").text());
			$("#upgame_id").text(game_id);
			$("#game_id").val(game_id);
		})
		$("#uploading").click(function() {
			var formData = new FormData($("form")[0]);
			$.ajax({
				type : "post",
				url : "addGameImage",
				contentType : false,
				processData : false,
				data : formData,
				success : function(result) {
					alert("上传成功！");
					$("#myModal").modal('hide');
					$("#imagefile").val("");
				},
				error : function(jqXHR, textStatus, errorThrown) {
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
<style>
.hiddenInput {
	display: none;
}
</style>
</head>

<body>
	<div>
		<div style="width: 60%; margin: 0 auto;">
			<h2>商品列表${customer.username}</h2>
			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr>
						<td>游戏编号</td>
						<td>游戏名称</td>
						<td>游戏描述</td>
						<td>游戏原价</td>
						<td>游戏折扣价</td>
						<td>游戏库存</td>
						<td>游戏类别</td>
						<td>编辑</td>
						<td>上传图片</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${gameList}" var="game" varStatus="st">
						<tr>
							<td>${game.game_id}</td>
							<td class="showInput">${game.name}</td>
							<td class="hiddenInput"><input type="text" name="name"
								class="form-control" value="${game.name}"></td>
							<td class="showInput">${game.subTitle}</td>
							<td class="hiddenInput"><input type="text" name="subTitle"
								class="form-control" value="${game.subTitle}"></td>
							<td class="showInput">${game.originalPrice }</td>
							<td class="hiddenInput"><input type="number"
								name="originalPrice" class="form-control"
								value="${game.originalPrice}"></td>
							<td class="showInput">${game.promotePrice }</td>
							<td class="hiddenInput"><input type="number"
								name="promotePrice" class="form-control"
								value="${game.promotePrice}"></td>
							<td class="showInput">${game.stock }</td>
							<td class="hiddenInput"><input type="number" name="stock"
								class="form-control" value="${game.stock}"></td>
							<td class="showInput">${game.category.name }</td>
							<td class="hiddenInput"><select>
									<c:forEach items="${categoryList}" var="category"
										varStatus="st">
										<option value="${category.category_id}">${category.name}</option>
									</c:forEach>
							</select></td>

							<td class="showInput"><input type="submit"
								class="btn btn-primary editGame" value="编辑"></td>
							<td class="hiddenInput"><input type="submit"
								class="btn btn-primary submitGame" value="提交"></td>
							<td>
								<button type="button" class="btn btn-primary uploadbutton"
									data-toggle="modal" data-target="#myModal">上传图片</button>

							</td>
							<td><input type="submit" class="btn btn-primary delGame"
								value="删除"></td>
						</tr>
					</c:forEach>
					<tr id="addGameTr">
						<td><input id="addGame" type="submit" class="btn btn-primary"
							value="增加"></td>
						<td><input type="text" name="name" class="form-control"
							value=""></td>
						<td><input type="text" name="subTitle" class="form-control"
							value=""></td>
						<td><input type="number" name="originalPrice"
							class="form-control" value=""></td>
						<td><input type="number" name="promotePrice"
							class="form-control" value=""></td>
						<td><input type="number" name="stock" class="form-control"
							value=""></td>
						<td><select id="test">
								<c:forEach items="${categoryList}" var="category" varStatus="st">
									<option value="${category.category_id}">${category.name}</option>
								</c:forEach>
						</select></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>
			<a href="gameShow">游戏购买</a>
			<c:forEach items="${imageList}" var="image" varStatus="st">
				<div style="width:100px;height:100px"><img style="width:100%;" src="<%=contextPath%>${image.img_url}"></img></div>
			</c:forEach>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">图片信息</h4>
						</div>
						<div class="modal-body" >
						<form id="form" method="post" enctype="multipart/form-data">
							<span>游戏编号：<span id="upgame_id"></span></span>
							<input type="hidden" name="game_id" id="game_id"/>
							<br/>选择图片:<input id="imagefile" type="file"
								name="image" accept="image/*" />
						</form>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" type="button" id="uploading">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</div>
	</div>
</body>
</html>
