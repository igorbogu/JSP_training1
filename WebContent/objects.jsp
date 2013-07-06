<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
String userName = request.getParameter("name");

if (userName !=null) {
	
	session.setAttribute("sessionUserName", userName);
	application.setAttribute("aplicationUserName", userName);
	pageContext.setAttribute("pageContextUserName", userName);
	pageContext.setAttribute("pageContextUserName", userName, PageContext.APPLICATION_SCOPE);
}
%>
<br>
UserName in request : <%=userName %>
<br>
UserName in session : <%=session.getAttribute("sessionUserName") %>
<br>
UserName in application : <%=application.getAttribute("aplicationUserName") %>
<br>
UserName in pageContext : <%=pageContext.getAttribute("pageContextUserName") %>
<br>
</body>
</html>