/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.arrays.utils;

/**
 *
 * @author erick
 */
public class ArrayUtils {
    
    public static void showContent(int[] unidimIntArray){
        int numOfElements;
        numOfElements = unidimIntArray.length;
        System.out.print("[");
        for(int i = 0; i < numOfElements; i++){
            System.out.print(unidimIntArray[i]);
            // si no es la última posición (el último índice válido)
            if(i != numOfElements - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    } // fin de método showContent()
    
    // Overload .showContent(double[] unidimDoubArray)
    public static void showContent(double[] unidimDoubArray){
        int numOfElements;
        numOfElements = unidimDoubArray.length;
        System.out.print("[");
        for(int i = 0; i < numOfElements; i++){
            System.out.print(unidimDoubArray[i]);
            // si no es la última posición (el último índice válido)
            if(i != numOfElements - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    } // fin de método showContent(double[] dContent)
    
    public static String toStringRep(int[] unidimIntArray){
        StringBuilder sb = new StringBuilder();
        int numOfElements;
        numOfElements = unidimIntArray.length;
        sb.append("[");
        for(int i = 0; i < numOfElements; i++){
            sb.append(unidimIntArray[i]);
            if(i != numOfElements - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    } // fin de método static String toString() 
    
    //** Overload .toStringRep(double[] dContent)
    public static String toStringRep(double[] unidimDoubArray){
        StringBuilder sb = new StringBuilder();
        int numOfElements;
        numOfElements = unidimDoubArray.length;
        sb.append("[");
        for(int i = 0; i < numOfElements; i++){
            sb.append(unidimDoubArray[i]);
            if(i != numOfElements - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    } // fin de método static String toString() 
    
    
    public static int[] inverse(int[] array){
        int[] result;
        int numOfElements, idx;
        numOfElements = array.length;
        idx = -1;
        result = new int[numOfElements];
        for(int reverseIdx = numOfElements - 1; reverseIdx >= 0; reverseIdx--){
            result[++idx] = array[reverseIdx];
        }
        return result;
    } // fin de método inverse(int[] array)
} // fin de clase ArrayUtils
