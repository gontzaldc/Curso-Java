package com.gontzal.servlets;

import java.io.IOException;

import com.gontzal.accesoadatos.DaoProducto;
import com.gontzal.accesoadatos.DaoProductoMemoria;
import com.gontzal.servlets.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mostrar")
public class Mostrar extends HttpServlet {
	private static final DaoProducto DAO = DaoProductoMemoria.getInstancia();

	private static final long serialVersionUID = 1L;

	public Mostrar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Iterable<Producto> lista = DAO.obtenerTodos();
		String busqueda = request.getParameter("busqueda");

		if (busqueda != null) {
			lista = DAO.obtenerPorNombre(busqueda);
		}
		response.setContentType("text/plain");
		for (Producto p : lista) {
			response.getWriter().println("ID: " + p.getId());
			response.getWriter().println("Nombre: " + p.getNombre());
			response.getWriter().println("Descripcion: " + p.getDescripcion());
			response.getWriter().println("Stock: " + p.getStock());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
