package br.com.leadersofts.controller.logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ControllerLogicRedirecionamento implements ControllerLogic {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        String page = request.getParameter("page");
        request.getRequestDispatcher(page).forward(request, response);        
    }

}
