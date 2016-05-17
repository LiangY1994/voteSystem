<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    	<form action="clientShowVote.action" method="post">
    		<select name="channelID">
    			<option value="1">NBA</option>
				<option value="2">CBA</option>
				<option value="3">FIFA</option>
				<option value="4">French Open</option>
    		</select> <br/>
    		<input type="submit" value="Submit" />
    	</form>
	<img src="images/partition.gif" />
	
	<div id="footer">Vote System@Liang Yi</div>
  </body>
</html>
