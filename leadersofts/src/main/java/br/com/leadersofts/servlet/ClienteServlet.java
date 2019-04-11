package br.com.leadersofts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.leadersofts.spring.model.Cliente;


@WebServlet("/ClienteServlet")
public class ClienteServlet {
	
    private static final long serialVersionUID = 1L;
    private Cliente cliente;        
	/**
	 *
	 * @author Quintiliano
	 */

	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
	        printWriter.println("<html>");
	        printWriter.println("<head>");
	        printWriter.println("</head>");
	        printWriter.println("<script language=\"JavaScript\">");
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/javascript/validate.js");
	        requestDispatcher.include(request, response);
	        printWriter.println("<body>");
	        printWriter.println("<form action =\"/servlet/sucess.jsp\"> onSubmit=\"return validateUserName(this.username.value) \">");
	        printWriter.println("username: <inpyt type=\"text\" name=\"username\">");
	        printWriter.println("<inpyt type=\"submit\" value=\"Submit\">");
	        printWriter.println("</form>");
	        printWriter.println("</body>");
	        printWriter.println("</html>");
	        printWriter.println(" ");
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final int INSERIR = 1;
        final int VISUALIZAR = 2;
        final int EDITAR = 3;

        switch (Integer.parseInt(request.getParameter("id"))) {

            case INSERIR:
                
                cliente = new Cliente();

                cliente.setNome(request.getParameter("nome"));
                cliente.setCpf( request.getParameter("cpf") );
                cliente.setNascto( request.getParameter("nascto") );
                cliente.setPeso( Double.parseDouble( request.getParameter("peso") ) );
                cliente.setUF( request.getParameter("uf") );

                request.getSession().setAttribute("cliente", cliente);

                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case VISUALIZAR:
                request.getRequestDispatcher("visualizaCliente.jsp").forward(request, response);
                break;
                
            case EDITAR:

            	cliente.setNome(request.getParameter("nome"));
                cliente.setCpf( request.getParameter("cpf") );
                cliente.setNascto( request.getParameter("nascto") );
                cliente.setPeso( Double.parseDouble( request.getParameter("peso") ) );
                cliente.setUF( request.getParameter("uf") );

                request.getSession().setAttribute("cliente", cliente);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}
