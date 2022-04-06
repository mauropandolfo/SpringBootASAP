package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;


import com.domain.util.ConnectionManager;

public class AlumnoDAO implements DAO {

	public AlumnoDAO() throws ClassNotFoundException, SQLException{

	}
	
	
	@Override
	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
		String sql = new String("insert into alumnos(ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL ,ALU_CONOCIMIENTOS, ALU_GIT");
		
		Alumno alu = (Alumno) pModel;
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		
	}

	@Override
	public void modificar(Model pModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Model pModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Model> leer(Model pModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
