package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Usuario;

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
		
		if(!usuario.getRol().equals("ADMIN")) {
			request.setAttribute("reservas", Globales.DAORESERVA.obtenerPorEmail(usuario.getEmail()));
			request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
			return;
		}
			
		

		request.setAttribute("reservas", Globales.DAORESERVA.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
