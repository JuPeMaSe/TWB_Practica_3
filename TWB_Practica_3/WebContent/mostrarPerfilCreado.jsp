<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
    xmlns:c="http://java.sun.com/jstl/core_rt"
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
	<jsp:useBean id= "tecnologiaBean" class="com.mistrutswebapp.beans.TecnologiaBean" scope="session"/>
	<jsp:useBean id= "experienciaBean" class="com.mistrutswebapp.beans.ExperienciaBean" scope="session"/>
	
	<title>Crear perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean> 
 	<div id="content">
   		<p align="right">Usuario: 
			<jsp:getProperty property="user_ID" name="loginBean"/>
		</p>
		<h1>Formulario de registro</h1>
		<html:form action="/processGrabar" enctype="multipartform-data">
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
						<td>Titulación</td>
						<td><jsp:getProperty name="titulacionBean" property="nombre_Tit"/></td>
					</tr>
					<tr>
						<td>Tecnología</td>
						<td><jsp:getProperty name="tecnologiaBean" property="nombre_Tec"/></td>
					</tr>
					<tr>
						<td>Empresa</td>
						<td><jsp:getProperty name="experienciaBean" property="empresa"/></td>
					</tr>
					<tr>
						<td>Cargo</td>
						<td><jsp:getProperty name="experienciaBean" property="cargo"/></td>
					</tr>
					<tr>
						<td>Año de Inicio</td>
						<td><jsp:getProperty name="experienciaBean" property="a_Inicio"/></td>
					</tr>
					<tr>
						<td>Año de Finalización</td>
						<td><jsp:getProperty name="experienciaBean" property="a_Fin"/></td>
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
  	