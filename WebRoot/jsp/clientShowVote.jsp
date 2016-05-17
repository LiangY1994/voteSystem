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
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/options.css" />
	<link rel="stylesheet" type="text/css" href="css/main.css" />
  </head>
  
  <body>
   	<img id="banner" src="images/banner.jpg" />
  	<div id="banner2">Administrator</div>
    <ul id="navi">
		<li><a href="jsp/index.jsp">Change Channel</a></li>
	</ul>
	<img src="images/partition.gif" />
	<s:iterator value="#request.voteResults" var="voteResult">
	<div id="vote">
		Vote ID:${voteResult.vote.voteID }<br />
		Vote Name:${voteResult.vote.voteName }<br/>
		<s:subset source="#voteResult.options" id="subvoteOptions"></s:subset>
        Options:
        <form action="clientVote.action?voteID=${voteResult.vote.voteID }" method="post" id="options">
        	<s:iterator value="#attr.subvoteOptions" var="voteOption">
            	<input type="radio" name="optionID" value="${voteOption.optionID}"/>${voteOption.optionName}
            </s:iterator>
            <br />
            <input type="submit" value="Submit" />
       	</form>
       	<a href="clientShowResult.action?voteID=${voteResult.vote.voteID }">Show Result</a>
	</div>
	</s:iterator>
	<s:if test="#request.page.hasPreviousPage">
		<a href="clientShowVote.action?currentPage=${page.currentPage-1}">Previous Page</a>
	</s:if>
	<s:if test="#request.page.hasNextPage">
		<a href="clientShowVote.action?currentPage=${page.currentPage+1}">Next Page</a>
	</s:if>
   	<div id="footer">Vote System@Liang Yi</div>
  </body>
</html>
