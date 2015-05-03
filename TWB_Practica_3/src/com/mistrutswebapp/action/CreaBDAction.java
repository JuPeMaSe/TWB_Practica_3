package com.mistrutswebapp.action;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.model.Tecnologia;
import com.mistrutswebapp.model.Titulacion;

import java.sql.*;  
import java.util.ArrayList;

public class CreaBDAction extends Action {
	 private static Log log = LogFactory.getLog(LoginAction.class);

	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
		  if (log.isInfoEnabled())
		  { 
		   log.info("In CreaBDAction");
		  }
		  HttpSession sesion = request.getSession();
		  Connection con = null;  
          Statement  st   = null;  
          String     sql  = null;  
          ResultSet  rst1 = null;  
            
//          try {  
//              // Cargamos el controlador JDBC  
//              Class.forName("org.hsqldb.jdbcDriver");  
//          } catch (Exception ex){  
//              log.error("Se ha producido un error al cargar el controlador JDBC"+ ex.getMessage());  
//              return mapping.findForward("error");  
//          }              
//          // Nos conectamos a la base de datos creandola en caso de que no exista   
//          conn = DriverManager.getConnection("jdbc:hsqldb:mem:memoriadb");  
//          // Creamos la tabla sobre la que trabajaremos  +
          try{
              // hago el lookup del pool de conexiones
              Context ctx=new InitialContext();
              DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
                 
              // pido una conexion
              con=ds.getConnection();
              //System.out.println(con);
			  log.info("In LoginAction despues de connection");
			  // try {  
              st  = con.createStatement();  
              //Creamos la tabla Usuario
              sql = "CREATE TABLE Usuario(" +
              		"user_ID VARCHAR(30) NOT NULL PRIMARY KEY," +
              		"	password VARCHAR(30)," +
              		"	nombre VARCHAR(50)," +
              		"	apellidos VARCHAR(60)," +
              	//	"	fe_Nac DATE," +	//da problemas con el tipo de dato
              		"	tfno CHAR(9)," +
              		"	email VARCHAR(60)," +
              		"	userType VARCHAR(3));";
              st.executeUpdate(sql);
            //  log.info("In LoginAction despues de crear tabla Usuario");
              //Creamos la tabla Perfil
              sql="CREATE TABLE Perfil(" +
              		//"	profile_ID INTEGER NOT NULL PRIMARY KEY," +
              		//"	profile_ID SMALLINT NOT NULL AUTO_INCREMENT," +
            		"   profile_ID INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1),"+
              		"	pdf VARCHAR(100)," +
              		"	fotografia VARCHAR(100)," +
              		"	direccion VARCHAR(40)," +
              		"	localidad VARCHAR(40)," +
              		"	provincia VARCHAR(40)," +
              		"	pais VARCHAR(40)," +
              		"	cont_MeGusta INTEGER," +
              		"	user_ID VARCHAR(30)," +
              		"	reference VARCHAR(40)" +
              		//" PRIMARY KEY (profile_ID)"+
              		//"   FOREIGN KEY (user_ID) REFERENCES Usuario(user_ID)"+
              		");";
              st.executeUpdate(sql);
             // log.info("In LoginAction despues de crear tabla Perfil");
             // Creamos la table Tecnologia
             sql = "CREATE TABLE Tecnologia(	" +
              		"tecnologia_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	nombre_Tec VARCHAR(50)" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Tecnologia");
              //Creamos la tabla Perfil-Tec
             sql= "CREATE TABLE Perfil_Tec(" +
              		"	tecnologia_ID INTEGER," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Perfil_Tec");
              //Creamos la tabla Titulacion
              sql="CREATE TABLE Titulacion(" +
              		"	titulacion_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	nombre_Tit VARCHAR(50)" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Titulación");
              //Creamos la tabla Perfil_Tit
              sql="CREATE TABLE Perfil_Tit(" +
              		"	titulacion_ID INTEGER," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Perfil_Tit");
              //Creamos la tabla Experiencia
              sql="CREATE TABLE Experiencia(" +
              		"	exp_ID INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1)," +
              		"	empresa VARCHAR(60)," +
              		"	cargo VARCHAR(50)," +
              		"	a_Inicio VARCHAR(10)," +
              		"	a_Fin VARCHAR(10)," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Experiencia");
              
              //Borramos los usuarios que existiesen en la tabla Usuario  
              st.executeUpdate("DELETE FROM Usuario");  
//           // Varios usuarios de prueba  
//              st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
//              		"VALUES ('jpms', '4367',  'Juan Pedro', 'Marquez Sevilla','', '','adm')");
//              //st.executeUpdate("INSERT INTO Usuario (User_ID, Password, Nombre) VALUES ('jpms', '4367',  'Juan Pedro')");
//              st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre) VALUES ('ja', '5367',  'Jose Angel')");  
//      			st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre) VALUES ('jj', '6367',  'Juan Jose')");
              //Introducimos varias titulaciones
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID,nombre_Tit) " +
              		"VALUES (0,'Sin titulación')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID,nombre_Tit) " +
            		"VALUES (1,'Graduado Ingenieria Informatica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) " +
              		"VALUES (2,'Graduado Ingenieria Tecnologías de la Información')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) " +
              		"VALUES (3,'Graduado Física')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) " +
              		"VALUES (4,'Graduado Matemáticas')");
              //Introducimos varias tecnologías
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                		"VALUES (0,'N/A')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
              		"VALUES (1,'Java2')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                	"VALUES (2,'C++')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                	"VALUES (3,'SQL')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    "VALUES (4,'Struts')");
	// Mostramos por pantalla todos los usuarios de la tabla  
            rst1 = st.executeQuery("SELECT * FROM Usuario");  
            while (rst1.next()){  
                log.info("In CreaBDAction --> Tabla Usuario: "+ rst1.getString("user_ID") + " " + rst1.getString("password") + " " + rst1.getString("nombre"));
                  
            }  
            
            //Creamos la listaTitulaciones con scope=session
            rst1 = st.executeQuery("SELECT * FROM Titulacion");
            ArrayList<Titulacion> listaTitulaciones = new ArrayList<Titulacion>();
            log.info("In CreaBDAction --> ");
            while (rst1.next()){ 
            	Titulacion tit = new Titulacion();
            	int ID = rst1.getInt("titulacion_ID");
            	String nom = rst1.getString("nombre_Tit"); 
            	tit.setTitulacion_ID(ID);
            	tit.setNombre_Tit(nom);
            	listaTitulaciones.add(tit);
                log.info("Tabla Titulación: "+	ID + " "+nom);  
            }
            sesion.setAttribute("listaTitulaciones",listaTitulaciones);
            
            
            rst1 = st.executeQuery("SELECT * FROM Tecnologia");
            ArrayList<Tecnologia> listaTecnologias = new ArrayList<Tecnologia>();
            log.info("In CreaBDAction --> ");
            while (rst1.next()){ 
            	Tecnologia tec = new Tecnologia();
            	int ID = rst1.getInt("tecnologia_ID");
            	String nom = rst1.getString("nombre_Tec"); 
            	tec.setTecnologia_ID(ID);
            	tec.setNombre_Tec(nom);
            	listaTecnologias.add(tec);
                log.info("Tabla Tecnología: "+	ID + " "+nom);  
            }
            sesion.setAttribute("listaTecnologias",listaTecnologias);
              // Enviamos el comando para que salve todos los datos temporales de forma permanente  
 //             st = con.createStatement();  
 //             st.executeUpdate("SHUTDOWN");  
              
              // Liberamos recursos y cerramos la conexion  
             st.close();  
              con.close();  
          } catch (Exception ex){  
              log.error("BD no creada por --> "+ ex.getMessage());
          }finally{  
        	  
        
          }
          log.info("In CreaBDAction --> Base de datos creada");
          
          return mapping.findForward("Ok");
          
	 }

}
