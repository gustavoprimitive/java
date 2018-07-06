package com.empleados;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import static java.awt.Color.*;
import java.awt.GridLayout;
 
public class GridEmpleados {
	
	//Frame   
	JFrame frame = new JFrame(); 
    //Array de etiquetas
	JLabel[][] grid;     
	//Borde de etiquetas
	Border border = BorderFactory.createLineBorder(BLACK, 1);

	//Metodo para generar el grid a partir del nº de filas, columnas y array de datos
	/**
	 * A partir del array con los datos de la tabla EMPLEADOS, construye un grid (frame de labels) para presentar los mismos.
	 * 
	 * @param numFilas
	 * @param numColumnas
	 * @param empl
	 * @throws Exception
	 */
	public void generaGrid(int numFilas, int numColumnas, String[][] empl) throws Exception{ 

		//Definicion de tamaño de frame y de nº de posiciones del array
		frame.setLayout(new GridLayout(numFilas+1, numColumnas));
        grid = new JLabel[numFilas+1][numColumnas];         
        
        //Construcción de grid
        for(int i=0; i<=numFilas; i++){        
        	for(int j=0; j<numColumnas; j++){
        		grid[i][j] = new JLabel(empl[i][j]);     
                frame.add(grid[i][j]);
                //Para la cabecera
                if (i == 0) {
                	grid[i][j].setOpaque(true);
                    grid[i][j].setBackground(BLUE);
                    grid[i][j].setForeground(WHITE);
                }
                grid[i][j].setBorder(border);
        	}
        }
        //Propiedades del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); 
        frame.setVisible(true); 
	}
}
