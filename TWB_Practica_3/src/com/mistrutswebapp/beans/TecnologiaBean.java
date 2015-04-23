package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class TecnologiaBean extends ValidatorForm implements Serializable{	
	private static final long serialVersionUID = 1L;
	private String tecnologia_ID;
	private String nombre_Tec;
	
	public TecnologiaBean(){
		super();
	}
	
	public String getTecnologia_ID() {
		return tecnologia_ID;
	}
	public void setTecnologia_ID(String tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}
	public String getNombre_Tec() {
		return nombre_Tec;
	}
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
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

}