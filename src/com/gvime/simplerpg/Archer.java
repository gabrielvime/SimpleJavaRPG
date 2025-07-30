package com.gvime.simplerpg;

public class Archer extends Hero {

    private final double HP_PER_LEVEL = 10;
    private final double DAMAGE_PER_LEVEL = 8;
    private final double ARMOR_PER_LEVEL = 0.75;
    private final double CRIT_PER_LEVEL = 0.008; // 0.8% crit chance per level

    /*
     ARCHERS STARTS WITH 10% CRIT CHANCE
     AND RECEIVE 0,8% PER LEVEL (TOTAL OF 50% AT LV 100)
     (THE RANGED DPS OF THE TEAM)
     */

    //CREATES LV 1 ARCHER
    public Archer(String name) {
        super(name, 1, 100, 15, 5, 0.7, 0.08, 0.1);
    }

    //CREATES AN ARCHER WITH A GIVEN LEVEL
    public Archer(String name, int lv) {
        super(name, lv, 100, 15, 5, 0.7, 0.05, 0.1);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
        super.setCritChance(super.getCritChance() + (CRIT_PER_LEVEL * (lv - 1)));
    }


    /*
    CREATES A STATED ARCHER

    !! USED ONLY FOR TESTING PURPOSES OR SPECIFIC CASES !!
     */
    public Archer(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance) {
        super(name, lv, hp, att, def, spe, eva, critChance);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
        super.setCritChance(super.getCritChance() + (CRIT_PER_LEVEL * (lv - 1)));
    }




}
