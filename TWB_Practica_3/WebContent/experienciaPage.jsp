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
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<jsp:useBean id= "titulacionBean" class="com.mistrutswebapp.beans.TitulacionBean" scope="session"/>
	<jsp:useBean id= "tecnologiaBean" class="com.mistrutswebapp.beans.TecnologiaBean" scope="session"/>
	
	<title>Crear perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 
 	<div id="content">
 	  	
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
						<td>Titulación</td>
						<td><jsp:getProperty name="titulacionBean" property="titulacion_ID"/></td>
					</tr>
					<tr>
						<td>Tecnología</td>
						<td><jsp:getProperty name="tecnologiaBean" property="tecnologia_ID"/></td>
					</tr>
				</table>
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
