package com.gvime.simplerpg;

public class Assassin extends Hero{

    private final double HP_PER_LEVEL = 15;
    private final double DAMAGE_PER_LEVEL = 15;
    private final double ARMOR_PER_LEVEL = 0.9;

    /*
    ASSASSINS DEALS 20% MORE DAMAGE TO ENEMIES WITH LESS THAN 50% HP
    AND ALWAYS HIT (IGNORING EVASION)
     */

    // GENERATES LV 1 ASSASSIN
    public Assassin(String name){
        super(name, 1, 130, 30, 7, 0.4, 0.1, 0.0, 2.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1)));
    }

    // CREATES AN ASSASSIN WITH A GIVEN LEVEL
    public Assassin(String name, int lv){
        super(name, lv, 130, 30, 7, 0.4, 0.1, 0.0, 2.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }
}

