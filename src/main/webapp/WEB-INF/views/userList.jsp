<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户列表</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnExport").click(function(){
			top.$.jBox.confirm("确认要导出用户数据吗？","系统提示",function(v,h,f){
				if(v=="ok"){
					$("#searchForm").attr("action","${ctx}/cms/export");
					$("#searchForm").submit();
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
		});
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").attr("action","${ctx}/cms/infoQuerySelect");
		$("#searchForm").submit();
		return false;
	}
</script>
<style type="text/css">
.input-info {
	width: 146px;
	margin-left: 3px;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/accountList">用户列表</a></li>
		<li><a href="${ctx}/cms/accountAdd">添加用户</a></li>
	</ul><br/>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- 最少5个字宽，一个汉字13px -->
				<th style="min-width:65px;overflow:auto;display:block;text-align:center">操作</th>
				<th>用户名</th>
				<th>部门</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="user">
				<tr>
					<td><a href="${ctx}/cms/accountAdd?id=${user.id}">修改</a> 
					<a href="${ctx}/cms/accountDelete?id=${user.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a></td>
					<td>${user.username}</td>
					<td>${user.department.getName()}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>