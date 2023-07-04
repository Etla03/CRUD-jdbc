<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*,com.jdbc.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ProyectoMVC</title>
		<link rel="stylesheet" href="style.css">
	</head>
		


	<body>
	
		<table>
			<thead>
				<th>ID</th>
				<th>Seccion</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Fecha</th>
				<th>Importado</th>
				<th>Pais Origen</th>
				<th>Actualizar/Eliminar</th>
			</thead>
			<tbody>
			
			
		
	
			
			
			
			<c:forEach var="tmpProduct" items="${ListaProductos}">
			
			<!-- campo clave seleccionado al actualizar -->
			
			<c:url var="tmpLink" value="ControladorProductos">>
			
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="indice" value="${tmpProduct.indice}"></c:param>
			
			</c:url>
			
			
			<c:url var="tmpLinkEliminar" value="ControladorProductos">
				<c:param name="instruccion" value="eliminar"></c:param>
				<c:param name="indice" value="${tmpProduct.indice}"></c:param>
				
			
			
			</c:url>
				<tr>
				<td>${tmpProduct.indice}</td>
				<td>${tmpProduct.seccion}</td>
				<td>${tmpProduct.nombre}</td>
				<td>${tmpProduct.precio}</td>
				<td>${tmpProduct.fecha}</td>
				<td>${tmpProduct.importado}</td>
				<td>${tmpProduct.paisOrigen}</td>
				<td><input type="button" value="&#128260;" onclick="window.location.href='${tmpLink}'"/>
					&nbsp;&nbsp;<input type="button" value="&#10060" onclick="window.location.href='${tmpLinkEliminar}'" /></td>
				</tr>
			</c:forEach>
			
			</tbody>
			
		</table>
		
		
		<div id="boton">
			<input type="button" value="Insertar Registro" onclick="window.location.href='InsertarProducto.jsp'"/>
			
		</div>
	
	</body>
</html>