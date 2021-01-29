/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.math.numerical.systems.*;
/**
 *
 * @author erick
 */
public class RomanConverterTest {

    /**
     * @param args the command line arguments
     */
    
    /*
    Roman numerals correspondence rules are as follows:
        M 1000
        D 500
        C 100
        L 50
        X 10
        V 5
        I 1
    
        M = 1000, D = 500, C = 100, L = 50, X = 10, V = 5, I = 1
    */
    /*Samples: 
    1 : I, 2 : II, 3 : III, 4 : IV, 5 : V, 6 : VI, 7 : VII, 8 : VIII, 9 : IX, 10 : X, 11 : XI, 12 : XII, 13 : XIII, 14 : XIV, 15 : XV, 16 : XVI, 17 : XVII, 18 : XVIII, 19 : XIX, 20 : XX
    */
    public static void main(String[] args) {
        // TODO code application logic here
        // https://www.romannumerals.org/converter
        BasicRomanNumeralConverter romanConverter = new BasicRomanNumeralConverter();
        char[] testNumerals = {'V', 'D', 'C', 'I', 'K'};
        String[] romanNumbers= {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        System.out.println("Prueba de conversión de números Romanos.");
        System.out.println("Reglas de Conversión : M = 1000, D = 500, C = 100, L = 50, X = 10, V = 5, I = 1");
        System.out.println("####################################################");
        try{
            for(char numeral : testNumerals){
                System.out.println(String.format("['%s'] = [%d]", numeral, romanConverter.romanNumeralToDecimal(numeral)));
            }
        }catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println("Test de conversión de números Romanos a Decimal.");
        try{
            for(String romanNumber : romanNumbers){
                System.out.println(String.format("[%s] = [%d]", romanNumber, romanConverter.romanNumberToDecimal(romanNumber)));
            }
        }catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println("Fin de test de Conversión de números romanos");
    } // fin de método main()
    
}
