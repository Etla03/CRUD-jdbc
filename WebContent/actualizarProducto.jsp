<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Actualizar Producto</title>
	</head>
	
	<body>
	<form name="actualizarProducto" method="post" action="ControladorProductos">
		<input type="hidden" name="instruccion" value="actualizar">
		<input type="hidden" name="indice" value="${productoSeleccionado.indice}">
		
			 <label for="seccion">Seccion</label>
	         <input type="text" name="seccion" value= "${productoSeleccionado.seccion}" required>
	         
	         <label for="nombre">Nombre</label>
	         <input type="text" name="nombre" value= "${productoSeleccionado.nombre}" required>
	         
	         <label for="precio">Precio</label>
	         <input type="text" name="precio" value= "${productoSeleccionado.precio}" required>
	         
	         <label for="fecha">Fecha</label>
	         <input type="date" name="fecha" value= "${productoSeleccionado.fecha}" required>
	         
	         <label for="importado">Importado</label>
	         <input type="text" name="importado" required value= "${productoSeleccionado.importado}" placeholder="Verdadero/Falso">
	         
	         <label for="pais">Pais de Origen</label>
	         <input type="text" name="pais" value= "${productoSeleccionado.paisOrigen}" required>
				
			<input type="submit" value="Actualizar producto">	
		</form>
	
	
	</body>
	
	
	
</html>