/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.games;

import org.eec.math.randomizers.*;
import java.util.Scanner;
/**
 *
 * @author erick
 */
public class HangmanGame {
    
    public static final int MAX_ERRORS = 6;
    private int errorsNum;
    private String clearString;
    private GenericRandomizer gRadomizer;
    private Scanner keyboard;
    private StringBuilder playerString;
    
    public HangmanGame(){
        super();
        this.errorsNum = 0;
        this.gRadomizer = new GenericRandomizer();
        this.clearString = this.gRadomizer.nextWord();
        this.keyboard = new Scanner(System.in);
        this.playerString = generateObscuredStr(clearString.length());
    } // fin de constructor HangmanGame
    
    /*
    Genera cadena compuesta de guiones
    */
    private StringBuilder generateObscuredStr(int length){
        StringBuilder sb = new StringBuilder();
        int numOfHyphens = 0;
        while(++numOfHyphens <= length){
            sb.append("-");
        }
        return sb;
    }
    
    
    public void play(){
        int attempts = 0;
        char charTmp;
        String strTmp, sWordPreviousState;
        System.out.println("##--Welcome to the Hangman game--##");
        while(!isGameOver()){
            // this.errorsNum++;
            attempts++;
            System.out.println("*********************************************");
            sWordPreviousState = this.playerString.toString();
            System.out.println("Secret word: " + sWordPreviousState);
            System.out.println("Attempt: " + attempts);
            System.out.println("Errors: " + this.errorsNum);
            System.out.println("Wich character do you believe is part of the secret word? [Input JUST ONE CHARACTER and then Press ENTER]: ");
            strTmp = this.keyboard.nextLine();
            //System.out.println("Entrada desde teclado: " + charTmp);
            charTmp = strTmp.charAt(0);
            System.out.println(String.format("Determining if the character [%s] is in the secret word...", charTmp));
            // actualuzar estado de la cadena ofuscada: (playerString)
            guessesReplace(charTmp);
            System.out.println("UPDATED secret word: " + this.playerString);
            
            //System.out.println("Previous state: " + sWordPreviousState);
            //System.out.println("CURRENT state: " + this.playerString);
            
            if(sWordPreviousState.equals(this.playerString.toString())){
                this.errorsNum++;
            }
            
            // verificar condicion de victoria en el juego
            if(this.clearString.equals(this.playerString.toString())){
                break;
            }
            
        } // fin de ciclo while
        
        if(isGameOver()){
            System.out.println(String.format("GAME OVER!, sorry you have reached the MAXIMUM amount of permisible errors[%d]", MAX_ERRORS));
        }else{
            System.out.println("Congratulations! You have correctly guessed the hiden word!");
        }
        
        System.out.println("The secret word was: " + this.clearString);
    } // fin metodo play()
    
    private void guessesReplace(char c){
        // StringBuilder result = generateObscuredStr(orgStr.length());
        // this.playerString;
        int currentIdx, tmpIdx;
        if((currentIdx = clearString.indexOf(c)) != -1){
            // caracter encontrado por Primera vez
            this.playerString.setCharAt(currentIdx, c);
            while(currentIdx < clearString.length()){
                // buscar ocurrencias posteriores
                tmpIdx = clearString.indexOf(c, currentIdx + 1);
                if(tmpIdx != -1){
                    // caracter encontrado en la posición tmpIdx
                    this.playerString.setCharAt(tmpIdx, c);
                    currentIdx = tmpIdx;
                }else{
                    // caracter no encontrado: romper el ciclo while
                    break;
                }
            } // fin while
        }
        // return result.toString();
    }
    
    
    /*solo con fines de prueba*/
    private String getClearString(){
        return clearString;
    }
    
    public boolean isGameOver(){
        return this.errorsNum == MAX_ERRORS;
    } // fin de método isGameOver
    
} // fin de clase HangmanGame
