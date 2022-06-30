package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.dal.DaoUsuarioMySQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/usuarios/*")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Con /usuarios/* en el webservlet
//		String pathInfo = request.getPathInfo();

//		if(pathInfo!=null) {
//			switch(request.getPathInfo()) {
//			case "/insertar":
//				System.out.println("insertando");
//				request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
//				break;
//			}
//		}

		// Empaqueta datos para la siguiente vista
//		request.setAttribute("usuarios", Globales.DAO.obtenerTodos());
		

		request.setAttribute("usuarios", DaoUsuarioMySQL.getInstancia().obtenerTodos());
		
		// Redirecciona a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/usuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
