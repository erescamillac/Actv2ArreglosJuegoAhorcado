/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.arrays.utils.*;
/**
 *
 * @author erick
 */
public class ArrayInverterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] originalArray, inversedArray;
        originalArray = new int[]{5, 7, 3, 1, 9};
        System.out.println("Prueba de INVERSOR de arreglo.");
        System.out.println("Arreglo Original: " + ArrayUtils.toStringRep(originalArray));
        inversedArray = ArrayUtils.inverse(originalArray);
        System.out.println("Arreglo INVERTIDO: " + ArrayUtils.toStringRep(inversedArray));
    } // fin de método main()
    
}
