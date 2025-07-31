package com.gvime.simplerpg;

public class Turn {

    public static void heroesTurn(Match match) {

        Logger.output("Your turn!");
        for (Hero hero : match.getMyParty().getBySpeed()) {
            Logger.output("Hero: " + hero.getName() + " | Level: " + hero.getLevel() + " | HP: " + hero.getHealth() + "/" + hero.getMaxHealth());
            Logger.output("SELECT A MONSTER TO ATTACK:");
            for (Monster monster : match.getMonsters()) {
                Logger.output((match.getMonsters().indexOf(monster) + 1) + " - Monster: " + monster.getRace() + " | Level: " + monster.getLevel() + " | HP: " + monster.getHealth() + "/" + monster.getMaxHealth());
            }

            Logger.output("Type the number of the monster you want to attack:");
            int monsterIndex = Utils.getInput().nextInt() - 1;
            hero.attack(match.getMonsters().get(monsterIndex));

            // Check if the monster is defeated
            if (match.getMonsters().get(monsterIndex).getHealth() <= 0 ) {
                Logger.output("Monster " + match.getMonsters().get(monsterIndex).getRace() + " defeated!");
                match.getMonsters().remove(monsterIndex);
            }

            // Check if all monsters are defeated
            if (match.getMonsters().isEmpty()){
                Logger.output("All monsters defeated! Heroes win this turn!");
                match.matchWinner(true);
                break;
            }

            if(match.getMyParty().isEmpty()){
                Logger.output("All heroes defeated! Monsters win this turn!");
                match.matchWinner(false);
                break;
            }
        }
        Logger.output("Heroes have finished their turn.");
    }

    public static void monsterTurn(Match match) {
        Logger.output("Monsters' turn!");
        for (Monster monster : match.getMonsters()) {

            int targetIndex = Utils.getRandomInt(0, match.getMyParty().getHeroes().size() - 1);
            Hero target = match.getMyParty().getHeroes().get(targetIndex);

            Logger.output("Monster: " + monster.getRace() + " | Level: " + monster.getLevel() + " | HP: " + monster.getHealth() + "/" + monster.getMaxHealth());
            Logger.output("Attacking Hero: " + target.getName() + " | Level: " + target.getLevel() + " | HP: " + target.getHealth() + "/" + target.getMaxHealth());

            monster.attack(target);

            if (target.getHealth() <= 0) {
                Logger.output("Hero " + target.getName() + " defeated!");
                match.getMyParty().getHeroes().remove(targetIndex);
            }
        }

        Logger.output("Monsters have finished their turn.");
    }
}
