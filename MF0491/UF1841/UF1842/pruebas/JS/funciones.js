'use strict';

window.addEventListener('DOMContentLoaded', function () {

    const celda = document.getElementsByClassName('cuadro')
    let currentPlayer = "X"
    const player1 = [];
    const player2 = [];
    let turno = document.getElementById("turno");
    let finjuego=false;
    if(finjuego){

    }else{
    for (let i = 0; i <= 9; i++) {
        celda[i].addEventListener('click', function () {
                  if (currentPlayer === "X") {
                celda[i].innerHTML = "<img src='img/x.png' alt='x img'>"
                player1.unshift(parseInt(celda[i].id.replace("cell-", "")))
                comprobarGanador(player1,currentPlayer)
                turno.innerText = "Turno Jugador 2 (O)"
                currentPlayer = "O"
            } else {
                celda[i].innerHTML = "<img src='img/O.png' alt='O img'>"
                player2.unshift(parseInt(celda[i].id.replace("cell-", "")))
                comprobarGanador(player2,currentPlayer);
                turno.innerText = "Turno Jugador 1 (X)"
                currentPlayer = "X"
            }
        
        },{once:true})
    }
    }
});


function comprobarGanador(comp,player) {
    const ganador = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ];
    for(let x of ganador){
        if (x.every(item => comp.includes(item))) {
            if(player==="X"){
                alert("EL JUGADOR 1 HA GANADO")
                return true;
            }else{
                alert("EL JUGADOR 2 HA GANADO")
            }
        }
    }
}
