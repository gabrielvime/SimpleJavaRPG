package com.gvime.simplerpg;

//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Initialize the game
        Game gameInstance = new Game();

        Logger.output("Welcome to Simple RPG!");

        Party myParty = new Party();

        Archer myArcher = new Archer("Archer");
        Assassin myAssassin = new Assassin("Assassin");
        Mage myMage = new Mage("Mage");
        Warrior myWarrior = new Warrior("Warrior");

        myParty.addMember(myAssassin);
        myParty.addMember(myArcher);
        myParty.addMember(myMage);
        myParty.addMember(myWarrior);

        Save mySave = new Save(myParty, 1);

        gameInstance.loadGame(mySave);
        gameInstance.isRunning(true);

        // NEW MATCH
        while (gameInstance.getGameLevel() <= 50){
            Logger.output("Starting match at level " + gameInstance.getGameLevel() + "...");

            Match match = new Match(gameInstance);
            match.generateMonsters();
            match.startMatch();

            if (match.matchWinner()) {
                Logger.output("You won the match!");
                gameInstance.levelUp();
            } else {
                Logger.output("You lost the match. Game over.");
                gameInstance.isRunning(false);
                break;
            }

            // Save the game after each match
            mySave.updateSave(gameInstance.getMyParty(), gameInstance.getGameLevel());
            Logger.output("Game saved with " + gameInstance.getGameLevel() + " level and " +
                    gameInstance.getMyParty().getNumArchers() + " archers, " +
                    gameInstance.getMyParty().getNumAssassins() + " assassins, " +
                    gameInstance.getMyParty().getNumMages() + " mages, and " +
                    gameInstance.getMyParty().getNumWarriors() + " warriors.");
            Logger.output("Exit Game? (Y/N)");
            if (Utils.getInput().nextLine().equalsIgnoreCase("Y")) {
                gameInstance.isRunning(false);
                Logger.output("Thank you for playing!");
                break;
            }
            Logger.output("Starting a new match...");
        }

    }
}
