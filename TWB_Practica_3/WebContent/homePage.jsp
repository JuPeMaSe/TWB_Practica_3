<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 		
   version="2.0">
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
 <html:html xhtml="true">
 <head> 
<!-- 	Comentario añadido para probar Github -->

   	<link href="threeregion.css" rel="stylesheet" type="text/css" />
   	   	<title>LinkUNEDin</title>  
 </head>
  <body> 	
  	<jsp:directive.include file="header.jsp" />
  	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean> 
  <div id="content">  
  		<p align="right">Usuario: 
			<jsp:getProperty property="user_ID" name="loginBean"/>
		</p>
	    <h1>LinkUNEDin</h1>
	    <h3>Página de inicio del portal</h3>
	    <p>Este portal se ha creado para aquellos profesionales que decidan compartir con nosotros su currículo, así como, permitir una mejor entrada en el mercado laboral</p>
	    <p><html:link action="creaBD.do">Crear base de datos automática </html:link>(Crea la estructura de la base de datos para las pruebas).</p>
	    <p> Es la primera acción a realizar antes de utilizar las demás, para evitar errores por no haberse creado ninguna Base de Datos</p>
	    <p><html:link action="fromhomeconsulta.do">Hacer una consulta </html:link></p>
	    <p><html:link action="fromhomealta.do">Darse de alta como usuario</html:link></p>
	    <p><html:link action="fromhomebaja.do">Darse de baja como usuario</html:link></p>
	    <p><html:link action="fromhomemodificar.do">Modificar un perfil</html:link></p>
	    <p><html:link action="fromhomeeliminar.do">Eliminar un perfil</html:link></p>
	    <p><html:link action="fromhomecrear.do">Crear un perfil</html:link></p>
	    <p><html:link action="fromhomeadministrar.do">Administrar web</html:link></p>
	    <p><html:link action="mostrarBD.do">Mostrar Base de Datos</html:link></p>
	    
   </div>
 
    <jsp:directive.include file="footer.jsp" />   
  
  </body>
</html:html>
</jsp:root>