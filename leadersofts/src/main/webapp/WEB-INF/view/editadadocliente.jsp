<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Edit Student Details</h1>
 	
	<form:form method="POST" modelAttribute="student"  class="form-horizontal" action="/springexample/editsave">

<div class="row">
			<div class="form-group col-md-12">
				<div class="col-md-7">
					<form:hidden path="id_cliente"  class="form-control input-sm"/>
					<div class="has-error">
				</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">Nome</label>
				<div class="col-md-7">
					<form:input type="text" path="Name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="nome" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="cpf">CPF</label>
				<div class="col-md-7">
					<form:input type="text" path="cpf" id="cgc" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="cpf" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
<!--  
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="sexo"> Gênero </label>
				<div class="col-md-7" class="form-control input-sm">
					<form:radiobutton path="sexo" value="M" />Masculino 
	    			<form:radiobutton path="sexo" value="F" />Feminino
					<div class="has-error">
						<form:errors path="sexo" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> -->

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="nascto">Data de Nascimento</label>
				<div class="col-md-7">
					<form:input type="text" path="nascto" id="nascimento" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="nascto" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="peso">Peso (KG)</label>
				<div class="col-md-7">
					<form:input type="text" path="peso" id="pesokg" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="peso" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="uf"> UF </label>
				<div class="col-md-7">
					<form:input type="text" path="uf" id="ufederativa" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="uf" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstAttempt">First Attempt ?</label>
				<div class="col-md-1">
					<form:checkbox path="firstAttempt" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstAttempt" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="subjects">Subjects</label>
				<div class="col-md-7">
					<form:select path="subjects" items="${subjects}" multiple="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="subjects" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Edit" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>