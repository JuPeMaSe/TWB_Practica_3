package com.mistrutswebapp.dao;

import java.sql.Blob;
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

import com.mistrutswebapp.model.Experiencia;
import com.mistrutswebapp.model.Perfil;

public class PerfilDAO {
	private Connection connection = null;
	private Statement statement = null;
	private Statement stTit =null;
	private Statement stTec=null;
	private Statement stExp = null;
	private ResultSet results = null;
	private ResultSet resTit= null;
	private ResultSet resTec= null;
	private ResultSet resExp= null;
	private PreparedStatement prepStatement = null;
	private static final String DATASOURCE_NAME = "java:comp/env/jdbc/ConexionHSQLDS";
	private static final String INSERT_STATEMENT_PERFIL = "INSERT INTO Perfil " +
			//"(profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, cont_MeGusta, user_ID)" +
			//" VALUES (?,?,?,?,?,?,?,?,?)"; 
//			"(pdf, fotografia, direccion, localidad, provincia, pais, cont_MeGusta, user_ID)" +
//			" VALUES (?,?,?,?,?,?,?,?)"; 
			"(direccion, localidad, provincia, pais, user_ID, pdf,fotografia,cont_MeGusta,reference)"+ 
			//" VALUES (?,?,?,?,?,CAST(? AS BLOB)";
			" VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String INSERT_STATEMENT_PERFIL_TIT = "INSERT INTO Perfil_Tit " +
			"(titulacion_ID,profile_ID) VALUES (?,?)";
	
	private static final String INSERT_STATEMENT_PERFIL_TEC = "INSERT INTO Perfil_Tec " +
			"(tecnologia_ID, profile_ID) VALUES (?,?)";
	
	private static final String INSERT_STATEMENT_EXPERIENCIA = "INSERT INTO Experiencia " +
			"(empresa, cargo, a_Inicio, a_Fin, profile_ID) VALUES (?,?,?,?,?)";

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
		    prepStatement = connection.prepareStatement(INSERT_STATEMENT_PERFIL);
		    prepStatement.setString(1, perfil.getDireccion());
		    prepStatement.setString(2, perfil.getLocalidad());
		    prepStatement.setString(3, perfil.getProvincia());
		    prepStatement.setString(4, perfil.getPais());
		    prepStatement.setString(5, perfil.getUser_ID());
		    prepStatement.setString(6,perfil.getPdf());
		    prepStatement.setString(7, perfil.getFotografia());
		    prepStatement.setInt(8, perfil.getCont_MeGusta());
		    prepStatement.setString(9, perfil.getReference());
		    prepStatement.executeUpdate();
		    prepStatement.close();
		    prepStatement = null;
		    connection.close();
		    connection = null;

		 }catch(SQLException e){
			 System.out.println("error crearPerfil:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			cleanUp();
		 }
	}
	 
	 public int getProfile_ID(Perfil perfil){
		 int intProfile_ID=0;
		 getConnection();
		    try {
				statement = connection.createStatement();			
			    results= statement.executeQuery("Select * FROM Perfil WHERE reference = '"+perfil.getReference()+"'");
//			    System.out.println("QUERY =Select * from PERFIL where reference='"+perfil.getReference()+"'" );
//			    System.out.println("results tamaño= "+results.getFetchSize());			   
			    while(results.next()){
				    if(results.getString("reference")!= null){
				    	intProfile_ID = results.getInt("profile_ID");				    	
				    }
			    }
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 return intProfile_ID;
	 }
	 
	 public void addTitulacion(int profile_ID, Perfil perfil){
		 ArrayList<Integer> listaTit = perfil.getListaTit();
		// System.out.println("En perfilDAO: addTitulacion --> listaTit.size == " + listaTit.size());
		 try {
			 getConnection();
			prepStatement= connection.prepareStatement(INSERT_STATEMENT_PERFIL_TIT);
			for (int i=0; i<listaTit.size();i++){
				prepStatement.setInt(1, listaTit.get(i));
				prepStatement.setInt(2,profile_ID);
				prepStatement.executeUpdate();
			}
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			 System.out.println("error addTitulacion:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		}finally{
			cleanUp();
		}	 
	 }
	 
	 public void addTecnologia(int profile_ID, Perfil perfil){
		 ArrayList<Integer> listaTec = perfil.getListaTec();
		 try {
			 getConnection();
			prepStatement= connection.prepareStatement(INSERT_STATEMENT_PERFIL_TEC);
			for (int i=0; i<listaTec.size();i++){
				prepStatement.setInt(1, listaTec.get(i));
				prepStatement.setInt(2,profile_ID);
				prepStatement.executeUpdate();
			}
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			 System.out.println("error addTitulacion:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		}finally{
			cleanUp();
		}	 
	 }
	 
	 public void addExperiencia(int profile_ID, Experiencia experiencia){
		try {
			getConnection();
			prepStatement = connection.prepareStatement(INSERT_STATEMENT_EXPERIENCIA);
			prepStatement.setString(1,experiencia.getEmpresa());
			prepStatement.setString(2,experiencia.getCargo());
			prepStatement.setString(3, experiencia.getA_Inicio());
			prepStatement.setString(4,experiencia.getA_Fin());
			prepStatement.setInt(5,profile_ID);
			prepStatement.executeUpdate();
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cleanUp();
		}
		 
		 
	 }


	 public Collection<Perfil> leerPerfiles(String whereClause){
		   Collection<Perfil> perfiles = new ArrayList<Perfil>();
		   try{
			   getConnection();
			   stTit = connection.createStatement();//Se podría eliminar sin afectar al funcionamiento ????? Parece que no
			   stTec = connection.createStatement();//Idem
			   stExp = connection.createStatement();//Idem
			   statement = connection.createStatement();
			   results = statement.executeQuery("SELECT * FROM Perfil " + whereClause);
			   System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil " + whereClause);
			   int profile_ID;
			   String pdf;
			   String fotografia;
			   String direccion;
			   String localidad;
			   String provincia;
			   String pais;
			   int cont_MeGusta;
			   String user_ID;
			   String reference;
			   ArrayList<Integer> listaTit;
			   ArrayList<Integer> listaTec;
			   ArrayList<Experiencia> listaExp;
			   
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
			   	 reference=results.getString("reference");
			   	 listaTit= new ArrayList<Integer>();			   	 
				 resTit = stTit.executeQuery("SELECT * FROM Perfil_Tit where profile_ID ='" +profile_ID+"'");
			   	while (resTit.next()){
					 listaTit.add(resTit.getInt("titulacion_ID"));
				 }
				 listaTec= new ArrayList<Integer>();
				 resTec = stTec.executeQuery("SELECT * FROM Perfil_Tec where profile_ID ='" +profile_ID+"'");
				 while (resTec.next()){
					 listaTec.add(resTec.getInt("tecnologia_ID"));
				 }
				 listaExp= new ArrayList<Experiencia>();			   	 
				 resExp = stExp.executeQuery("SELECT * FROM Experiencia where profile_ID ='" +profile_ID+"'");
				 while (resExp.next()){
					 Experiencia exp = new Experiencia();
					 exp.setEmpresa(resExp.getString("empresa"));
					 exp.setCargo(resExp.getString("cargo"));
					 exp.setA_Fin(resExp.getString("a_Fin"));
					 exp.setA_Inicio(resExp.getString("a_Inicio"));
					 exp.setExp_ID(resExp.getInt("exp_ID"));
					 exp.setProfile_ID(resExp.getInt("profile_ID"));
					 listaExp.add(exp);
				 }
				 
			   	 perfil=new Perfil();
			   	 perfil.setProfile_ID(profile_ID);
			   	 perfil.setPdf(pdf);
			   	 perfil.setFotografia(fotografia);
			   	 perfil.setDireccion(direccion);
			   	 perfil.setLocalidad(localidad);
			   	 perfil.setProvincia(provincia);
			   	 perfil.setPais(pais);
			   	 perfil.setCont_MeGusta(cont_MeGusta);
			   	 perfil.setUser_ID(user_ID);
			   	 perfil.setReference(reference);
			   	 perfil.setListaTit(listaTit);
			   	 perfil.setListaTec(listaTec);
			   	 perfil.setListaExp(listaExp);			   	 
			   	 
			   	 perfiles.add(perfil);
			   	System.out.println("leido perfil -->"+profile_ID);
			 }
//		     results.close();
//		     results = null;
//		     resTit.close();
//		     resTit = null;
//		     resTec.close();
//		     resTec = null;
//		     resExp.close();
//		     resExp = null;
//		     statement.close();
//		     statement = null;
//		     stTit.close();
//		     stTit=null;
//		     stTec.close();
//		     stTec=null;
//		     stExp.close();
//		     stExp=null;
//		     connection.close();
//		     connection = null;
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
		 if(resTit != null){
				try{
					resTit.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resTit = null;
			 }
		 if(resTec != null){
				try{
					resTec.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resTec = null;
			 }
		 if(resExp != null){
				try{
					resExp.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resExp = null;
			 }
		 if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 statement = null;
		 }
		 if(stTit != null){
				try{
					stTit.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 stTit = null;
		}
		 if(stTec != null){
				try{
					stTec.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 stTec = null;
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
