'use strict';

let inputId, inputNombre, inputDescripcion, modal, boton;
const botonNuevo = document.querySelector('#botonNuevo')

URL = "http://localhost:3000/personas/";

window.addEventListener('DOMContentLoaded', async function () {


    modal = new bootstrap.Modal(document.getElementById('modalDatos'))
    inputId = document.querySelector("#id");
    inputNombre = document.querySelector("#nombre");
    inputDescripcion = document.querySelector("#descripcion");
    boton = document.querySelector('#boton-guardar');

    await generarCard()

    boton.addEventListener('click', guardar)

});

async function generarCard() {
    const main = document.querySelector("#main");

    main.innerHTML = '';

    const respuesta = await fetch(URL);
    const personas = await respuesta.json();

    personas.forEach(function (persona) {
        console.log(persona)
        const div = document.createElement('div');
        div.classList.add("card");
        div.style.cssText = "width: 18rem;"

        div.innerHTML = `
        <div class="card-body">
            <h5 class="card-title">${persona.nombre}</h5>
            <p class="card-text">${persona.descripcion}</p>
            <a href="javascript:editar(${persona.id})" class="card-link" >Editar</a>
            <a href="javascript:borrar(${persona.id})" class="card-link">Borrar</a>
        </div>
        `;

        main.appendChild(div);
    })

}
async function borrar(id) {
    const respuesta = await fetch(URL + id, { method: 'DELETE' });

    console.log(id);

    await generarCard();
}

async function editar(id) {


    modal.show()
    const respuesta = await fetch(URL + id);
    const persona = await respuesta.json();

    console.log(persona.id, persona.nombre, persona.descripcion)
    inputId.value = persona.id;
    inputNombre.value = persona.nombre;
    inputDescripcion.value = persona.descripcion;

}


async function guardar(e) {

    const persona = { id: inputId.value, nombre: inputNombre.value, descripcion: inputDescripcion.value };
    const json = JSON.stringify(persona);

    const cabeceras = new Headers();
    cabeceras.append("Content-type", "application/json");



    let metodo = 'POST';
    let url = URL;
    if (persona.id) {
        metodo = 'PUT'
        url = URL + persona.id;
    }
    const respuesta = await fetch(url, { method: metodo, body: json, headers: cabeceras });

    console.log(respuesta);
    modal.hide();
    await generarCard()
}

function inicializarForm() {
    inputId.value = "";
    inputNombre.value = "";
    inputDescripcion.value = "";
}

function nuevo() {
    modal.show()
}
