var player = {
    deck: [], 
    hand: ["Accelerate","Aegis","Accelerate","Lightning_bolt","Accelerate",], 
    field: [],
    class: null,
    pool: 5,
    health: 20,
    clock: 1,
    playCard: function(indexOfCardInHand){
        hand[indexOfCardInHand].counters = hand[indexOfCardInHand].cost;
    },
    getHand: function (){
        return this.hand;
    }
}; 

export function createPlayer(){
    return Object.create(player);
}

