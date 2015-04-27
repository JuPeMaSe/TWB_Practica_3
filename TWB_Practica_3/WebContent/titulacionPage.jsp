<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
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
	<title>Añadir Titulación</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean> 
 	<div id="content">
   		<p align="right">Usuario: 
			<jsp:getProperty property="user_ID" name="loginBean"/>
		</p>  
  	
<!-- 		<h1>Página crear perfil.Saludos desde Github</h1> -->
<!-- 		<p>Aquí habrá que mostrar el formulario para rellenarlo.</p> -->
	  <h1>Formulario de registro</h1>
<h1>Añade tus titulaciones</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processTitulacion" enctype="multipartform-data">
				<table>
					<tr>
						<td><label for="nombre_Tit">Titulación:</label></td>
					<!-- 	<td><html:text property="nombre_Tit" /></td> -->
					 <td><html:select property="nombre_Tit">
					 		<html:option value="0">Selecciona Titulación</html:option>
					 		<html:option value="1">Graduado Ingeniería Informática</html:option>
					 		<html:option value="2">Graduado Ingeniería Tecnologías de la Informacion</html:option>
					 		</html:select></td>  
						<td><html:errors property="nombre_Tit" /></td>
					</tr>
					<tr>
						<td><html:submit>Submit</html:submit></td>
					</tr>
				</table>


			</html:form>



		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>