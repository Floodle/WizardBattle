public class Generic_Protection extends Passive_Modify_Damage {

    int cost = 2;
    int id = 2;
    ThrowCatch OppCatch = ThrowCatch.DAMAGE;

    public Generic_Protection(){

    }
    @Override
    public void play(){
        currentCounters=cost;
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
        if(answer/2>=currentCounters){
            while(currentCounters>0||answer>0){
                answer-=2;
                currentCounters-=1;
                owner.clock(1);

            }
            if(answer<0){
                answer=0;
            }
        }

        return answer;
    }

    @Override
    public void cast(){

    }
    public void cast(Player p1, Player p2){


    }
}
