package DesignedCards;

import ActualCode.Player;
import ActualCode.ThrowCatch;

public class Heated_Casting extends Passive_Modify_Damage {

    public Heated_Casting(){

    }
    @Override
    public void play(){
        cost = 3;
        id = 6;
        currentCounters=cost;
        PlayerCatch = ThrowCatch.DAMAGE;
    }

    @Override
    public void play(Player p1, Player p2){

    }

    @Override
    public void passive(){

    }
    @Override
    public void passive(Player p1, Player p2){

    }

    @Override
    public int passive(int input, Player owner){
        int answer = input;
        answer += 2;
        return answer;
    }

    @Override
    public void cast(){

    }
    public void cast(Player p1, Player p2){


    }
}
