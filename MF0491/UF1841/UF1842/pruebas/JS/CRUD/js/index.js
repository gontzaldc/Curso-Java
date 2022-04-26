'use strict';

URL = "http://localhost:3000/personas/";

window.addEventListener('DOMContentLoaded', async function () {

    await generarCard()

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
            <a data-bs-toggle="modal" data-bs-target="#exampleModal" href="javascript:editar(${persona.id})" class="card-link" >Editar</a>
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

    
}
