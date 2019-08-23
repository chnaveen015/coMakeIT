package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import bean.Journey;
import repository.BusDao;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BusDao bd = new BusDao();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String operation = (String) request.getParameter("operation");
		if (operation.equals("ReserveTicket")) {
			Client client = ClientBuilder.newClient( new ClientConfig());
			String apiURL = "http://localhost:8080/BusReservation/webapi/Buses";
			WebTarget webTarget = client.target(apiURL).path("get-sources");
			WebTarget webTarget1 = client.target(apiURL).path("get-destinations");
			Invocation.Builder invocationBuilderSources =  webTarget.request(MediaType.APPLICATION_JSON);
			Invocation.Builder invocationBuilderDestinations =  webTarget1.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilderSources.get();
			Response clientResponse1 = invocationBuilderDestinations.get();	
			GenericType<ArrayList<String>> sourceGtype=new GenericType<ArrayList<String>>() {};
//			ArrayList<String> source = new BusDao().getSources();
//			ArrayList<String> destination = new BusDao().getDestinations();
			ArrayList<String>source=clientResponse.readEntity(sourceGtype);
			ArrayList<String>destination=clientResponse1.readEntity(sourceGtype);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("User.jsp");

			request.setAttribute("sources", source);
			request.setAttribute("destination", destination);

			requestDispatcher.forward(request, response);
		} else if (operation.equals("CancelTicket")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("CancelTicket.jsp");
			requestDispatcher.forward(request, response);
		} else if (operation.equals("viewticket")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewTicket.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}