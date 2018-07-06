package com.empleados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UltimoIdEmpl {

	/**
	 * Método para obtener el último valor del campo ID de la tabla EMPLEADOS.
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int ObtenerID(Connection con) throws Exception {
		
		Logger.putLine("Se obtiene valor de último ID de empleado");		
		
		final Statement selectLastIdEmpl = con.createStatement();
		final ResultSet rs = selectLastIdEmpl.executeQuery(OraQueries.getEmpMaxId);

		Logger.putQuery(OraQueries.getEmpMaxId);
		
		rs.next();
		return Integer.parseInt(rs.getString(1));												
	}
}
