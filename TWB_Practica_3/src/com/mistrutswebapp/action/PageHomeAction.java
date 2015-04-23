package com.mistrutswebapp.action;

import org.apache.struts.action.* ;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.*;
import com.mistrutswebapp.beans.LoginBean;

public class PageHomeAction extends Action
{
  private static Log log = LogFactory.getLog(PageHomeAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    if (log.isInfoEnabled())
    { 
      log.info("In PageHomeAction");	
    }

	HttpSession session = request.getSession();
	LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");

	if (loginBean.getUser_ID() == null)
	{
		log.info("In PageHomeAction: usuario no registrado");
		return mapping.findForward("noRegistrado");
	}
	else
	{
		log.info("In PageHomeAction: usuario registrado: "+loginBean.getUser_ID());
		return mapping.findForward("registrado");
	}
	  
  }
}