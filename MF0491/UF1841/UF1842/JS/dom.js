'use strict';

window.addEventListener('DOMContentLoaded', function(){

    const h1s=document.getElementsByTagName('h1');

    for (let h1 of h1s){
        console.log(h1);
        h1.innerText+=' Escrito'
    }

    const boton= document.getElementById('btn-saludar');
    const nombre=document.getElementById('nombre');
    const respuesta=document.getElementById('respuesta');

    boton.addEventListener('click',function(){
        respuesta.innerText= 'Hola '+ nombre.value;
        nombre.setAttribute('readonly',true)
    })
})