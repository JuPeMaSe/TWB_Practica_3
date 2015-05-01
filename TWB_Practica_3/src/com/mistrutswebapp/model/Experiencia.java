package com.mistrutswebapp.model;

import java.io.Serializable;

public class Experiencia implements Serializable{
	private static final long serialVersionUID = 1L;
	int exp_ID;
	String empresa;
	String cargo;
	int a_Inicio;
	int a_Fin;
	int profile_ID;
	
	public Experiencia(){
		super();
	}

	/**
	 * @return the exp_ID
	 */
	public int getExp_ID() {
		return exp_ID;
	}

	/**
	 * @param exp_ID the exp_ID to set
	 */
	public void setExp_ID(int exp_ID) {
		this.exp_ID = exp_ID;
	}

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

	/**
	 * @return the a_Inicio
	 */
	public int getA_Inicio() {
		return a_Inicio;
	}

	/**
	 * @param a_Inicio the a_Inicio to set
	 */
	public void setA_Inicio(int a_Inicio) {
		this.a_Inicio = a_Inicio;
	}

	/**
	 * @return the a_Fin
	 */
	public int getA_Fin() {
		return a_Fin;
	}

	/**
	 * @param a_Fin the a_Fin to set
	 */
	public void setA_Fin(int a_Fin) {
		this.a_Fin = a_Fin;
	}

	/**
	 * @return the profile_ID
	 */
	public int getProfile_ID() {
		return profile_ID;
	}

	/**
	 * @param profile_ID the profile_ID to set
	 */
	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
	}
	
}
