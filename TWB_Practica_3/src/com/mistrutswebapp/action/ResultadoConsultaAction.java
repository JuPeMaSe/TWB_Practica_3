package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ResultadoConsultaBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;

public class ResultadoConsultaAction extends Action {
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	  {
		 ResultadoConsultaBean rcb = (ResultadoConsultaBean)form;
		 String strClave = rcb.getMostrar();
		 int intFinalClave= Integer.parseInt(strClave.substring(16));
		 
		 HttpSession sesion = request.getSession();
		 ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
		 listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles(" WHERE profile_ID = " + intFinalClave);
		 sesion.setAttribute("listaPerfiles",listaPerfiles);

		 return mapping.findForward("success");
	  }
}
