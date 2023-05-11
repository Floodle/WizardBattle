package ActualCode;

import DesignedCards.Card;
import DesignedCards.Class_Arcane;

public class Player {

    public Owner Player_num;
    public Card Class;
    public int health;
    public int pool;
    public int clock;
    public int manaBurn;

    public Deck player_deck;

    Player(){
        health = 20;
        pool=0;
        clock=0;
        manaBurn=0;
        player_deck = new Deck();
        Class = new Class_Arcane();
        Class.currentCounters=10;
    }

    public void recieve_damage(int num_damage){
        health-=num_damage;
    }

    public void clock(int num){
        manaBurn-=num;
        if(manaBurn<0){
            clock-=manaBurn;
            manaBurn=0;
        }
    }



}
