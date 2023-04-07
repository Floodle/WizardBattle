import {getCardByID, getCardByName, getCardTypeCount} from './Card.js';
import { createPlayer} from './PlayerData';

var player1 = createPlayer();
var player2 = createPlayer();

export default function Game() {
    var out = [];

    out.push(<p>{"Mana Pool: " + player2.pool + " | Clock: " + player2.clock + " | Health: " + player2.health}</p>);
    for(var i = 0; i < 5; i++){
        out.push(getCardByID(i));
    }
    out.push(<br></br>);
    for(var i = 0; i < 5; i++){
        out.push(getCardByName("Accelerate"));
    }
    out.push(<br/>);
    out.push(<p>{"Mana Pool: " + player1.pool + " | Clock: " + player1.clock + " | Health: " + player1.health}</p>);
    for(var i = 0; i < 5; i++){
        out.push(getCardByName(player1.getHand()[i]));
    }
    return <div>{out}</div>;
}  

