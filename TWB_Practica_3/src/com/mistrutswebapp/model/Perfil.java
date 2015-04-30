package com.mistrutswebapp.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;

public class Perfil implements Serializable {
	private int profile_ID;
	private String pdf; //a cambiar el tipo para almacenar pdf
	private String fotografia;//a cambiar el tipo para almacenar jpeg, bmp...
	private String direccion;
	private String localidad;
	private String provincia;
	private String pais;
	private int cont_MeGusta;
	private String user_ID;
	
	public Perfil(){
		super();
	}
	

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

	public int getProfile_ID() {
		return profile_ID;
	}

	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getCont_MeGusta() {
		return cont_MeGusta;
	}

	public void setCont_MeGusta(int cont_MeGusta) {
		this.cont_MeGusta = cont_MeGusta;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	
	
}
