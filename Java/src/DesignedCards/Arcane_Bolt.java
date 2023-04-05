package DesignedCards;


public class Arcane_Bolt extends Card {

    int cost = 3;
    int id = 1;
    int throwPassiveType = 1;

    public Arcane_Bolt(){

    }
    @Override
    public void play(){


    }

    @Override
    public void passive() {

    }

    @Override
    public void cast(){

    }
    public void cast(Player p1, Player p2){
        p2.recieve_damage(6);

    }
}
