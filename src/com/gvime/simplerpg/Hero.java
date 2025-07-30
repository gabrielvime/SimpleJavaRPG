package com.gvime.simplerpg;

public class Hero extends Character{

    private String name;
    private int maxLevel = 100;

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
}
