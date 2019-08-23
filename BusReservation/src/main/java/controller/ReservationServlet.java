package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

import bean.Bus;
import bean.BusDetails;
import bean.Journey;
import bean.Reservation;
import business.RandomGeneration;

/**
 * Servlet implementation class ReservationServlet
 */
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Journey journey_id=new Journey();
		journey_id.setJourney_id(Integer.parseInt(request.getParameter("journey_id")));
		Reservation reservation=new Reservation();
		reservation.setPnr(new RandomGeneration().getPnr());
		reservation.setName(request.getParameter("name"));
		reservation.setBus_id(Integer.parseInt(request.getParameter("bus_id")));
		reservation.setStopno1(Integer.parseInt(request.getParameter("stopNo1")));
		reservation.setStopno2(Integer.parseInt(request.getParameter("stopNo2")));
		reservation.setDateOfJourney(request.getParameter("dateOfJourney"));
		reservation.setDestination(request.getParameter("destination"));
		reservation.setSource(request.getParameter("source"));
		reservation.setFare(Integer.parseInt(request.getParameter("fare")));
		reservation.setId_proof_no(request.getParameter("idProofNo"));
		reservation.setNo_of_seats(Integer.parseInt(request.getParameter("noOfSeats")));
		Integer j_id=journey_id.getJourney_id();
		Client client = ClientBuilder.newClient( new ClientConfig());
		String apiURL = "http://localhost:8080/BusReservation/webapi/Buses";
		WebTarget webTarget = client.target(apiURL).path("reserve-ticket");
		WebTarget webTarget1 = client.target(apiURL).path("get-journey-details");
		Invocation.Builder invocationBuilderForJourney =  webTarget1.request(MediaType.APPLICATION_JSON);
		Response clientResponse1 = invocationBuilderForJourney.post(Entity.entity(j_id, MediaType.APPLICATION_JSON));	
		reservation.setJourney(clientResponse1.readEntity(Journey.class));
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(reservation, MediaType.APPLICATION_JSON));
		String status="no";
		 status=clientResponse.readEntity(String.class);
		RequestDispatcher rd = request.getRequestDispatcher("Ticket.jsp");
			request.setAttribute("ticket", reservation);
			rd.forward(request, response);

	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
