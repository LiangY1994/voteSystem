<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
  </head>
  
  <body>
   	<img id="banner" src="images/banner.jpg" />
  	<div id="banner2">Administrator</div>
    <ul id="navi">
		<li><a href="jsp/addVote.jsp">Add Vote</a></li>
		<li><a href="showVote.action">Show Vote</a></li>
	</ul>
	<img src="images/partition.gif" />
	
	<form action="addVote.action" method="post" name="addForm">
		Please select a channel
		<select name="channelID">
			<option value="1">NBA</option>
			<option value="2">CBA</option>
			<option value="3">FIFA</option>
			<option value="4">French Open</option>
		</select>
		<br />
		Vote Name: <input type="text" name="voteName" />
		<div id="optionList">
			<br/>Option 1:<input type="text" name="option" />
			<br/>Option 2:<input type="text" name="option" />
			<br/>Option 3:<input type="text" name="option" />
		</div>
		<input type="button" value="New Option" onclick="addOption()" /><br />
		<input type="submit" value="New Vote" />
		<input type="reset" value="Reset" />
	</form>
	
   	<div id="footer">Vote System@Liang Yi</div>
   	<script type="text/javascript" src="scripts/addVote.js"></script>
  </body>
</html>
