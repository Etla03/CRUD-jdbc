package com.jdbc;

import java.util.Date;

public class Producto {
	
	private int indice;
	private String seccion;
	private String nombre;
	private double precio;
	private Date fecha;
	private String importado;
	private String paisOrigen;
	
	
	public Producto(int indice, String seccion, String nombre, double precio, Date fecha, String importado,
			String paisOrigen) {
		
		this.indice = indice;
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}
	
	
	public Producto(String seccion, String nombre, double precio, Date fecha, String importado,
			String paisOrigen) {
		
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}
	
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}


	@Override
	public String toString() {
		return "Producto [indice=" + indice + ", seccion=" + seccion + ", nombre=" + nombre + ", precio=" + precio
				+ ", fecha=" + fecha + ", importado=" + importado + ", paisOrigen=" + paisOrigen + "]";
	}
	
	
	//metodo toString
	
	

}
