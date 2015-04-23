package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ExperienciaBean extends ValidatorForm implements Serializable{
	
	private String exp_ID;//Campo Int en la base de datos
	private String empresa;
	private String cargo;
	private String a_Inicio;//Campo Int en la base de datos
	private String a_Fin;//Campo Int en la base de datos
	
	
	public ExperienciaBean(){
		super();
	}
	
	/*Los campos Int, creo recordar que vi en el libro como controlarlos
	 * Lo mirarÃ© y modificarÃ© este bean.
	 */
	public String getExp_ID() {
		return exp_ID;
	}
	public void setExp_ID(String exp_ID) {
		this.exp_ID = exp_ID;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getA_Inicio() {
		return a_Inicio;
	}
	public void setA_Inicio(String a_Inicio) {
		this.a_Inicio = a_Inicio;
	}
	public String getA_Fin() {
		return a_Fin;
	}
	public void setA_Fin(String a_Fin) {
		this.a_Fin = a_Fin;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(exp_ID == null || exp_ID.equals("")){
			errors.add("exp_ID", new ActionMessage("error.exp_ID"));
		}
		//Así hay que implementar todos los posibles fallos del formulario
		//complementado en WebContent/WEN-INF/classes/ApplicationResources.properties
		//las distintas etiquetas error.loquesea = mensaje a aparecer
		//Si no hay errores, este método devolverá null, con lo que el formulario
		//se considerará correcto y el servidor pasará al Action
		
		return errors;
	}

}
