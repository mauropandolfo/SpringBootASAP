package com.domain.modelo.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;

class AlumnoDAOTest {
	
	AlumnoDAO aluDao;
	Alumno alumno;
	Alumno aluMod;
	
	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		alumno = new Alumno(0, "Mauro_Test","Pandolfo_Test", "pandolfo@mail_Test","Universitarios_Test", "githubrepo_Test");
		aluMod = new Alumno(0, "Mauro_MOD","Pandolfo_MOD", "pandolfo@mail_MOD","Universitarios_MOD", "githubrepo_MOD");
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao=null;
		alumno=null;
	}

	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumno);
			assertTrue(true);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	@Test
	void testModificar() {
		try {
			aluDao.modificar(aluMod);
			assertTrue(true);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			assertTrue(false);
		}
	}

}
