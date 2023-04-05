public class Player {

    Card Class;
    int health;
    int pool;
    int clock;
    int manaBurn;
    Deck player_deck;

    Player(){
        health = 20;
        pool=0;
        clock=0;
        manaBurn=0;
        player_deck = new Deck();
        Class = new Class_Arcane();
        Class.currentCounters=10;
    }

    void recieve_damage(int num_damage){
        health-=num_damage;
    }

    void clock(int num){
        manaBurn-=num;
        if(manaBurn<0){
            clock-=manaBurn;
            manaBurn=0;
        }
    }

}
