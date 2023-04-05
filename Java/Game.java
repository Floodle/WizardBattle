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
        player2=p2;
    }

    void startTurn(){
        turn++;
        //determine turn
        Player current_Player;
        if(turn%2 == 0){
            current_Player=player2;
        } else{
            current_Player=player1;
        }
        //removing counters and adding to clock
        current_Player.Class.currentCounters-=1;
        for (Card c:current_Player.player_deck.field) {
            c.currentCounters -= 1;
            current_Player.clock(1);
        }

        //triggers effects
        for (Card c:current_Player.player_deck.field) {
            //checks for passives that care about removing counters
            if(c.throwPassiveType==3){
                c.passive();
            }
            if(c.currentCounters==0||c.currentCounters==c.quickplay){
                //effect is going off
                c.cast(player1, player2);
            }
        }

        //adds clocked mana to pool
        current_Player.pool +=current_Player.clock;

        //draw step
        current_Player.player_deck.draw();

        //manaBurn step

    }

    void passTurn(){

    }


}
