package com.mistrutswebapp.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MostrarBDAction extends Action {
	 private static Log log = LogFactory.getLog(LoginAction.class);
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
		  if (log.isInfoEnabled())
		  { 
		   log.info("In MostrarBDAction");
		  }
		  Connection con = null;  
          Statement  st   = null;  
          String     sql  = null;  
          ResultSet  rst1 = null;  
            
          try{
              // hago el lookup del pool de conexiones
              Context ctx=new InitialContext();
              DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
                 
              // pido una conexion
              con=ds.getConnection();
              //System.out.println(con);
			  log.info("In MostrarBDAction despues de connection");
			  // try {  
              st  = con.createStatement();  
              rst1 = st.executeQuery("SELECT * FROM Usuario");  
              while (rst1.next()){  
                  log.info("In MostrarBDAction USUARIO--> "+ rst1.getString("user_ID") + " " + rst1.getString("password") + " " + rst1.getString("nombre") );  
              } 
              rst1 = st.executeQuery("SELECT * FROM Perfil");  
              while (rst1.next()){  
                  log.info("In MostrarBDAction PERFIL--> "+ rst1.getInt("profile_ID") + " " + rst1.getString("direccion") + " " + rst1.getString("localidad")+
                		  " " + rst1.getString("provincia") + " " + rst1.getString("pais")+" " + rst1.getString("pdf") + " " + rst1.getString("fotografia")+
                		  " " + rst1.getInt("cont_MeGusta") + " " + rst1.getString("user_ID"));  
              }  
              
          } catch (Exception ex){  
              log.error("BD error --> "+ ex.getMessage());
          }finally{  
        	  
        
          }
          log.info("In MostrarBDAction --> finalizado");
          
          return mapping.findForward("Ok");
          
	 }

}
