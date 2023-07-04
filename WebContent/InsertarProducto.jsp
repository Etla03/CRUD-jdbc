<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insertar Producto</title>
	</head>
	
	<body>
		<form name="insertarProducto" method="post" action="ControladorProductos">
		<input type="hidden" name="instruccion" value="insertar">
			 <label for="seccion">Seccion</label>
	         <input type="text" name="seccion" required>
	         
	         <label for="nombre">Nombre</label>
	         <input type="text" name="nombre" required>
	         
	         <label for="precio">Precio</label>
	         <input type="text" name="precio" required>
	         
	         <label for="fecha">Fecha</label>
	         <input type="date" name="fecha" required placeholder="aaaa-mm-dd">
	         
	         <label for="importado">Importado</label>
	         <input type="text" name="importado" required placeholder="Verdadero/Falso">
	         
	         <label for="pais">Pais de Origen</label>
	         <input type="text" name="pais" required>
				
			<input type="submit" value="Agregar producto">	
		</form>
	</body>
</html>