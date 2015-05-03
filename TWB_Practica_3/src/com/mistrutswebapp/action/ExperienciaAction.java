package com.mistrutswebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ExperienciaBean;
import com.mistrutswebapp.beans.TecnologiaBean;

public class ExperienciaAction extends Action{
	
	private static Log log = LogFactory.getLog(ExperienciaAction.class);
	private ExperienciaBean experienciaBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		if (log.isInfoEnabled()) {
//			log.info("In ExperienciaAction");
//		}
		experienciaBean= (ExperienciaBean)form;
		HttpSession sesion = request.getSession();
		sesion.setAttribute("experienciaBean",experienciaBean);
		return mapping.findForward("succes");
	}
}
