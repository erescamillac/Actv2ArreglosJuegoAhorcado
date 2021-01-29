/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

/**
 *
 * @author erick
 */
public class PrePostIncrementTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int counter = -1;
        System.out.println("Test de PRE y Post incrementos");
        
        System.out.println("##--PRE-incremento: ");
        while(++counter < 10){
            System.out.println(counter);
        }
        System.out.println("##++PRE-incremento");
        
        counter = 0;
        System.out.println("##--Post-incremento: ");
        while(counter++ < 10){
            System.out.println(counter);
        }
        System.out.println("##++Post-incremento");
    } // fin método main()
    
}
