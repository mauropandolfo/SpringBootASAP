package com.domain.modelo.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConnectionManager;


class AlumnoDAOTest {
	AlumnoDAO 	aluDao;
	
	Alumno 		alumnoAgregar;
	Alumno 		alumnoEliminar;
	Alumno 		alumnoModificar;
	Alumno 		alumnoLeerCod;
	Alumno 		alumnoLeerNom;
	//voy a dejar una conexion de uso publico
	Connection 	con;
	Statement 	stm;
	ResultSet   rs;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//voy a armar un lote de pruebas que tenga 
		//1 alumno para eliminar en la base de datos
		//1- alumno para modificar
		//1- alumno para leer.
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosCrear.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desConectar();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//voy a armar un lote de pruebas que tenga 
		//1 alumno para eliminar en la base de datos
		//1- alumno para modificar
		//1- alumno para leer.
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosEliminar.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desConectar();
	}

	
	
	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		//este es el alumno a agregar
		alumnoAgregar = new Alumno(0, "Gabriel_test", "Casas_test", "gcasas@gmail.test", "universitarios_test", "http://gitlab/gcasas1972/repo.git");
		
		//datos de conexion.
		ConnectionManager.conectar();
	    con = ConnectionManager.getConection();
	    stm = con.createStatement();
	    
	  //el alumnon a modificar
	    StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
					    			sql.append(" From alumnos ");
					    			sql.append(" Where alu_nombre='Marina_test'");
	    			
	    rs  = stm.executeQuery(sql.toString());
	    if(rs.next())
		    alumnoModificar= new Alumno(rs.getInt("ALU_ID"), 
		    							rs.getString("ALU_NOMBRE"), 
										rs.getString("ALU_APELLIDO"), 
										rs.getString("ALU_EMAIL"), 
										rs.getString("ALU_CONOCIMIENTOS"),
										rs.getString("ALU_GIT") );
		//el alumno a eliminar
	    sql = new StringBuilder("Select ALU_ID FROM ALUMNOS WHERE ALU_NOMBRE ='Monsef_test' ");	    
	    rs  = stm.executeQuery(sql.toString());
	    if(rs.next())
	    	alumnoEliminar = new Alumno(rs.getInt("AlU_ID"));
	    
		//leer por codigo
	    sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append(" From alumnos ");
		sql.append(" Where alu_nombre='Aarn_test'");
		
	    
	    rs  = stm.executeQuery(sql.toString());
	    rs.next();

	    alumnoLeerCod= new Alumno(	rs.getInt("ALU_ID"), 
									rs.getString("ALU_NOMBRE"), 
									rs.getString("ALU_APELLIDO"), 
									rs.getString("ALU_EMAIL"), 
									rs.getString("ALU_CONOCIMIENTOS"),
									rs.getString("ALU_GIT") );
	    
		//leer por nombre
	    sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append(" From alumnos ");
		sql.append(" Where alu_nombre='Ivn_test'");
		
	    
	    rs  = stm.executeQuery(sql.toString());
	    rs.next();

	    alumnoLeerNom= new Alumno(	rs.getInt("ALU_ID"), 
									rs.getString("ALU_NOMBRE"), 
									rs.getString("ALU_APELLIDO"), 
									rs.getString("ALU_EMAIL"), 
									rs.getString("ALU_CONOCIMIENTOS"),
									rs.getString("ALU_GIT") );
	    
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao			= null;
		
		alumnoAgregar	= null;
		alumnoEliminar	= null;
		alumnoModificar	= null;
		alumnoLeerCod	= null;
		alumnoLeerNom	= null;
	}

	@Test
	void testLeerTodosLosAlumnos() {
		System.out.println("alumnoAgregar=" 	+ alumnoAgregar);
		System.out.println("alumnoEliminar=" 	+ alumnoEliminar);
		System.out.println("alumnoModificar=" 	+ alumnoModificar);
		System.out.println("alumnoLeerCod=" 	+ alumnoLeerCod);
		System.out.println("alumnoLeerNom=" 	+ alumnoLeerNom);
		
		assertNotNull(alumnoAgregar);
		assertNotNull(alumnoEliminar);
		assertNotNull(alumnoModificar);
		assertNotNull(alumnoLeerCod);
		assertNotNull(alumnoLeerNom);
		
		}
	
	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumnoAgregar);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

}
