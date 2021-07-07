
package dev.j3c.helpers;

public class RandomDistance {
    public static int getNewRandomDistance() {
        int randomNumber;
        do {
            randomNumber = (int)(Math.random() * 10);
        } while((randomNumber <= 0 || randomNumber > 6));    
        return(randomNumber *= 100);
    }
}
