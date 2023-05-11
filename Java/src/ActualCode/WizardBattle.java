package ActualCode;

import ActualCode.Deck;
import ActualCode.Game;
import ActualCode.Player;

public class WizardBattle {

    public static void main(String[] args) {

        Game g = new Game(new Player(), new Player());
        g.player2.player_deck = new Deck(2);
        //1
        g.startTurn();
        g.startTurn();
        //2
        g.startTurn();
        g.startTurn();
        //3
        g.startTurn();
        g.play_card(0);
        g.startTurn();
        //4
        g.startTurn();
        g.startTurn();
        //5
        g.startTurn();
        g.startTurn();
        g.play_card(0);
        //6
        g.startTurn();
        g.startTurn();
        //7
        g.startTurn();
        g.startTurn();
        //8
        g.startTurn();
        g.startTurn();
        //9
        g.startTurn();
        g.startTurn();
        //10
        g.startTurn();
        g.startTurn();



    }

    
}

