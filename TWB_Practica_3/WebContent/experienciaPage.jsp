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
	
	<SCRIPT type="text/javascript">
	function newExperiencia(){
		var posicion=document.getElementById("posicionActual");
 		var nuevoFieldset = document.createElement("Fieldset");
 		var nuevaTabla = document.createElement('TABLE');
  		var LineaTr=document.createElement('TR');
    	var LineaTd=document.createElement('TD');
		var lbl=document.createElement('label');
 		var texto=document.createTextNode("Empresa: ");
 		lbl.appendChild(texto);		
  		LineaTd.appendChild(lbl);
  		LineaTr.appendChild(LineaTd);  		
  		var txtEmpresa=document.createElement('input');
  		txtEmpresa.type='text';
  		txtEmpresa.setAttribute("name","empresa_var");
  		var LineaTd=document.createElement('TD');
  		LineaTd.appendChild(txtEmpresa);
  		LineaTr.appendChild(LineaTd);
  		nuevaTabla.appendChild(LineaTr);
  		
  		var LineaTr=document.createElement('TR');
    	var LineaTd=document.createElement('TD');
		var lbl=document.createElement('label');
 		var texto=document.createTextNode("Cargo: ");
 		lbl.appendChild(texto);		
  		LineaTd.appendChild(lbl);
  		LineaTr.appendChild(LineaTd);  		
  		var txtCargo=document.createElement('input');
  		txtCargo.type='text';
  		txtCargo.setAttribute("name","cargo_var");
  		var LineaTd=document.createElement('TD');
  		LineaTd.appendChild(txtCargo);
  		LineaTr.appendChild(LineaTd);
  		nuevaTabla.appendChild(LineaTr);
  		
  		var LineaTr=document.createElement('TR');
    	var LineaTd=document.createElement('TD');
		var lbl=document.createElement('label');
 		var texto=document.createTextNode("Año de Inicio: ");
 		lbl.appendChild(texto);		
  		LineaTd.appendChild(lbl);
  		LineaTr.appendChild(LineaTd);  		
  		var txtA_Inicio=document.createElement('input');
  		txtA_Inicio.type='text';
  		txtA_Inicio.setAttribute("name","a_Inicio_var");
  		var LineaTd=document.createElement('TD');
  		LineaTd.appendChild(txtA_Inicio);
  		LineaTr.appendChild(LineaTd);
  		nuevaTabla.appendChild(LineaTr);
  		
  		var LineaTr=document.createElement('TR');
    	var LineaTd=document.createElement('TD');
		var lbl=document.createElement('label');
 		var texto=document.createTextNode("Año de Finalización: ");
 		lbl.appendChild(texto);		
  		LineaTd.appendChild(lbl);
  		LineaTr.appendChild(LineaTd);  		
  		var txtA_Fin=document.createElement('input');
  		txtA_Fin.type='text';
  		txtA_Fin.setAttribute("name","a_Fin_var");
  		var LineaTd=document.createElement('TD');
  		LineaTd.appendChild(txtA_Fin);
  		LineaTr.appendChild(LineaTd);
  		nuevaTabla.appendChild(LineaTr);
  		
  		nuevoFieldset.appendChild(nuevaTabla);
  		posicion.appendChild(nuevoFieldset);
	}
	
	</SCRIPT> 
	
	
	
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
					<jsp:setProperty name="titulacionBean" property="titulacion_var" param="titulacion_var" /> 
					<c:forEach var="titu" items="${titulacionBean.titulacion_var}">
						<tr>
							<td>Titulacion</td>
							<td><c:out value="${titu}"/></td>
						</tr>
					</c:forEach>
					
					<jsp:setProperty name="tecnologiaBean" property="tecnologia_var" param="tecnologia_var"/>
					<c:forEach var="tecn" items="${tecnologiaBean.tecnologia_var}" >
						<tr>
							<td>Tecnología</td>
							<td><c:out value="${tecn}" /></td>
						</tr>
					</c:forEach>
				</table>
<h1>Añade tu experiencia</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processExperiencia" enctype="multipartform-data">
			<fieldset><legend>Experiencia:</legend>
				<table>
					
					<!-- Con la experiencia también se podrían poner los campos cargo, año de inicio y de fin, desactivados y activarlos con js -->
					<tr>
						<td><label for="empresa_var">Empresa:</label></td>
						<td><html:text property="empresa_var" /></td>
						<td><html:errors property="empresa_var" /></td>
					</tr>
					<tr>
						<td><label for="cargo_var">Cargo:</label></td>
						<td><html:text property="cargo_var" /></td>
						<td><html:errors property="cargo_var" /></td>
					</tr>
					<tr>
						<td><label for="a_Inicio_var">Año de inicio:</label></td>
						<td><html:text property="a_Inicio_var" /></td>
						<td><html:errors property="a_Inicio_var" /></td>
					</tr>
					<tr>
						<td><label for="a_Fin_var">Año de finalización:</label></td>
						<td><html:text property="a_Fin_var" /></td>
						<td><html:errors property="a_Fin_var" /></td>
					</tr>					
				</table>				
			</fieldset>
			<div id="posicionActual">
			<p></p>
			</div>
			<table>
				<tr>
					<td><html:submit>Submit</html:submit></td>
				</tr>
					
				<tr><td><A HREF="javascript:newExperiencia()">Agregar otra Experiencia</A></td></tr>
			</table>

			</html:form>



		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
