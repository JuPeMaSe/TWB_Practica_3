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
  	
<!-- 		<h1>Página crear perfil.Saludos desde Github</h1> -->
<!-- 		<p>Aquí habrá que mostrar el formulario para rellenarlo.</p> -->
	  <h1>Formulario de registro</h1>
<h1>Crea tu perfil</h1>
			<!-- el action tendrá que ir hacia processCrear -->
			<html:form action="/processCrear" enctype="multipartform-data">
				<table>
					<tr>
						
						
						<td><label for="pais">País:</label></td> 
<!-- 						<td><html:text property="pais" /></td> -->
				<td><html:select property="pais">
				 	<html:option value="ES">España</html:option>  
					  <html:option value="AF"> Afganistán </html:option>
					  <html:option value="AL"> Albania </html:option>
					  <html:option value="DE"> Alemania </html:option>
					  <html:option value="AD"> Andorra </html:option>
					
<!-- 					  <html:option value="AO"> Angola </html:option>
					  <html:option value="AI"> Anguilla </html:option>
					  <html:option value="AQ"> Antártida </html:option>
					  <html:option value="AG"> Antigua y Barbuda </html:option>
					  <html:option value="AN"> Antillas Holandesas </html:option>
					
					  <html:option value="SA"> Arabia Saudí; </html:option>
					  <html:option value="DZ"> Argelia </html:option>
					  <html:option value="AR"> Argentina </html:option>
					  <html:option value="AM"> Armenia </html:option>
					  <html:option value="AW"> Aruba </html:option>
					
					  <html:option value="MK"> ARY Macedonia </html:option>
					  <html:option value="AU"> Australia </html:option>
					  <html:option value="AT"> Austria </html:option>
					  <html:option value="AZ"> Azerbaiyán </html:option>
					  <html:option value="BS"> Bahamas </html:option>
					
					  <html:option value="BH"> Bahréin </html:option>
					  <html:option value="BD"> Bangladesh </html:option>
					  <html:option value="BB"> Barbados </html:option>
					  <html:option value="BE"> Bélgica </html:option>
					  <html:option value="BZ"> Belice </html:option>
					
					  <html:option value="BJ"> Benin </html:option>
					  <html:option value="BM"> Bermudas </html:option>
					  <html:option value="BT"> Bhután </html:option>
					  <html:option value="BY"> Bielorrusia </html:option>
					  <html:option value="BO"> Bolivia </html:option>
					
					  <html:option value="BA"> Bosnia y Herzegovina </html:option>
					  <html:option value="BW"> Botsuana </html:option>
					  <html:option value="BR"> Brasil </html:option>
					  <html:option value="BN"> Brunéi </html:option>
					  <html:option value="BG"> Bulgaria </html:option>
					
					  <html:option value="BF"> Burkina Faso </html:option>
					  <html:option value="BI"> Burundi </html:option>
					  <html:option value="CV"> Cabo Verde </html:option>
					  <html:option value="KH"> Camboya </html:option>
					  <html:option value="CM"> Camerú;n </html:option>
					
					  <html:option value="CA"> Canadá; </html:option>
					  <html:option value="TD"> Chad </html:option>
					  <html:option value="CL"> Chile </html:option>
					  <html:option value="CN"> China </html:option>
					  <html:option value="CY"> Chipre </html:option>
					
					  <html:option value="VA"> Ciudad del Vaticano </html:option>
					  <html:option value="CO"> Colombia </html:option>
					  <html:option value="KM"> Comoras </html:option>
					  <html:option value="CG"> Congo </html:option>
					  <html:option value="KP"> Corea del Norte </html:option>
					
					  <html:option value="KR"> Corea del Sur </html:option>
					  <html:option value="CI"> Costa de Marfil </html:option>
					  <html:option value="CR"> Costa Rica </html:option>
					  <html:option value="HR"> Croacia </html:option>
					  <html:option value="CU"> Cuba </html:option>
					
					  <html:option value="DK"> Dinamarca </html:option>
					  <html:option value="DM"> Dominica </html:option>
					  <html:option value="EC"> Ecuador </html:option>
					  <html:option value="EG"> Egipto </html:option>
					  <html:option value="SV"> El Salvador </html:option>
					
					  <html:option value="AE"> Emiratos Árabes Unidos </html:option>
					  <html:option value="ER"> Eritrea </html:option>
					  <html:option value="SK"> Eslovaquia </html:option>
					  <html:option value="SI"> Eslovenia </html:option>
                      
                      <html:option value="ES">España</html:option> 
					
					  <html:option value="US"> Estados Unidos </html:option>
					  <html:option value="EE"> Estonia </html:option>
					  <html:option value="ET"> Etiopía </html:option>
					  <html:option value="PH"> Filipinas </html:option>
					  <html:option value="FI"> Finlandia </html:option>
					
					  <html:option value="FJ"> Fiyi </html:option>
					  <html:option value="FR"> Francia </html:option>
					  <html:option value="GA"> Gabón </html:option>
					  <html:option value="GM"> Gambia </html:option>
					  <html:option value="GE"> Georgia </html:option>
					
					  <html:option value="GH"> Ghana </html:option>
					  <html:option value="GI"> Gibraltar </html:option>
					  <html:option value="GD"> Granada </html:option>
					  <html:option value="GR"> Grecia </html:option>
					  <html:option value="GL"> Groenlandia </html:option>
					
					  <html:option value="GP"> Guadalupe </html:option>
					  <html:option value="GU"> Guam </html:option>
					  <html:option value="GT"> Guatemala </html:option>
					  <html:option value="GF"> Guayana Francesa </html:option>
					  <html:option value="GN"> Guinea </html:option>
					
					  <html:option value="GQ"> Guinea Ecuatorial </html:option>
					  <html:option value="GW"> Guinea-Bissau </html:option>
					  <html:option value="GY"> Guyana </html:option>
					  <html:option value="HT"> Haití; </html:option>
					  <html:option value="HN"> Honduras </html:option>
					
					  <html:option value="HK"> Hong Kong </html:option>
					  <html:option value="HU"> Hungría </html:option>
					  <html:option value="IN"> India </html:option>
					  <html:option value="ID"> Indonesia </html:option>
					  <html:option value="IR"> Irán </html:option>
					
					  <html:option value="IQ"> Iraq </html:option>
					  <html:option value="IE"> Irlanda </html:option>
					  <html:option value="BV"> Isla Bouvet </html:option>
					  <html:option value="CX"> Isla de Navidad </html:option>
					  <html:option value="NF"> Isla Norfolk </html:option>
					
					  <html:option value="IS"> Islandia </html:option>
					  <html:option value="KY"> Islas Caimán </html:option>
					  <html:option value="CC"> Islas Cocos </html:option>
					  <html:option value="CK"> Islas Cook </html:option>
					  <html:option value="FO"> Islas Feroe </html:option>
					
					  <html:option value="GS"> Islas Georgias del Sur y Sandwich del Sur </html:option>
					  <html:option value="AX"> Islas Gland </html:option>
					  <html:option value="HM"> Islas Heard y McDonald </html:option>
					  <html:option value="FK"> Islas Malvinas </html:option>
					  <html:option value="MP"> Islas Marianas del Norte </html:option>
					
					  <html:option value="MH"> Islas Marshall </html:option>
					  <html:option value="PN"> Islas Pitcairn </html:option>
					  <html:option value="SB"> Islas Salomón </html:option>
					  <html:option value="TC"> Islas Turcas y Caicos </html:option>
					  <html:option value="UM"> Islas ultramarinas de Estados Unidos </html:option>
					
					  <html:option value="VG"> Islas Vírgenes Británicas </html:option>
					  <html:option value="VI"> Islas Vírgenes de los Estados Unidos </html:option>
					  <html:option value="IL"> Israel </html:option>
					  <html:option value="IT"> Italia </html:option>
					  <html:option value="JM"> Jamaica </html:option>
					
					  <html:option value="JP"> Japón </html:option>
					  <html:option value="JO"> Jordania </html:option>
					  <html:option value="KZ"> Kazajstán </html:option>
					  <html:option value="KE"> Kenia </html:option>
					  <html:option value="KG"> Kirguistán </html:option>
					
					  <html:option value="KI"> Kiribati </html:option>
					  <html:option value="KW"> Kuwait </html:option>
					  <html:option value="LA"> Laos </html:option>
					  <html:option value="LS"> Lesotho </html:option>
					  <html:option value="LV"> Letonia </html:option>
					
					  <html:option value="LB"> Líbano </html:option>
					  <html:option value="LR"> Liberia </html:option>
					  <html:option value="LY"> Libia </html:option>
					  <html:option value="LI"> Liechtenstein </html:option>
					  <html:option value="LT"> Lituania </html:option>
					
					  <html:option value="LU"> Luxemburgo </html:option>
					  <html:option value="MO"> Macao </html:option>
					  <html:option value="MG"> Madagascar </html:option>
					  <html:option value="MY"> Malasia </html:option>
					  <html:option value="MW"> Malawi </html:option>
					
					  <html:option value="MV"> Maldivas </html:option>
					  <html:option value="ML"> Malí </html:option>
					  <html:option value="MT"> Malta </html:option>
					  <html:option value="MA"> Marruecos </html:option>
					  <html:option value="MQ"> Martinica </html:option>
					
					  <html:option value="MU"> Mauricio </html:option>
					  <html:option value="MR"> Mauritania </html:option>
					  <html:option value="YT"> Mayotte </html:option>
					  <html:option value="MX"> México </html:option>
					  <html:option value="FM"> Micronesia </html:option>
					
					  <html:option value="MD"> Moldavia </html:option>
					  <html:option value="MC"> Mónaco </html:option>
					  <html:option value="MN"> Mongolia </html:option>
					  <html:option value="MS"> Montserrat </html:option>
					  <html:option value="MZ"> Mozambique </html:option>
					
					  <html:option value="MM"> Myanmar </html:option>
					  <html:option value="NA"> Namibia </html:option>
					  <html:option value="NR"> Nauru </html:option>
					  <html:option value="NP"> Nepal </html:option>
					  <html:option value="NI"> Nicaragua </html:option>
					
					  <html:option value="NE"> Níger </html:option>
					  <html:option value="NG"> Nigeria </html:option>
					  <html:option value="NU"> Niue </html:option>
					  <html:option value="NO"> Noruega </html:option>
					  <html:option value="NC"> Nueva Caledonia </html:option>
					
					  <html:option value="NZ"> Nueva Zelanda </html:option>
					  <html:option value="OM"> Omán </html:option>
					  <html:option value="NL"> Países Bajos </html:option>
					  <html:option value="PK"> Pakistán </html:option>
					  <html:option value="PW"> Palau </html:option>
					
					  <html:option value="PS"> Palestina </html:option>
					  <html:option value="PA"> Panamá </html:option>
					  <html:option value="PG"> Papúa Nueva Guinea </html:option>
					  <html:option value="PY"> Paraguay </html:option>
					  <html:option value="PE"> Perú </html:option>
					
					  <html:option value="PF"> Polinesia Francesa </html:option>
					  <html:option value="PL"> Polonia </html:option>
					  <html:option value="PT"> Portugal </html:option>
					  <html:option value="PR"> Puerto Rico </html:option>
					  <html:option value="QA"> Qatar </html:option>
					
					  <html:option value="GB"> Reino Unido </html:option>
					  <html:option value="CF"> República Centroafricana </html:option>
					  <html:option value="CZ"> República Checa </html:option>
					  <html:option value="CD"> República Democrática del Congo </html:option>
					  <html:option value="DO"> República Dominicana </html:option>
					
					  <html:option value="RE"> Reunión </html:option>
					  <html:option value="RW"> Ruanda </html:option>
					  <html:option value="RO"> Rumania </html:option>
					  <html:option value="RU"> Rusia </html:option>
					  <html:option value="EH"> Sahara Occidental </html:option>
					
					  <html:option value="WS"> Samoa </html:option>
					  <html:option value="AS"> Samoa Americana </html:option>
					  <html:option value="KN"> San Cristóbal y Nevis </html:option>
					  <html:option value="SM"> San Marino </html:option>
					  <html:option value="PM"> San Pedro y Miquelón </html:option>
					
					  <html:option value="VC"> San Vicente y las Granadinas </html:option>
					  <html:option value="SH"> Santa Helena </html:option>
					  <html:option value="LC"> Santa Lucía </html:option>
					  <html:option value="ST"> Santo Tomé y Príncipe </html:option>
					  <html:option value="SN"> Senegal </html:option>
					
					  <html:option value="CS"> Serbia y Montenegro </html:option>
					  <html:option value="SC"> Seychelles </html:option>
					  <html:option value="SL"> Sierra Leona </html:option>
					  <html:option value="SG"> Singapur </html:option>
					  <html:option value="SY"> Siria </html:option>
					
					  <html:option value="SO"> Somalia </html:option>
					  <html:option value="LK"> Sri Lanka </html:option>
					  <html:option value="SZ"> Suazilandia </html:option>
					  <html:option value="ZA"> Sudáfrica </html:option>
					  <html:option value="SD"> Sudán </html:option>
					
					  <html:option value="SE"> Suecia </html:option>
					  <html:option value="CH"> Suiza </html:option>
					  <html:option value="SR"> Surinam </html:option>
					  <html:option value="SJ"> Svalbard y Jan Mayen </html:option>
					  <html:option value="TH"> Tailandia </html:option>
					
					  <html:option value="TW"> Taiwán </html:option>
					  <html:option value="TZ"> Tanzania </html:option>
					  <html:option value="TJ"> Tayikistán </html:option>
					  <html:option value="IO"> Territorio Británico del Océano índico </html:option>
					  <html:option value="TF"> Territorios Australes Franceses </html:option>
					
					  <html:option value="TL"> Timor Oriental </html:option>
					  <html:option value="TG"> Togo </html:option>
					  <html:option value="TK"> Tokelau </html:option>
					  <html:option value="TO"> Tonga </html:option>
					  <html:option value="TT"> Trinidad y Tobago </html:option>
					
					  <html:option value="TN"> Túnez </html:option>
					  <html:option value="TM"> Turkmenistán </html:option>
					  <html:option value="TR"> Turquía </html:option>
					  <html:option value="TV"> Tuvalu </html:option>
					  <html:option value="UA"> Ucrania </html:option>
					
					  <html:option value="UG"> Uganda </html:option>
					  <html:option value="UY"> Uruguay </html:option>
					  <html:option value="UZ"> Uzbekistán </html:option>
					  <html:option value="VU"> Vanuatu </html:option>
					  <html:option value="VE"> Venezuela </html:option>
					
					  <html:option value="VN"> Vietnam </html:option>
					  <html:option value="WF"> Wallis y Futuna </html:option>
					  <html:option value="YE"> Yemen </html:option>
					  <html:option value="DJ"> Yibuti </html:option>
					  <html:option value="ZM"> Zambia </html:option>
					
					  <html:option value="ZW"> Zimbabue </html:option> -->
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
