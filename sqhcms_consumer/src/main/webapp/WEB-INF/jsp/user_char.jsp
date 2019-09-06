<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.css" />
</head>
<body>
	<div class="container" align="center">
		<div class="card">
			<div class="card-head">用户详情</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<td>角色ID</td>
						<td>${user.id}</td>
					</tr><tr>
						<td>角色名称</td>
						<td>${user.name}</td>
					</tr><tr>
						<td>创建日期</td>
						<td>${user.created}</td>
					</tr><tr>
						<td>拥有权限</td>
						<td>
						<c:forEach items="${control}" var="c">
							${c.type}、
						</c:forEach>
						</td>
					</tr><tr>
						<td colspan="2"><a href="list" class="btn btn-info">返回</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</body>
</html>