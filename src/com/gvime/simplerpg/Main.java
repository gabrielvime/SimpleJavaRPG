package com.gvime.simplerpg;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Initialize the game
        Game gameInstance = new Game();

        System.out.println("Welcome to Simple RPG!");

        ArrayList<Archer> archersList = new ArrayList<Archer>();
        ArrayList<Assassin> assassinsList = new ArrayList<Assassin>();
        ArrayList<Mage> magesList = new ArrayList<Mage>();
        ArrayList<Warrior> warriorsList = new ArrayList<Warrior>();

        Archer myArcher = new Archer("Archer");
        archersList.add(myArcher);

        Assassin myAssassin = new Assassin("Assassin");
        assassinsList.add(myAssassin);

        Mage myMage = new Mage("Mage");
        magesList.add(myMage);

        Warrior myWarrior = new Warrior("Warrior");
        warriorsList.add(myWarrior);

        Save mySave = new Save(archersList, assassinsList, magesList, warriorsList, 1);

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
