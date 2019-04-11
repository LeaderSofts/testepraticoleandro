<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	  	<title> GT4W / Leadersofts - Cadastro de clientes </title>
		<link rel="stylesheet" type="text/css" href="css/estilo.css" />
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>	
<body>
	<h3> <a href="/leadersofts">Home</a> </h3>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <script src="bootstrap/js/bootstrap.min.js"></script> 
	    <!-- include Cycle plugin -->
		<script type="text/javascript" src="http://malsup.github.com/jquery.cycle.all.js"></script>

	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <!-- Validação de navegador logo abaixo -->
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    	<!--[if lt IE 9]>
      		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->

	<jsp:useBean id="cliente" scope="session" class="br.com.leadersofts.spring.model.Cliente"/>

	<c:if test="${not empty cliente.nome}">
    	Nome: ${cliente.nome} 
    	 <br>
	</c:if>
	CPF: ${cliente.cpf}<br>
	Data de nascimento: ${cliente.nascto} <br>
	Peso: ${cliente.peso} <br>
	UF:   		

</body>
</html>