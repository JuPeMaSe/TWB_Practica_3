package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ExperienciaBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.beans.TecnologiaBean;
import com.mistrutswebapp.beans.TitulacionBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;

public class MostrarPerfilCreadoAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		PerfilBean perfilBean;
		TitulacionBean titulacionBean;
		TecnologiaBean tecnologiaBean;
		ExperienciaBean experienciaBean;
		
		HttpSession sesion = request.getSession();
		perfilBean = (PerfilBean) sesion.getAttribute("perfilBean");
		titulacionBean= (TitulacionBean) sesion.getAttribute("titulacionBean");
		tecnologiaBean = (TecnologiaBean) sesion.getAttribute("tecnologiaBean");
		experienciaBean=(ExperienciaBean) sesion.getAttribute("experienciaBean");
		
		ArrayList<Integer> listaTit= new ArrayList<Integer>();
		//System.out.println("En MostrarPerfilCreado: titulacion--> "+titulacionBean.getTitulacion_ID()+titulacionBean.getNombre_Tit());
		
		listaTit= perfilBean.getListaTit();
		int t= listaTit.size();
		for(int i=0; i<t; i++){			
			System.out.println("En MostrarPerfilCreado: perfilBean.listaTitulacion.item --> "+listaTit.get(i));		
		}
		
		ArrayList<Integer> listaTec = new ArrayList<Integer>();
		listaTec=perfilBean.getListaTec();
		int z = listaTec.size();
		for(int i=0;i<z;i++){
			System.out.println("En MostrarPerfilCreado: perfilBean.listaTecnologia.item --> "+listaTec.get(i));
		}
			
		
		ModelFacade.crearPerfil(perfilBean);
		
			ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();;
			listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+perfilBean.getUser_ID() + "'");
			sesion.setAttribute("listaPerfiles", listaPerfiles);
		
		return mapping.findForward("succes");
	}
}
