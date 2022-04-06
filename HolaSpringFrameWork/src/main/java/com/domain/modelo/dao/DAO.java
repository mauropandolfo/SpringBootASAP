package com.domain.modelo.dao;
import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Model;
public interface DAO {
	public void agregar (Model pModel) throws ClassNotFoundException, SQLException;
	public void modificar(Model pModel);
	public void eliminar(Model pModel);
	public List<Model> leer(Model pModel);
}
