package com.domain.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.util.ConnectionManager;

class ConnectionManagerTest {

	Connection con;
	@BeforeEach
	void SetUp() throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		con = ConnectionManager.getConection();
	}
	@AfterEach
	void TearDown() {
		con = null;
	}
	@Test
	void testConectarYGerConection() {
		try {
			ConnectionManager.conectar();
			assertNotNull(ConnectionManager.getConection());
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
	@Test
	void testDesconectar() throws SQLException {
		ConnectionManager.desConectar();
		assertTrue(con.isClosed());
	}

}
