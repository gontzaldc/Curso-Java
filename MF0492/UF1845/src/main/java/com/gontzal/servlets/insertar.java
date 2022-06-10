package com.gontzal.servlets;

import java.io.IOException;
import java.math.BigInteger;

import com.gontzal.accesoadatos.DaoProducto;
import com.gontzal.accesoadatos.DaoProductoMemoria;
import com.gontzal.servlets.modelos.Producto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertar
 */
@WebServlet("/insertar")
public class insertar extends HttpServlet {


	private static final long serialVersionUID = 1L;
       
	private static final DaoProducto DAO = DaoProductoMemoria.getInstancia();
	
    public insertar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String stock = request.getParameter("stock");
		String descripcion = request.getParameter("descripcion");
		
		Producto p = new Producto();
		
		p.setNombre(nombre);
		p.setStock(new BigInteger(stock));
		p.setDescripcion(descripcion);
		
		DAO.insertar(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("mostrar");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
