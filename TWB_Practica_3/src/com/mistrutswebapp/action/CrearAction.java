package com.mistrutswebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.PerfilBean;

public class CrearAction extends Action {

	private static Log log = LogFactory.getLog(AltaAction.class);
	private PerfilBean perfilBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isInfoEnabled()) {
			log.info("In CrearAction");
		}
		return mapping.findForward("succes");
	}
}
