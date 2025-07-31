package com.gvime.simplerpg;

//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Initialize the game
        Game gameInstance = new Game();

        Log.output("Welcome to Simple RPG!");

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
            Log.output("Starting match at level " + gameInstance.getGameLevel() + "...");

            Match match = new Match(gameInstance);
            match.generateMonsters();
            match.startMatch();

            if (match.matchWinner()) {
                Log.output("You won the match!");
                gameInstance.levelUp();
            } else {
                Log.output("You lost the match. Game over.");
                gameInstance.isRunning(false);
                break;
            }

            // Save the game after each match
            mySave.updateSave(gameInstance.getMyParty(), gameInstance.getGameLevel());
            Log.output("Game saved with " + gameInstance.getGameLevel() + " level and " +
                    gameInstance.getMyParty().getNumArchers() + " archers, " +
                    gameInstance.getMyParty().getNumAssassins() + " assassins, " +
                    gameInstance.getMyParty().getNumMages() + " mages, and " +
                    gameInstance.getMyParty().getNumWarriors() + " warriors.");
            Log.output("Exit Game? (Y/N)");
            if (Utils.getInput().nextLine().equalsIgnoreCase("Y")) {
                gameInstance.isRunning(false);
                Log.output("Thank you for playing!");
                break;
            }
            Log.output("Starting a new match...");
        }

    }
}
