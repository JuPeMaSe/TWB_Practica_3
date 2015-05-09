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

		tecnologiaBean.setTecnologia_var(request.getParameterValues("tecnologia_var"));
		ArrayList<Integer> listaTec = new ArrayList<Integer>();
		String tecValues[] = request.getParameterValues("tecnologia_var");
		
		for (int i =0; i< tecValues.length;i ++){
			int t = Integer.parseInt(tecValues[i]);
			listaTec.add(t);
		}
		
		perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
		perfilBean.setListaTec(listaTec);
		sesion.setAttribute("tecnologiaBean", tecnologiaBean);
		return mapping.findForward("succes");
	}
}
