package DesignedCards;

import ActualCode.Player;
import ActualCode.ThrowCatch;

public abstract class Card {

    public int cost;

//implement effect type for passives. Each effect has a type and passives check for effects of a matching type.
    public ThrowCatch OppCatch = ThrowCatch.NO_FLAG;
    public ThrowCatch PlayerCatch = ThrowCatch.NO_FLAG;
    //1: typical damage spell
    //2: defensive spell
    //3: triggers on removal of counter
    public int quickplay;
    public int currentCounters;
    public int id;
    public abstract void play();

    public abstract void play(Player p1, Player p2);

    public abstract void passive();

    public abstract void passive(Player p1, Player p2);

    public abstract void cast();

    public abstract void cast(Player p1, Player p2);

    public int getCost(){
        return cost;
    }

}
