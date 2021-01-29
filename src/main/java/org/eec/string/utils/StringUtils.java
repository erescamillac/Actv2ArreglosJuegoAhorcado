/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.string.utils;

/**
 *
 * @author erick
 */
public class StringUtils {
    public static boolean isValidIndex(String s, int idx){
        if(s == null){
            return false;
        }else{
            return (idx >= 0 && idx < s.length()) ? true : false;
        }
    } // fin isValidIndex
} // fin de clase StringUtils
