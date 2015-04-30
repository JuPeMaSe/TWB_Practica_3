package com.mistrutswebapp.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.beans.UsuarioBean;
import com.mistrutswebapp.dao.PerfilDAO;
import com.mistrutswebapp.dao.UsuarioDAO;

public class ModelFacade {
	private static Log log = LogFactory.getLog(ModelFacade.class);
	/**
	 * Crea un perfil y lo guarda en la BD a partir de los datos introducidos
	 * en el formulario y obtenidos del bean PerfilBean
	 * @param perfilBean
	 * @return Perfil
	 */
	public static Perfil crearPerfil(PerfilBean perfilBean){
		Perfil perfil= new Perfil();
		try {
			//pasamos las propiedades del PerfilBean al Perfil
			PropertyUtils.copyProperties(perfil,  perfilBean);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			log.error(e.getMessage());
		}	
		//completamos las propiedades que faltan del perfil
		perfil.setCont_MeGusta(0);
		perfil.setUser_ID(perfilBean.getUser_ID());
		
		//escribimos el perfil en la base de datos
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.crearPerfil(perfil);		
		return perfil;
	}
	
	
	/**
	 * Crea un usuario y lo guarda en la BD a partir de los datos introducidos
	 * en el formulario y obtenidos del bean UsuarioBean
	 * @param usuarioBean
	 * @return Usuario
	 */
	public static Usuario crearUsuario(UsuarioBean usuarioBean) {
		Usuario usuario =new Usuario();
		try{
			PropertyUtils.copyProperties(usuario, usuarioBean);
			//log.info("copy propertues usuario apellidos== "+ usuario.getApellidos());
		}catch(IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e){
		    log.error(e.getMessage());
		   // return null;
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.crearUsuario(usuario);
		
		return usuario;
	}
	
	/**
	 * Devuelve una colección con los usuarios registrados en la BD y que
	 * cumplen con la condición expresada en whereClause
	 * @param whereClause
	 * @return Collection<Usuario>
	 */
	public static Collection<Usuario> getUsuarios(String whereClause){
		// if no 'where' clause string is passed in, create an empty string
		  if(whereClause == null){
			  whereClause = new String();
		  }
		  UsuarioDAO udao = new UsuarioDAO();
		  Collection<Usuario> usuarioCollection = udao.leerUsuarios(whereClause);
		  return usuarioCollection;
	}
	
	/**
	 * Devuelve una colección con los perfiles que se encuentran registrados en la BD y que
	 * cumplen con la condición expresada en whereClause
	 * @param whereClause
	 * @return Collection<Perfil>
	 */
	public static Collection<Perfil> getPerfiles(String whereClause){
		// if no 'where' clause string is passed in, create an empty string
		  if(whereClause == null){
			  whereClause = new String();
		  }
		  PerfilDAO pdao = new PerfilDAO();
		  Collection<Perfil> perfilCollection = pdao.leerPerfiles(whereClause);
		  return perfilCollection;
	}
}
