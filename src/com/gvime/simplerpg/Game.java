package com.gvime.simplerpg;
import java.util.ArrayList;


public class Game {

    private ArrayList<Archer> archers;
    private ArrayList<Assassin> assassins;
    private ArrayList<Mage> mages;
    private ArrayList<Warrior> warriors;
    private int gameLevel;
    private boolean gameRunning;

    /*
     * CONSTRUCTOR FOR THE GAME CLASS
     * THIS CONSTRUCTOR IS USED TO CREATE A NEW GAME
     * WITH EMPTY HERO LISTS.
     */
    public Game() {
        this.archers = new ArrayList<>();
        this.assassins = new ArrayList<>();
        this.mages = new ArrayList<>();
        this.warriors = new ArrayList<>();
        this.gameLevel = 1;
    }

    /*
     * INITIALIZE GAME WITH A GIVEN PARTY OF HEROES
     */
    public Game(Save party) {
        this.archers = new ArrayList<>();
        this.assassins = new ArrayList<>();
        this.mages = new ArrayList<>();
        this.warriors = new ArrayList<>();
        this.gameLevel = 1;

        this.archers.addAll(party.getArchers());
        this.assassins.addAll(party.getAssassins());
        this.mages.addAll(party.getMages());
        this.warriors.addAll(party.getWarriors());
    }


    public void startGame() {
        System.out.println("TA FUNCIONANDO");

        this.isRunning(true);

        System.out.println("Game started with " + gameLevel + " level and " +
                archers.size() + " archers, " +
                assassins.size() + " assassins, " +
                mages.size() + " mages, and " +
                warriors.size() + " warriors.");

        //Scanner input = new Scanner(System.in);
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
        Save mySave = new Save(archers, assassins, mages, warriors, gameLevel);
        System.out.println("Game saved with " + mySave.getGameLevel() + " level and " +
                mySave.getArchers().size() + " archers, " +
                mySave.getAssassins().size() + " assassins, " +
                mySave.getMages().size() + " mages, and " +
                mySave.getWarriors().size() + " warriors.");

        return mySave;
    }

    public void loadGame(Save savefile) {
        this.archers = savefile.getArchers();
        this.assassins = savefile.getAssassins();
        this.mages = savefile.getMages();
        this.warriors = savefile.getWarriors();
        this.gameLevel = savefile.getGameLevel();
        System.out.println("Game loaded with " + gameLevel + " level and " +
                archers.size() + " archers, " +
                assassins.size() + " assassins, " +
                mages.size() + " mages, and " +
                warriors.size() + " warriors.");
    }



}
