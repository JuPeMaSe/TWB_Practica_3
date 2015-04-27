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
	<title>Crear perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean> 
 	<div id="content">
   		<p align="right">Usuario: 
			<jsp:getProperty property="user_ID" name="loginBean"/>
		</p>  
  	
		<h1>Página crear perfil.Saludos desde Github</h1>
		<p>Aquí habrá que mostrar el formulario para rellenarlo.</p>
	  <h1>Formulario de registro</h1>
<h1>Añade tu experiencia</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processExperiencia" enctype="multipartform-data">
				<table>
					
					<!-- Con la experiencia también se podrían poner los campos cargo, año de inicio y de fin, desactivados y activarlos con js -->
					<tr>
						<td><label for="empresa">Empresa:</label></td>
						<td><html:text property="empresa" /></td>
						<td><html:errors property="empresa" /></td>
					</tr>
					<tr>
						<td><label for="cargo">Cargo:</label></td>
						<td><html:text property="cargo" /></td>
						<td><html:errors property="cargo" /></td>
					</tr>
					<tr>
						<td><label for="a_Inicio">Año de inicio:</label></td>
						<td><html:text property="a_Inicio" /></td>
						<td><html:errors property="a_Inicio" /></td>
					</tr>
					<tr>
						<td><label for="a_Fin">Año de finalización:</label></td>
						<td><html:text property="a_Fin" /></td>
						<td><html:errors property="a_Fin" /></td>
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
