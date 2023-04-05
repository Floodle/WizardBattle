public class Class_Arcane extends Card {

    int cost = 10;
    int id = 3;



    public Class_Arcane(){

    }
    @Override
    public void play(){
        //deal 6 damage to opponent

    }

    @Override
    public void passive() {

    }

    @Override
    public void cast(){
        currentCounters+=3;
    }

    public void active(){

    }
    @Override
    public void cast(Player p1, Player p2){
        p2.recieve_damage(2);

    }
}
