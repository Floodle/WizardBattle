var player = {
    health: 20,
    mana: 10,
    clock: 0,
    deck: [],
    hand: [],
    field: [],
    discard: []
};

var createNewPlayer = function (){
    var p = {...player};
    p.deck = [];
    p.hand = [];
    p.field = [];
    p.discard = [];
    return p;
}

module.exports = {createNewPlayer};