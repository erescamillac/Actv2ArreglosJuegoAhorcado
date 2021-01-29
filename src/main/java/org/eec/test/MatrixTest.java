/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.io.InputReader;
import org.eec.math.*;
/**
 *
 * @author erick
 */
public class MatrixTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputReader iReader = new InputReader();
        Matrix matrixA;
        Coords2D minCoords, maxCoords;
        String inputMsg;
        int rows, cols;
        double minVal, maxVal;
        System.out.println("##--Prueba de clase Matrix--##");
        inputMsg = "Ingrese el número de FILAS de la Matriz (el valor mínimo DEBE SER 1['uno']): ";
        rows = iReader.readInteger(inputMsg, 0, true);
        System.out.println("Num. de Filas especificadas por el usuario: " + rows);
        inputMsg = "Ingrese el número de Columnas de la Matriz (el valor mínimo DEBE SER 1['uno']): ";
        cols = iReader.readInteger(inputMsg, 0, true);
        matrixA = new Matrix(rows, cols);
        System.out.println("Ingrese los VALORES para la Matriz: ");
        matrixA.readData();
        System.out.println("DATOS almacenados en la Matriz: ");
        //matrixA.showContent();
        System.out.println(matrixA);
        maxVal = matrixA.maxVal();
        minVal = matrixA.minVal();
        System.out.println("MÁXIMO VALOR almacenado en la Matriz: " + maxVal);
        System.out.println("Mínimo (mín) valor almacenado en la Matriz: " + minVal);
        System.out.println(String.format("El valor MÁX [%f] se encuentra en (fila, colum) [índices BASADOS en 0-Cero-] [%s]", maxVal, matrixA.findValue(maxVal)));    
        System.out.println(String.format("El valor MÍN [%f] se encuentra en (fila, colum) [índices BASADOS en 0-Cero-] [%s]", minVal, matrixA.findValue(minVal)));
        
    } // fin de método main()
    
} // fin de clase MatrixTest
