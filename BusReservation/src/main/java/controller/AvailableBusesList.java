package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import bean.BasicDetailsBean;
import bean.BusDetails;
import bean.Login;

/**
 * Servlet implementation class CheckReservationAvailability
 */
public class AvailableBusesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableBusesList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at:").append(request.getContextPath());
		BasicDetailsBean details=new BasicDetailsBean();
		
		details.setSource((String)request.getParameter("source"));
		details.setDestination(request.getParameter("destination"));
		details.setNoOfSeats(Integer.parseInt(request.getParameter("noofseats")));
		details.setDateOfJourney(request.getParameter("dateofjourney"));
		
		Client client = ClientBuilder.newClient( new ClientConfig());
		String apiURL = "http://localhost:8080/BusReservation/webapi/Buses";
		WebTarget webTarget = client.target(apiURL).path("available-buses");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		
		Response clientResponse = invocationBuilder.post(Entity.entity(details, MediaType.APPLICATION_JSON));
		
		GenericType<ArrayList<BusDetails>> gType = new GenericType<ArrayList<BusDetails>>() {};
		ArrayList<BusDetails> viewBuses = clientResponse.readEntity(gType);
		
		HttpSession session = request.getSession();
		session.setAttribute("details",details);

		RequestDispatcher dispatch = request.getRequestDispatcher("ViewBuses.jsp");
		session.setAttribute("viewBuses",  viewBuses);
		dispatch.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}