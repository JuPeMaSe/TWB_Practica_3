package com.mistrutswebapp.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts.action.* ;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.*;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;

public class PageHomeAction extends Action
{
  private static Log log = LogFactory.getLog(PageHomeAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    if (log.isInfoEnabled())
    { 
      log.info("In PageHomeAction");	
    }
    
	HttpSession sesion = request.getSession();
	LoginBean loginBean = (LoginBean)sesion.getAttribute("loginBean");
	
	  

	if (loginBean.getUser_ID() == null){
		log.info("In PageHomeAction: usuario no registrado");
		return mapping.findForward("noRegistrado");
	}else{
//		ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();;
//		listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("");
//		sesion.setAttribute("listaPerfiles", listaPerfiles);
		log.info("In PageHomeAction: usuario registrado: "+loginBean.getUser_ID());
		if(loginBean.getUser_ID().equals("admin")){
			return mapping.findForward("admin");
		}else{
			return mapping.findForward("registrado");
		}		
	}	  
  }
}