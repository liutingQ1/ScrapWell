<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户管理</title>
<meta name="decorator" content="default" />
<style type="text/css">
.input-info {
	width: 146px;
	margin-left: 3px;
}

.input-medium {
	width: 170px;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/accountList">用户列表</a></li>
		<li class="active"><a href="${ctx}/cms/accountAdd">添加用户</a></li>
	</ul>
	<br/>
	<c:if test="${not empty message}">
		<script language="javascript">
			alert("用户已存在！");
		</script>
	</c:if>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/cms/accountSave" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<div class="control-group">
			<label class="control-label">用户名:</label>
			<div class="controls">
				<input id="username" name="username" type="text"
					<c:if test="${not empty user.username}">
							value="${user.username}" 
							</c:if>
					<c:if test="${empty user.username}">
							value=""
							</c:if>
					maxlength="50" minlength="2" class="required" /> <span
					class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
				<input id="password" name="password" type="text"
					<c:if test="${not empty user.password}">
							value="${user.password}" 
							</c:if>
					<c:if test="${empty user.password}">
							value=""
							</c:if>
					maxlength="50" minlength="3" class="required" /> <span
					class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">部门:</label>
			<div class="controls">
				<select name="dep" class="input-medium">
					<c:forEach var="dep" items="${departmentList}">
						<option value="${dep}"
							<c:if test="${not empty user.department and dep eq user.department.getName()}">
							selected="selected"
						</c:if>>${dep}</option>
					</c:forEach>
				</select>
				</li> <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">权限:</label>
			<div class="controls">
				<input name="recordAuthority" type="checkbox"
					<c:if test="${not empty user.recordAuthority}">
					checked="checked" 
					</c:if>
					value="" /> <label>录入&nbsp;&nbsp;&nbsp;</label> <input
					name="modifyAuthority" type="checkbox"
					<c:if test="${not empty user.modifyAuthority}">
					checked="checked" 
					</c:if>
					value="" /> <label>修改&nbsp;&nbsp;&nbsp;</label> <input
					name="deleteAuthority" type="checkbox"
					<c:if test="${not empty user.deleteAuthority}">
					checked="checked" 
					</c:if>
					value="" /><label>删除&nbsp;&nbsp;&nbsp;</label> <input
					name="checkAuthority" type="checkbox"
					<c:if test="${not empty user.checkAuthority}">
					checked="checked" 
					</c:if>
					value="" /><label>审核</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保存"/>
		</div>
	</form:form>
</body>
</html>