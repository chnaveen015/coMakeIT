package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import bean.Login;

/**
 * Servlet implementation class LoginValidater
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		Login login = new Login();
		login.setUsername(uname);
		login.setPassword(pass);
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8080/BusReservation/webapi/login";
		WebTarget webTarget = client.target(apiURL).path("validate");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);//
		Response clientResponse = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
		Login validate = clientResponse.readEntity(Login.class);
			
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
				request.setAttribute("validate", validate);
				requestDispatcher.forward(request, response);
		
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
