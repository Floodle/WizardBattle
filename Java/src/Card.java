public abstract class  Card {

    int cost;

//implement effect type for passives. Each effect has a type and passives check for effects of a matching type.
    ThrowCatch OppCatch = ThrowCatch.NO_FLAG;
    ThrowCatch PlayerCatch = ThrowCatch.NO_FLAG;
    //1: typical damage spell
    //2: defensive spell
    //3: triggers on removal of counter
    int quickplay;
    int currentCounters;
    int id = 0;
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
