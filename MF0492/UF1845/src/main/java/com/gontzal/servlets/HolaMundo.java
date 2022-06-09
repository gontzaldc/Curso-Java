package com.gontzal.servlets;

import java.io.IOException;

import com.gontzal.accesoadatos.DaoProducto;
import com.gontzal.accesoadatos.DaoProductoMemoria;
import com.gontzal.accesoadatos.DaoProductoServlet;
import com.gontzal.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
	private static final DaoProducto DAO = DaoProductoMemoria.getInstancia();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolaMundo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Producto> lista = DAO.obtenerTodos();
		String busqueda = request.getParameter("busqueda");
		if (busqueda != null) {
			lista = DAO.obtenerPorNombre(busqueda);
		}
		for (Producto p : lista) {
			response.getWriter().println("ID: " + p.getId());
			response.getWriter().println("Nombre: " + p.getNombre());
			response.getWriter().println("Descripcion: " + p.getDescripcion());
			response.getWriter().println("Descripcion: " + p.getStock());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
