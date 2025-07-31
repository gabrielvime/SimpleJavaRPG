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
        System.out.println("TA FUNCIONANDO");

        this.isRunning(true);

        System.out.println("Game started with " + gameLevel + " level and " +
                myParty.getArchers().size() + " archers, " +
                myParty.getAssassins().size() + " assassins, " +
                myParty.getMages().size() + " mages, and " +
                myParty.getWarriors().size() + " warriors.");

        int choice = 1;
        while (choice != 0) {
            System.out.println("Game is running...");
            System.out.println("Enter 0 to end the game.");
            choice = Utils.getInput().nextInt();
        }
        this.endGame();

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
        System.out.println("Game Over");
        this.isRunning(false);
    }

    public Save saveGame() {
        Save mySave = new Save(myParty, gameLevel);
        System.out.println("Game saved with " + gameLevel + " level and " +
                myParty.getNumArchers() + " archers, " +
                myParty.getNumAssassins() + " assassins, " +
                myParty.getNumMages() + " mages, and " +
                myParty.getNumWarriors() + " warriors.");
        return mySave;
    }

    public void loadGame(Save savefile) {
        this.myParty = savefile.getSaveParty();
        this.gameLevel = savefile.getSaveLevel();
        System.out.println("Game loaded with " + gameLevel + " level and " +
                myParty.getNumArchers() + " archers, " +
                myParty.getNumAssassins() + " assassins, " +
                myParty.getNumMages() + " mages, and " +
                myParty.getNumWarriors() + " warriors.");
    }



}
