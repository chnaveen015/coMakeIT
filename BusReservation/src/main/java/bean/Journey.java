package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Journey {
	@Id
	private int journey_id;
//	@NotNull
//	private String bus_id;
	@NotNull
	private Date journey_date;
	private int total_cost;
	@OneToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	public int getJourney_id() {
		return journey_id;
	}

	public void setJourney_id(int journey_id) {
		this.journey_id = journey_id;
	}

	public String getJourney_date() {
		return String.valueOf(journey_date);
	}

	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}

	public int getCost() {
		return total_cost;
	}

	public void setCost(int total_cost) {
		this.total_cost = total_cost;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Journey [journey_id=" + journey_id + ", journey_date=" + journey_date + ", total_cost=" + total_cost
				+ ", bus=" + bus + "]";
	}

}
