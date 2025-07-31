package com.gvime.simplerpg;

import java.util.ArrayList;

/**
 * PARTY HOLDS THE PLAYER'S HEROES
 * AND ITS ITEMS (ITEMS SHOULD BE IMPLEMENTED LATER)
 * IT ALSO MANAGES THE PARTY, LIKE ADDING OR REMOVING HEROES
 * AND CHECKING IF THE PARTY IS EMPTY.
 */

public class Party {

    private ArrayList<Archer> archers;
    private ArrayList<Assassin> assassins;
    private ArrayList<Mage> mages;
    private ArrayList<Warrior> warriors;


    /** CREATE A PARTY WITH EMPTY HERO LISTS */
    public Party() {
        this.archers = new ArrayList<>();
        this.assassins = new ArrayList<>();
        this.mages = new ArrayList<>();
        this.warriors = new ArrayList<>();
    }

    /** USED WHEN CREATING A PARTY FROM ANOTHER PARTY */
    public Party(Party party) {
        this.archers = new ArrayList<>(party.getArchers());
        this.assassins = new ArrayList<>(party.getAssassins());
        this.mages = new ArrayList<>(party.getMages());
        this.warriors = new ArrayList<>(party.getWarriors());
    }

    /** CREATE A PARTY FROM A SAVE FILE */
    public Party(Save party) {
        this.archers = new ArrayList<>(party.getArchers());
        this.assassins = new ArrayList<>(party.getAssassins());
        this.mages = new ArrayList<>(party.getMages());
        this.warriors = new ArrayList<>(party.getWarriors());
    }

    /** STANDARD PARTY CONSTRUCTOR, GIVING THE HEROES (AND LATER ITEMS) AS PARAMETERS */
    public Party(ArrayList<Archer> archers, ArrayList<Assassin> assassins, ArrayList<Mage> mages, ArrayList<Warrior> warriors) {
        this.archers = archers;
        this.assassins = assassins;
        this.mages = mages;
        this.warriors = warriors;
    }

    /*
     * THERE ARE SETTERS FOR EACH HERO TYPE.
     * AVOID USING THEM DIRECTLY AS
     * THE PARTY MANAGEMENT MUST BE DONE BY
     * ADDING OR REMOVING EACH HERO USING THE
     * addMember() AND removeMember() METHODS
     */

    public void setArchers(ArrayList<Archer> archers) {
        this.archers = archers;
    }

    public void setAssassins(ArrayList<Assassin> assassins) {
        this.assassins = assassins;
    }

    public void setMages(ArrayList<Mage> mages) {
        this.mages = mages;
    }

    public void setWarriors(ArrayList<Warrior> warriors) {
        this.warriors = warriors;
    }

    /*
     * GETTERS FOR EACH HERO TYPE
     */

    public ArrayList<Archer> getArchers() {
        return this.archers;
    }

    public ArrayList<Assassin> getAssassins() {
        return this.assassins;
    }

    public ArrayList<Mage> getMages() {
        return this.mages;
    }

    public ArrayList<Warrior> getWarriors() {
        return this.warriors;
    }

    /*
     * SPECIAL GETTER FOR ITERATING OVER THE PARTY.
     * THIS METHOD RETURNS AN ARRAYLIST OF ALL HEROES
     */
     public ArrayList<Hero> getHeroes(){
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.addAll(archers);
        heroes.addAll(assassins);
        heroes.addAll(mages);
        heroes.addAll(warriors);
        return heroes;
     }

    /*
     * GET HERO BY NAME.
     * THIS MAY RETURN NULL.
     * I WILL IMPLEMENT A TRY CATCH
     * LATER TO HANDLE THIS CASE.
     */

    public Hero getHero(String heroName) {

        for (Archer archer : archers) {
            if (archer.getName().equalsIgnoreCase(heroName)) {
                return archer;
            }
        }
        for (Assassin assassin : assassins) {
            if (assassin.getName().equalsIgnoreCase(heroName)) {
                return assassin;
            }
        }
        for (Mage mage : mages) {
            if (mage.getName().equalsIgnoreCase(heroName)) {
                return mage;
            }
        }
        for (Warrior warrior : warriors) {
            if (warrior.getName().equalsIgnoreCase(heroName)) {
                return warrior;
            }
        }
        // HERO NOT FOUND
        //THIS SHOULD BE HANDLED LATER BY TRY CATCH
        return null;
    }


    /*
     * THERE ARE OVERLOADED addMember() METHODS
     * ONE IS FOR A Hero OBJECT AND
     * THE OTHER IS FOR A HERO NAME.
     * THE SAME IS VALID FOR removeMember().
     * THIS WAY, IS POSSIBLE TO ADD OR REMOVE
     * MEMBERS BY NAME OR BY OBJECT.
     */

    public void addMember(Hero hero) {
        if (hero instanceof Archer) {
            archers.add((Archer) hero);
        } else if (hero instanceof Assassin) {
            assassins.add((Assassin) hero);
        } else if (hero instanceof Mage) {
            mages.add((Mage) hero);
        } else if (hero instanceof Warrior) {
            warriors.add((Warrior) hero);
        }
    }

    public void addMember(String heroName) {
        Hero hero = getHero(heroName);
        this.addMember(hero);
        /* I DON'T WANT TO IMPLEMENT THE
         * SAME CODE AGAIN, SO JUST CALLING
         * addMember(Hero hero) METHOD
         * (MAYBE THERE IS A BETTER WAY TO DO THIS)
         */
    }

    public void removeMember(Hero hero) {
        switch (hero) {
            case Archer archer -> archers.remove(hero);
            case Assassin assassin -> assassins.remove(hero);
            case Mage mage -> mages.remove(hero);
            case Warrior warrior -> warriors.remove(hero);
            case null, default -> System.out.println("Hero not found in party: " + hero.getName());
        }
    }

    public void removeMember(String heroName) {
        Hero hero = getHero(heroName);
        if (hero != null) {
            this.removeMember(hero);
        } else {
            System.out.println("Hero not found: " + heroName);
        }

    }

    /*
     * GETTERS FOR THE NUMBER OF HEROES.
     * THERE ARE GETTERS FOR EACH HERO TYPE
     * AND A GENERAL getNumHeroes() METHOD.
     * ALSO, A EMPTY PARTY CHECKER
     */

    public int getNumArchers() {
        return archers.size();
    }

    public int getNumAssassins() {
        return assassins.size();
    }

    public int getNumMages() {
        return mages.size();
    }

    public int getNumWarriors() {
        return warriors.size();
    }

    public int getNumHeroes() {
        return archers.size() + assassins.size() + mages.size() + warriors.size();
    }

    public boolean isEmpty() {
        return archers.isEmpty() && assassins.isEmpty() && mages.isEmpty() && warriors.isEmpty();
    }

    /*
     * SORT A ARRAYLIST SORTED BY SPEED
     */
    public ArrayList<Hero> getBySpeed() {
        ArrayList<Hero> heroes = getHeroes();
        heroes.sort((h1, h2) -> Double.compare(h2.getSpeed(), h1.getSpeed()));
        return heroes;
    }

}
