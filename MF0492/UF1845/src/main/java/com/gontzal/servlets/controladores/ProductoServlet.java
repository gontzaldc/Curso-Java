package com.gontzal.servlets.controladores;

import java.io.IOException;

import com.gontzal.accesoadatos.DaoProductoMemoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		request.setAttribute("producto", DaoProductoMemoria.getInstancia().obtenerPorId(Long.parseLong(id)));
		request.getRequestDispatcher("/WEB-INF/vistas/producto.jsp").forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
