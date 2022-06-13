package com.gontzal.servlets.controladores;

import java.io.IOException;
import java.math.BigInteger;

import com.gontzal.accesoadatos.DaoProducto;
import com.gontzal.accesoadatos.DaoProductoMemoria;
import com.gontzal.servlets.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modificar")
public class AdminModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DaoProducto DAO = DaoProductoMemoria.getInstancia();

	public AdminModificarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		request.setAttribute("producto", DAO.obtenerPorId(Long.parseLong(id)));
		request.getRequestDispatcher("/WEB-INF/vistas/adminedit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Producto p = new Producto();
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String stock = request.getParameter("stock");
		String descripcion = request.getParameter("descripcion");
		String vendiendo = request.getParameter("vendiendo");
		
		p.setId(Long.parseLong(id));
		p.setNombre(nombre);
		p.setStock(new BigInteger(stock));
		p.setDescripcion(descripcion);
		if(vendiendo==null) {
			vendiendo="False";
		}
		else {
			vendiendo="True";
		}
		p.setVendiendo(Boolean.parseBoolean(vendiendo));
		DAO.modificar(p);
		
		request.setAttribute("productos", DAO.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin.jsp").forward(request, response);
	}

}
