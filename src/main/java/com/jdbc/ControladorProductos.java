package com.jdbc;
import java.text.*;
import javax.naming.InitialContext;
import javax.sql.*;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ModeloProductos modelo;
	
	@Resource(name="jdbc/db")
	private DataSource ds;
	 
	
 

	@Override
	public void init() throws ServletException {
		
		super.init();
		try {
			modelo= new ModeloProductos(ds);
		}catch(Exception e) {
			throw new ServletException(e);
			
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//leer la instruccion del formulario
		
		String instruccion = request.getParameter("instruccion");
		
		if(instruccion == null) instruccion="listar";
		
		switch (instruccion) {
		
			case "listar":
				obtenerProductos(request, response);
				break;
				
			
				
			case "cargar":
				try {
					cargarProducto(request,response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			
				
			case "eliminar":
				eliminarProducto(request,response);
				
				break;
			
			
		}
		

	
		
		
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String instruccion = request.getParameter("instruccion");
		
		switch (instruccion) {
			case "insertar":
				try {
					agregarProductos(request,response);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "actualizar":
				try {
					actualizarProductos(request,response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
		}
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
	
		
		List<Producto> productos;
		try {
			productos=modelo.getProductos();
			
	
			request.setAttribute("ListaProductos", productos);

			RequestDispatcher dispatch = request.getRequestDispatcher("Vista.jsp");
			dispatch.forward(request, response);
			
		}catch(Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}
		
	}
	
	private void agregarProductos(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		Date fecha = convertirFecha(request.getParameter("fecha"));
		String importado = request.getParameter("importado");
		String pais = request.getParameter("pais");
		
		Producto productoNuevo= new Producto(seccion,nombre,precio,fecha,importado,pais);
		
		modelo.agregarProducto(productoNuevo);
	
		obtenerProductos(request,response);
		
		
		
		
		
	}
	
	
	private void cargarProducto(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		
		int indice= Integer.parseInt(request.getParameter("indice"));
		
		
		Producto productoSeleccionado =modelo.getProducto(indice);
		
		request.setAttribute("productoSeleccionado", productoSeleccionado);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("actualizarProducto.jsp");
		
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}
	
	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int indice=Integer.parseInt( request.getParameter("indice"));
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		Date fecha = convertirFecha(request.getParameter("fecha"));
		String importado = request.getParameter("importado");
		String pais = request.getParameter("pais");
		
		
		Producto prodMod= new Producto(indice,seccion,nombre,precio,fecha,importado,pais);
		
		
		modelo.actualizarProducto(prodMod);
		
		
		obtenerProductos(request,response);
		
	}
	
	
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		
		int indice = Integer.parseInt(request.getParameter("indice"));
		try {
			
			modelo.eliminarProducto(indice);
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		obtenerProductos(request,response);
		
		
		
	}
	
	
	private Date convertirFecha(String fecha) {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFinal=null;
		try {
		
		fechaFinal=formato.parse(fecha);
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fechaFinal;
		
	}

}
