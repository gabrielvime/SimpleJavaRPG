package com.gvime.simplerpg;

public class Character {

    private double health, damage, armor, speed, evasion;
    int level;

    // Generates a character with random stats
    public Character() {
        this.health = Utils.getRandomDouble(10, 100);
        this.damage = Utils.getRandomDouble(1, 10);
        this.armor = Utils.getRandomDouble(1, 10);
        this.speed = Utils.getRandomDouble(0, 1);
        this.evasion = Utils.getRandomDouble(0, 1);
        this.level = 1;
    }

    // Generates a character with specified stats
    public Character(int level, double hp, double att, double def, double spe, double eva) {
        this.health = hp;
        this.damage = att;
        this.armor = def;
        this.speed = spe;
        this.evasion = eva;
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getArmor() {
        return armor;
    }

    public double getSpeed() {
        return speed;
    }

    public double getEvasion() {
        return evasion;
    }

    public int getLevel() {
        return level;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
