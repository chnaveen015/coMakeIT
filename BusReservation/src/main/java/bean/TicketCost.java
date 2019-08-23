package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@NamedNativeQueries({ @NamedNativeQuery(name = "hello", query = "SELECT  t FROM TicketCost t")
})
@Entity
public class TicketCost {
	@Id
	private int routeno;
	public int getRouteno() {
		return routeno;
	}
	public void setRouteno(int routeno) {
		this.routeno = routeno;
	}
	@NotNull
	private String source;
	@NotNull
	private String destination;
	@NotNull
	private int fare;
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
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
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	@Override
	public String toString() {
		return "TicketCost [routeno=" + routeno + ", source=" + source + ", destination=" + destination + ", fare="
				+ fare + ",  bus=" + bus + "]";
	}
	
	
}