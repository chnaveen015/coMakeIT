package bean;
import java.sql.Date;

public class BasicDetailsBean {
	@Override
	public String toString() {
		return "BasicDetailsBean [source=" + source + ", destination=" + destination + ", noOfSeats=" + noOfSeats
				+ ", dateOfJourney=" + dateOfJourney + "]";
	}
	String source,destination;
	int noOfSeats;
	String dateOfJourney;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getDateOfJourney() {
		return String.valueOf(dateOfJourney);
	}
	public void setDateOfJourney(String dateofjourney) {
		this.dateOfJourney = dateofjourney ;
	}
}