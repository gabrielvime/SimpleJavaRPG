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
        super(name, 1, 130, 30, 7, 0.4, 0.1, 0.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1)));
    }

    // CREATES AN ASSASSIN WITH A GIVEN LEVEL
    public Assassin(String name, int lv){
        super(name, lv, 130, 30, 7, 0.4, 0.1, 0.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    // CREATES A STATED ASSASSIN
    public Assassin(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance){
        super(name, lv, hp, att, def, spe, eva, critChance);
        super.setHealth(hp + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(att + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(def + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    // SPECIAL ATTACK IMPLEMENTATION FOR ASSASSINS SINCE THEY HAVE NO SPECIAL MODIFIERS
    @Override
    public void attack(Character target) {

        Hit attackType = Utils.tryAttack(0, this.getCritChance());
        // EVASION CHANCE = 0 SO IT WILL ALWAYS HIT

        // IF THE TARGET HAS LESS THAN 50% HP, ASSASSINS DEALS 20% MORE DAMAGE
        if (target.getHealth() < (target.getMaxHealth() * 0.5)) {
            if (attackType == Hit.HIT) {
                ModifiedHit modifiedAttack = new ModifiedHit(attackType, 1.2);
                double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
                System.out.println(damageDealt);
            }
            else if (attackType == Hit.CRIT) {
                ModifiedHit modifiedAttack = new ModifiedHit(attackType, 2.4);
                double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
                System.out.println(damageDealt + "!!");
            }
        }
        else {
            double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), attackType);
            target.setHealth(target.getHealth() - damageDealt);
            System.out.println(damageDealt + (attackType == Hit.CRIT ? "!!" : ""));
        }
    }
}



