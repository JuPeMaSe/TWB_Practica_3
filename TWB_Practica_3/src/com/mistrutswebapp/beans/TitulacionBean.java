
package com.mistrutswebapp.beans;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class TitulacionBean extends ValidatorForm implements Serializable{

	private static final long serialVersionUID = 1L;
	private int titulacion_ID;
	private String nombre_Tit;
	
	public TitulacionBean(){
		super();
	}
	
	public int getTitulacion_ID() {
		return titulacion_ID;
	}
	public void setTitulacion_ID(String titulacion_ID) {
		this.titulacion_ID = Integer.parseInt(titulacion_ID);
	}
	public String getNombre_Tit() {
		return nombre_Tit;
	}
	public void setNombre_Tit(String nombre_Tit) {
		this.nombre_Tit = nombre_Tit;
	}
	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		
		//Aqu� hay que implementar todos los posibles fallos del formulario
		//complementado en WebContent/WEN-INF/classes/ApplicationResources.properties
		//las distintas etiquetas error.loquesea = mensaje a aparecer
		//Si no hay errores, este m�todo devolver� null, con lo que el formulario
		//se considerar� correcto y el servidor pasar� al Action
		
		return errors;
	}
	
	/*En principio no habría que implementar control de errores aquí
	 * puesto que la titulación puede estar vacía. ¿Me equivoco?
	 */

}