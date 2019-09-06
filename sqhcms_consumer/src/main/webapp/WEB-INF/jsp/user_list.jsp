<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
</head>
<body>
	<div class="container" align="center">
		<div class="card">
			<div class="card-head">
				<a href="toSaveUser" class="btn btn-success">√添加</a> <input
					type="button" value="批量删除" class="btn btn-warning" onclick="deleteall()">
			</div>
			<div class="card-body">
				${pageInfo}
				<table class="table table-bordered table-hover">
					<tr>
						<td><input type="button" value="全选" class="btn btn-info" onclick="qx()"></td>
						<td>角色ID</td>
						<td>角色名称</td>
						<td>创建日期</td>
						<td>拥有权限</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${pageInfo.list}" var="c">
						<tr>
							<td><input type="checkbox" name="cks" value="${c.id}"></td>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.created}</td>
							<td>${c.types}</td>
							<td><a href="getUser?id=${c.id}" class="btn btn-info">查看</a></td>
						</tr>
					</c:forEach>
				</table>
				<div align="center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="list?pageNum=1">Previous</a></li>
							<li class="page-item"><a class="page-link" href="list?pageNum=${pageInfo.pageNum-1<0?1:pageInfo.pageNum-1}">上一页</a></li>
							<li class="page-item"><a class="page-link" href="list?pageNum=${pageInfo.pageNum+1>pageInfo.pages?pageInfo.pages:pageInfo.pageNum+1}">下一页</a></li>
							<li class="page-item"><a class="page-link" href="list?pageNum=${pageInfo.pages}">Next</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		function qx() {
			$("[name='cks']:checkbox").each(function() {
				this.checked = !this.checked;
			})
		}
		function deleteall(){
			var ids = $("[name='cks']:checked").map(function(){
				return this.value;
			}).get().join();
			if(ids.length>0){
				if(confirm("你确认删除IDw为"+ids+"的数据吗?")){
					$.post(
						"deleteAll",
						{ids:ids},
						function(bl){
							if(bl){
								alert("删除成功！");
								location.href="list";
							}else{
								alert("删除失败!");
							}
						}
					)
				}
			}			
		}
	</script>

</body>
</html>