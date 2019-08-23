package com.busreservation.BusReservation;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.BasicDetailsBean;
import bean.Bus;
import bean.BusDetails;
import bean.Details;
import bean.Journey;
import bean.NoOfBusesDetails;
import bean.Reservation;
import bean.TicketCost;
import repository.BusDao;
@Path("/Buses")
public class BusResources {
	@POST
    @Path("/available-buses")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BusDetails> getBuses(BasicDetailsBean details)
	{
		
		ArrayList<BusDetails>busDetailsList=new BusDao().getAvailableBus(details);
		return busDetailsList;	
	}
	@POST
    @Path("/reserve-ticket")
    @Produces(MediaType.APPLICATION_JSON)
	public String reserveTicket(Reservation reservation)
	{
		
		
		String status=new BusDao().reserveTicket(reservation);
		return status;	
	}
	@POST
    @Path("/cancel-ticket")
    @Produces(MediaType.APPLICATION_JSON)
	public String cancelTicket(Integer pnr)
	{
	
		
		String status=new BusDao().cancelTicket(pnr);
		return status;	
	}
	@POST
    @Path("/view-ticket")
    @Produces(MediaType.APPLICATION_JSON)
	public Reservation viewTicket(Integer pnr)
	{
	
		
		Reservation ticket=new BusDao().viewTicket(pnr);
		return ticket;	
	}
	@POST
    @Path("/view-income")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Journey> viewIncome(String dateOfJourney)
	{
	
		
		ArrayList<Journey> incomeDetails=(ArrayList<Journey>)new BusDao().viewIncome(dateOfJourney);
		return incomeDetails;	
	}
	@POST
    @Path("/view-passengers")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reservation> viewPassengers(Details details)
	{
	
		
		ArrayList<Reservation> passengers=(ArrayList<Reservation>)new BusDao().viewPassengers(details);
		return passengers;	
	}
	@POST
    @Path("/total-No-Of-buses")
    @Produces(MediaType.APPLICATION_JSON)
	public Integer getNoBuses(NoOfBusesDetails details)
	{
		
		Integer noOfBuses=new BusDao().getNoOfBuses(details);
		return noOfBuses;	
	}
	@POST
    @Path("/get-journey-details")
    @Produces(MediaType.APPLICATION_JSON)
	public Journey getJourney(Integer journey_id)
	{
		Journey journey=new BusDao().getJourney(journey_id);
		return journey;	
	}
	@GET
    @Path("/get-sources")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> getSources()
	{
		ArrayList<String> source = new BusDao().getSources();
		return source;	
	}
	@GET
    @Path("/get-destinations")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> getDestinations()
	{
		ArrayList<String> destination = new BusDao().getDestinations();
		return destination;	
	}
   
}