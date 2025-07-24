package com.gvime.simplerpg;

public class Utils {

    public static double getRandomDouble(double min, double max) {
        return min + (Math.random() * (max - min));
    }
}
