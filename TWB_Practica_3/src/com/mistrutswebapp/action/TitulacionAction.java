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
		int t= Integer.parseInt(request.getParameter("titulacion_ID"));
		titulacionBean.setTitulacion_ID(request.getParameter("titulacion_ID"));
		//System.out.println("Nombre titulacion = "+ request.getParameter("titu_nombre"));
		perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
		ArrayList<Integer> listaTit = new ArrayList<Integer>();
		listaTit.add(t);
		perfilBean.setListaTit(listaTit);
		
		sesion.setAttribute("titulacionBean", titulacionBean);
		return mapping.findForward("succes");
	}
	
}
