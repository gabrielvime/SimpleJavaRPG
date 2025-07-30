package com.gvime.simplerpg;

public class Character {

    private double health, maxHealth, damage, armor, speed, evasion, critChance;
    private int level;
    public final double MAX_EVASION = 0.75; // Maximum evasion chance (75%)
    public final double MAX_CRIT_CHANCE = 1.0;// Maximum critical hit chance (100%)


    // Generates a character with random stats
    public Character() {
        this.health = Utils.getRandomDouble(10, 100);
        this.maxHealth = this.health; // Set max health to initial health
        this.damage = Utils.getRandomDouble(1, 10);
        this.armor = Utils.getRandomDouble(1, 10);
        this.speed = Utils.getRandomDouble(0, 1);
        this.evasion = Utils.getRandomDouble(0, 1);
        this.level = 1;
    }

    // Generates a character with specified stats
    public Character(int level, double hp, double att, double def, double spe, double eva, double crC) {
        this.level = level;
        this.health = hp;
        this.maxHealth = hp;
        this.damage = att;
        this.armor = def;
        this.speed = spe;
        this.evasion = eva;
        this.critChance = crC;
    }

    public double getHealth() {
        return this.health;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public double getDamage() {
        return this.damage;
    }

    public double getArmor() {
        return this.armor;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getEvasion() {
        return this.evasion;
    }

    public int getLevel() {
        return this.level;
    }

    public double getCritChance() {
        return this.critChance;
    }

    public void setHealth(double health) {
        this.health = Math.min(health, this.maxHealth);
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
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

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    // ATTACK IMPLEMENTATION
    public void attack(Character target) {

        /* FIRST CHECK IF THE ATTACK MISS, NORMAL HITS OR CRITICAL */

        Hit attackType = Utils.tryAttack(target.getEvasion(), this.getCritChance());

        if (attackType == Hit.MISS) {
            System.out.println("MISS");
        } else {
            double damageDealt = Utils.damageCalc(this.damage, target.getArmor(), attackType);
            target.setHealth(target.getHealth() - damageDealt);
            System.out.println(damageDealt + (attackType == Hit.CRIT ? "!!" : ""));
        }
    }
}
