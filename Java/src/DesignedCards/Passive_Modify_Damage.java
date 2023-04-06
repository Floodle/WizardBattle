package DesignedCards;

import ActualCode.Player;
import DesignedCards.Card;

public abstract class Passive_Modify_Damage extends Card {

    public abstract int passive(int input, Player owner);
}
