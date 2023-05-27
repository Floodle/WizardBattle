import {Card, FieldCard} from "./Card";
import React from "react";
import {playCard} from "./networkUtil.js"

var updateFunct;

export default function board({game, passTurn, update}){
    updateFunct = update;

    if(!game) return null;

    return (
        <div>
        <p>Player {game.currTurn %2 + 1}'s Turn</p>
            <Hand hand={game.player1.hand}/>
            <PlayerStats player={game.player1}/>
            <Field field={game.player1.field}/>
            <Field field={game.player2.field}/>
            <PlayerStats player={game.player2}/>
            <button onClick={()=>{passTurn("Test", update)}}>Pass Turn</button>
            <Hand hand={game.player2.hand}/>
        </div>
    );
};

function Hand({hand}){
    var handImgs = [];
    hand.forEach(element => {
        handImgs.push(<Card name={element.cardName} click={()=>{playCard("Test", element, updateFunct)}}/>);
    });
    return <p>{handImgs}</p>
};

function Field({field}){
    var fieldImgs = [];
    field.forEach(element => {
        fieldImgs.push(<FieldCard name={element.cardName}/>);
    });
    return <p>{fieldImgs}</p>
};

function PlayerStats({player}){
    var line = 
    "Health: " + JSON.stringify(player.health) + 
    " | Mana: " + JSON.stringify(player.mana) + 
    " | Clock: " + JSON.stringify(player.clock);
    return (<div>{line}</div>);
};