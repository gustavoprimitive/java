package com.empleados;

import java.sql.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import java.net.UnknownHostException;

public class GestorOracle {

	// Datos de conexión con Oracle
	//final String orafile = "C:/Users/gustavo.tejerina/eclipse-workspace/empl/oracle.xml";
	final String orafile = "/home/gustavo/workspace/empl/oracle.xml";
	public String datosConex[] = new String[4];
	public Connection con;

	/**
	 * Método para leer los datos de conexión desde XML.
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public String[] leerDatosConex() throws UnknownHostException {

		File file = new File(orafile);

		Logger.putLine("Leyendo datos de conexión en " + orafile);

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);

			datosConex[0] = document.getElementsByTagName("user").item(0).getTextContent();
			datosConex[1] = document.getElementsByTagName("pass").item(0).getTextContent();
			datosConex[2] = document.getElementsByTagName("instance").item(0).getTextContent();
			datosConex[3] = document.getElementsByTagName("port").item(0).getTextContent();
		} catch (Exception e) {
			Logger.putLine("ERROR No se ha podido leer el fichero " + orafile);
		}

		return datosConex;

	}

	/**
	 * Método para establecer conexión con la B.DD.
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection conexion() throws Exception {

		String stringConnect = "jdbc:oracle:thin:@" + "localhost" + ":" + datosConex[3] + ":" + datosConex[2];
		con = DriverManager.getConnection(stringConnect, datosConex[0], datosConex[1]);
		return con;
	}

	/**
	 * Método para probar si se ha establecido la conexión.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean compruebaConexion() throws Exception {

		final Statement st = con.createStatement();
		final ResultSet rs = st.executeQuery(OraQueries.getInstance);
		String check = "";

		while (rs.next()) {
			check = rs.getString(1);
		}

		if (check.equalsIgnoreCase(datosConex[2])) {
			// Ha conectado
			dataOracle();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ejecuta consulta para obtener datos de la instancia de Oracle: nombre, versión y fecha/hora en que se levantó.
	 * 
	 * @throws Exception
	 */
	public void dataOracle() throws Exception {

		final Statement instOra = con.createStatement();
		final ResultSet rs = instOra.executeQuery(OraQueries.getInstanceData);

		while (rs.next()) {
			Logger.putLine(rs.getString(1));
		}
	}
	
	/**
	 * Cierre conexión con Oracle.
	 * 
	 * @throws Exception
	 */
	public void cerrarConexion() throws Exception {
		con.close();
	}
}
