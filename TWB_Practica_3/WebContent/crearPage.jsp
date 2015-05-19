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
	<title>Crear perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 <div id="content">
  	
<!-- 		<h1>Página crear perfil.Saludos desde Github</h1> -->
<!-- 		<p>Aquí habrá que mostrar el formulario para rellenarlo.</p> -->
	<h1>Crea tu perfil</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processCrear" enctype="multipartform-data">
			
			<fieldset>
				<table>
				
				<tr>
					<td><label for="user_ID">User_ID</label></td>
					<td><label property="user_ID"><jsp:getProperty property="user_ID" name="loginBean"/></label></td>
					<td><html:errors property="user_ID" /></td>
				</tr>
					<tr>
						
						
						<td><label for="pais">País:</label></td> 
<!--  						<td><html:text property="pais" /></td>    --> 

 				<td><html:select property="pais">
						<c:forEach var="lP" items="${listaPaises}">
							<html:option value="${lP.key}">${lP.value}</html:option> 					
						</c:forEach>
					

                  </html:select></td>    
						<td><html:errors property="pais" /></td>
					</tr>
					<tr>
						<td><label for="provincia">Provincia:</label></td>
						<td><html:text property="provincia" /></td>
						<td><html:errors property="provincia" /></td>
					</tr>
					<tr>
						<td><label for="localidad">Localidad:</label></td>
						<td><html:text property="localidad" /></td>
						<td><html:errors property="localidad" /></td>
					</tr>
					<tr>
						<td><label for="direccion">Dirección:</label></td>
						<td><html:text property="direccion" /></td>
						<td><html:errors property="direccion" /></td>
					</tr>
					<tr>
						<td><label for="pdf">Incluye un curriculum en PDF:</label></td>
						<td><html:file property="pdf" /></td>
						<td><html:errors property="pdf" /></td>
					</tr>
					<tr>
						<td><label for="fotografia">Fotografía:</label></td>
						<td><html:file property="fotografia" /></td>
						<td><html:errors property="fotografia" /></td>
					</tr>
				</table>
			</fieldset>
				<p></p>
				<html:submit>Seguir</html:submit>
				<p></p>
			</html:form>

		<p></p>

		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
