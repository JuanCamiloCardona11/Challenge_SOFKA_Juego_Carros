/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.j3c.helpers;

/**
 *
 * @author administrator
 */
public class RandomDistance {
    
    public static int getNewRandomDistance() {
        int randomNumber;
        do {
            randomNumber = (int)(Math.random() * 10);
        } while((randomNumber <= 0 || randomNumber > 6));    
        return(randomNumber *= 100);
    }
    
}
