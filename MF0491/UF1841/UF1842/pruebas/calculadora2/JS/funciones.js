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

            if (isNaN(+botones[i].textContent)) {
                operacion=botones[i].textContent;
                numero=parseInt(numero,10);
                console.log()

                switch(botones[i].textContent){
                    case "=":

                        break;
                    case "+":
                        resultado+=numero;
                        pantalla.value=resultado;
                        break;
                    case "*":
                        resultado*=numero;
                        pantalla.value=resultado;
                        break;
                    case "/":
                            resultado/=numero;
                            pantalla.value=resultado;
                            break;
                    case "-":
                        resultado-=numero;
                        pantalla.value=resultado;
                        break;
                    case ",":
                        if(numero.includes(",")){
                            
                        }

                }
            }
            else{
                numero=0;
                numero+=botones[i].textContent;
                pantalla.value=+numero;
                console.log(numero)
            }
        });

    }
});