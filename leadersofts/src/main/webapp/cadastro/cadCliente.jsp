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
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <script src="bootstrap/js/bootstrap.min.js"></script> 
	    <!-- include Cycle plugin -->
		<script type="text/javascript" src="http://malsup.github.com/jquery.cycle.all.js"></script>
		
		<script type="text/javascript" src="leadersofts/src/main/webapp/WEB-INF/javascript/validade.js">

	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <!-- Validação de navegador logo abaixo -->
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    	<!--[if lt IE 9]>
      		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->
    	
    	<form name="formulario" action="/Pessoa_Polimorfico/Controller?classe=ControllerLogicPessoaCadastrar" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th> Cadastro de Pessoa </th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nome: </td>
                        <td> <input type="text" name="nome" value="" size="30" /> </td>
                    </tr>
                    <tr>
                        <td> CPF: </td>
                        <td> <input type="text" name="cpf" value="" size="30" /> </td>
                    </tr>
                    <tr>
                        <td>Data de Nascimento: </td>
                        <td> <input type="text" name="nascto" value="" size="30" /> </td>
                    </tr>
                    <tr>
                        <td> Peso: </td>
                        <td> <input type="text" name="peso" value="" size="30" /> </td>
                    </tr>
                    
                    <tr>    
                        <select onclick="getSelectedUnidadeFederativa()" id="seletorUF">
							<option>UF</option>                        	
                        </select>                        
                    </tr>
                </tbody>			 
            </table>
           
        </form>

    	 
    	<br />
</body>

</html>


