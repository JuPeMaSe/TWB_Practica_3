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
import com.mistrutswebapp.beans.TitulacionBean;

public class TitulacionAction extends Action {

	private static Log log = LogFactory.getLog(TitulacionAction.class);
	private TitulacionBean titulacionBean;
	private PerfilBean perfilBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		titulacionBean = (TitulacionBean)form;
		HttpSession sesion = request.getSession();
		titulacionBean.setTitulacion_var(request.getParameterValues("titulacion_var"));
		ArrayList<Integer> listaTit = new ArrayList<Integer>();
		
		if(request.getParameterValues("titulacion_var")==null){
			listaTit.add(0);
		}else{
			String titValues[] = request.getParameterValues("titulacion_var");
			for (int i =0; i< titValues.length;i ++){
				int t = Integer.parseInt(titValues[i]);
				listaTit.add(t);
			}
		}
		perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
		perfilBean.setListaTit(listaTit);
		
		sesion.setAttribute("titulacionBean", titulacionBean);
		return mapping.findForward("succes");
	}
	
}
