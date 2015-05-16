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
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="request"/>
	

	
<!-- 	<script src="funcionesJS.js" language="JavaScript" type="text/javascript"></script> -->
	<title>Añadir Titulación</title>
	
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 
 	<div id="content">
   		 
		
<!-- 		<h1>Página crear perfil.Saludos desde Github</h1> -->
<!-- 		<p>Aquí habrá que mostrar el formulario para rellenarlo.</p> -->

<h1>Añade tus titulaciones al perfil</h1>
	
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processTitulacion" enctype="multipartform-data">
		 
		
			 <fieldset id="posicionActual"><legend>Titulaciones</legend>	
				<table>
 					<tr>
						<td><label for="titulacion_var">Titulación:</label></td>
<!-- 					 	<td><html:text property="nombre_Tit" /></td>      -->					 
					
					 <td><html:select property="titulacion_var" multiple="multiple">
					 
						 <c:forEach var="titu"  items="${listaTitulaciones}" >
						 <c:set var="titu_ID" scope="request" value= "${titu.titulacion_ID}"/>
						 <c:set var="titu_nombre" scope="request" value="${titu.nombre_Tit}"/>
						 	<html:option value="${titu_ID}">${titu_nombre}</html:option>					 
						 </c:forEach> 					
				 		</html:select></td>  
				 <!--   		<html:text property="nombre_Tit"><c:out value="${titu_nombre}"/></html:text>  -->   
						<td><html:errors property="titulacion_ID" /></td>
						<!-- <td><A HREF="javascript:newTitulacion('${titu_nombre}')">Agregar otra Titulación</A></td>  -->
					</tr>
				</table>
				
				
			 </fieldset>
			 	<p></p>
				<html:button property="atras" onclick="parent.location='crearPage.jsp'">Atras</html:button> <html:submit>Seguir</html:submit>
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
				
				</table>
			</fieldset>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
