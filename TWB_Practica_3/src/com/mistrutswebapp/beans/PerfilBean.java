package com.mistrutswebapp.beans;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.mistrutswebapp.model.Experiencia;

public class PerfilBean extends ValidatorForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//private int profile_ID;
	private String pdf; //a cambiar el tipo para almacenar pdf
	private String fotografia;//a cambiar el tipo para almacenar jpeg, bmp...
	private String direccion;
	private String localidad;
	private String provincia;
	private String pais;
	private int cont_MeGusta;
	private String user_ID;
	private ArrayList<Integer> listaTit;
	private ArrayList<Integer> listaTec;
	private ArrayList<Experiencia> listaExp;
	
	
	public PerfilBean(){
		super();
		listaTit=new ArrayList<Integer>();
		listaTec=new ArrayList<Integer>();
		listaExp=new ArrayList<Experiencia>();
	}
	
//	
//	/**
//	 * @return the profile_ID
//	 */
//	public int getProfile_ID() {
//		return profile_ID;
//	}
//
//	/**
//	 * @param profile_ID the profile_ID to set
//	 */
//	public void setProfile_ID(int profile_ID) {
//		this.profile_ID = profile_ID;
//	}

	
	/**
	 * @return the pdf
	 */
	public String getPdf() {
		return pdf;
	}

	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	/**
	 * @return the fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}

	/**
	 * @param fotografia the fotografia to set
	 */
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the cont_MeGusta
	 */
	public int getCont_MeGusta() {
		return cont_MeGusta;
	}

	/**
	 * @param cont_MeGusta the cont_MeGusta to set
	 */
	public void setCont_MeGusta(int cont_MeGusta) {
		this.cont_MeGusta = cont_MeGusta;
	}

	/**
	 * @return the user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID the user_ID to set
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}


	
	
	/**
	 * @return the listaTit
	 */
	public ArrayList<Integer> getListaTit() {
		return listaTit;
	}

	/**
	 * @param listaTit the listaTit to set
	 */
	public void setListaTit(ArrayList<Integer> listaTit) {
		this.listaTit = listaTit;
	}

	/**
	 * @return the listaExp
	 */
	public ArrayList<Experiencia> getListaExp() {
		return listaExp;
	}

	/**
	 * @param listaExp the listaExp to set
	 */
	public void setListaExp(ArrayList<Experiencia> listaExp) {
		this.listaExp = listaExp;
	}

	/**
	 * @return the listaTec
	 */
	public ArrayList<Integer> getListaTec() {
		return listaTec;
	}

	/**
	 * @param listaTec the listaTec to set
	 */
	public void setListaTec(ArrayList<Integer> listaTec) {
		this.listaTec = listaTec;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		
		//Aquí hay que implementar todos los posibles fallos del formulario
		//complementado en WebContent/WEN-INF/classes/ApplicationResources.properties
		//las distintas etiquetas error.loquesea = mensaje a aparecer
		//Si no hay errores, este método devolverá null, con lo que el formulario
		//se considerará correcto y el servidor pasará al Action
		
		return errors;
	}


}
