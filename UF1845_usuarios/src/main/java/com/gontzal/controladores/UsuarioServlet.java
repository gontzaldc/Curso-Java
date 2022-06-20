package com.gontzal.controladores;

import java.io.IOException;

import com.gontzal.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id= request.getParameter("id");
		String ver= request.getParameter("ver");
		
		if(id!=null&& Boolean.parseBoolean(ver)) {
			Usuario usuario= Globales.DAO.obtenerPorId(Long.parseLong(id));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
		}else {
			if(id!=null) {
			Usuario usuario= Globales.DAO	.obtenerPorId(Long.parseLong(id));
			request.setAttribute("usuario", usuario);
			
			}
			request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email= request.getParameter("email");
		String contra = request.getParameter("contra");
		
		
		Usuario usuario= new Usuario(null,nombre,email, contra);
		if(id==null || id.trim().length()==0) {
			Globales.DAO.insertar(usuario);
		}
		else {
			usuario.setId(Long.parseLong(id));
			Globales.DAO.modificar(usuario);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
	}

}
