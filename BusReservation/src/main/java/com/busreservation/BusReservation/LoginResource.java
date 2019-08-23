package com.busreservation.BusReservation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Login;
@Path("login")
public class LoginResource {
	 @POST
	    @Path("validate")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Login getDetails(Login login)
	    {
	    	
	    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("busreservationsystem");
	    	EntityManager entityManager = entityManagerFactory.createEntityManager();
	    	entityManager.getTransaction().begin();
	    	ArrayList<Login> validate=(ArrayList<Login>) entityManager.createQuery("select login from Login login where login.username=?1 and login.password=?2").setParameter(1,login.getUsername()).setParameter(2, login.getPassword()).getResultList();
	    	entityManager.getTransaction().commit();
	    	if(validate!=null)
	    	for(Login loginDetails:validate)
	    		return loginDetails;
	    
			return null;
	    }
}
