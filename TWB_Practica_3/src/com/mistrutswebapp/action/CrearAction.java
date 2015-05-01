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

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Titulacion;

public class CrearAction extends Action {

	private static Log log = LogFactory.getLog(CrearAction.class);
	private PerfilBean perfilBean;
	private LoginBean loginBean;
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		if (log.isInfoEnabled()) {
//			log.info("In CrearAction");
//		}
		perfilBean = (PerfilBean)form;
		HttpSession sesion = request.getSession();
		LoginBean loginBean = (LoginBean)sesion.getAttribute("loginBean");
//		loginBean  = (LoginBean) request.getSession().getAttribute("user_ID");
//		
//		//código para prueba. elimarlo al final
//		@SuppressWarnings("unchecked")
//		ArrayList<Titulacion> lista = (ArrayList<Titulacion>)sesion.getAttribute("listaTitulaciones");
//		for(int i=0; i<lista.size();i++){
//			System.out.println("ID= "+lista.get(i).getTitulacion_ID()+" Nombre= "+lista.get(i).getNombre_Tit());
//		}
//		
		 
		perfilBean.setUser_ID(loginBean.getUser_ID());
		//ModelFacade.crearPerfil(perfilBean);
		 sesion.setAttribute("perfilBean", perfilBean);
		return mapping.findForward("succes");
	}
}
