<?xml version="1.0" encoding="UTF-8"?>
<!-- File: bajaPage.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 
   xmlns:bean="http://struts.apache.org/tags-bean"			
   version="2.0">
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
	 doctype-root-element="html"
	 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
	 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
<html:html xhtml="true">
<head>
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<title>Página de Baja</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
 	 
	<div id="content"> 
	  	<h1>Página de Baja</h1>
	  	
	  	<html:link action="processBaja">Confirmar la baja de usuario</html:link><br />
	  	<html:link action="home">Cancelar y volver a Home</html:link>
	  	
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
