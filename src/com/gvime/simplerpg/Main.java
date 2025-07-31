package com.gvime.simplerpg;

//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Initialize the game
        Game gameInstance = new Game();

        System.out.println("Welcome to Simple RPG!");

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

        while (gameInstance.isRunning()){
            System.out.println("WHILE LOOP");
            gameInstance.startGame();
            System.out.println("Save game? (y/n)");
            String saveChoice = Utils.getInput().nextLine();
            if (saveChoice.equalsIgnoreCase("y")) {mySave.updateSave(gameInstance.saveGame());}
            //gameInstance.endGame();
        }
    }
}
