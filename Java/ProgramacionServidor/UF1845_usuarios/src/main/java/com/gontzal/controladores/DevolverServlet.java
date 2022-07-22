package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/libros/devolver")
public class DevolverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String idLibro = request.getParameter("idL");

		Libro libro= Globales.DAOLIBRO.buscarPorId(Long.parseLong(idLibro));
		Globales.DAORESERVA.borrar(Long.parseLong(id));

		request.setAttribute("textoAlerta", "El libro se ha devuelto correctamente.");
		request.setAttribute("nivelAlerta", "success");
		
		libro.setDisponible(true);
		Globales.DAOLIBRO.modificar(libro);
		
		request.getRequestDispatcher("/libros").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
