
function validateUserName(username){
		var result = true;
		if(username == ""){
			alert("Please providae a username!");
			result = false;
		}
		return result;
}

$(document).ready(function(){
	$('#seletorUF').click( function(){    
	    $.ajax({
	        url: 'https://servicodados.ibge.gov.br/api/v1/localidades/estados',
	        type: "POST",
	        dataType: "JSON",  // A propriedade refere-se ao tipo de dado que o servidor deve retornar a requisição.
	        success: function(data) {        	
	            for(var i=0; data.length > i; i++ ){  //Adicionando registros retornados na tabela
	            	$('select').append('<option>' +data[i].nome+ '</option>');
	            }	            
	        }
	    })  
	});
});        

function getSelectedUnidadeFederativa(){
	return document.getElementById('#seletorUF').toString();	
}









/*
$(document).ready(function(){
	$("#txtCep").focusout(function() {
		var cep = $("#txtCep").val();
		cep = cep.replace("-", "");
		var urlStr = "https://viacep.com.br/ws/"+ cep + "/json";
		 $.ajax({
		  url: urlStr,
		  type: "get",
		  dataType: "json",
		  success : function(data){
		   console.log(data);
		   $("txtCidade").val(data.localidade);
		   $("txtCidade").val(data.uf);
		   $("txtCidade").val(data.bairro);
		   $("txtCidade").val(data.logradouro);
		   $("txtComplemento").val(data.complemento);
		  },
		  error : function(erro) {
			console.log(erro);
		  }
		 });
	}
} */


