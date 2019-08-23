package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	private int pnr;
	private String name;
	@ManyToOne
	@JoinColumn(name="journey_id")
	private Journey journey;
	private int bus_id;
	private int stopno1;
	private int stopno2;
	private String source;
	private String destination;
	private int no_of_seats;
	private String dateOfJourney;
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	private int fare;
	private String id_proof_no;
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public int getStopno1() {
		return stopno1;
	}
	public void setStopno1(int stopno1) {
		this.stopno1 = stopno1;
	}
	public int getStopno2() {
		return stopno2;
	}
	public void setStopno2(int stopno2) {
		this.stopno2 = stopno2;
	}
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
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getId_proof_no() {
		return id_proof_no;
	}
	public void setId_proof_no(String id_proof_no) {
		this.id_proof_no = id_proof_no;
	}
	@Override
	public String toString() {
		return "Reservation [pnr=" + pnr + ", name=" + name + ", journey=" + journey + ", stopno1=" + stopno1
				+ ", stopno2=" + stopno2 + ", source=" + source + ", destination=" + destination + ", no_of_seats="
				+ no_of_seats + ", dateOfJourney=" + dateOfJourney + ", fare=" + fare + ", id_proof_no=" + id_proof_no
				+ "]";
	}
	
}
