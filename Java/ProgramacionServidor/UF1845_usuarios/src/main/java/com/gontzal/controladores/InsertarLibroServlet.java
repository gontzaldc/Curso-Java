package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/libros/insertar")
public class InsertarLibroServlet extends HttpServlet {
	private static final String INSERTAR_LIBRO_JSP = "/WEB-INF/vistas/libro.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher(INSERTAR_LIBRO_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		
		Libro libro = new Libro(null, titulo,categoria,true);
		
		if(libro.getErrores().size()>0) {
			
			request.setAttribute("alertatexto", "No se ha podido realizar la reserva. Revise los datos.");
			request.setAttribute("alertanivel", "danger");

			request.setAttribute("libro", libro);

			request.getRequestDispatcher(INSERTAR_LIBRO_JSP).forward(request, response);
			return;
			
		}
		
		Globales.DAOLIBRO.insertar(libro);
		request.setAttribute("textoAlerta", "El libro se ha añadido correctamente.");
		request.setAttribute("nivelAlerta", "success");
		request.getRequestDispatcher("/admin#tabLibros").forward(request, response);
	}

}
