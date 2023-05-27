import React, {useEffect, useState} from "react";
import Board from "./Board";
import {getGameData, passTurn, resetGame, login, getGames, joinGame} from "./networkUtil";

export default function Game() {
    const [data, setData] = useState(null);
    const [state, setState] = useState("login");
    const [gameList, setGameList] = useState(null);
    
    useEffect(()=>{
        getGames(setGameList);
        console.log(gameList);
    }, []);

    if(state === "login"){
        return (
            <div>
                <input id={"uname"} type="text"/>
                <button onClick={()=>{login(document.getElementById("uname").value); setState("joinGame");}}>Log in</button>
            </div>
        );
    }

    if(state === "joinGame"){
        
        var buttons = [];

        for(var i = 0; i < gameList.length; i++){
            buttons.push(<button onClick={()=>{joinGame(gameList[i], setState)}}>{gameList[i]}</button>)
        }

        return (
            <div>
                <p>Join a Game</p>
                <p>{buttons}</p>
            </div>
        )    
    }
    
    if(state === "inGame"){
        // return <p>In a game</p>;
        
        if(!data){   // don't cause an infinite loop
            getGameData("Test", setData);
            return <p>Loading...</p>;
        }
        return (
            <div className="App">
                <Board game={data} passTurn={passTurn} update={setData}/>
                <button onClick={()=>{resetGame(setData)}}>reset</button>
            </div>
        );
    }
}