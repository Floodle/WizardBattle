package DesignedCards;
import ActualCode.Player;
import ActualCode.ThrowCatch;

public class Arcane_Bolt extends Card {





    public Arcane_Bolt(){

    }
    @Override
    public void play(){
        cost = 3;
        currentCounters=cost;
        id = 1;
    }
    @Override
    public void play(Player p1, Player p2){

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
        int base_damage=6;
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
