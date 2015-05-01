package com.mistrutswebapp.action;

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
		
		
		ModelFacade.crearPerfil(perfilBean);
		
		return mapping.findForward("succes");
	}
}
