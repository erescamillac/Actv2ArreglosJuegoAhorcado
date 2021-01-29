/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.math.randomizers;

import java.util.Random;
/**
 *
 * @author erick
 */
public class GenericRandomizer {
    
    private static final String[] wordsBank = {"cascada", "emancipar", "fuego", "sangre", "estupefacto", "antojo", "capricho", "hijo", "respeto", "afecto", "espada", "guerra", "polar", "pardo"}; 
    private Random randomGenerator;
    
    public GenericRandomizer(){
        super();
        randomGenerator = new Random();
    }
    
    public String nextWord(){
        int randomIdx;
        randomIdx = this.randomGenerator.nextInt(wordsBank.length);
        return wordsBank[randomIdx];
    } // fin de método nextWord() : String
    
}// fin de clase GenericRandomizer
