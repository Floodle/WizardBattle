export function login(username){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
            username: username
        }),
    }
    fetch("http://localhost:8080/login", requestOptions)
        .then(()=>{
        });
};

export function getGames(setGameList){
    const requestOptions = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    }
    fetch("http://localhost:8080/getGames", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setGameList(gameObject);
        });
};

export function joinGame(game, setState){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
            gameName: game
        }),
    }
    fetch("http://localhost:8080/joinGame", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setState("inGame");
        });
};

export function resetGame(setData){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
    }
    fetch("http://localhost:8080/reset", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setData(gameObject);
        }
    );
};

export function getGameData(username, setData){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
            username: username
        }),
    };
    fetch("http://localhost:8080/getBoardState", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setData(gameObject);
        }
    );
};

export function playCard(username, card, setData){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: username,
            cardID: card.cardID,
        }),
    };
    fetch("http://localhost:8080/playCard", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setData(gameObject);
        });
};

export function passTurn(username, setData){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
            username: username,
        }),
    };
    fetch("http://localhost:8080/passTurn", requestOptions)
        .then((res)=>res.json())
        .then((gameObject)=>{
            setData(gameObject);
        });
}
