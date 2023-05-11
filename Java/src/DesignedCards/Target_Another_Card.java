package DesignedCards;

import ActualCode.Player;

public abstract class Target_Another_Card extends Card {
    //when using this class the first input is the owner of the played card
    //the second input is the owner of the targeted card


    public abstract void play(Player owner, Player victim, int target);

    public abstract void passive(Player owner, Player victim, int target);

    public abstract void cast(Player owner, Player victim, int target);
}
