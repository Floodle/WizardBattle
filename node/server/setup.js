const playerUtil = require("./player.js");
const cardUtil = require("./Card.js");

var lastId = 0;

function setup(game){
    game.id = lastId + 1;
    lastId++;
    
    game.player1 = playerUtil.createNewPlayer();
    game.player2 = playerUtil.createNewPlayer();

    game.player1.hand = [cardUtil.createNewCard("Accelerate"), cardUtil.createNewCard("Lightning_Storm")];
    game.player2.hand = [cardUtil.createNewCard("Decelerate"), cardUtil.createNewCard("Age")];
    game.player1.deck = [cardUtil.createNewCard("Stagger"), cardUtil.createNewCard("Robust_Cast")];
    game.player2.deck = [cardUtil.createNewCard("Spatial_Tear"), cardUtil.createNewCard("Rapid_Cast")];

    return game;
};




module.exports = {setup};