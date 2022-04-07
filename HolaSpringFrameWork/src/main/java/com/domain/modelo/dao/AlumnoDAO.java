package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;


import com.domain.util.ConnectionManager;

public class AlumnoDAO implements DAO {
	private Connection conexion;
	
	@Override
	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion = ConnectionManager.getConection();
		
		StringBuilder sql = new StringBuilder("INSERT INTO Alumnos(ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL, ");
		 sql.append( "ALU_CONOCIMIENTOS, ALU_GIT)").append("values(?,?,?,?,?)");
		
		Alumno alu = (Alumno) pModel;
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		stm.execute();
		
		ConnectionManager.desConectar();
	}

	@Override
	public void modificar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion = ConnectionManager.getConection();
		StringBuilder sql = new StringBuilder("UPDATE Alumnos SET ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL, ALU_CONOCIMIENTOS, ALU_GIT WHERE ALU_ID=ALU_ID values(?,?,?,?,?,?)");
		
		Alumno alu = (Alumno) pModel;
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		stm.setInt(6, alu.getCodigo());
		
		stm.execute();
		
		ConnectionManager.desConectar();

	}

	@Override
	public void eliminar(Model pModel) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder("DELETE ");
		
		Alumno alu = (Alumno) pModel;
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		stm.setInt(6, alu.getCodigo());
		
		stm.execute();

	}

	@Override
	public List<Model> leer(Model pModel) throws ClassNotFoundException, SQLException {

		return null;		
	}

}
