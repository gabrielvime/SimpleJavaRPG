package com.gvime.simplerpg;

import java.util.ArrayList;

public class Save {

//    private static int archerCount;
//    private static int assassinCount;
//    private static int mageCount;
//    private static int warriorCount;
    private ArrayList<Archer> archers;
    private ArrayList<Assassin> assassins;
    private ArrayList<Mage> mages;
    private ArrayList<Warrior> warriors;
    private int gameLevel;

    /*
        * Constructor for the Save class.
        * This constructor is used to create a save file
        * with the current state of the game.
     */
    public Save(ArrayList<Archer> archers, ArrayList<Assassin> assassins, ArrayList<Mage> mages, ArrayList<Warrior> warriors, int gameLevel) {
        this.archers = archers;
        this.assassins = assassins;
        this.mages = mages;
        this.warriors = warriors;
        this.gameLevel = gameLevel;
    }

    /*
     * THERE ARE NO SETTERS FOR EACH HERO TYPE
     * AS THEY ARE NOT MEANT TO BE MODIFIED
     * DIRECTLY IN THE SAVE FILE BUT RATHER
     * BY GAME CLASS.
     */
    public void updateSave(ArrayList<Archer> archers, ArrayList<Assassin> assassins, ArrayList<Mage> mages, ArrayList<Warrior> warriors, int gameLevel){
        this.archers = archers;
        this.assassins = assassins;
        this.mages = mages;
        this.warriors = warriors;
        this.gameLevel = gameLevel;
    };

    /*
        * Update the save file with the current state of the game.
     */
    public void updateSave(Save save){
        this.archers = save.getArchers();
        this.assassins = save.getAssassins();
        this.mages = save.getMages();
        this.warriors = save.getWarriors();
        this.gameLevel = save.getGameLevel();
    }

    /*
        * Getters for the party members and game level.
        * These methods allow access to the lists of heroes
        * and the current game level.
     */

    public ArrayList<Archer> getArchers() {
        return  archers;
    }

    public ArrayList<Assassin> getAssassins() {
        return assassins;
    }

    public ArrayList<Mage> getMages() {
        return mages;
    }

    public ArrayList<Warrior> getWarriors() {
        return warriors;
    }

    public int getGameLevel() {
        return gameLevel;
    }

}
