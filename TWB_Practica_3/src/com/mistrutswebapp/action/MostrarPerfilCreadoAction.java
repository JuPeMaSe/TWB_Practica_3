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
		int t = perfilBean.getListaTit().size();
		for(int i=0; i<t; i++){
			listaTit= perfilBean.getListaTit();
			System.out.println("En MostrarPerfilCreado: perfilBean.listaTitulacion.item --> "+listaTit.get(i));		
		}
		
		
		
		//listaTit.add(t);		
		//perfilBean.setListaTit(listaTit);
		//System.out.println(perfilBean.getListaTit().get(0).toString());
		
		ArrayList<Integer> listaTec= new ArrayList<Integer>();
		listaTec.add(tecnologiaBean.getTecnologia_ID());		
		perfilBean.setListaTec(listaTec);
		//System.out.println(perfilBean.getListaTec().get(0).toString());
		
		//ArrayList<Integer> listaExp= new ArrayList<Integer>();
				
		
		
		
		ModelFacade.crearPerfil(perfilBean,experienciaBean);
		
		return mapping.findForward("succes");
	}
}
