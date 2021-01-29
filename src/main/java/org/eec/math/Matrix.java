/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.math;

import org.eec.io.InputReader;

/**
 *
 * @author erick
 */
public class Matrix {
    private double[][] innerArray;
    private InputReader iReader;
    
    public Matrix(int rows, int cols) throws IllegalArgumentException{
        if(rows < 1 || cols < 1){
            throw new IllegalArgumentException(String.format("El número de filas [%d] y de columnas [%d] DEBEN SER POR LO MENOS 1 (uno) [Matriz de 1x1].", rows, cols));
        }
        this.innerArray = new double[rows][cols];
        this.iReader = new InputReader();
    }
    
    
    public int getNumRows(){
        return innerArray.length;
    }
    
    public int getNumCols(){
        return innerArray[0].length;
    }
    // readMatrixData
    public void readData(){
        String inputMsg;
        int rowNumber = -1;
        for(double[] row: innerArray){
            ++rowNumber;
            inputMsg = String.format("Ingrese los valores de la Fila [%d] separados por comas (por ejemplo: 1, 3.5, -9, 2): ", rowNumber);
            innerArray[rowNumber] = iReader.readDoubleRow(inputMsg, getNumCols(), ',');
        }
    } // fin del método: readData()
    
    // visualize Matrix:
    public void showContent(){
        int colIdx, rowIdx;
        rowIdx = -1;
        System.out.print("[");
        for(double[] row : innerArray){
            colIdx = -1;
            ++rowIdx;
            for(double element : row){
                ++colIdx;
                System.out.print(element);
                if(colIdx != getNumCols() - 1){
                    System.out.print(", ");
                }
            }
            
            if(rowIdx != getNumRows() - 1){
                System.out.print("\n");
            }   
        }
        System.out.print("]");
    } // fin del método showContent()
    
    public double maxVal(){
        double maxTmp;
        maxTmp = innerArray[0][0];
        for(double[] row: innerArray){
            for(double element : row){
                if(element > maxTmp){
                    maxTmp = element;
                }
            }
        }
        return maxTmp;
    }
    
    // minVal
    public double minVal(){
        double minTmp;
        minTmp = innerArray[0][0];
        for(double[] row: innerArray){
            for(double element : row){
                if(element < minTmp){
                    minTmp = element;
                }
            }
        }
        return minTmp;
    }
    
    // search for a value inside the Matrix and return the respective Coords
    // if value is NOT found : returns (-1, -1)
    public Coords2D findValue(double targetVal){
        Coords2D coords = new Coords2D(-1, -1);
        boolean found = false;
        int rowIdx, colIdx = -1;
        
        rowIdx = -1;
        for(double[] row : innerArray){
            ++rowIdx;
            colIdx = -1;
            for(double element : row){
                ++colIdx;
                if(targetVal == element){
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        
        if(found){
            coords.setX(rowIdx);
            coords.setY(colIdx);
        }
        return coords;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int colIdx, rowIdx;
        rowIdx = -1;
        sb.append("[");
        for(double[] row : innerArray){
            colIdx = -1;
            ++rowIdx;
            for(double element : row){
                ++colIdx;
                sb.append(element);
                if(colIdx != getNumCols() - 1){
                    sb.append(", ");
                }
            }
            
            if(rowIdx != getNumRows() - 1){
                sb.append("\n");
            }   
        }
        sb.append("]");
        return sb.toString();
    } // fin del método toString()
    
} // fin class Matrix
