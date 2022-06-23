package com.gontzal.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import com.gontzal.modelos.Libro;
import com.gontzal.modelos.Reserva;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/libros/reservas")
public class ReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("reservas", Globales.DAORESERVA.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
