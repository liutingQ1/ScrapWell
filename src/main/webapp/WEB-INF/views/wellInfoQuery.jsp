<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>油井管理</title>
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
	<form:form id="searchForm" modelAttribute="wellInfo"
		action="${ctx}/cms/infoQuerySelect" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>井&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label> <form:input
					path="code" htmlEscape="false" maxlength="50" class="input-info" /></li>
			<li><label>设计井别：</label> <form:select path="designType"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${designTypeList}" htmlEscape="false" />
				</form:select></li>
			<li><label>目前井别：</label> <form:select path="currentType"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${currentTypeList}" htmlEscape="false" />
				</form:select></li>
			<li><label>单位代码：</label> 
				<select name="dep" class="input-medium">
						<option value="" >-请选择-</option>
						<c:forEach var="dep" items="${departmentList}">
							<option value="${dep}" >${dep}</option>
						</c:forEach>
				</select></li>
			<li><label class="label-controll">生产状态:</label> <form:select
				path="productState" class="input-medium">
				<form:option value="" label="-请选择-" />
				<form:option value="生产" label="生产" />
				<form:option value="停产" label="停产" />
			</form:select></li>
			<li><label class="label-controll">是否报废:</label> <form:select
					path="isScrap" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:option value="是" label="是" />
					<form:option value="否" label="否" />
				</form:select></li>
			<li><label>报废类型：</label> <form:select path="scrapType"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${scrapTypeList}" htmlEscape="false" />
				</form:select></li>
			<li><label class="label-controll">是否在册:</label> <form:select
				path="isAbandon" class="input-medium">
				<form:option value="" label="-请选择-" />
				<form:option value="是" label="是" />
				<form:option value="否" label="否" />
			</form:select></li>
			<li><label class="label-controll">是否计井数:</label> <form:select
					path="isCount" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:option value="是" label="是" />
					<form:option value="否" label="否" />
				</form:select></li>
			<li><label class="label-controll">是否井网内:</label> <form:select
					path="isInWellNet" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:option value="是" label="是" />
					<form:option value="否" label="否" />
				</form:select></li>
			<li><label class="label-controll">地质风险:</label> <form:select path="geoRisk"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${geoRiskList}" htmlEscape="false" />
				</form:select></li>
			<li><label>封井情况：</label> <form:select path="shutWellState"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${shutWellStateList}" htmlEscape="false" />
				</form:select></li>
			<li><label>完井方式：</label> <form:select path="wellCompletion"
				class="input-medium">
				<form:option value="" label="-请选择-" />
				<form:options items="${wellCompletionList}" htmlEscape="false" />
			</form:select></li>
			<li><label class="label-controll">套变类型:</label> <form:select
					path="casingDeformationType" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${casingDeformationTypeList}" htmlEscape="false" />
				</form:select></li>
			<li><label class="label-controll" >油层套管:</label> <form:select
				path="isDownWellFL" class="input-medium">
				<form:option value="" label="-请选择-" />
				<form:option value="是" label="是" />
				<form:option value="否" label="否" />
			</form:select></li>
			<li><label class="label-controll">地面风险:</label> <form:select path="riskRank"
					class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${riskRankList}" htmlEscape="false" />
				</form:select></li>
			<li><label class="label-controll">下步方案:</label> <form:select
					path="nextSchema" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${nextSchemaList}" htmlEscape="false" />
				</form:select></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" onclick="return page();" />
			<li class="btns"><input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<c:if test="${modifyAuthority eq '1' || deleteAuthority eq '1' }">
				<!-- 最少5个字宽，一个汉字13px -->
				<th style="min-width:65px;text-align:center">操作</th>
				</c:if>
				<!-- 基础资料 -->
				<th style="min-width:65px;text-align:center">井号</th>
				<th>设计井别</th>
				<th>目前井别</th>
				<th>单位代码</th>
				<th>生产状态</th>
				<th>是否报废</th>
				<th style="min-width:78px;text-align:center">报废类型</th>
				<th>是否在册</th>
				<th>是否计井数</th>
				<!-- 地质概况 -->
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
				<!-- 井筒状况 -->
				<th style="min-width:325px;text-align:center">井内管柱</th>
				<th>封井情况</th>
				<th style="min-width:78px;text-align:center">完井方式</th>
				<th>套变类型</th>
				<th>油层套管</th>
				<!-- 地面状况 -->
				<!-- 最少20个字宽，一个汉字13px -->
				<th style="min-width:260px;text-align:center">地理位置</th>
				<th style="min-width:260px;text-align:center">周边环境描述</th>
				<th style="min-width:195px;text-align:center">井口状况</th>
				<th>井口横坐标</th>
				<th>井口纵坐标</th>
				<th>地面风险</th>
				<th>下步方案</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="wellInfo">
				<tr>
					<c:if test="${modifyAuthority eq '1' || deleteAuthority eq '1' }">
						<td><c:if test="${modifyAuthority eq '1'}">
								<a href="${ctx}/cms/modify?id=${wellInfo.id}">修改</a>
							</c:if> <c:if test="${deleteAuthority eq '1'}">
								<a href="${ctx}/cms/delete?id=${wellInfo.id}&myPage=query"
									onclick="return confirmx('确认要删除该信息吗？', this.href)">删除</a>
							</c:if></td>
					</c:if>
					<!-- 基础资料 -->
					<td><a href="${ctx}/cms/detail?id=${wellInfo.id}">${wellInfo.code}</a></td>
					<td>${wellInfo.designType}</td>
					<td>${wellInfo.currentType}</td>
					<td>${wellInfo.department.getName()}</td>
					<td>${wellInfo.productState}</td>
					<td>${wellInfo.isScrap}</td>
					<td>${wellInfo.scrapType}</td>
					<td>${wellInfo.isAbandon}</td>
					<td>${wellInfo.isCount}</td>
					<!-- 地质概况 -->
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
					<!-- 井筒状况 -->
					<td>${wellInfo.tubular}</td>
					<td>${wellInfo.shutWellState}</td>
					<td>${wellInfo.wellCompletion}</td>
					<td>${wellInfo.casingDeformationType}</td>
					<td>${wellInfo.isDownWellFL}</td>
					<!-- 地面状况 -->
					<td>${wellInfo.location}</td>
					<td>${wellInfo.environment}</td>
					<td>${wellInfo.groundFacility}</td>
					<td>${wellInfo.coordinateX}</td>
					<td>${wellInfo.coordinateY}</td>
					<td>${wellInfo.riskRank}</td>
					<td>${wellInfo.nextSchema}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>