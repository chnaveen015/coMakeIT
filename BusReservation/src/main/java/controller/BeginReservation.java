package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BusDetails;

/**
 * Servlet implementation class BeginReservation
 */
public class BeginReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeginReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag=0;
		HttpSession session=request.getSession();
		int bus_id=(Integer.parseInt(request.getParameter("bus_id")));
		ArrayList<BusDetails>details=(ArrayList<BusDetails>) session.getAttribute("viewBuses");
		if(details!=null)
		for(BusDetails busDetails:details)
		{
			if(bus_id==busDetails.getBus_id())
			{
				flag=1;
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("Reservation.jsp");
				request.setAttribute("busDetails", busDetails);
				requestDispatcher.forward(request, response);
			}
		}
		if(flag==0)
			System.out.println("enter valid Bud_id");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
