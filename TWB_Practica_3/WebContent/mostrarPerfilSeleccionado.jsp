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
	<jsp:useBean id= "tecnologiaBean" class="com.mistrutswebapp.beans.TecnologiaBean" scope="session"/>
	<jsp:useBean id= "experienciaBean" class="com.mistrutswebapp.beans.ExperienciaBean" scope="session"/>
	
	<title>Perfil seleccionado</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 
 	<div id="content">
   		
	<h1>Perfil Seleccionado</h1>
	<!--<html:form action="/processGrabar" enctype="multipartform-data">-->
	<c:forEach var="perfil" items="${listaPerfiles}">
			<fieldset><legend>Perfil del usuario: ${perfil.user_ID } </legend>
			<!--<html:button property="mostrar" onclick="parent.location='mostrarPerfilSeleccionado.jsp'">Mostrar Perfil</html:button>-->
			<table><tr><td>
				<fieldset><legend>Perfil</legend>	
					<table border="1">
<!-- 						<tr><th>profile_ID</th><th>dirección</th><th>localidad</th><th>provincia</th><th>pais</th>
						<th>Me gusta</th><th>pdf(url)</th><th>fotografia</th><th>user_ID</th></tr>	-->
	 		 			<tr><th>profile_ID</th><td>${perfil.profile_ID}</td></tr>
	 					<tr><th>dirección</th><td>${perfil.direccion}</td></tr>
	 					<tr><th>localidad</th><td>${perfil.localidad}</td></tr>
	 					<tr><th>provincia</th><td>${perfil.provincia}</td></tr>
	 					<tr><th>pais</th><td>${perfil.pais}</td></tr>
	 					<tr><th>cont_MeGusta</th><td>${perfil.cont_MeGusta}</td></tr>
	 					<tr><th>pdf (url)</th><td>${perfil.pdf}</td></tr>
	 					<tr><th>fotografia</th><td>${perfil.fotografia}</td></tr>
	 					<tr><th>user_ID</th><td>${perfil.user_ID}</td></tr> 
	 				<!-- 	<tr><td>${perfil.profile_ID}</td>
	 					<td>${perfil.direccion}</td>
	 					<td>${perfil.localidad}</td>
	 					<td>${perfil.provincia}</td>
	 					<td>${perfil.pais}</td>
	 					<td>${perfil.cont_MeGusta}</td>
	 					<td>${perfil.pdf}</td>
	 					<td>${perfil.fotografia}</td>
	 					<td>${perfil.user_ID}</td></tr> -->
	 					
	 				</table>
 				</fieldset>
 				</td>
 				<td>
 				
 				<fieldset><legend>Titulaciones: </legend>
 					<table>
 						<c:forEach var="titu" items="${perfil.listaTit}">
 							<c:forEach var="titula" items="${listaTitulaciones}">
	 							<c:if test="${titula.titulacion_ID == titu}">
	 								<tr><td>Titulación: </td><td>${titula.nombre_Tit}</td></tr>
	 							</c:if>
	 						</c:forEach>
 						</c:forEach>
 					</table>
 				</fieldset> 				
 				
 				</td></tr>
 			</table>
 			<table><tr><td> 				
 				<fieldset><legend>Experiencia: </legend>
 					<c:forEach var="expe" items="${perfil.listaExp}">
 						<table border="1">
 						<!-- <tr><th>exp_ID</th><th>profile_ID</th><th>empresa</th><th>cargo</th><th>a_Inicio</th><th>a_Fin</th></tr>	-->
 						<tr><th>exp_ID</th><td>${expe.exp_ID}</td></tr>
 						<tr><th>profile_ID</th><td>${expe.profile_ID}</td></tr>
	 					<tr><th>empresa</th><td>${expe.empresa}</td></tr>
	 					<tr><th>cargo</th><td>${expe.cargo}</td></tr>
	 					<tr><th>a_Inicio</th><td>${expe.a_Inicio}</td></tr>
	 					<tr><th>a_Fin</th><td>${expe.a_Fin}</td></tr>
	 			<!-- 		<tr><td>exp_ID</td><td>${expe.exp_ID}</td><td> </td><td>profile_ID</td><td>${expe.profile_ID}</td></tr>
	 						<tr><td>empresa</td><td>${expe.empresa}</td> <td></td>
	 							<td>cargo</td><td>${expe.cargo}</td></tr>
	 						<tr><td>a_Inicio</td><td>${expe.a_Inicio}</td> <td></td>
	 							<td>a_Fin</td><td>${expe.a_Fin}</td></tr> -->
	 						
	 					</table>
	 				</c:forEach>
 				</fieldset> 						
 				</td>
 				<td>	
	 			<fieldset><legend>Tecnologías: </legend>
	 				<table>
	 					<c:forEach var="tecn" items="${perfil.listaTec}">
	 						<c:forEach var="tecnol" items="${listaTecnologias}">
	 							<c:if test="${tecnol.tecnologia_ID == tecn}">
	 								<tr><td>Tecnología: </td><td>${tecnol.nombre_Tec}</td></tr>
	 							</c:if>
	 						</c:forEach>
	 					</c:forEach>
	 				</table>
	 			</fieldset>
	 			</td></tr>
 			</table> 
 			
 			
 			<!-- 	<html:submit property="mostrar" value="Mostrar Perfil: ${perfil.profile_ID}"></html:submit>
 				<html:submit property="accion" value="${perfil.profile_ID }"></html:submit>
 				<html:submit property="accion" value="Me gusta"></html:submit>
 				<html:submit property="accion" value="borrar"></html:submit>   -->		
 						
 			</fieldset>
 					
							 
		</c:forEach> 
	
	
	
	
	
	
	<!-- 	</html:form>-->
		
		
		
		  
  		<html:link action="home"><bean:message key="tohome.link" /></html:link>
  	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>