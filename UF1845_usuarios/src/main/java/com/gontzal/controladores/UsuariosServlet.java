package com.gontzal.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gontzal.dal.DaoUsuarioMemoria;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DaoUsuarioMemoria DAO = DaoUsuarioMemoria.getInstancia();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Empaqueta datos para la siguiente vista
		request.setAttribute("usuarios", DAO.obtenerTodos());
		// Redirecciona a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/usuarios-.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
