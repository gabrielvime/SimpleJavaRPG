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

    // CALCULATES THE DAMAGE DEALT BASED ON DAMAGE VALUE AND ARMOR
    public static double damageCalc(double damage, double armor, Hit multiplier) {
        if (damage <= 0) {
            return 0; //NEGATIVE DAMAGE WILL RESULT IN ZERO DAMAGE
        } else if (armor <= 0) {
            return multiplier.getMultiplier() * damage; //NEGATIVE ARMOR WILL NOT AFFECT DAMAGE
        }
        return multiplier.getMultiplier() * (damage * (1 - ((0.06 * armor) / (1 + 0.06 * Math.abs(armor)))));
        /*
        THIS FORMULA IS BASED ON DOTA 2 DAMAGE CALCULATION
        SEE https://liquipedia.net/dota2/Armor#Equations FOR MORE DETAILS
         */
    }

    // ATTEMPTS AN ATTACK BASED ON EVASION AND CRITICAL HIT CHANCES
    public static Hit tryAttack(double evasionChance, double critChance) {
        /*
        THE EVASION AND CRIT CHANCES ARE PRETTY SIMPLE FOR NOW.
        IT JUST GENERATES A RANDOM DOUBLE BETWEEN 0 AND 1
        AND COMPARES IT TO THE EVASION AND CRIT CHANCES.
        IF THE RANDOM NUMBER IS GREATER THAN THE EVASION CHANCE,
        THE ATTACK HITS, AND IF IT'S LESS THAN THE CRIT CHANCE,
        IT'S A CRITICAL HIT.
         */
        if (getRandomDouble(0.0, 1.0) > evasionChance) {
            if (getRandomDouble(0.0, 1.0) < critChance) {
                return Hit.CRIT; // CRITICAL HIT
            } else {
                return Hit.HIT; // NORMAL HIT
            }
        }else return Hit.MISS; // ATTACK MISSED
    }

    // OVERLOADED DAMAGE CALCULATION METHOD FOR MODIFIED HIT
    public static double damageCalc(double damage, double armor, ModifiedHit multiplier) {
        if (damage <= 0) {
            return 0;
        } else if (armor <= 0) {
            return multiplier.getMultiplier() * damage;
        }
        return multiplier.getMultiplier() * (damage * (1 - ((0.06 * armor) / (1 + 0.06 * Math.abs(armor)))));
    }
}
