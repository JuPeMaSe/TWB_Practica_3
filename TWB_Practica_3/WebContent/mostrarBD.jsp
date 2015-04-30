<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
   version="2.0">
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
<html:html xhtml="true">
<head>
	<meta http-equiv="Content-Type" content="text/html" />
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<title>Alta de usuario</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	 	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean> 
	<!-- <div id="content"> --> 
	  	<p align="right">Usuario: 
			<jsp:getProperty property="user_ID" name="loginBean"/>
		</p>
	 	<h1>Base de Datos</h1>
		<p>Aquí se tiene que mostrar la base de datos completa</p>
		<p>(De momento no está implementado así que se muestra en la pestaña Console de Eclipse)</p>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>