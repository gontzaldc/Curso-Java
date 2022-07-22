package com.gontzal.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import com.gontzal.modelos.Libro;
import com.gontzal.modelos.Reserva;

@WebServlet("/libros/hacer-reserva")
public class HacerReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email= request.getParameter("email");
		String idLibro= request.getParameter("idLibro");
		
		LocalDateTime fecha= LocalDateTime.now();
		
		
		
		Libro libro= Globales.DAOLIBRO.buscarPorId(Long.parseLong(idLibro));
		Globales.DAORESERVA.insertar(new Reserva(null,fecha,email,libro));
		
		request.setAttribute("textoAlerta", "El libro "+libro.getNombre()+"se ha reservado correctamente.");
		request.setAttribute("nivelAlerta", "success");
		libro.setDisponible(false);
		Globales.DAOLIBRO.modificar(libro);
		request.getRequestDispatcher("/libros").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
