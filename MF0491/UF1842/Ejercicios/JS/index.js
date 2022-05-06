'use strict';

window.addEventListener('DOMContentLoaded', function () {

});

// Ejercicio 1
// Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y 
// con un salto de línea entre cada impresión), sustituyendo los siguientes:
//   - Múltiplos de 3 por la palabra "fizz".
//   - Múltiplos de 5 por la palabra "buzz".
//   - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".

function ejercicio1() {

    for (let i = 1; i <= 100; i++) {
        if (i % 3 === 0) {
            console.log("fizz")
        }
        else if (i % 5 === 0) {
            console.log("buzz")
        }
        else if (i % 3 === 0 && i % 5 === 5) {
            console.log("fizzbuzz")
        }
        else {
            console.log(i);
        }
    }

}

// Ejercicio 2
// Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci 
// empezando en 0.
//   La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la 
//   suma de los dos anteriores.
//       0, 1, 1, 2, 3, 5, 8, 13...

function ejercicio2() {


    let n1 = 0, n2 = 1, fib = 0;
    for (let i = 0; n1 < 50; i++) {

        console.log(n1)

        fib = n1 + n2;
        n1 = n2;
        n2 = fib;
    }
}


// Ejercicio 3
// Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
// Hecho esto, imprime los números primos entre 1 y 100.

function ejercicio3() {

    for (let i = 0; i < 100; i++) {
        let primo = true;
        for (let j = 2; j < i; j++) {
            if (i % j == 0) {
                primo = false;
                break;
            }
        }
        if (primo) {
            console.log(i);
        }
    }
}

//  Ejercicio 4
//  Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y 
//  retornar el área de un polígono.
//      - La función recibirá por parámetro sólo UN polígono a la vez.
//      - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
//      - Imprime el cálculo del área de un polígono de cada tipo.

function ejercicio4(poligono, base, altura) {

    let area;

    if (poligono == "triangulo") {

        area = (base * altura) / 2;
        return 'El área del Triángulo es ' + area;
    }

    if (poligono == "cuadrado") {

        if (base != altura) {
            return 'Los cuadrados tienen la misma base y altura'
        }
        area = base * altura;
        return 'El área del Cuadrado es ' + area;
    }

    if (poligono == "rectangulo") {

        area = base * altura;
        return 'El área del Rectangulo es ' + area;
    }
}


//  Ejercicio 5
//  Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
//  - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
//  - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.

function ejercicio5() {

}


//  Ejercicio 6
//  Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del 
//  lenguaje que lo hagan de forma automática.
//   - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"

function ejercicio6(palabra) {
    const Arr = [];
    for (let i = 0; i < palabra.length; i++) {
        Arr.unshift(palabra[i])
    }

    const withoutCommas = Arr.join('');
    return withoutCommas
}

//  Ejercicio 7
//  Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el 
//  recuento final de todas ellas.
//   - Los signos de puntuación no forman parte de la palabra.
//   - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
//   - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.

function ejercicio7(texto) {


}

//  Ejercicio 8
//  Enunciado: Crea un programa se encargue de transformar un número decimal a binario 
//  sin utilizar funciones propias del lenguaje que lo hagan directamente.

function ejercicio8() {


}

//  Ejercicio 9
//  Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
//   - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
//   - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre 
//     palabras "  ".
//   - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.

function ejercicio9(texto) {

    const morseCode = {
        "A": ".-",
        "B": "-...",
        "C": "-.-.",
        "D": "-..",
        "E": ".",
        "F": "..-.",
        "G": "--.",
        "H": "....",
        "I": "..",
        "J": ".---",
        "K": "-.-",
        "L": ".-..",
        "M": "--",
        "N": "-.",
        "O": "---",
        "P": ".--.",
        "Q": "--.-",
        "R": ".-.",
        "S": "...",
        "T": "-",
        "U": "..-",
        "W": ".--",
        "X": "-..-",
        "Y": "-.--",
        "Z": "--..",
        " ": "/"

    }

    let morse = "";

    for (let i = 0; i < texto.length; i++) {
        morse += morseCode[texto[i].toUpperCase()] + " ";
    }

    return morse;
}

//  Ejercicio 10
// Enunciado:Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
//   - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
//   - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
//   - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
//   - Expresión no balanceada: { a * ( c + d ) ] - 5 }

function ejercicio10(expresion) {
    const regex = /\{.*\[.*\(.*\).*\].*\}/;

    return regex.test(expresion) ? 'Expresión Balanceada' : 'Expresión no Balanceada';
}

//  Ejercicio 11
//  Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras 
//             dos cadenas como salida (out1, out2).
//     - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
//     - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.

function ejercicio11(str1, str2) {

    str1 = str1.toUpperCase();
    str2 = str2.toUpperCase();

    let frase1 = str1.split(" ");
    let frase2 = str2.split(" ");
    let out1 = "", out2 = "";

    console.log(frase1);

    for (let i = 0; i < frase1.length; i++) {

        if (!frase2.includes(frase1[i])) {
            out1 += " " + frase1[i]
        }
    }

    for (let i = 0; i < frase2.length; i++) {

        if (!frase1.includes(frase2[i])) {
            out2 += " " + frase2[i]
        }
    }


    console.log('Palabras de str1 que no estan en str2 ->' + out1)
    console.log('Palabras de str2 que no estan en str1 ->' + out2)

}

//  Ejercicio 12
//  Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) 
//             según sean o no palíndromos.
//  Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de 
//  derecha a izquierda.
//  NO se tienen en cuenta los espacios, signos de puntuación y tildes.
//  Ejemplo: Ana lleva al oso la avellana.

function ejercicio12(frase) {

    let texto;

    frase = frase.replace(/\W|\_/g, '')
    texto = frase.toUpperCase();
    const arrInversa = [];

    for (let i = 0; i < texto.length; i++) {

        arrInversa.unshift(texto[i]);
    }

    const fraseInversa = arrInversa.join('');

    return fraseInversa === texto ? 'Palíndroma' : 'NO Palíndroma';
}

//  Ejercicio 13
//  Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.

function ejercicio13(num, cal) {
    if (!isNaN(cal)) {
        if (cal === 1) {
            console.log(num)
            return num
        }
        else {
            ejercicio13(num *= cal - 1, --cal)
        }

    }
    else {
        cal = num;
        ejercicio13(num, cal)
    }
}

//  Ejercicio 14
//  Enunciado: Escribe una función que calcule si un número dado es un número de Armstrong 
//             (o también llamado narcisista).
//   Si no conoces qué es un número de Armstrong, debes buscar información al respecto.

function ejercicio14(numero) {
    let resultado = 0;

    for (let i = 0; i < numero.toString().length; i++) {
        resultado += +Math.pow(numero.toString()[i], +numero.toString().length);
        console.log(+numero.toString()[i] + " ^ " + +numero.toString().length + " = " + +Math.pow(numero.toString()[i], +numero.toString().length))
    }

    console.log('Suma de todos los números = ' + resultado)
    return resultado === numero ? 'Es un número Armstrong' : 'No es un número Armstrong';
}

//  Ejercicio 15
//  Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que 
//             representen fechas.
//   - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
//   - La función recibirá dos String y retornará un Int.
//   - La diferencia en días será absoluta (no importa el orden de las fechas).
//   - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.

function ejercicio15() {

}

//  Ejercicio 16
// Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
//            poner en mayúscula la primera letra de cada palabra.
//  - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.

function ejercicio16(texto){

    let fraseFinal="";
    
    let arrTexto = texto.split(" ");
    const ArrFinal = [];
    for (let i = 0; i < arrTexto.length; i++) {
        ArrFinal.push(arrTexto[i].replace(arrTexto[i][0],arrTexto[i][0].toUpperCase())+" ")
    }

    fraseFinal= ArrFinal.join('')
    return fraseFinal   
}
