<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div id="navigationbar">
 <a href="homePage.jsp">
  <img src="webhomelogo.gif" alt="Web logo" />
 </a>
 <span class="topnavigationlink">
  <a href="homePage.jsp">Home</a>
 </span>
 <span class="topnavigationlink">
  <a href="consultaPage.jsp">P&aacute;gina Consulta</a>
 </span>
 <span class="topnavigationlink">
  <a href="contactoPage.htm">Contacta con nosotros</a>
 </span>
</div>
<div id="leftnavigation">
 <div class="leftnavigationlink">
  <a href="ayudaPage.htm">Ayuda</a>
 </div>
 <div class="leftnavigationlink">
  <a href="content.htm">Qui&eacute;nes somos</a>
 </div>
 <div class="leftnavigationlink">
  <a href="deal.htm">Mapa de Navegaci&oacute;n</a>
 </div>
 <div class="leftnavigationlink">
  <a href="more.htm">M&aacute;s info</a>
 </div>
</div>


<p align="right">Usuario:
	 <logic:notEmpty name="loginBean" property="user_ID">			
		<bean:write name="loginBean" property="user_ID"/>
		<p><html:link page="/logout.jsp">Terminar Sesion</html:link></p>	
	</logic:notEmpty>
	<logic:empty name="loginBean" property="user_ID">
		Anónimo
	</logic:empty>
	
</p>