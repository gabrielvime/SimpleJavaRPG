package com.gvime.simplerpg;

public class Utils {


    // GENERATES A RANDOM DOUBLE BETWEEN MIN AND MAX (INCLUSIVE)
    public static double getRandomDouble(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        return min + (Math.random() * (max - min));
    }

    // GENERATES A RANDOM INTEGER BETWEEN MIN AND MAX (INCLUSIVE)
    public static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        return (int) Math.floor(getRandomDouble(min, max + 1));
    }

    // CALCULATES THE DAMAGE MULTIPLIER BASED ON DAMAGE AND ARMOR
    public static double damageMultiplier(double damage, double armor) {
        if (damage < 0) {
            return 0; //NEGATIVE DAMAGE WILL RESULT IN ZERO DAMAGE
        }
        else if (armor < 0) {
            return damage; //NEGATIVE ARMOR WILL NOT AFFECT DAMAGE
        }
        return damage * (1 - ( ( 0.06 * armor ) / ( 1 + 0.06 * Math.abs(armor) ) ) );
        /*
        THIS FORMULA IS BASED ON DOTA 2 DAMAGE CALCULATION
        SEE https://liquipedia.net/dota2/Armor#Equations FOR MORE DETAILS
         */
    }
}
