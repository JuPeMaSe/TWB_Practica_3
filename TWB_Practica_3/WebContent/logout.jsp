<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="threeregion.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
<title>Logout</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
  	
  <div id="content">  
  		<logic:empty name="loginBean" property="user_ID">
	    	<jsp:forward page="homePage.jsp"></jsp:forward>
	    </logic:empty>
  		<logic:notEmpty name="loginBean" property="user_ID">  
  			<p>Hasta la pr�xima <bean:write name="loginBean" property="user_ID"/></p>	
  	<%--  	<% session.invalidate(); %> --%>
  	<%-- <%session.removeAttribute("perfilBean"); %>
  	<%session.removeAttribute("loginBean"); %>  --%>  	
		  	<jsp:scriptlet>
		  		session.removeAttribute("perfilBean"); 
		  		session.removeAttribute("loginBean");
		  	</jsp:scriptlet>
	    </logic:notEmpty>
	    
   </div>
 
    <jsp:directive.include file="footer.jsp" />
</body>
</html>