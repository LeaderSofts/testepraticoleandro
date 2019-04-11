package br.com.leadersofts.controller.logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerLogicClienteListar implements ControllerLogic {
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("visualizaClientes").forward(request, response);		
	}

}
