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
import com.mistrutswebapp.beans.TitulacionBean;

public class TitulacionAction extends Action {

	private static Log log = LogFactory.getLog(AltaAction.class);
	private TitulacionBean titulacionBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isInfoEnabled()) {
			log.info("In TitulacionAction");
		}
		return mapping.findForward("succes");
	}
	
}
