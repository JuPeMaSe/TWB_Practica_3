package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ExperienciaBean extends ActionForm implements Serializable{
	private String empresa;
	private String cargo;
	private String a_Inicio;
	private String a_Fin;
	/**
	 * @return the a_Inicio
	 */
	public String getA_Inicio() {
		return a_Inicio;
	}
	/**
	 * @param a_Inicio the a_Inicio to set
	 */
	public void setA_Inicio(String a_Inicio) {
		this.a_Inicio = a_Inicio;
	}
	/**
	 * @return the a_Fin
	 */
	public String getA_Fin() {
		return a_Fin;
	}
	/**
	 * @param a_Fin the a_Fin to set
	 */
	public void setA_Fin(String a_Fin) {
		this.a_Fin = a_Fin;
	}
	//private int profile_ID;
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		
		if(a_Inicio != null || !a_Inicio.equals("")){
			try{
				Integer.parseInt(a_Inicio);
			}catch(Exception e){
				errors.add("a_Inicio", new ActionMessage("error.a_Inicio"));	
			}
			
		}
		if(a_Fin != null || !a_Fin.equals("")){
			try{
				Integer.parseInt(a_Fin);
			}catch(Exception e){
				errors.add("a_Fin", new ActionMessage("error.a_Fin"));	
			}
			
		}
		//Aquí hay que implementar todos los posibles fallos del formulario
		//complementado en WebContent/WEN-INF/classes/ApplicationResources.properties
		//las distintas etiquetas error.loquesea = mensaje a aparecer
		//Si no hay errores, este método devolverá null, con lo que el formulario
		//se considerará correcto y el servidor pasará al Action
		
		return errors;
	}

}
