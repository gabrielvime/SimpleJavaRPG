package com.gvime.simplerpg;

public class Mage extends Hero{

    private final double HP_PER_LEVEL = 12;
    private final double DAMAGE_PER_LEVEL = 10;
    private final double ARMOR_PER_LEVEL = 0.75;

    /*
    MAGES DEALS 10% MORE DAMAGE
    STARTS WITH ADDITIONAL 35% CRIT DAMAGE
     */

    public Mage(String name){
        super(name, 1, 110, 20, 6, 0.6, 0.05, 0.0, 2.35);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1)));
    }

    public Mage(String name, int lv){
        super(name, lv, 110, 20, 6, 0.6, 0.05, 0.0, 2.35);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    public Mage(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance, double critDamage){
        super(name, lv, hp, att, def, spe, eva, critChance, critDamage);
        super.setHealth(hp + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(att + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(def + (ARMOR_PER_LEVEL * (lv - 1)));
    }
}
