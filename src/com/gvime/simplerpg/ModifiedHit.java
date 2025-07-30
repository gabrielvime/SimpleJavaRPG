package com.gvime.simplerpg;

public class ModifiedHit {
    private final Hit hitType;
    private final double multiplier;

    public  ModifiedHit(Hit hitType) {
        this.hitType = hitType;
        this.multiplier = hitType.getMultiplier();
    }

    public ModifiedHit(Hit hitType, double value) {
        this.hitType = hitType;
        this.multiplier = value;
    }

    public Hit getHitType() {
        return hitType;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return "ModifiedHit{" +
                "hitType=" + hitType +
                ", damage=" + multiplier +
                '}';
    }
}
