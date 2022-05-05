'use strict';

URL = "http://localhost:3000/personas/";

window.addEventListener('DOMContentLoaded', async function () {

    await cargarTabla();



});

async function cargarTabla() {
    const tbody = document.querySelector("tbody");
    const tr = document.querySelector("tr");

    tbody.innerHTML = ''

    const respuesta = await fetch(URL);
    const personas = await respuesta.json();

    personas.forEach(function (persona) {
        console.log(persona);
        const tr = document.createElement('tr');


        tr.innerHTML = `
            <th scope="row">${persona.id}</th>
            <td contenteditable='true' onfocusout="editar(${persona.id})">${persona.nombre}</td>
            <td contenteditable='true' class='w-100' onfocusout="editar(${persona.id})">${persona.descripcion}</td>
            <td><a class="btn btn-danger btn-sm" href="javascript:borrar(${persona.id})">Borrar</a></td>
        `;

        tbody.appendChild(tr);
    });
}



async function editar(id) {

    

    const respuesta = await fetch(URL + id);
    const persona = await respuesta.json();

    console.log()
    // nombre= .parentElement.cells
    // inputId.value = persona.id;
    // inputNombre.value = persona.nombre;
    //         const input=document.createElement('input')
    //         input.classList.add('form-control')
    //         input.value=this.textContent
    //         this.textContent=''
    //         this.appendChild(input)

}