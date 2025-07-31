package com.gvime.simplerpg;

import java.util.ArrayList;


public class Save {

    private Party saveParty;
    private int saveLevel;

    /*
     * Constructor for the Save class.
     * This constructor is used to create a save file
     * with the current state of the game.
     */

    public Save(Party gameParty, int gameLevel) {
        this.saveParty = new Party(gameParty);
        this.saveLevel = gameLevel;
    }

    /*
     * THERE ARE NO SETTERS FOR EACH HERO TYPE
     * AS THEY ARE NOT MEANT TO BE MODIFIED
     * DIRECTLY IN THE SAVE FILE BUT RATHER
     * BY Party CLASS.
     */


    /*
     * Update the save file with the current state of the game.
     */

    public void updateSave(Party gameParty, int gameLevel){
        this.saveParty = gameParty;
        this.saveLevel = gameLevel;
    }

    public void updateSave(Save save){
        this.saveParty = save.getSaveParty();
        this.saveLevel = save.getSaveLevel();
    }

    /*
        * Getters for the party members and game level.
        * These methods allow access to the lists of heroes
        * and the current game level.
     */

    public Party getSaveParty() { return this.saveParty; }

    public ArrayList<Archer> getArchers() {
        return this.saveParty.getArchers();
    }

    public ArrayList<Assassin> getAssassins() {
        return this.saveParty.getAssassins();
    }

    public ArrayList<Mage> getMages() {
        return this.saveParty.getMages();
    }

    public ArrayList<Warrior> getWarriors() {
        return this.saveParty.getWarriors();
    }

    public int getSaveLevel() {
        return saveLevel;
    }

}
