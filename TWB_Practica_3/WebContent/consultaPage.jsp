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
	<title>Consulta</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	 
	<div id="content">
		
		<h1>Página de Consulta</h1>
		<html:form action="/processConsulta"> 
			<table>
				
				<tr>
					<td><html:checkbox property="chkPais"/></td>
					<td><label for="pais">País:</label></td> 
<!-- 						<td><html:text property="pais" /></td> -->
					<td><html:select property="pais">
				 		<html:option value="ES">España</html:option>  
					  	<html:option value="AF"> Afganistán </html:option>
					  	<html:option value="AL"> Albania </html:option>
					  	<html:option value="DE"> Alemania </html:option>
					  	<html:option value="AD"> Andorra </html:option>
					  	</html:select></td>					
					<td><html:errors property="pais" /></td>
					
				</tr>
				<tr>
					<td><html:checkbox property="chkProvincia"></html:checkbox></td>
					<td><label for="provincia">Provincia:</label></td>
					<td><html:text property="provincia" /></td>
					<td><html:errors property="provincia" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkLocalidad"></html:checkbox></td>
					<td><label for="localidad">Localidad:</label></td>
					<td><html:text property="localidad" /></td>
					<td><html:errors property="localidad" /></td>
				</tr>
				<tr>
				 	<td><html:checkbox property="chkTecnologia"></html:checkbox></td>
					<td><label for="nombre_Tec">Tecnología:</label></td>
					<td><html:select property="nombre_Tec">
					 		<c:forEach var="tecn"  items="${listaTecnologias}" >
					 		<c:set var="tecn_ID" scope="page" value= "${tecn.tecnologia_ID}"/>
					 		<html:option value="${tecn_ID}">${tecn.nombre_Tec}</html:option>					 
							</c:forEach> 
					 	</html:select></td>  
					<td><html:errors property="nombre_Tec" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkTitulacion"></html:checkbox></td>
					<td><label for="nombre_Tit">Titulación:</label></td>
				<!-- 	<td><html:text property="nombre_Tit" /></td> -->
					<td><html:select property="nombre_Tit">
				 		 <c:forEach var="titu"  items="${listaTitulaciones}" >
					 		<c:set var="titu_ID" scope="page" value= "${titu.titulacion_ID}"/>
					 		<html:option value="${titu_ID}">${titu.nombre_Tit}</html:option>					 
					 	</c:forEach> 
				 		</html:select></td>  
					<td><html:errors property="nombre_Tit" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkExperiencia"></html:checkbox></td>
					<td><label for="a_Experiencia">Años de experiencia:</label></td>
					<td><html:text property="a_Experiencia" /></td>
					<td><html:errors property="a_Experiencia" /></td>
				</tr>
					
				<tr>
					<td></td>
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
