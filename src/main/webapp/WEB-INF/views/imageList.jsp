<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("basePath", basePath);  
%>  
<html>
<head>
<title>图片列表</title>
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
<div>
	<c:if test="${imageList.size() eq '0'}">
		<label style="font-weight: bold">该井还未上传图片信息</label><br/>
	</c:if>
	<c:forEach items="${imageList}" var="imageYear">
	<br/>
			<label style="font-weight: bold">${imageYear.getYear()}年</label>
			<br />
			<c:if test="${not empty imageYear.getImage1()}">
				<img src="${basePath}${imageYear.getImage1()}" width="30%" height="30px">
			</c:if>
			<c:if test="${not empty imageYear.getImage2()}">
				<img src="${basePath}${imageYear.getImage2()}" width="30%" height="30px">
			</c:if>
			<c:if test="${not empty imageYear.getImage3()}">
				<img src="${basePath}${imageYear.getImage3()}" width="30%" height="30px">
			</c:if>
		</c:forEach>
</div>
</body>
</html>