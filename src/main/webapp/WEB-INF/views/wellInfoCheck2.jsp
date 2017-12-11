<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>地质研究所审核</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
<style type="text/css">
.input-info {
	width: 150px;
	margin-left: 3px;
}
</style>
</head>
<body>
	<form:form id="searchForm" modelAttribute="wellInfo"
		action="${ctx}/cms/infoCheckSelect" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>井&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label> <form:input
					path="code" htmlEscape="false" maxlength="50" class="input-info" /></li>
			<li><label>目前井别：</label> <form:select path="currentType"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${currentTypeList}" htmlEscape="false" />
				</form:select></li>
			<li><label>单位代码：</label> 
				<select name="dep" class="input-medium">
				<c:if test="${department eq 'GEOGRAPHY' or department eq 'ENGINEERING'}">
						<option value="" >-请选择-</option>
						<c:forEach var="dep" items="${departmentList}">
							<option value="${dep}" >${dep}</option>
						</c:forEach>	
				</c:if>
				<c:if test="${(department eq 'TASK1')}">
						<option value="${department}" >作业一区</option>	
				</c:if>
				<c:if test="${(department eq 'TASK2')}">
						<option value="${department}" >作业二区</option>	
				</c:if>
				<c:if test="${(department eq 'TASK3')}">
						<option value="${department}" >作业三区</option>	
				</c:if>
				<c:if test="${(department eq 'MINING')}">
						<option value="${department}" >专采队</option>	
				</c:if>
				</select></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" onclick="return page();" />
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th style="min-width:39px;text-align:center">状态</th>
				<!-- 最少5个字宽，一个汉字13px -->
				<th style="min-width:65px;text-align:center">操作</th>
				<th style="min-width:65px;text-align:center">井号</th>
				
				<th>构造位置</th>
				<th style="min-width:195px;text-align:center">区块单元代码</th>
				<th>是否井网内</th>
				<th>开钻日期</th>
				<th>完井日期</th>
				<th>停产日期</th>
				<th>设计井深</th>
				<th>完钻井深</th>
				<th>单井控制储量</th>
				<th>末期生产层位</th>
				<th>累产油</th>
				<th>累产气</th>
				<th>累注水</th>
				<th>地质风险</th>
				
				<th>下步方案</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="wellInfo">
				<tr>
					<td>${wellInfo.state.name() eq 'BACK' ? '回修':'待审核'}</td>
					<!-- 有审核权限 -->
					<c:if test="${checkAuthority eq '1'}">
						<td><a href="${ctx}/cms/sendBack?id=${wellInfo.id}">退回</a> 
							<a href="${ctx}/cms/agree?id=${wellInfo.id}">通过</a></td>
					</c:if>
					<!-- 没有审核权限 -->
					<c:if test="${checkAuthority eq '0'}">
						<td><a href="${ctx}/cms/delete?id=${wellInfo.id}&myPage=check"
						onclick="return confirmx('确认要删除该信息吗？', this.href)">删除</a> 
							<a href="${ctx}/cms/modify?id=${wellInfo.id}">修改</a></td>
					</c:if>
					<td><a href="${ctx}/cms/detail?id=${wellInfo.id}">${wellInfo.code}</a></td>
					<td>${wellInfo.structure}</td>
					<td>${wellInfo.blockUnit}</td>
					<td>${wellInfo.isInWellNet}</td>
					<td>${wellInfo.timeDrilling}</td>
					<td>${wellInfo.timeCommission}</td>
					<td>${wellInfo.timeShutDown}</td>
					<td>${wellInfo.designDepth}</td>
					<td>${wellInfo.completeDepth}</td>
					<td>${wellInfo.controlReserves}</td>
					<td>${wellInfo.positionEndProduct}</td>
					<td>${wellInfo.cumulativeOil}</td>
					<td>${wellInfo.cumulativeGas}</td>
					<td>${wellInfo.cumulativeWater}</td>
					<td>${wellInfo.geoRisk}</td>
					<td>${wellInfo.nextSchema}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>