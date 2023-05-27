var cardNames = ["Accelerate", "Aegis", "Age", "Arcane_bolt", "Arcane_short", "Casting_Blitz", 
    "Change_Priorities", "Charged_Field", "Chilled_Casting", "Counterspell", "Decay", "Decelerate",
    "Defensive_Portal", "Disorienting_Shift", "Fireblast", "Forceful_casting", "Heated_Casting", 
    "Ignite_spell", "Illusion", "Kinetic_blast", "Lightbeam", "Lightning_bolt", "Lightning_Storm", 
    "Mana_Ground", "Mana_siphon", "Plated_Shield", "Rapid_Cast", "Reactive_Barrier", "Redirect", 
    "Robust_Cast", "Spatial_Tear", "Spelltrick", "Stagger", "Stasis", "Supressing_Aura"];

var cardCosts = [3,5,2,3,2,2,2,3,2,3,5,3,8,4,6,1,3,4,2,2,1,8,3,2,6,3,3,4,7,2,2,3,3,0,4];
var id = 0;

var card = {
    cardName: "",
    cardID: null,
    cost: 0,
    counters: 0,
    cast: ()=>{},
    play: ()=>{},
    removeCounter: ()=>{
        return ()=>{alert(0)};
    },
    outgoingDamageMod: (damage)=>{return damage},
    incomingDamageMod: (damage)=>{return damage}
};

function createNewCard(name){
    var c = {...card};
    var index = cardNames.indexOf(name);
    c.cardName = name;
    c.cardID = id+1;
    c.cost = cardCosts[index];
    id+=1;
    return c;
}

module.exports = {cardNames, cardCosts, card, createNewCard};