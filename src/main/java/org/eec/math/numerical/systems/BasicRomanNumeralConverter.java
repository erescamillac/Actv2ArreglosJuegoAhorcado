/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.math.numerical.systems;

import org.eec.string.utils.*;
/**
 *
 * @author erick
 */
public class BasicRomanNumeralConverter {
    /*TODO:
    * Add RegExp validation for RomanNumbers represented as Strings
    */
    private static final String ROMAN_NUMERALS = "MDCLXVI";
    private static final int[] decimalValues = {1000, 500, 100, 50, 10, 5, 1};
    /* Roman numerals correspondence rules are as follows:
        M 1000
        D 500
        C 100
        L 50
        X 10
        V 5
        I 1
    */
    
    /*
    String.format("u1=%s;u2=%s;u3=%s;u4=%s;", u1, u2, u3, u4);
    */
    public int romanNumeralToDecimal(char romanNumeral) throws IllegalArgumentException{
        int numeralIndex, decimalVal = -1;
        if( (numeralIndex = ROMAN_NUMERALS.indexOf(romanNumeral)) != -1){
            decimalVal = decimalValues[numeralIndex];
        }else{
            throw new IllegalArgumentException(String.format("El caracter [%s] NO representa un numeral ROMANO", romanNumeral));
        }
        return decimalVal;
    } // fin metodo romanNumeralToDecimal
    
    public int romanNumberToDecimal(String romanNumber){
        int acumulador = 0, lastPosVal, previousPosVal, lastIdx, difference, partialSum;
        if(romanNumber != null){
            if(romanNumber.length() > 1){
                // Primero validar caso especial de Resta
                lastIdx = romanNumber.length() - 1;
                lastPosVal = romanNumeralToDecimal(romanNumber.charAt(lastIdx));
                previousPosVal = romanNumeralToDecimal(romanNumber.charAt(lastIdx - 1));
                
                if(lastPosVal > previousPosVal){
                    // Caso de resta
                    difference = lastPosVal - previousPosVal;
                    partialSum = romToDecAdditionMethod(romanNumber, lastIdx - 2);
                    acumulador += partialSum + difference;
                }else{
                    // Caso de suma [Addition Rule]
                    return romToDecAdditionMethod(romanNumber);
                }
                
            }else{
                if(StringUtils.isValidIndex(romanNumber, 0)){
                    return romanNumeralToDecimal(romanNumber.charAt(0));
                }
            }
        }
        return acumulador;
    } // fin de método romanNumberToDecimal(String s)
    
    private int romToDecAdditionMethod(String s){
        int acumulador = 0;
        if(s != null){
            for(char c : s.toCharArray()){
                acumulador += romanNumeralToDecimal(c);
            }
        }
        return acumulador;
    } // fin método romToDecAdditionMethod(String s)
    
    private int romToDecAdditionMethod(String s, int lastIndex){
        int acumulador = 0, indexTmp = -1;
        if(s != null){
            while(++indexTmp <= lastIndex){
                acumulador += romanNumeralToDecimal(s.charAt(indexTmp));
            }
        }
        return acumulador;
    } // fin método romToDecAdditionMethod(String s, int lastIndex)
    
    
} //-- fin clase BasicRomanNumeralConverter
