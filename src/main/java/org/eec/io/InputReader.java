/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.io;

import java.util.Scanner;
/**
 *
 * @author erick
 */
public class InputReader {
    private Scanner console;
    
    public InputReader(){
        this.console = new Scanner(System.in);
    }
    
    public int readInteger(String inputMsg, int threshold, boolean greaterThan){
        int value = -1;
        boolean error = false;
        String errorMsg = "";
        do{
            if(error){
                System.out.println(errorMsg);
            }
            error = false;
            
            value = readInteger(inputMsg);
            
            if(greaterThan){
                // DEBE CUMPLIRSE QUE: val > threshold
                if(!(value > threshold)){
                    error = true;
                    errorMsg = String.format("El valor INGRESADO [%d] DEBE SER MAYOR QUE [%d]. Inténtelo nuevamente.", value, threshold);
                }
            }else{
                // DEBE CUMPLIRSE QUE: val < threshold
                if(!(value < threshold)){
                    error = true;
                    errorMsg = String.format("El valor INGRESADO [%d] DEBE ser menor que [%d]. Inténtelo nuevamente.", value, threshold);
                }
            }
            
        }while(error);
        return value;
    } //-- fin: método readInteger(String, int, boolean)
    
    // method readInteger() : READY for external usage
    public int readInteger(String inputMsg){
        int value = -1;
        boolean error = false;
        String errorMsg = "", strReadFromKb = "";
        do{
            if(error){
                System.out.println(errorMsg);
            }
            error = false;
            try{
                System.out.println(inputMsg);
                strReadFromKb = this.console.nextLine();
                value = Integer.parseInt(strReadFromKb);
            }catch(Exception e){
                error = true;
                errorMsg = String.format("La cadena [%s] NO REPRESENTA UN valor ENTERO, por favor ingrese un ENTERO. Inténtelo nuevamente.", strReadFromKb);
            }
        }while(error);
        return value;
    } // fin readInteger
    
    // readDoubleRow() : listo para usarse - [200 : OK]
    public double[] readDoubleRow(String inputMsg, int expectedElements, char delimiter){
        double[] row = {};
        //double doubleTmp;
        boolean error = false;
        // int idxTmp;
        String errorMsg = "", strFromKeyboard, delimiterAsStr, val;
        String[] indvValues;
        delimiterAsStr = String.valueOf(delimiter);
        val = "";
        do{
            if(error){
                System.out.println(errorMsg);
            }
            error = false;
            System.out.println(inputMsg);
            strFromKeyboard = this.console.nextLine();
            //System.out.println("Cadena leída dese TECLADO: " + strFromKeyboard);
            if(strFromKeyboard.isBlank()){
                error = true;
                errorMsg = "NO SE ACEPTA UNA ENTRADA VACÍA, debe esribir almenos 1 dígito. Inténtelo nuevamente.";
            }else{
                indvValues = strFromKeyboard.split(delimiterAsStr);
                
                if(indvValues.length != expectedElements){
                    error = true;
                    errorMsg = String.format("Fueron ingresados [%d] elementos SEPARADOS POR ['%s'], se esperaban [%d] VALORES. Ingrese EXACTAMENTE [%d] valores separados por ['%s']. Inténtelo nuevamente.", indvValues.length, delimiter, expectedElements, expectedElements, delimiter);
                }else{
                    // intento de conversion de elementos individuales separados por el caracter delimiter a double
                    // try-catch
                    row = new double[expectedElements];
                    try{
                        for(int idxTmp = 0; idxTmp < indvValues.length; idxTmp++){
                            val = indvValues[idxTmp];
                            // System.out.println(val);
                            // doubleTmp = Double.parseDouble(val);
                            row[idxTmp] = Double.parseDouble(val);
                        }
                    }catch(Exception e){
                        // Error al intentar convertir val a tipo double
                        //System.out.println("ERROR DE PARSING a double");
                        //System.out.println(e.getMessage());
                        error = true;
                        errorMsg = String.format("La cadena ['%s'] NO REPRESENTA un VALOR NÚMERICO, por favor ingrese valores numéricos, separados por ['%s'].", val, delimiter);
                    }
                       
                } // fin: else (expectedElements)
            }
        }while(error);
        return row;
    } // fin de método readDoubleRow
    
} // fin de clase InputReader
