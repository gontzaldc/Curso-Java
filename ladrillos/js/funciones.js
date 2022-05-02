'use strick';

let teclaPulsada, tabla;
let posLeft=0;

var ballRadius = 10;

window.addEventListener('DOMContentLoaded', function(){
    tabla=document.getElementById('tabla');
    

});

document.addEventListener('keydown', function(e){
    console.log(e);

    teclaPulsada=e.key;

    switch(teclaPulsada){

        case 'ArrowRight':
            console.log('right')
            tabla.style.marginLeft  = (posLeft+4)+"px";
            posLeft+=4;
        break;
        case 'ArrowLeft':
            console.log('left')
            tabla.style.marginLeft  = (posLeft-4)+"px";
            posLeft-=4;
        break;
    }
});

function moverDerecha(){

    
}