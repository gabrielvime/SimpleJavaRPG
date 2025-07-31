package com.gvime.simplerpg;


public class Game {

    private Party myParty;
    private int gameLevel;
    private boolean gameRunning;

    /*
     * CONSTRUCTOR FOR THE GAME CLASS
     * THIS CONSTRUCTOR IS USED TO CREATE A NEW GAME
     * WITH EMPTY PARTY.
     */

    public Game() {
        this.myParty = new Party();
        this.gameLevel = 1;
    }

    /*
     * INITIALIZE GAME WITH A GIVEN PARTY OF HEROES
     */
    public Game(Save party) {
        this.myParty = new Party(party);
        this.gameLevel = 1;
    }


    public void startGame() {
        this.isRunning(true);

        Log.output("Game started with " + gameLevel + " level and " +
                myParty.getArchers().size() + " archers, " +
                myParty.getAssassins().size() + " assassins, " +
                myParty.getMages().size() + " mages, and " +
                myParty.getWarriors().size() + " warriors.");
    }


    // USED FOR WHILE LOOP
    public boolean isRunning() {
        return this.gameRunning;
    }

    // USED FOR START OR END GAME
    public void isRunning(boolean flag) {
        this.gameRunning = flag;
    }

    public void endGame() {
        Log.output("Game Over");
        this.isRunning(false);
    }

    public Save saveGame() {
        Save mySave = new Save(myParty, gameLevel);
        Log.output("Game saved with " + gameLevel + " level and " +
                myParty.getNumArchers() + " archers, " +
                myParty.getNumAssassins() + " assassins, " +
                myParty.getNumMages() + " mages, and " +
                myParty.getNumWarriors() + " warriors.");
        return mySave;
    }

    public void loadGame(Save savefile) {
        this.myParty = savefile.getSaveParty();
        this.gameLevel = savefile.getSaveLevel();
        Log.output("Game loaded with " + gameLevel + " level and " +
                myParty.getNumArchers() + " archers, " +
                myParty.getNumAssassins() + " assassins, " +
                myParty.getNumMages() + " mages, and " +
                myParty.getNumWarriors() + " warriors.");
    }

    public int getGameLevel() {
        return this.gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public Party getMyParty() {
        return this.myParty;
    }

    public void levelUp(){
        this.gameLevel++;
        for (Hero hero : myParty.getHeroes()) {
            hero.setLevel(hero.getLevel() + 2);
        }
    }



}
