// Obliga a declarar variables 
'use strict';

// Crear funcion 
// Ejemplos de alert, confirm, prompt...
function interaccion() {

    alert("alerta");

    // Const -> Constante, no se puede cambiar su valor
    // var declara en todo el documento / let declara a partir de donde se crea
    const SiONo = confirm("Confirmación");

    console.log('Respuesta del usuario: ', SiONo);
    console.log(typeof SiONo);

    const nombre = prompt("Cómo te llamas?");
    console.log('Has introducido ' + nombre);


}

function conversiones() {
    let numero = 5;

    numero = prompt('Introduce un numero');

    // convertir el numero
    numero = +numero;// numero=parseInt(numero);

    console.log("el número vale ", numero + 10);

    //convierte en numero diractamente antes de recibir con el + delante
    const numerador = +prompt('Dime un numero');

    //convertir a string ''+number o .toString
    console.log(numerador.toString);

    // Convertir a Booolean !!
    console.log(!!numerador);
}

function sentenciasControl() {
    //Condicionales
    const confirmar = confirm('Estas Seguiro?');
    if (confirmar) {
        console.log('Seguro');
    } else {
        console.log('No Seguro');
    }
    
}


