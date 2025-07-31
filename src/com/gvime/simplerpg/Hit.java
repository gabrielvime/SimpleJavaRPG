package com.gvime.simplerpg;

public enum Hit {
    MISS(0, "Miss"),
    HIT(1, "Hit"),
    CRIT(2,"Critical Hit");

    private final int multiplier;
    private final String description;

    Hit(int value, String description) {
        this.multiplier = value;
        this.description = description;
    }

    public int getMultiplier() {
        return multiplier;
    }

//    public String getDescription() {
//        return description;
//    }
}
