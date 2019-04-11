package br.com.leadersofts.spring.controller;

import br.com.leadersofts.controller.logic.ControllerLogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Controlador que receberá todas as requisições
            Class<?> classe = Class.forName("br.com.leadersofts.controller.logic."+request.getParameter("classe"));            
            ControllerLogic controller = (ControllerLogic) classe.newInstance();
            controller.executar(request, response);
            
        } catch (Exception ex) {
            log(ex.getMessage());
        }
        
    }
	
}
