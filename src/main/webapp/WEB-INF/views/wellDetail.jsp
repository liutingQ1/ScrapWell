<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("basePath", basePath);  
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
.max{width:100%;height:auto;}
.min{width:300px;height:auto;}
</style>
</head>
<body>
	<form:form id="inputForm" modelAttribute="wellInfo"
		action="" method="post" class="breadcrumb form-search">
		<form:hidden path="id" />
		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">基础资料</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">*井号:</label> <form:input readonly="true"
						path="code" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">设计井別:</label> <form:select
						path="currentType" class="input-medium">
						<form:option value="" label="${wellInfo.designType}" />
					</form:select></li>
				<li><label class="label-controll">目前井別:</label> <form:select
						path="currentType" class="input-medium">
						<form:option value="" label="${wellInfo.getCurrentType()}" />
					</form:select></li>
				<li><label class="label-controll">*单位代码:</label> <form:select
						path="department" class="input-medium">
						<form:option value="" label="${wellInfo.getDepartment().getName()}" />
					</form:select></li>
				<li><label class="label-controll">生产状态:</label> <form:select
					path="productState" class="input-medium">
					<form:option value="" label="${wellInfo.getProductState()}" />
				</form:select></li>
				<li><label class="label-controll">是否报废:</label> <form:select
						path="isScrap" class="input-medium">
						<form:option value="" label="${wellInfo.getIsScrap()}" />
					</form:select></li>
				<li><label class="label-controll">报废类型:</label> <form:select
					path="isScrap" class="input-medium">
					<form:option value="" label="${wellInfo.scrapType}" />
				</form:select></li>
				<li><label class="label-controll">是否在册:</label> <form:select
					path="isAbandon" class="input-medium">
					<form:option value="" label="${wellInfo.getIsAbandon()}" />
				</form:select></li>
				<li><label class="label-controll">是否计井数:</label> <form:select
						path="isCount" class="input-medium">
						<form:option value="" label="${wellInfo.getIsCount()}" />
					</form:select></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">地质概况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">构造位置:</label> <form:input readonly="true"
						path="structure" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">区块单元代码:</label> <form:input readonly="true"
						path="blockUnit" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">是否井网内:</label> <form:select
						path="isInWellNet" class="input-medium">
						<form:option value="" label="${wellInfo.getIsInWellNet()}" />
					</form:select></li>
				<li><label class="label-controll">开钻日期:</label> <form:input readonly="true"
						path="timeDrilling" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">完井日期:</label> <form:input readonly="true"
						path="timeCommission" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">停产日期:</label> <form:input readonly="true"
						path="timeShutDown" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">设计井深:</label> <form:input readonly="true"
						path="designDepth" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">完钻井深:</label> <form:input readonly="true"
						path="completeDepth" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">单井控制储量:</label> <form:input readonly="true"
						path="controlReserves" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 11px">末期生产层位:</label> <form:input readonly="true"
						path="positionEndProduct" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累产油:</label> <form:input readonly="true"
						path="cumulativeOil" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累产气:</label> <form:input readonly="true"
						path="cumulativeGas" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">累注水:</label> <form:input readonly="true"
						path="cumulativeWater" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">地质风险:</label> <form:select
						path="geoRisk" class="input-medium">
						<form:option value="" label="${wellInfo.geoRisk}" />
					</form:select></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">井筒状况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">井内管柱:</label> <form:input readonly="true"
						path="tubular" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">封井情况:</label> <form:select
						path="shutWellState" class="input-medium">
						<form:option value="" label="${wellInfo.getShutWellState()}" />
					</form:select></li>
				<li><label class="label-controll">完井方式:</label> <form:select
					path="wellCompletion" class="input-medium">
					<form:option value="" label="${wellInfo.getWellCompletion()}" />
				</form:select></li>
				<li><label class="label-controll">套变类型:</label> <form:select
						path="casingDeformationType" class="input-medium">
						<form:option value="" label="${wellInfo.getCasingDeformationType()}" />
					</form:select></li>
				<li><label class="label-controll">油层套管:</label> <form:select
					path="isScrap" class="input-medium">
					<form:option value="" label="${wellInfo.getIsDownWellFL()}" />
				</form:select></li>
				<li class="clearfix"></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<li><label class="label-controll" style="font-weight: bold">地面状况</label></li>
				<li class="clearfix"></li>
				<li><label class="label-controll">地理位置:</label> <form:input readonly="true"
						path="location" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll" style="font-size: 12px">周边环境描述:</label> <form:input readonly="true"
						path="environment" htmlEscape="false" maxlength="120" class="input-info" />
				<li><label class="label-controll">井口状况:</label> <form:input readonly="true"
						path="groundFacility" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">井口横坐标:</label> <form:input readonly="true"
						path="coordinateX" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll">井口纵坐标:</label> <form:input readonly="true"
						path="coordinateY" htmlEscape="false" maxlength="120" class="input-info" />
				</li>
				<li><label class="label-controll"><font color="red"><strong>地面风险:</strong></font></label> <form:select
						path="riskRank" class="input-medium">
						<form:option value="" label="${wellInfo.getRiskRank()}" />
					</form:select></li>
				<li><label class="label-controll"><font color="red"><strong>下步方案:</strong></font></label> <form:select
						path="nextSchema" class="input-medium">
						<form:option value="" label="${wellInfo.getNextSchema()}" />
					</form:select></li>
				<li class="clearfix"></li>
			</ul>
		</div>

		<div class="control-group">
			<ul class="ul-form">
				<label class="label-controll" style="font-weight: bold">井图列表</label>
				<c:set var="image1">${wellInfo.getImageCurrentYear().getImage1()}</c:set>
				<c:set var="image1null">${basePath}\\static\\images\\nullImage.jpg</c:set>
				<c:set var="image1src">${basePath}${wellInfo.getImageCurrentYear().getImage1()}</c:set>
				<img id='img1' class='min' src="${not empty image1 ? image1src : image1null}" width="350px" height="200px">
				
				<c:set var="image2">${wellInfo.getImageCurrentYear().getImage2()}</c:set>
				<c:set var="image2null">${basePath}\\static\\images\\nullImage.jpg</c:set>
				<c:set var="image2src">${basePath}${wellInfo.getImageCurrentYear().getImage2()}</c:set>
				<img id='img2' class='min' src="${not empty image2 ? image2src : image2null}" width="350px" height="200px">
				
				
				<c:set var="image3">${wellInfo.getImageCurrentYear().getImage3()}</c:set>
				<c:set var="image3null">${basePath}\\static\\images\\nullImage.jpg</c:set>
				<c:set var="image3src">${basePath}${wellInfo.getImageCurrentYear().getImage3()}</c:set>
				<img id='img3' class='min' src="${not empty image3 ? image3src : image3null}" width="350px" height="200px">
				
				<a href="${ctx}/cms/images?id=${wellInfo.id}">历史图片</a>
			</ul>
		</div>
		<div class="control-group">
			<label class="label-controll">备注:</label>
			<div class="controls">
				<form:textarea path="remark" htmlEscape="false" rows="4"
					maxlength="200" class="input-xxlarge" />
			</div>
		</div>
	</form:form>
	<script>
		$('#img1').click(function(){
			$(this).toggleClass('min');
			$(this).toggleClass('max');
			});
		$('#img2').click(function(){
			$(this).toggleClass('min');
			$(this).toggleClass('max');
			});
		$('#img3').click(function(){
			$(this).toggleClass('min');
			$(this).toggleClass('max');
			});
	</script>
</body>
</html>