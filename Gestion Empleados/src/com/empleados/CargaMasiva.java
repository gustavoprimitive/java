package com.empleados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class CargaMasiva {

	//Datos de fichero a leer
	final String pathToFile = "/home/gustavo/";
	final String fileName = "salida.csv";
	final String file = pathToFile.concat(fileName);
	//Instancia para almacenar los datos de cada empleado
	RegistroEmpleado emplFile = new RegistroEmpleado(0, file, file, 0, file, null);

	/**
	 * Lectura de fichero línea a línea, y llamada a método "extraerDatosEmpl" y "insertaRegistro".
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void insertarLineaFichero(Connection con) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {			
			String line;
			while ((line = br.readLine()) != null) {
				Logger.putLine(line);
				//Llamada a método de extracción de campos de cada línea del fichero
				emplFile = extraerDatosEmpl(line);	
				//Llamada a método de inserción en tabla
				insertaRegistro(emplFile, con);
			}
		}				
	}
	
	/**
	 * Extracción de campos y asignación al tipo "RegistroEmpleado".
	 * 
	 * @param line
	 * @return
	 * @throws Exception
	 */
	private RegistroEmpleado extraerDatosEmpl(String line) throws Exception {		
		
		String[] camposEmpl;
		camposEmpl = line.split(";");
		
		emplFile.emplId = Integer.parseInt(camposEmpl[0]);
		emplFile.empNombre = camposEmpl[1];
		emplFile.empApellido = camposEmpl[2];
		emplFile.empCategoria = camposEmpl[3];
		emplFile.empFechaIngreso = camposEmpl[4];
		
		return emplFile;
		
	}
	
	/**
	 * Inserción en tabla EMPLEADOS del contenido del tipo "RegistroEmpleado".
	 * 
	 * @param emplFile
	 * @param con
	 * @throws Exception
	 */
	private void insertaRegistro(RegistroEmpleado emplFile, Connection con) throws Exception {

			String oraNull = "NULL";
			
			Logger.putLine("Se inserta empleado");		

			final Statement insertEmpl = con.createStatement();
			final String sql = "INSERT INTO empleados " + "VALUES(" + emplFile.emplId + "," + "'" + emplFile.empNombre + "'" + "," + "'"
					+ emplFile.empApellido + "'" + "," + oraNull + "," + "'" + emplFile.empCategoria + "'"
					+ "," + "TO_DATE('" + emplFile.empFechaIngreso + "','DD/MM/YY'))";
			Logger.putQuery(sql);

			try {
				insertEmpl.executeQuery(sql);
			} catch (Exception e) {
				Logger.putLine("ERROR en inserción de registro de empleado " + e);
			}
		}
}
