package com.gvime.simplerpg;

public class Mage extends Hero{

    private final double HP_PER_LEVEL = 12;
    private final double DAMAGE_PER_LEVEL = 10;
    private final double ARMOR_PER_LEVEL = 0.75;

    /*
    MAGES DEALS 10% MORE NORMAL HIT DAMAGE
    DEALS ADDITIONAL 35% CRIT DAMAGE
     */


    public Mage(String name){
        super(name, 1, 110, 20, 6, 0.6, 0.05, 0.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (super.getLevel() - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (super.getLevel() - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (super.getLevel() - 1)));
    }

    public Mage(String name, int lv){
        super(name, lv, 110, 20, 6, 0.6, 0.05, 0.0);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    public Mage(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance){
        super(name, lv, hp, att, def, spe, eva, critChance);
        super.setHealth(hp + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(att + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(def + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    // SPECIAL ATTACK IMPLEMENTATION FOR MAGES SINCE THEY HAVE NO SPECIAL MODIFIERS
    @Override
    public void attack(Character target) {

        Hit attackType = Utils.tryAttack(target.getEvasion(), this.getCritChance());

        if (attackType == Hit.MISS){
            System.out.println("MISS");
        }
        else if (attackType == Hit.HIT){
            ModifiedHit modifiedAttack = new ModifiedHit(attackType, 1.1);
            double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
            System.out.println(damageDealt);
        }
        else if (attackType == Hit.CRIT){
            ModifiedHit modifiedAttack = new ModifiedHit(attackType, 2.35);
            double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
            System.out.println(damageDealt + "!!");
        }


    }
}
