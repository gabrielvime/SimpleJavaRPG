package com.gvime.simplerpg;

public class Hero extends Character{

    private String name;
    private final int maxLevel = 100; //LEVEL CAP

    //ALL HEROES MUST HAVE A NAME

    //RANDOM HERO
    public Hero(String name){
        super();
        this.name = name;
    }

    //STATED HERO
    public Hero(String name, int lv, double hp, double att, double def, double spe, double eva, double critChance){
        super(lv, hp, att, def, spe, eva, critChance);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

//    public int getMaxLevel() {
//        return this.maxLevel;
//    }

    public void setName(String name) {
        this.name = name;
    }

}
