package DesignedCards;

import ActualCode.Player;
import ActualCode.ThrowCatch;

public class Shock extends Card {





    public Shock(){

    }
    @Override
    public void play(){
        cost = 1;
        currentCounters=cost;
        id = 3;
    }
    @Override
    public void play(Player p1, Player p2){
        p1.manaBurn+=1;
        currentCounters+=1;

    }

    @Override
    public void passive() {

    }
    @Override
    public void passive(Player p1, Player p2){

    }

    @Override
    public void cast(){

    }
    public void cast(Player p1, Player p2){
        int base_damage=2;
        for (Card c: p1.player_deck.field) {
            if(c.PlayerCatch== ThrowCatch.DAMAGE){
                base_damage = ((Passive_Modify_Damage) c).passive(base_damage, p1);
            }

        }

        for (Card c: p2.player_deck.field) {
            if(c.OppCatch== ThrowCatch.DAMAGE){
                base_damage = ((Passive_Modify_Damage) c).passive(base_damage, p2);
            }

        }

        p2.recieve_damage(base_damage);

    }
}
