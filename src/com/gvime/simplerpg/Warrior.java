package com.gvime.simplerpg;

public class Warrior extends Hero{

    private final double HP_PER_LEVEL = 20;
    private final double DAMAGE_PER_LEVEL = 5;
    private final double ARMOR_PER_LEVEL = 2;

    /*
    WARRIORS STARTS WITH MORE ARMOR AND HP
    RECEIVE MORE HP AND ARMOR THAN OTHER HEROES
    (THE TANK OF THE TEAM)
     */

    //GENERATES LV 1 WARRIOR
    public Warrior(String name){
        super(name, 1, 200, 10, 20, 0.5, 0.01, 0.0, 2.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1))); // Health increases with level
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1))); // Damage increases with level
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1))); // Armor increases with level
    }

    // CREATES A WARRIOR WITH A GIVEN LEVEL
    public Warrior(String name, int lv){
        super(name, lv, 200, 10, 20, 0.5, 0.01, 0.0, 2.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    /*
    CREATES A STATED WARRIOR

    !! USED ONLY FOR TESTING PURPOSES OR SPECIFIC CASES !!
     */
    public Warrior(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance, double critDamage){
        super(name, lv, hp, att, def, spe, eva, critChance, critDamage);
        super.setHealth(hp + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(att + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(def + (ARMOR_PER_LEVEL * (lv - 1)));
    }

}
