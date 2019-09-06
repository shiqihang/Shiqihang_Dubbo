<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加页面</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
</head>
<body>
	<div class="container" align="center">
		<div class="card">
			<div class="card-head">用户详情</div>
			<div class="card-body" align="center">
				<form action="">
					<table class="table table-bordered table-hover">
						<tr>
							<td>标号</td>
							<td><input type="text"></td>
						</tr>
						<tr>
							<td>角色名称:</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>创建日期</td>
							<td><input type="date" name="created"></td>
						</tr>
						<tr>
							<td>拥有权限</td>
							<td><c:forEach items="${list}" var="c">
									<input type="checkbox" name="ids" value="${c.id}">${c.type}
						</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2"><input type="button" onclick="saveUser()"
								class="btn btn-success" value="保存"><a href="list"
								class="btn btn-info">关闭</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		function saveUser() {
			var id = $("[name='id']").val();
			var name = $("[name='name']").val();
			var created = $("[name='created']").val();
			var ids = $("[name='ids']:checked").map(function() {
				return this.value;
			}).get().join();
				if (name != "") {
					if (created != "") {
						if (ids.length > 0) {
							$.post(
								"saveUser",
								$("form").serialize(),
								function(bl){
									if(bl){
										alert("成功!");
										location.href="list";
									}else{
										alert("失败");
									}
								}
							)
						} else {
							alert("至少沟中一项权限!");
						}
					} else {
						alert("时间不能为空");
					}
				} else {
					alert("姓名不能为空!");
				}
		}
	</script>
</body>
</html>