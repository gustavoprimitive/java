package com.empleados;

import java.sql.*;

public class LeerEmpleado {
	
	/**
	 * Obtención de los datos de un empleado en la tabla EMPLEADOS a partir de su valor de ID.
	 * 
	 * @param idEmpleado
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public void LeeEmpleadoPorID(int idEmpleado, Connection con) throws Exception {				
		
		final Statement st = con.createStatement();
		final String sql = OraQueries.getEmpDataById + idEmpleado;
		final ResultSet rs = st.executeQuery(sql);

		Logger.putLine("Los datos del empleado con ID " + idEmpleado + " son:");
		Logger.putQuery(sql);
		
		if (rs.next() == false) {
			Logger.putLine("ERROR No se encuentra el empleado con ID " + idEmpleado);
		}else{
			Logger.putLine(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
		}									
	}
}
