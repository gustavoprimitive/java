package com.empleados;

import java.util.ArrayList;

public class Prueba {
	
	public static void main(String[] args) throws Exception {				
		
		ArrayList<String> empleado = null;
		
		GestorOracle ora = new GestorOracle();		
		
		//Lectura de datos de conexión
		ora.leerDatosConex();
		
		//Conexión
		ora.conexion();
		
		//Check de conexión
		if (ora.compruebaConexion()) {
			Logger.putLine("Conectado a Oracle");
		}else {
			Logger.putLine("ERROR al intentar conectar a Oracle");
		}		
		
		NuevoEmpleado empl = new NuevoEmpleado();
		
		//Petición de datos de nuevo empleado
		empleado = empl.lecturaDatosEmpl();
		
		//Inserción de registro en B.DD.
		empl.insertEmpl(empleado, ora.con);
		
		UltimoIdEmpl ult = new UltimoIdEmpl();
		
		//Obtener último ID
		int ultID = ult.ObtenerID(ora.con);
					
		LeerEmpleado emp = new LeerEmpleado();
		
		//Se recuperan los datos del empleado 		
		emp.LeeEmpleadoPorID(ultID, ora.con);
		
		//Lectura de datos de tabla empleados
		DatosTablaEmpleados tab = new DatosTablaEmpleados();
		tab.contarRegistros(ora.con);
		String[][] tabla = tab.datosEmpleados(ora.con, tab.filasEmpleados);	
		
		/*for(int i=0; i<tabla.length; i++) {
			for(int j=0; j<6; j++) {
				Logger.putLine(tabla[i][j]);
			}
		}*/
		
		
		//Generación de grid con los datos de empleados
		GridEmpleados gridEmpl = new GridEmpleados();		
		gridEmpl.generaGrid(tab.filasEmpleados, tab.columnasEmpleados, tabla);		
		
		/*CargaMasiva cargaFichero = new CargaMasiva();
		
		cargaFichero.insertarLineaFichero(ora.con);

		//Lectura de datos de tabla empleados
		DatosTablaEmpleados tab = new DatosTablaEmpleados();
		tab.contarRegistros(ora.con);
		String[][] tabla = tab.datosEmpleados(ora.con, tab.filasEmpleados);	
		GridEmpleados gridEmpl = new GridEmpleados();		
		gridEmpl.generaGrid(tab.filasEmpleados, tab.columnasEmpleados, tabla);*/		
		
		//Cierre de conexion
		ora.cerrarConexion();		

	}
}
