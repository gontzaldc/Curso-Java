package com.gontzal.servlets.controladores;

import java.io.IOException;

import com.gontzal.accesoadatos.DaoProducto;
import com.gontzal.accesoadatos.DaoProductoMemoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final DaoProducto DAO = DaoProductoMemoria.getInstancia();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 TreeMap<Long, Producto> productos = new TreeMap<>();
//
//	
//			productos.put(1L, new Producto(1L, "Crema de Cacahuete", new BigInteger("12"), "adsfgh dassADSF"));
//			productos.put(2L, new Producto(2L, "Crema de Verdura", new BigInteger("12"), "adsfgh dassADSF"));
//			productos.put(3L, new Producto(3L, "Chocolate", new BigInteger("12"), "adsfgh dassADSF"));

// Empaqueta datos para la siguiente vista
		request.setAttribute("productos", DAO.obtenerTodos());
// Redirecciona a la siguiente vista
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
