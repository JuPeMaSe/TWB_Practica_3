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
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<jsp:useBean id= "titulacionBean" class="com.mistrutswebapp.beans.TitulacionBean" scope="session"/>
	<title>Crear perfil</title>
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
	   <table border="0">
					<tr>
						<td>Dirección</td>
						<td><jsp:getProperty name="perfilBean" property="direccion"/></td>
					</tr>
					<tr>
						<td>Provincia</td>
						<td><jsp:getProperty name="perfilBean" property="provincia"/></td>
					</tr>
					<tr>
						<td>Pais</td>
						<td><jsp:getProperty name="perfilBean" property="pais"/></td>
					</tr>
					<tr>
						<td>Pdf</td>
						<td><jsp:getProperty name="perfilBean" property="pdf"/></td>
					</tr>
					<tr>
						<td>Fotografía</td>
						<td><jsp:getProperty name="perfilBean" property="fotografia"/></td>
					</tr>
					<tr>
						<td>Titulacion</td>
						<td><jsp:getProperty name="titulacionBean" property="nombre_Tit"/></td>
					</tr>
				</table>
<h1>Añade tecnologías</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processTecnologia" enctype="multipartform-data">
				<table>
					<tr>
						<td><label for="nombre_Tec">Tecnología:</label></td>
						 <td><html:select property="nombre_Tec">
						 		<html:option value="0">Selecciona Tecnología</html:option>
						 		<html:option value="1">Java 2</html:option>
						 		<html:option value="2">C++</html:option>
						 		</html:select></td>  
						<td><html:errors property="nombre_Tec" /></td>
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
