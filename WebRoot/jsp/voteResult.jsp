<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Vote System</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  
  <body>
  	<img id="banner" src="images/banner.jpg" />
  	<div id="banner2">Vote System</div>
  	<ul id="navi">
		<li><a href="jsp/index.jsp">Change Channel</a></li>
	</ul>
    	
	<img src="images/partition.gif" />
	<ul>
		<s:iterator value="#request.options" var="option">
			<li>${option.optionName } : ${option.optionNumber }</li>
		</s:iterator>	
	</ul>
	<div id="footer">Vote System@Liang Yi</div>
  </body>
</html>
