package br.com.leadersofts.controller.logic;

import br.com.leadersofts.spring.model.Cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerLogicClienteEditar implements ControllerLogic {

	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setCpf( request.getParameter("cpf") );
        cliente.setNascto( request.getParameter("nascto") );
        cliente.setPeso( Double.parseDouble( request.getParameter("peso") ) );
        cliente.setUF( request.getParameter("uf") );        
        request.getSession().setAttribute("cliente", cliente);
        request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

}
