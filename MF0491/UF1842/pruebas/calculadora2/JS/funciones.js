'use strict';

window.addEventListener('DOMContentLoaded', function () {
    let botones = document.getElementsByTagName('button');
    let numero=0 , resultado=0;
    let operacion;
    let pantalla= document.getElementById("pantalla")
    console.log(botones.length)
    //inicializar los botones
    for (let i = 0; i < botones.length; i++) {
        botones[i].addEventListener('click', function () {
            if (isNaN(+this.innerText)) {
                numero=parseInt(numero,10);
                operaciones(botones[i])
            }   
            else{
                numero+=this.textContent;
                pantalla.value=+numero;
            }
        });

    }

    function operaciones(valorBoton){
    switch(valorBoton.textContent){
        case "=":
            operaciones(operacion)
            break;
        case "+":
            resultado+=numero;
            operacion=valorBoton;
            break;
        case "*":
            resultado*=numero;
            break;
        case "/":
            resultado/=numero;
            break;
        case "-":
            resultado-=numero;
            break;
    }
    
    pantalla.value=resultado;
}
});