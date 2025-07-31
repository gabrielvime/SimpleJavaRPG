package com.gvime.simplerpg;

import java.util.ArrayList;

public class Match {

    /*
    * A MATCH REPRESENTS A COMBAT SCENARIO
    * IT'S MANAGES THE TURN ORDER, THE HEROES AND THE MONSTERS
    * IT ALSO KEEPS TRACK OF THE LOG OF THE MATCH
    * AND THE CURRENT TURN
     */

    private Party heroes;
    private ArrayList<Monster> monsters;
    private int gameLevel;
    private boolean winner;


    public Match(Game game){
        this.heroes = game.getMyParty();
        this.monsters = new ArrayList<>();
        this.gameLevel = game.getGameLevel();
    }

    public void generateMonsters() {
        if (this.gameLevel >= 1 && this.gameLevel <= 9) {
            Monster monster1 = new Monster("Goblin", gameLevel);
            Monster monster2 = new Monster("Orc", gameLevel);
            this.monsters.add(monster1);
            this.monsters.add(monster2);
        }
        else if (this.gameLevel == 10) {
            Monster boss10 = new Boss("King Goblin", gameLevel);
            this.monsters.add(boss10);
        }
        else if (this.gameLevel >= 11 && this.gameLevel <= 19) {
            Monster monster1 = new Monster("Goblin", gameLevel);
            Monster monster2 = new Monster("Hell Hound", gameLevel);
            Monster monster3 = new Monster("Orc", gameLevel);
            this.monsters.add(monster1);
            this.monsters.add(monster2);
            this.monsters.add(monster3);
        }
        else if (this.gameLevel == 20) {
            Monster boss20 = new Boss("King Orc", gameLevel);
            this.monsters.add(boss20);
        }
        else if (this.gameLevel >= 21 && this.gameLevel <= 29) {
            Monster monster1 = new Monster("Goblin", gameLevel);
            Monster monster2 = new Monster("Hell Hound", gameLevel);
            Monster monster3 = new Monster("Orc", gameLevel);
            Monster monster4 = new Monster("Skeleton", gameLevel);
            this.monsters.add(monster1);
            this.monsters.add(monster2);
            this.monsters.add(monster3);
            this.monsters.add(monster4);
        }
        else if (this.gameLevel == 30) {
            Monster boss30 = new Boss("Bigger Hell Hound", gameLevel);
            this.monsters.add(boss30);
        }
        else if (this.gameLevel >= 31 && this.gameLevel <= 39) {
            Monster monster1 = new Monster("Goblin", gameLevel);
            Monster monster2 = new Monster("Orc", gameLevel);
            Monster monster3 = new Monster("Hell Hound", gameLevel);
            Monster monster4 = new Monster("Skeleton", gameLevel);
            Monster monster5 = new Monster("Zombie", gameLevel);
            this.monsters.add(monster1);
            this.monsters.add(monster2);
            this.monsters.add(monster3);
            this.monsters.add(monster4);
            this.monsters.add(monster5);
        }
        else if (this.gameLevel == 40) {
            Monster boss40 = new Boss("Bigger Zombie", gameLevel);
            this.monsters.add(boss40);
        }
        else if (this.gameLevel >= 41 && this.gameLevel <= 49) {
            Monster monster1 = new Monster("Goblin", gameLevel);
            Monster monster2 = new Monster("Orc", gameLevel);
            Monster monster3 = new Monster("Hell Hound", gameLevel);
            Monster monster4 = new Monster("Skeleton", gameLevel);
            Monster monster5 = new Monster("Zombie", gameLevel);
            Monster monster6 = new Monster("Slime", gameLevel);
            this.monsters.add(monster1);
            this.monsters.add(monster2);
            this.monsters.add(monster3);
            this.monsters.add(monster4);
            this.monsters.add(monster5);
            this.monsters.add(monster6);
        }
        else if (this.gameLevel == 50) {
            Monster boss50 = new Boss("Final Boss", gameLevel);
            this.monsters.add(boss50);
        }
    }

    public void startMatch(){

        while (!this.heroes.isEmpty() && !this.monsters.isEmpty()) {
            Log.output("Heroes left: " + this.heroes.getNumHeroes());
            Log.output("Monsters left: " + this.monsters.size());
            Log.output("-----------------------------");
            Turn.heroesTurn(this);
            Turn.monsterTurn(this);
        }
    }

    public boolean matchWinner(){
        return this.heroes.getNumHeroes() > 0 && this.monsters.isEmpty();
    }

    public void matchWinner(boolean flag) {
        this.winner = flag;
        if (flag) {
            Log.output("Heroes win the match!");
        } else {
            Log.output("Monsters win the match!");
        }
    }

    public Party getMyParty() {
        return this.heroes;
    }

    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }


}
