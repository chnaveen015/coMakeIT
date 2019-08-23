package repository;

import java.sql.Date; 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import bean.BasicDetailsBean;
import bean.Bus;
import bean.BusDetails;
import bean.Details;
import bean.Journey;
import bean.Login;
import bean.NoOfBusesDetails;
import bean.Reservation;
import bean.SeatAvailable;
import bean.TicketCost;
import connection.ConnectionEstablishment;

public class BusDao {
	// Returns available source list.
	//Returns list of Strings
	//used to display available sources
	public ArrayList<String> getSources() {
		// TODO Auto-generated method stub
		EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		ArrayList<String> sources = (ArrayList<String>) entityManager
				.createQuery("select distinct t.source from TicketCost t").getResultList();
		entityManager.getTransaction().commit();
		return sources;
	}
	// Returns available destination list.
		//Returns list of Strings
	//used to display available destinations
	public ArrayList<String> getDestinations() {
		// TODO Auto-generated method stub
		EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		ArrayList<String> destination = (ArrayList<String>) entityManager
				.createQuery("select distinct t.destination from TicketCost t").getResultList();
		entityManager.getTransaction().commit();
		return destination;
	}
	//returns available buses from source A to Destination B
	//It also checks whether given seats are available or not based on the specified date
	//parameters are BasicDetailsBean object contains basicDetails
	 public ArrayList<BusDetails> getAvailableBus(BasicDetailsBean details)
	    {
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		 entityManager.getTransaction().begin();
	    	ArrayList<TicketCost> sourceList=(ArrayList<TicketCost>)entityManager.createQuery("select t from TicketCost t where t.source=?1").setParameter(1,details.getSource()).getResultList();
	    	ArrayList<TicketCost> destinationList=(ArrayList<TicketCost>)entityManager.createQuery("select t from TicketCost t where t.destination=?1").setParameter(1,details.getDestination()).getResultList();
	    	Iterator sources=sourceList.iterator();
	    	Iterator destinations=destinationList.iterator();
	    	TicketCost source,destination;
	    	Bus sourceBus,destinationBus;
	    	ArrayList<BusDetails> busDetailsList=new ArrayList<BusDetails>();
	    	while(sources.hasNext()&&destinations.hasNext())
	    	{
	    		source=(TicketCost) sources.next();
	    		destination=(TicketCost) destinations.next();
	    		sourceBus=source.getBus();
	    		destinationBus=destination.getBus();
	    		if(sourceBus.getBus_id()==destinationBus.getBus_id() && sourceBus.getBus_id()==destinationBus.getBus_id())
	    		{		
	    			BusDetails busDetails=new BusDetails();
	    			BusDetails b=new BusDetails();
	    			busDetails.setBus_id(sourceBus.getBus_id());
	    			busDetails.setRouteno1(source.getRouteno());
	    			busDetails.setRouteno2(destination.getRouteno());
	    			busDetails.setJourney_date(Date.valueOf(details.getDateOfJourney()));
	    			
	    			busDetails=new BusDao().getJourneyId(busDetails);
	    			if(busDetails.getJourney_id()!=0)
	    			{
	    			busDetails=new BusDao().getAvailableSeats(busDetails);
	    			if(busDetails.getAvailable_seats()>details.getNoOfSeats())
	    			{
	    				busDetails.setFare(new BusDao().getFare(busDetails));
	    				busDetailsList.add(busDetails);
	    			}
	    			}
	    		}
	    		}
	    	entityManager.getTransaction().commit();	
	    	return busDetailsList;
	    }

	public BusDetails getJourneyId(BusDetails busDetails) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Bus bus;
		ArrayList<Journey> destination = (ArrayList<Journey>) entityManager
				.createQuery("select journey from Journey journey where journey.journey_date = ?1 and bus_id =?2")
				.setParameter(1, busDetails.getJourney_date()).setParameter(2, busDetails.getBus_id()).getResultList();
		for (Journey journey : destination) {
			bus = journey.getBus();
			if (bus.getBus_id() == busDetails.getBus_id()) {
				busDetails.setJourney_id(journey.getJourney_id());
				busDetails.setBus_type(bus.getBus_type());
				return busDetails;
			}
		}
		entityManager.getTransaction().commit();

		return busDetails;

	}

	public BusDetails getAvailableSeats(BusDetails busDetails) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Integer available_seats = (Integer) entityManager.createQuery(
				"select min(seat.available_seats) from SeatAvailable seat where journey_id=?1 and (routeno>=?2 and routeno<=?3)")
				.setParameter(1, busDetails.getJourney_id()).setParameter(2, busDetails.getRouteno1())
				.setParameter(3, busDetails.getRouteno2()).getSingleResult();
		if (available_seats != null && available_seats > 0)
			busDetails.setAvailable_seats(available_seats);
		entityManager.getTransaction().commit();

		return busDetails;

	}

	public Long getFare(BusDetails busDetails) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Long fare = (Long) entityManager.createQuery(
				"select sum(ticket.fare) from TicketCost ticket where (ticket.routeno>=?1 and ticket.routeno<=?2)")
				.setParameter(1, busDetails.getRouteno1()).setParameter(2, busDetails.getRouteno2()).getSingleResult();
		if (fare > 0)
			return fare;
		entityManager.getTransaction().commit();

		return (long) 0;

	}

	public String reserveTicket(Reservation reservation) {
		// TODO Auto-generated method stub
		Integer flag=null;
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery(
				"update SeatAvailable set available_seats=available_seats-?1 where journey_id=?2 and (routeno>=?3 and routeno<=?4)")
				.setParameter(1, reservation.getNo_of_seats()).setParameter(2, reservation.getJourney().getJourney_id())
				.setParameter(3, reservation.getStopno1()).setParameter(4, reservation.getStopno2());
		query.executeUpdate();
		Query query1=entityManager.createQuery("update Journey set total_cost=total_cost+?1 where journey_id=?2").setParameter(1, reservation.getFare()).setParameter(2, reservation.getJourney().getJourney_id());
		flag=query1.executeUpdate();
		entityManager.persist(reservation);

		entityManager.getTransaction().commit();
		if(flag!=null)
		return "yes";
		else
			return "no";
	}

	public String cancelTicket(Integer pnr) {
		// TODO Auto-generated method stub
		Integer flag=null;
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Reservation reservation=entityManager.find(Reservation.class, pnr);
		if(reservation!=null)
		{
		Query query = entityManager.createQuery(
				"update SeatAvailable set available_seats=available_seats+?1 where journey_id=?2 and (routeno>=?3 and routeno<=?4)")
				.setParameter(1, reservation.getNo_of_seats()).setParameter(2, reservation.getJourney().getJourney_id())
				.setParameter(3, reservation.getStopno1()).setParameter(4, reservation.getStopno2());
		query.executeUpdate();
		Query query1=entityManager.createQuery("update Journey set total_cost=total_cost-?1 where journey_id=?2").setParameter(1, reservation.getFare()).setParameter(2, reservation.getJourney().getJourney_id());
		 flag=query1.executeUpdate();
		
		
		entityManager.remove(reservation);
		}
		
		entityManager.getTransaction().commit();
		if(flag!=null)
			return "yes";
		else
		return "no";
	}

	public Reservation viewTicket(Integer pnr) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Reservation reservation=entityManager.find(Reservation.class, pnr);
		entityManager.getTransaction().commit();
		return reservation;
	}

	public ArrayList<Journey> viewIncome(String dateOfJourney) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		ArrayList<Journey> incomeDetails=(ArrayList<Journey>) entityManager.createQuery("select busdetails from Journey busdetails where journey_date=?1").setParameter(1, Date.valueOf(dateOfJourney)).getResultList();
		entityManager.getTransaction().commit();
		return incomeDetails;
	}

	public ArrayList<Reservation> viewPassengers(Details details) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		ArrayList<Reservation> passengers=(ArrayList<Reservation>) entityManager.createQuery("select passengers from Reservation passengers where passengers.dateOfJourney=?1 and bus_id=?2").setParameter(1, details.getDate()).setParameter(2, details.getBus_id()).getResultList();
		entityManager.getTransaction().commit();
		return passengers;
	}

	public Integer getNoOfBuses(NoOfBusesDetails details) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		 entityManager.getTransaction().begin();
    	ArrayList<TicketCost> sourceList=(ArrayList<TicketCost>)entityManager.createQuery("select t from TicketCost t where t.source=?1").setParameter(1,details.getSource()).getResultList();
    	ArrayList<TicketCost> destinationList=(ArrayList<TicketCost>)entityManager.createQuery("select t from TicketCost t where t.destination=?1").setParameter(1,details.getDestination()).getResultList();
    	Iterator sources=sourceList.iterator();
    	Iterator destinations=destinationList.iterator();
    	TicketCost source,destination;
    	Bus sourceBus,destinationBus;
    	int count=0;
    	ArrayList<BusDetails> busDetailsList=new ArrayList<BusDetails>();
    	while(sources.hasNext()&&destinations.hasNext())
    	{
    		source=(TicketCost) sources.next();
    		destination=(TicketCost) destinations.next();
    		sourceBus=source.getBus();
    		destinationBus=destination.getBus();
    		if(sourceBus.getBus_id()==destinationBus.getBus_id() && sourceBus.getBus_id()==destinationBus.getBus_id())
    		{		
    			BusDetails busDetails=new BusDetails();
    			BusDetails b=new BusDetails();
    			busDetails.setBus_id(sourceBus.getBus_id());
    			count+=new BusDao().getBusCount(busDetails,details);
    			
    			}
    	}
    	entityManager.getTransaction().commit();	
    	return count;
	}


	private int getBusCount(BusDetails busDetails, NoOfBusesDetails details) {
		// TODO Auto-generated method stub
		 EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Bus bus;
		ArrayList<Journey> destination = (ArrayList<Journey>) entityManager
				.createQuery("select journey from Journey journey where journey.journey_date >=?1 and journey.journey_date<=?2 and bus_id =?3")
				.setParameter(1, Date.valueOf(details.getStartDate())).setParameter(2, Date.valueOf(details.getEndDate())).setParameter(3, busDetails.getBus_id()).getResultList();
		
		entityManager.getTransaction().commit();

		return destination.size();
	}

	public Journey getJourney(Integer journey_id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = new ConnectionEstablishment().getConnection();
		entityManager.getTransaction().begin();
		Journey journey=entityManager.find(Journey.class, journey_id);
		entityManager.getTransaction().commit();
		return journey;
	}


}