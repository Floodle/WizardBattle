const gameTemplate = require("./game.js");
const setup = require("./setup.js");
const express = require("express");
const sessions = require('express-session');
const cors = require("cors");
const cookieParser = require("cookie-parser");
const PORT = 8080;
const app = express();

var session;
var games = {"Test": setup.setup({...gameTemplate.game})};
var game = setup.setup({...gameTemplate.game});
app.use(cookieParser());
app.use(cors());
app.use(express.json());

const oneDay = 1000 * 60 * 60 * 24;
app.use(sessions({
    secret: "thisismysecrctekeyfhrgfgrfrty84fwir767",
    saveUninitialized:true,
    cookie: { maxAge: oneDay },
    resave: false
}));
app.use(function(req, res, next) {
    res.header('Content-Type', 'application/json;charset=UTF-8')
    res.header('Access-Control-Allow-Credentials', true)
    res.header(
      'Access-Control-Allow-Headers',
      'Origin, X-Requested-With, Content-Type, Accept'
    )
    next()
});

app.post("/login", (req, res)=>{
    session = req.session;
    session.userid = req.body.username;
    console.log(req.session);
    res.send();
});

app.get("/getGames",  (req, res)=>{
    res.send(Object.keys(games));
});

app.post("/joinGame", (req, res)=>{
    console.log(session.userid + " has joined the game " + req.session.userid);
});

app.post("/reset", (req, res)=>{
    game = setup.setup({...gameTemplate.game});
    returnGame(res);
});

app.post("/getBoardState", (req, res) => {
    let data = req.body.message;
    returnGame(res);
});

app.post("/playCard", (req, res) => {
    let data = req.body.cardID;
    var removed = -1;
    console.log(game.currTurn);
    
    var p;
    if(game.currTurn == 1){
        p = game.player1;
    }else {
        p = game.player2;
    }
    for(var i = 0; i < p.hand.length; i++){
        if(p.hand[i].cardID == data){
            removed = p.hand[i].cardID;
            playCard(p, p.hand[i]);
            console.log("Player 1 has attempted to play card ID " + data);
        }
    };
    returnGame(res);
});

app.post("/passTurn", (req, res) => {
    let data = req.body.username;
    game.currTurn = (game.currTurn % 2) + 1;    // swap turn #
    console.log("Current turn: " + game.currTurn);

    // remove counters from all cards
    // put counters in clock
    // order triggers
    // activate triggers
    // remove any cards with no counters
    // move clock to pool
    // draw a card
    // add manaburn
    var p;
    if(game.currTurn == 1){
        p = game.player1;
    } else {
        p = game.player2;
    }

    var triggers = [];

    for(var i = 0; i < p.field.length; i++){
        p.field[i].counters--;
        triggers.push(p.field[i].removeCounter);
        p.clock++;
    }

    for(var i = 0; i < triggers.length; i++){
        triggers[i]();
    }

    for(var i = 0; i < p.field.length; i++){
        console.log(i + ": " + p.field[i].counters);
        if(p.field[i].counters <= 0){
            p.field.splice(i, 1);
            i--;
        }
    }

    p.mana += p.clock;
    p.clock = 0;

    if(p.deck.length >= 1){
        p.hand.push(p.deck.pop());
    }

    returnGame(res);
});

app.listen(PORT, () => {
    console.log(`Server listening on ${PORT}`);
});


function playCard(player, card){
    if(player.mana >= card.cost){
        card.counters = card.cost;
        player.field.push(card);
        player.hand.splice(player.hand.indexOf(card), 1);
        player.mana -= card.cost;
    }
}

function returnGame(res){
    res.send(JSON.stringify({...game}));
}