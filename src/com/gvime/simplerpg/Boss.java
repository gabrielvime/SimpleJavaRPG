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

    public Boss (String race, int lv) {
        super(race, lv);
        super.setHealth(super.getHealth() + (HP_PER_LEVEL * (lv - 1)));
        super.setDamage(super.getDamage() + (DAMAGE_PER_LEVEL * (lv - 1)));
        super.setArmor(super.getArmor() + (ARMOR_PER_LEVEL * (lv - 1)));
    }

    @Override
    public void attack(Character target) {

        Hit attackType = Utils.tryAttack(target.getEvasion(), this.getCritChance());

        if (attackType == Hit.MISS){
            System.out.println("MISS");
        }
        else if (attackType == Hit.HIT){
            ModifiedHit modifiedAttack = new ModifiedHit(attackType, 1.4);
            double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
            System.out.println(damageDealt);
        }
        else if (attackType == Hit.CRIT){
            ModifiedHit modifiedAttack = new ModifiedHit(attackType, 3.0); // Bosses have a crit damage multiplier of 3.0
            double damageDealt = Utils.damageCalc(this.getDamage(), target.getArmor(), modifiedAttack);
            System.out.println(damageDealt + "!!");
        }


    }

}
