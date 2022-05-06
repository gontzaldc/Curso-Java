'use strict';

window.addEventListener('DOMContentLoaded', function () {
    let numero1=document.getElementById("numero1");
    let numero2=document.getElementById("numero2");
    let operacion=document.getElementById("operacion");
    let boton=document.getElementById("boton")
    let resultado=document.getElementById("resultado")

    boton.addEventListener('click', function(){

        switch(operacion.value){
            case "+":
                resultado.innerText= +numero1.value + (+numero2.value);
                break;
            case "-":
                resultado.innerText= +numero1.value - (+numero2.value);
                break;
            case "*":
                resultado.innerText= +numero1.value * (+numero2.value);
                break;
            case "/":
                resultado.innerText= +numero1.value / (+numero2.value);
                break;
        }
    })

});