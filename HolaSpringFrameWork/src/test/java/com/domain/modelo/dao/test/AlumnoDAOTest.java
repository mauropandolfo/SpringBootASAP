package com.domain.modelo.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConnectionManager;


class AlumnoDAOTest {
	AlumnoDAO 	aluDao;
	
	Alumno alumnoAgregar;
	Alumno alumnoEliminar;
	Alumno alumnoModificar;
	Alumno alumnoLeerCod;
	Alumno alumnoLeerNom;
	Alumno aluLeido;
	
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
		alumnoAgregar = new Alumno(0, "Mauro_test", "Pandolfo_test", "pandolfo@gmail.test", "universitarios_test", "githublink");
		
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
		
		alumnoAgregar = null;
		alumnoEliminar	= null;
		alumnoModificar	= null;
		alumnoLeerCod	= null;
		alumnoLeerNom	= null;
		aluLeido = null;
		
		con = null;
		stm = null;
		rs = null;
	}

	@Test
	void testLeerTodosLosAlumnos() {
		System.out.println("alumnoAgregar=" + alumnoAgregar);
		System.out.println("alumnoEliminar=" + alumnoEliminar);
		System.out.println("alumnoModificar=" + alumnoModificar);
		System.out.println("alumnoLeerCod=" + alumnoLeerCod);
		System.out.println("alumnoLeerNom=" + alumnoLeerNom);
		
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
			// leer de la db lo escrito
			
			 StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='Mauro_test'");			
			    
			rs  = stm.executeQuery(sql.toString());
		    if(rs.next())
		    	   aluLeido= new Alumno(rs.getInt("ALU_ID"), 
										rs.getString("ALU_NOMBRE"), 
										rs.getString("ALU_APELLIDO"), 
										rs.getString("ALU_EMAIL"), 
										rs.getString("ALU_CONOCIMIENTOS"),
										rs.getString("ALU_GIT") );
				
			assertEquals(alumnoAgregar.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoAgregar.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoAgregar.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoAgregar.getEstudios(), aluLeido.getEstudios());
			assertEquals(alumnoAgregar.getLinkArepositorio(), aluLeido.getLinkArepositorio());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	void testModificar() {
		try {
			alumnoModificar.setNombre("Mauro_Mod");
			alumnoModificar.setApellido("Pandolfo_Mod");
			alumnoModificar.setEmail("correo_Mod");
			alumnoModificar.setEstudios("estudios_Mod");
			alumnoModificar.setLinkArepositorio("Link_Mod");
			
			aluDao.modificar(alumnoModificar);
			// leer de la db lo escrito
			
			StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='Mauro_Mod'");			
			    
			rs  = stm.executeQuery(sql.toString());
		    if(rs.next())
		    	   aluLeido= new Alumno(rs.getInt("ALU_ID"), 
										rs.getString("ALU_NOMBRE"), 
										rs.getString("ALU_APELLIDO"), 
										rs.getString("ALU_EMAIL"), 
										rs.getString("ALU_CONOCIMIENTOS"),
										rs.getString("ALU_GIT") );
				
			assertEquals(alumnoModificar.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoModificar.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoModificar.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoModificar.getEstudios(), aluLeido.getEstudios());
			assertEquals(alumnoModificar.getLinkArepositorio(), aluLeido.getLinkArepositorio());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	void testEliminar() {
		try {		
			aluDao.eliminar(alumnoEliminar);
			// leer de la db lo escrito
			
			StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='Monsef_test'");			
			    
			rs  = stm.executeQuery(sql.toString());
		    assertFalse(rs.next());
		    
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	void testLeerCod() {
		try {
			
			
			List<Model> alumnos = aluDao.leer(alumnoLeerCod);
			
			Alumno aluLeido = (Alumno) alumnos.get(0);
			
			
			// leer de la db lo escrito
			assertEquals(1, alumnos.size());
			
			assertEquals(alumnoLeerCod.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoLeerCod.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoLeerCod.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoLeerCod.getEstudios(), aluLeido.getEstudios());
			assertEquals(alumnoLeerCod.getLinkArepositorio(), aluLeido.getLinkArepositorio());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	void testLeerNombre() {
		try {
			
			List<Model> alumnos = aluDao.leer(alumnoLeerNom);
			
			Alumno aluLeido = (Alumno) alumnos.get(0);
			
			assertEquals(1, alumnos.size());
			
			assertEquals(alumnoLeerNom.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoLeerNom.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoLeerNom.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoLeerNom.getEstudios(), aluLeido.getEstudios());
			assertEquals(alumnoLeerNom.getLinkArepositorio(), aluLeido.getLinkArepositorio());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
	@Test
	void testLeerTodos_Null() {
		try {
			
			List<Model> alumnos = aluDao.leer(null);
			Alumno aluLeido = (Alumno) alumnos.get(0);
			System.out.println("alumnos" + alumnos);
			assertTrue(alumnos.size()>1);
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	void testLeerTodos_Vacio(){
		try {		
			List<Model> alumnos = aluDao.leer(new Alumno());
			System.out.println("alumnos=" + alumnos);
			assertTrue(alumnos.size()>1);
				
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

}
