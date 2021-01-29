/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.games.*;
/**
 *
 * @author erick
 */
public class HangmanGameTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HangmanGame game;
        System.out.println("--Hangman game Test--");
        game = new HangmanGame();
        //System.out.println("Hangman game Clear string: " + game.getClearString());
        
        game.play();
        
    }
    
}
