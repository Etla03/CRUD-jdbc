package com.jdbc;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource dataSource;
	
	public ModeloProductos(DataSource ds) {
		this.dataSource=ds;
		
	}
	
	
	public List<Producto> getProductos() throws Exception{
		
		List<Producto> productos = new ArrayList <> ();
		
		Connection myConexion=null;
		Statement myStatement=null;
		ResultSet myRs= null;
		

		try {
		myConexion= dataSource.getConnection();
		

		String instruccion="SELECT * FROM productos";
		
		myStatement=myConexion.createStatement();

		myRs= myStatement.executeQuery(instruccion);
	
		while(myRs.next()) {
			int indice=myRs.getInt("id");
			String seccion=myRs.getString("seccion");
			String nombre=myRs.getString("nombre");
			double precio=myRs.getDouble("precio");
			Date fecha = myRs.getDate("fecha");
			String importado=myRs.getString("importado");
			String paisOrigen=myRs.getString("pais_origen");
			
			Producto tmpProducto=new Producto(indice,seccion,nombre,precio,fecha,importado,paisOrigen);
			
			productos.add(tmpProducto);
		}
		}finally{
			myStatement.close();
			myConexion.close();
			
		}
			
		
		
		return productos;
	}
	
	
	public void agregarProducto(Producto p) throws Exception {

		
		Connection myConexion=null;
		PreparedStatement myStatement=null;
		
		
		try {
			myConexion = dataSource.getConnection();
		
			String instruccion ="INSERT INTO productos (seccion,nombre,precio,fecha,importado,pais_origen) VALUES(?,?,?,?,?,?)";
			
			
			myStatement = myConexion.prepareStatement(instruccion);
		
			myStatement.setString(1,p.getSeccion());
			myStatement.setString(2,p.getNombre());
			myStatement.setDouble(3, p.getPrecio());
			myStatement.setDate(4, new java.sql.Date(p.getFecha().getTime()));
			myStatement.setString(5,p.getImportado());
			myStatement.setString(6,p.getPaisOrigen());
			
			myStatement.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			myStatement.close();
			myConexion.close();
			
		}
		
		 
		
		
		
		
		
	}


	public Producto getProducto(int i) throws Exception {
		Producto pS=null;
		Connection myConexion=null;
		PreparedStatement myStatement=null;
		ResultSet myRs= null;
		
		try{
		
		myConexion=dataSource.getConnection();
		
		String instruccion="SELECT * FROM productos WHERE id=?";
		
		myStatement=myConexion.prepareStatement(instruccion);
		myStatement.setInt(1, i);
		
		myRs=myStatement.executeQuery();
		
		if(myRs.next()) {
			int indice=myRs.getInt("id");
			String seccion=myRs.getString("seccion");
			String nombre=myRs.getString("nombre");
			double precio=myRs.getDouble("precio");
			Date fecha = myRs.getDate("fecha");
			String importado=myRs.getString("importado");
			String paisOrigen=myRs.getString("pais_origen");
			
			pS= new Producto(indice,seccion,nombre,precio,fecha,importado,paisOrigen);
			
			
		}else {
			throw new Exception("Articulo con id "+ i + "no encontrado");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			myRs.close();
			myStatement.close();
			myConexion.close();
		}
		
		
		return pS;
	}


	public void actualizarProducto(Producto p) throws Exception {
		Connection myConexion=null;
		PreparedStatement myStatement=null;
		
		try {
			myConexion=dataSource.getConnection();
			
			String instruccion = "UPDATE productos SET seccion=?,nombre=?,precio=?,fecha=?,importado=?,pais_origen=? WHERE id=? ";
			
			myStatement= myConexion.prepareStatement(instruccion);
			
			myStatement.setString(1, p.getSeccion());
			myStatement.setString(2, p.getNombre());
			myStatement.setDouble(3, p.getPrecio());
			myStatement.setDate(4, new java.sql.Date(p.getFecha().getTime()));
			myStatement.setString(5, p.getImportado());
			myStatement.setString(6, p.getPaisOrigen());
			myStatement.setInt(7, p.getIndice());
			
			myStatement.execute();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			myStatement.close();
			myConexion.close();
		}

		
		
		
	}
	
	public void eliminarProducto(int i) throws Exception {
		Connection myConexion=null;
		PreparedStatement myStatement=null;
		
		try {
			myConexion=dataSource.getConnection();
			
			String instruccion = "DELETE FROM productos WHERE id=?";
			
			myStatement=myConexion.prepareStatement(instruccion);
			myStatement.setInt(1, i);
			
			myStatement.execute();
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			myConexion.close();
			myStatement.close();
		}
		
		
	}

}
