package br.com.leadersofts.webservices;

import javax.xml.ws.handler.LogicalHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import br.com.leadersofts.spring.dao.ClienteDAO;
import br.com.leadersofts.spring.model.Cliente;

@Path("fazenda")
public class GT4W {
	
	private UriInfo context;

	public GT4W() {
        
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "meu primeiro WebService Restful";
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Cliente/get/{nome}/{cpf}")
    public String getUsuario( @PathParam("nome") String nome, @PathParam("cpf") String cpf ){
		ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        clienteDAO = new ClienteDAO();
        //clienteDAO.listaClientes();
        Gson gson = new Gson();
        return gson.toJson(cliente);
    }
	
}
