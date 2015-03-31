<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:url value="/resultado" var="urlAjax"></c:url>
<c:url value="/cargar" var="cargar"></c:url>
<c:url value="/otro" var="otro"></c:url>
<html>
<head>
<script type="text/javascript" src="<c:url  value="/resources/jquery-2.1.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap.min.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap.min.css" />" type="text/css">
	<title>Creacion de Usuarios</title>
</head>
<body>

<script type="text/javascript">
	$("document").ready(function(){
	
		$("#tabla").empty();
		
		var carga = "${cargar}";
		$.get( carga , function(data , status , rhx){
			for( i in data ){
				
				var rol = (data[i].rol.rol == 1)?" Admin":"Consultor";
				
				var fila =  "<tr>"+ "<td>" + "<label> Usuario: </label> " +data[i].usuario + " <td> "+" <label> Clave </label> " + data[i].clave +
				" <label> Rol: </label>" + rol+
				"</tr>";
				
				$("#tabla").append(fila);
				
				
			}
			
		} );
		
		$("#form1").submit(function(evento){
			
			
			
			var url = "${urlAjax}"
			var usuario = $("#usuario").val();
			var clave = $("#clave").val();
			var rol  = $("#rol").val();
			
			$.get( url , { username: usuario , password: clave , role : rol} , function(data , status , rhx){
				$("#tabla").empty();
				for( i in data ){
					var rol = (data[i].rol.rol == 1)?" Admin":"Consultor";
					var fila =  "<tr>"+ "<td>" + "<label> Usuario: </label> " +data[i].usuario + " <td> "+" <label> Clave </label> " + data[i].clave +
					" <td> "+" <label> Rol: </label>" + rol+
					"</tr>";
					
					$("#tabla").append(fila);
					
					
				}
				
			} );
			
			
			
			
			evento.preventDefault();
			
		});
		
		
		$("#boton").click(function(){
			var url = "${otro}";
			$.get(url ,{nombre:"cosa"}, function(data,status,rhx){
				$("#tabla").empty();
				alert(status);
				
			});
		});
	});
	
</script>
<header>
	<h1 > <label class="label label-default">Creacion de usuario y sus roles</label></h1> 
</header>

<nav >
		<form id="form1"  >
			<label>usuario: </label><input type="text" id="usuario" name="username">
			<label>clave: </label><input type="password" id="clave" name="password">
			<label>rol: </label><select name="role" id="rol">
				<option value="1"> admin</option>
				<option value="2"> consultor </option>
			</select>
			<input type="submit">
		</form>
</nav>
<article>
	<table id="tabla" class="table table-bordered">	</table>
</article>

<P>  The time on the server is ${serverTime}. </P>

<button id="boton">eliminar</button>
</body>
</html>
