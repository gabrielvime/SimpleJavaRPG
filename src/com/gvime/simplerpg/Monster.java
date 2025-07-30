package com.gvime.simplerpg;

public class Monster extends Character{

    private final double HP_PER_LEVEL = 50;
    private final double DAMAGE_PER_LEVEL = 10;
    private final double ARMOR_PER_LEVEL = 1.5;

    /*
    MONSTERS HAVE NO LEVEL CAP
     */

    // GENERATES A LEVEL SPECIFIC MONSTER
    public Monster(int lv){
        super(lv, Utils.getRandomDouble(100, 300), Utils.getRandomDouble(5, 30), Utils.getRandomDouble(2, 15), Utils.getRandomDouble(0.1, 0.9), Utils.getRandomDouble(0.0, 0.3), Utils.getRandomDouble(0.0, 0.3));
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1)));
    }
}
