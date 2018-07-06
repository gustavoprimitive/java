package com.empleados;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NuevoEmpleado {

	ArrayList<String> empleado = new ArrayList<String>();
	Scanner scanner = new Scanner(System.in);
	String oraSeqEmpl = "seq_empleados.nextval";
	String oraSysdate = "SYSDATE";
	
	/**
	 * Solicitud de datos por consola de nuevo empleado a insertar en la tabla EMPLEADOS.
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public ArrayList<String> lecturaDatosEmpl() throws UnknownHostException {
		
		Logger.putLine("Solicitid de datos de empleado");
		
		System.out.println("Nombre: ");
		empleado.add(0, scanner.nextLine());
		
		System.out.println("Apellidos: ");
		empleado.add(1, scanner.nextLine());				
		
		do {
			System.out.println("Edad: ");
			empleado.add(2, scanner.nextLine());
		}while (!Pattern.matches("^[0-9]+$", empleado.get(2)));
		
		System.out.println("Categoria: ");
		empleado.add(3, scanner.nextLine());		
		
		return empleado;
		
	}

	/**
	 * Inserción en B.DD. de los datos del empleado.
	 * 
	 * @param empleado
	 * @param con
	 * @throws Exception
	 */
	public void insertEmpl(ArrayList<String> empleado, Connection con) throws Exception {

		Logger.putLine("Se inserta empleado");		

		final Statement insertEmpl = con.createStatement();
		final String sql = "INSERT INTO empleados " + "VALUES(" + oraSeqEmpl + "," + "'" + empleado.get(0) + "'" + "," + "'"
				+ empleado.get(1) + "'" + "," + Integer.parseInt(empleado.get(2)) + "," + "'" + empleado.get(3) + "'"
				+ "," + oraSysdate + ")";
		Logger.putQuery(sql);

		try {
			insertEmpl.executeQuery(sql);
		} catch (Exception e) {
			Logger.putLine("ERROR en inserción de registro de empleado " + e);
		}
	}
}
