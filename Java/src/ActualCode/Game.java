package ActualCode;

import DesignedCards.Card;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Player player1;
    public Player player2;

    int turn = 0;
    //odd = p1
    //even = p2


    Game(){

    }

    Game(Player p1, Player p2){
        player1=p1;
        p1.Player_num=Owner.PLAYER_1;
        player2=p2;
        p2.Player_num=Owner.PLAYER_2;
    }

    void startTurn(){
        turn++;
        //determine turn
        Player current_Player;
        Player other_Player;
        if(turn%2 == 0){
            current_Player=player2;
            other_Player = player1;
        } else{
            current_Player=player1;
            other_Player = player2;
        }
        //removing counters and adding to clock
        if(current_Player.Class.currentCounters>0) {
            current_Player.Class.currentCounters -= 1;
            current_Player.clock(1);
        }

        for (Card c:current_Player.player_deck.field) {
            c.currentCounters -= 1;
            current_Player.clock(1);
        }
        List<Integer> indexes = new ArrayList<>();
        //triggers effects
        for (Card c:current_Player.player_deck.field) {
            //checks for passives that care about removing counters
            if(c.PlayerCatch== ThrowCatch.COUNTER_REMOVE){
                c.passive(current_Player, other_Player);
            }
            if(c.currentCounters==0||c.currentCounters==c.quickplay){
                //effect is going off
                indexes.add(current_Player.player_deck.field.indexOf(c));
            }
        }
        //ordering of triggers happens here
        for(int i = indexes.size()-1; i>=0; i--){
            current_Player.player_deck.field.get(indexes.get(i)).cast(current_Player, other_Player);
            current_Player.player_deck.field_to_discard(indexes.get(i));
        }



        //adds clocked mana to pool
        current_Player.pool +=current_Player.clock;
        current_Player.clock=0;

        //draw step
        current_Player.player_deck.draw();

        //manaBurn step


        if(turn%2 == 0){
            player2=current_Player;
            player1 = other_Player;
        } else{
            player1=current_Player;
            player2 = other_Player;
        }
    }

    //playing from hand
    void play_card(int index){
        Player current_Player;
        Player other_Player;
        if(turn%2 == 0){
            current_Player=player2;
            other_Player = player1;
        } else{
            current_Player=player1;
            other_Player = player2;
        }
        current_Player.player_deck.hand.get(index).play();
        current_Player.player_deck.hand.get(index).play(current_Player, other_Player);

        current_Player.pool -=current_Player.player_deck.hand.get(index).getCost();
        current_Player.player_deck.play_from_hand(index);



        if(turn%2 == 0){
            player2=current_Player;
            player1 = other_Player;
        } else{
            player1=current_Player;
            player2 = other_Player;
        }

    }

    void play_card(int index, int target, int victim){
        //needs to be implemented to take input and play card with selected target.

        //victim == 1 means current player
        //victim == 2 means other player
        Player current_Player;
        Player other_Player;
        if(turn%2 == 0){
            current_Player=player2;
            other_Player = player1;
        } else{
            current_Player=player1;
            other_Player = player2;
        }




        current_Player.player_deck.hand.get(index).play();

        current_Player.player_deck.hand.get(index).play(current_Player, other_Player);

        current_Player.pool -=current_Player.player_deck.hand.get(index).getCost();

        current_Player.player_deck.play_from_hand(index);



        if(turn%2 == 0){
            player2=current_Player;
            player1 = other_Player;
        } else{
            player1=current_Player;
            player2 = other_Player;
        }

    }

    void passTurn(){

    }


}
