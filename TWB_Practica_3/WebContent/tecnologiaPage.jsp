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
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<jsp:useBean id= "titulacionBean" class="com.mistrutswebapp.beans.TitulacionBean" scope="session"/>
	<title>Crear perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 
 	
 	<div id="content">
	<h1>Añade tus tecnologías al perfil</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processTecnologia" enctype="multipartform-data">
			<fieldset><legend>Tecnologías:</legend>
				<table>
					<tr>
						<td><label for="tecnologia_var">Tecnología:</label></td>
						 <td><html:select property="tecnologia_var" multiple= "multiple">
							  	<c:forEach var="tecn"  items="${listaTecnologias}" >
						 		<c:set var="tecn_ID" scope="page" value= "${tecn.tecnologia_ID}"/>
						 		<html:option value="${tecn_ID}">${tecn.nombre_Tec}</html:option>					 
							</c:forEach> 
						 	</html:select></td>  
						<td><html:errors property="nombre_Tec" /></td>
					</tr>
				</table>
			</fieldset>
				<p></p>
				<html:button property="atras" onclick="parent.location='titulacionPage.jsp'">Atras</html:button> <html:submit>Seguir</html:submit>
				<p></p>
			</html:form>
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
		
		<fieldset>
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
					 <jsp:setProperty name="titulacionBean" property="titulacion_var" param="titulacion_var" /> 
						<c:forEach var="titu" items="${titulacionBean.titulacion_var}">
					<tr>
						<c:forEach var="titula" items="${listaTitulaciones}">
	 							<c:if test="${titula.titulacion_ID == titu}">
	 								<tr><td>Titulación: </td><td>${titula.nombre_Tit}</td></tr>
	 							</c:if>
	 						</c:forEach>
					</tr>
					</c:forEach>
				</table>
		</fieldset>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
