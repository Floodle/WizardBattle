package DesignedCards;

import ActualCode.Player;
import ActualCode.ThrowCatch;

public class Counterspell extends Target_Another_Card {

    public Counterspell(){

    }
    @Override
    public void play(){
        cost = 3;
        id = 7;
        currentCounters=cost;

    }

    @Override
    public void play(Player p1, Player p2){

    }

    @Override
    public void play(Player owner, Player victim, int target) {
        boolean do_effect = true;

        if(owner.Player_num!=victim.Player_num){
            for (Card c: owner.player_deck.field) {
                if(c.PlayerCatch== ThrowCatch.TARGET_OPP){
                    c.passive();
                }

            }

            for (Card c: owner.player_deck.field) {
                if(c.PlayerCatch== ThrowCatch.TARGET_SELF){
                    c.passive();
                }

            }


        } else {

            for (Card c: owner.player_deck.field) {
                if(c.PlayerCatch== ThrowCatch.TARGET_OPP){
                    c.passive();
                }

            }

            for (Card c: victim.player_deck.field) {
                if(c.OppCatch== ThrowCatch.TARGET_OPP){
                    c.passive();
                }

            }





        }

        if(do_effect){

            victim.clock(victim.player_deck.field.get(target).currentCounters);
            victim.player_deck.field.get(target).currentCounters = 0;
            victim.player_deck.field_to_discard(target);

        }


    }

    @Override
    public void passive(){

    }
    @Override
    public void passive(Player p1, Player p2){

    }
    @Override
    public void passive(Player owner, Player victim, int target) {

    }


    @Override
    public void cast(){

    }
    public void cast(Player p1, Player p2){


    }

    @Override
    public void cast(Player owner, Player victim, int target) {

    }
}
