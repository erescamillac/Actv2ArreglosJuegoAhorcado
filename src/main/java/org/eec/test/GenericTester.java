/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import java.util.Random;
import org.eec.math.randomizers.*;
/**
 *
 * @author erick
 */
public class GenericTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random random = new Random();
        GenericRandomizer gRandomizer = new GenericRandomizer();
        for(int i = 1; i < 10; i++){
            System.out.println("Iteration: " + i);
            System.out.println("Random int: " + random.nextInt(10));
        }
        
        System.out.println("##Random word generation test: ");
        for(int i = 1; i < 16; i++){
            System.out.println("Iteration: " + i);
            System.out.println("Random WORD: " + gRandomizer.nextWord());
        }
        System.out.println("Tester strings!!!");
        String str = "cascada", guessesReplacedStr;
        // a: 1, 2, 4, 6
        //str.indexOf('a');
        findAllOcurrences(str, 'a');
        
        System.out.println("Tets generate Obsucured string: " + generateObscuredStr(3));
        
        System.out.println("Test de guesses replace: ");
        System.out.println("ORIGINAL str: " + str);
        guessesReplacedStr = guessesReplace(str, 'a');
        System.out.println("Guesses replaced string: " + guessesReplacedStr);
        
        String csvStr = "3.2";
        String[] indvValues;
        indvValues = csvStr.split(",");
        
        System.out.println("--Ini: Test .split(',')");
        for(String val : indvValues){
            System.out.println(val);
        }
        System.out.println("++Fin: Test .split(',')");
    } // fin método main()
    
    public static void findAllOcurrences(String s, char c){
        int currentIdx, tmpIdx;
        if((currentIdx= s.indexOf(c)) != -1){
            System.out.println("First match index: " + currentIdx);
            while(currentIdx < s.length()){
                tmpIdx = s.indexOf(c, currentIdx + 1);
                if(tmpIdx != -1){
                    System.out.println("Match index: " + tmpIdx);
                    currentIdx = tmpIdx;
                }else{
                    break;
                }
            }
        }else{
            System.out.println(String.format("No se encontró el caracter [%s] en la cadena [%s]", c, s));
        }
    } // fin método findAllOcurrences
    
    public static String guessesReplace(String orgStr, char c){
        StringBuilder result = generateObscuredStr(orgStr.length());
        int currentIdx, tmpIdx;
        if((currentIdx = orgStr.indexOf(c)) != -1){
            // caracter encontrado por Primera vez
            result.setCharAt(currentIdx, c);
            while(currentIdx < orgStr.length()){
                // buscar ocurrencias posteriores
                tmpIdx = orgStr.indexOf(c, currentIdx + 1);
                if(tmpIdx != -1){
                    // caracter encontrado en la posición tmpIdx
                    result.setCharAt(tmpIdx, c);
                    currentIdx = tmpIdx;
                }else{
                    // caracter no encontrado: romper el ciclo while
                    break;
                }
            } // fin while
        }
        return result.toString();
    }
    
    public static StringBuilder generateObscuredStr(int length){
        StringBuilder sb = new StringBuilder();
        int numOfHyphens = 0;
        while(++numOfHyphens <= length){
            sb.append("-");
        }
        return sb;
    }
    // updateState(char c)
    // private String currentState;
    // public static final int MAX_ERRORS = 6;
    
} // fin de clase GenericTester
