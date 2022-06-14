package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.dal.DaoUsuarioMemoria;
import com.gontzal.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DaoUsuarioMemoria DAO= DaoUsuarioMemoria.getInstancia();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id= request.getParameter("id");
		String ver= request.getParameter("ver");
		
		if(id!=null && Boolean.parseBoolean(ver)==true) {
			Usuario usuario= DAO.obtenerPorId(Long.parseLong(id));
			request.setAttribute("usuario", usuario);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
