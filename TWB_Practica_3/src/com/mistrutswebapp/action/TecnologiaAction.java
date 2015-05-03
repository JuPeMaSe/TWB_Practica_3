package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.beans.TecnologiaBean;
import com.mistrutswebapp.beans.TitulacionBean;

public class TecnologiaAction extends Action {
	
	private static Log log = LogFactory.getLog(TecnologiaAction.class);
	private TecnologiaBean tecnologiaBean;
	private PerfilBean perfilBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		tecnologiaBean = (TecnologiaBean)form;
		HttpSession sesion = request.getSession();
		
		int t= Integer.parseInt(request.getParameter("tecnologia_ID"));
		tecnologiaBean.setTecnologia_ID(request.getParameter("tecnologia_ID"));
		
		sesion.setAttribute("tecnologiaBean", tecnologiaBean);
		
		perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
		ArrayList<Integer> listaTec = new ArrayList<Integer>();
		listaTec.add(t);
		perfilBean.setListaTec(listaTec);
		
		
		return mapping.findForward("succes");
	}

}
