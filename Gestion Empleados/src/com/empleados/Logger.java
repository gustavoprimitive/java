package com.empleados;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class Logger {
	
		static Date timestamp = new Date();
		
		/**
		 * Obtención de la IP del servidor.
		 * 
		 * @return
		 * @throws UnknownHostException
		 */
		public static String host() throws UnknownHostException {
			String host = InetAddress.getLocalHost().getHostAddress();
			return host;
		}
		
		/**
		 * Generación de traza genérica de log (INFO).
		 * 
		 * @param text
		 * @throws UnknownHostException
		 */
		public static void putLine(String text) throws UnknownHostException {
			System.out.println(timestamp + "\t" + host() + "\t" + text);
		}

		/**
		 * Generación de traza de sentencia Oracle.
		 * 
		 * @param text
		 * @throws UnknownHostException
		 */
		public static void putQuery(String text) throws UnknownHostException {
			System.out.println(timestamp + "\t" + host() + "\t\t" + "Query: " + text);
		}
}
