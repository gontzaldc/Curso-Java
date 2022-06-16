package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.dal.DaoUsuarioMemoria;
import com.gontzal.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DaoUsuarioMemoria DAO = DaoUsuarioMemoria.getInstancia();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		
		DAO.borrar(Long.parseLong(id));
		
		response.sendRedirect(request.getContextPath() + "/usuarios");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
