<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%  
String currentYear = String.valueOf(new Date().getYear() + 1900);  
request.setAttribute("currentYear", currentYear);  
%> 
<html>
<head>
<title>信息添加</title>
<meta name="decorator" content="default" />
<style type="text/css">
.input-info {
	width: 130px;
}
.input-medium {
    width: 143px;
}
.label-controll {
	margin-right: 20px;
	padding-top: 3px;
	text-align: right;
	width: 100px;
	font-family: Helvetica, Georgia, Arial, sans-serif, 宋体;
	font-size: 13px;
}
</style>
</head>
<body>
	<form:form id="inputForm" modelAttribute="wellInfo"
		action="${ctx}/cms/save" method="post" class="breadcrumb form-search" enctype="multipart/form-data">
		<form:hidden path="id" />
		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">基础资料</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">*井号:</label> <form:input
						path="code" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">设计井别:</label> <form:select
						path="designType" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${designTypeList}" htmlEscape="false" />
					</form:select></li>
				<li><label class="label-controll">目前井別:</label> <form:select
						path="currentType" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${currentTypeList}" htmlEscape="false" />
					</form:select></li>
				<li><label class="label-controll">*单位代码:</label> <select
						name="dep" class="input-medium">
						<option value="${dep}" label="${dep}">${dep}</option>
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
				<li><label class="label-controll">报废类型:</label> <form:select
					path="scrapType" class="input-medium">
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
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">地质概况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">构造位置:</label> <form:input
						path="structure" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">区块单元代码:</label> <form:input
						path="blockUnit" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">是否井网内:</label> <form:select
						path="isInWellNet" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:option value="是" label="是" />
						<form:option value="否" label="否" />
					</form:select></li>
				<li><label class="label-controll">开钻日期:</label> <form:input
						path="timeDrilling" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">完井日期:</label> <form:input
						path="timeCommission" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">停产日期:</label> <form:input
						path="timeShutDown" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">设计井深:</label> <form:input
						path="designDepth" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">完钻井深:</label> <form:input
						path="completeDepth" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">单井控制储量:</label> <form:input
						path="controlReserves" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">末期生产层位:</label> <form:input
						path="positionEndProduct" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累产油:</label> <form:input
						path="cumulativeOil" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累产气:</label> <form:input
						path="cumulativeGas" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累注水:</label> <form:input
						path="cumulativeWater" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">地质风险:</label> <form:select
						path="geoRisk" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${geoRiskList}" htmlEscape="false" />
					</form:select></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">井筒状况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">井内管柱:</label> <form:input
						path="tubular" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">封井情况:</label> <form:select
						path="shutWellState" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${shutWellStateList}" htmlEscape="false" />
					</form:select></li>
				<li><label class="label-controll">完井方式:</label> <form:select
					path="wellCompletion" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:options items="${wellCompletionList}" htmlEscape="false" />
				</form:select></li>
				<li><label class="label-controll">套变类型:</label> <form:select
						path="casingDeformationType" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${casingDeformationTypeList}" htmlEscape="false" />
					</form:select></li>
				<li><label class="label-controll">油层套管:</label> <form:select
					path="isDownWellFL" class="input-medium">
					<form:option value="" label="-请选择-" />
					<form:option value="是" label="是" />
					<form:option value="否" label="否" />
				</form:select></li>
				<li class="clearfix"></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">地面状况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">地理位置:</label> <form:input
						path="location" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 12px">周边环境描述:</label> <form:input
						path="environment" htmlEscape="false" maxlength="120" class="input-info" />
				<li><label class="label-controll">井口状况:</label> <form:input
						path="groundFacility" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">井口横坐标:</label> <form:input
						path="coordinateX" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">井口纵坐标:</label> <form:input
						path="coordinateY" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">地面风险:</label> <form:select
						path="riskRank" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${riskRankList}" htmlEscape="false" />
					</form:select></li>
				<li><label class="label-controll">下步方案:</label> <form:select
						path="nextSchema" class="input-medium">
						<form:option value="" label="-请选择-" />
						<form:options items="${nextSchemaList}" htmlEscape="false" />
					</form:select></li>
				<li class="clearfix"></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll">年份:</label> <select
					name="year" class="input-medium">
						<c:forEach var="y" items="${fns:getYearList()}">
							<option value="${y}" 
							<c:if test="${y eq currentYear}">
							selected="selected"
							</c:if>
							>${y}年 </option>
						</c:forEach>
				</select></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">图片1:</label> <input
					type="file" name="iamge1" /></li>
				<li><label class="label-controll">图片2:</label> <input
					type="file" name="iamge2" /></li>
				<li><label class="label-controll">图片3:</label> <input
					type="file" name="iamge3" /></li>
			</ul>
		</div>
		<div class="control-group">
			<label class="label-controll">备注:</label>
			<label style="font-size: 11px">(其他情况，例如发生过井喷失控、井口冒气、侵占、偷盗油痕迹等)</label>
			<div class="controls">
				<form:textarea path="remark" htmlEscape="false" rows="4"
					maxlength="200" class="input-xxlarge" />
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" />&nbsp; <input id="btnCancel" class="btn"
				type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>