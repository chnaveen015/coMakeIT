package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
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


import bean.Bus;
import bean.Journey;
import bean.TicketCost;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		Bus bus=new Bus();
//		bus.setBus_id(Integer.parseInt(request.getParameter("bus_id")));
//		bus.setBus_type(request.getParameter("bus_type"));
//		bus.setSource(request.getParameter("source"));
//		bus.setDestination(request.getParameter("destination"));
//		bus.setCapacity(Integer.parseInt(request.getParameter("capacity")));
//		Journey j=new Journey();
//		j.setJourney_id(Integer.parseInt(request.getParameter("bus_id")));
		TicketCost t=new TicketCost();
		t.setRouteno(Integer.parseInt(request.getParameter("bus_id")));
		Client client = ClientBuilder.newClient( new ClientConfig() );
		
		String apiURL = "http://localhost:8080/BusReservation/webapi/myresource";
		WebTarget webTarget = client.target(apiURL).path("check");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);//
		
		System.out.println("test11 ->" + t);
		
		Response clientResponse = invocationBuilder.post(Entity.entity(t, MediaType.APPLICATION_JSON));
		
		TicketCost validate = clientResponse.readEntity(TicketCost.class);
		Bus b=validate.getBus();
		System.out.println(b.getBus_type());
		//System.out.println("--------> " + validate);
		
				System.out.println("DONE DONE DONE!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
