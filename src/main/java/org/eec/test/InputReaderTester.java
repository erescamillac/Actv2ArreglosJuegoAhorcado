/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.io.InputReader;
import org.eec.arrays.utils.*;
/**
 *
 * @author erick
 */
public class InputReaderTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputReader iReader = new InputReader();
        double[] rowReadFromKb;
        int rows;
        rowReadFromKb = iReader.readDoubleRow("Ingrese los valores de la fila separados por una coma (por ejemplo: 15.2, 3, 2.3, 7): ", 3, ',');
        System.out.println("--Contenido del Arreglo (row)");
        ArrayUtils.showContent(rowReadFromKb);
        System.out.println("\n++Contenido del Arreglo (row)");
        System.out.println("\nArreglo leido DESDE TECLADO (como String): " + ArrayUtils.toStringRep(rowReadFromKb));
        
        System.out.println("Test lectura de números ENTEROS: ");
        rows = iReader.readInteger("Ingrese el núemro de filas: ");
        System.out.println("# de filas leídas desde teclado: " + rows);
    } // fin de método main()
    
}
