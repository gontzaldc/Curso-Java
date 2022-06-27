package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Reserva;
import com.gontzal.modelos.Usuario;
import com.gontzal.modelos.Usuario.Roles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/libros/reservas")
public class ReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Iterable<Reserva> obtener = Globales.DAORESERVA.obtenerPorEmail(usuario.getEmail());
		
		if(usuario.getRol().equals(Roles.ADMIN)) {
			obtener= Globales.DAORESERVA.obtenerTodos();
		}
		
		request.setAttribute("reservas", obtener);
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
