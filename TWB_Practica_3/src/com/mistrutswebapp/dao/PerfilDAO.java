package com.mistrutswebapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.mistrutswebapp.model.Perfil;

public class PerfilDAO {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private ResultSet results = null;
	private static final String DATASOURCE_NAME = "java:comp/env/jdbc/ConexionHSQLDS";
	private static final String INSERT_STATEMENT = "INSERT INTO Perfil " +
			"(profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, cont_MeGusta, user_ID)" +
			" VALUES (?,?,?,?,?,?,?,?,?)"; 

	private void getConnection(){
		if(connection == null){
			try{
				Context initialContext = new InitialContext();
			    DataSource ds = (DataSource)initialContext.lookup(DATASOURCE_NAME);
			    connection = ds.getConnection();
			}catch(NamingException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	 }
	  
	 public void crearPerfil(Perfil perfil){
		 try{
			getConnection();
		    prepStatement = connection.prepareStatement(INSERT_STATEMENT);
		    prepStatement.setInt(0,perfil.getProfile_ID());
		    prepStatement.setString(1, perfil.getPdf());
		    prepStatement.setString(2, perfil.getFotografia());
		    prepStatement.setString(3, perfil.getDireccion());
		    prepStatement.setString(4, perfil.getLocalidad());
		    prepStatement.setString(5, perfil.getProvincia());
		    prepStatement.setString(6, perfil.getPais());
		    prepStatement.setInt(7, perfil.getCont_MeGusta());
		    prepStatement.setString(8, perfil.getUser_ID());
		    prepStatement.executeUpdate();
		    prepStatement.close();
		    prepStatement = null;
		    connection.close();
		    connection = null;
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			cleanUp();
		 }
	}
	   
//	   public void linkToPolicy(Claim claim, Policy policy)
//	   {
//	   	String reference = claim.getReference();
//	   	String policyNumber = policy.getPolicyNumber();
//	    try
//	   	{
//	     getConnection();
//	     Statement statement = connection.createStatement();
//	     ResultSet results = statement.executeQuery("SELECT policyID_PK FROM policy WHERE policyNumber=\'" + policyNumber + "\'");
//	     int key = 0;
//	     while(results.next())
//	     {
//	   	  key = results.getInt("policyID_PK");
//	     }
//	     results.close();
//	     results = null;
//	     statement.close();
//	     statement = null;
//	   	 statement = connection.createStatement();
//	     statement.executeUpdate("UPDATE claim SET claim.policyID_FK = " + key + " WHERE claim.reference=\'" + reference + "\'");
//	     statement.close();
//	     statement = null;
//	     connection.close();
//	     connection = null;
//	    }
//	    catch(SQLException e)
//	    {
//	     e.printStackTrace();
//	    }
//	    finally
//	    {
//	     cleanUp();
//	    }
//	   }

	 public Collection<Perfil> leerPerfiles(String whereClause){
		   Collection<Perfil> perfiles = new ArrayList<Perfil>();
		   try{
			   getConnection();
			   Statement statement = connection.createStatement();
			   ResultSet results = statement.executeQuery("SELECT * FROM Perfil " + whereClause);
			   int profile_ID;
			   String pdf;
			   String fotografia; //habrá que cambiar el tipo
			   String direccion; //idem
			   String localidad;
			   String provincia;
			   String pais;
			   int cont_MeGusta;
			   String user_ID;			    
			    
			   Perfil perfil = null;
			   while(results.next()){
			  	 profile_ID = results.getInt("profile_ID"); 
			   	 pdf= results.getString("pdf");
			   	 fotografia=results.getString("fotografia");
			   	 direccion=results.getString("direccion");
			   	 localidad=results.getString("localidad");
			   	 provincia=results.getString("provincia");
			   	 pais=results.getString("pais");
			   	 cont_MeGusta = results.getInt("cont_MeGusta");
			   	 user_ID=results.getString("user_ID");
			   	 
			   	 perfil=new Perfil();
			   	 perfil.setProfile_ID(profile_ID);
			   	 perfil.setPdf(pdf);
			   	 perfil.setFotografia(fotografia);
			   	 perfil.setDireccion(direccion);
			   	 perfil.setLocalidad(localidad);
			   	 perfil.setProvincia(provincia);
			   	 perfil.setPais(pais);
			   	 perfil.setCont_MeGusta(cont_MeGusta);
			   	 
			   	 perfiles.add(perfil);
			   	System.out.println("leido perfil -->"+profile_ID);
			 }
		     results.close();
		     results = null;
		     statement.close();
		     statement = null;
		     connection.close();
		     connection = null;
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }finally{
	    	cleanUp();
	    }
	    return perfiles;
	 }
	 
	 private void cleanUp(){
		 // nos aseguramos de cerrar results, statements , connections...
		 if(results != null){
			try{
				results.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 results = null;
		 }
		 if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 statement = null;
		 }
		 if(prepStatement != null){
			try{
				prepStatement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			prepStatement = null;
		 }
		 if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			connection = null;
		 }
	}
}
