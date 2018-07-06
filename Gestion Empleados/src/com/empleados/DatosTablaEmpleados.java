package com.empleados;

import java.sql.*;

public class DatosTablaEmpleados {

	public int filasEmpleados;
	public final int columnasEmpleados = 6;
	//Lista con los nombres de cabecera correspondientes a los campos de la tabla EMPLEADOS
	public final String[] listaCabecera = {"ID", "NOMBRE", "APELLIDOS", "EDAD", "CATEGORIA", "FECHA REGISTRO"}; 
	
	/**
	 * Método para contabilizar el nº de registros existentes en la tabla EMPLEADOS.
	 * 
	 * @param con
	 * @return 
	 * @throws Exception
	 */
	public int contarRegistros(Connection con) throws Exception {
		
		Logger.putLine("Cómputo de registros de tabla EMPLEADOS");
		
		final Statement st = con.createStatement();
		final ResultSet rs = st.executeQuery(OraQueries.getCountEmp);
		
		Logger.putQuery(OraQueries.getCountEmp);
		
		rs.next();					
		filasEmpleados = Integer.parseInt(rs.getString(1));		
		
		return filasEmpleados;
				
	}
	
	/**
	 * Almacenamiento en array bidimensional de los datos de la tabla EMPLEADOS.
	 * 
	 * @param con
	 * @param numFilas
	 * @return
	 * @throws Exception
	 */
	public String[][] datosEmpleados(Connection con, int numFilas) throws Exception{
		
		Logger.putLine("Construyendo grid de tabla EMPLEADOS");
		
		final Statement st = con.createStatement();
		final ResultSet rs = st.executeQuery(OraQueries.getEmpData);
		
		//Array con datos de la tabla
		//Se suma una fila para asignar las cabeceras de los campos
		String[][] tablaEmp = new String[numFilas+1][6];
		
		//Asignación de valores de cabecera
		for (int x=0; x<listaCabecera.length; x++) {
			tablaEmp[0][x] = listaCabecera[x];
		}
		
		//Asignación de datos de tabla
		for(int i=1; i<=numFilas; i++) {	
			rs.next();
			for(int j=0; j<6; j++) {
				tablaEmp[i][j] = rs.getString(j+1);
			}
		}
		
		return tablaEmp;		
	}
	
}
