package com.empleados;

public class OraQueries {

	//Queries sobre datos de la instancia
	final static String getInstance = "SELECT instance_name FROM v$instance";
	final static String getInstanceData = "SELECT 'Oracle version ' || version || ' Instancia ' || instance_name || ' Startup ' || startup_time FROM v$instance";

	//Queries sobre la tabla EMPLEADOS
	final static String getCountEmp = "SELECT COUNT(1) FROM empleados";
	final static String getEmpData = "SELECT id, nombre, apellidos, edad, categoria, TO_CHAR(fecha_registro,'DD/MM/YYYY HH24:MI') FROM empleados";
	final static String getEmpDataById = "SELECT * FROM empleados WHERE id = ";
	final static String getEmpMaxId = "SELECT MAX(id) FROM empleados";
}
