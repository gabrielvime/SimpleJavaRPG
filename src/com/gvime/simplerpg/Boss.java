package com.gvime.simplerpg;

public class Boss extends Monster {

    private final double HP_PER_LEVEL = 300;
    private final double DAMAGE_PER_LEVEL = 50;
    private final double ARMOR_PER_LEVEL = 5.0;

    /*
    SPECIAL MONSTER
    HAVE MASSIVE HP AND DAMAGE
    CRIT DAMAGE INCREASED
     */

    public Boss (int lv) {
        super(lv);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
        super.setCritDamage(3.0); // Bosses have a crit damage multiplier of 3.0
    }

}
