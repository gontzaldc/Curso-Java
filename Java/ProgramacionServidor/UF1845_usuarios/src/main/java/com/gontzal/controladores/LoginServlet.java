package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuario = new Usuario(null, null, email, password,null);

		Usuario usuarioValido = validarUsuario(usuario);

		if (usuarioValido != null) {

			request.getSession().setAttribute("usuario", usuarioValido);
			response.sendRedirect(request.getContextPath() + "/admin/usuarios");

		} else {
			request.setAttribute("textoAlertaLogin", "Email o contraseña incorrectos");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}

	}

	private Usuario validarUsuario(Usuario usuario) {

		Usuario usuarioEncontrado = Globales.DAO.BuscarPorEmail(usuario.getEmail());

		if (usuarioEncontrado != null && usuario.getcontrasena().equals(usuarioEncontrado.getcontrasena())) {
			return usuarioEncontrado;
		}

		return null;
	}

}
