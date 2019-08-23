package bean;

import java.sql.Date;
import java.util.ArrayList;

public class BusDetails {
		private int journey_id;
		private int bus_id;
		private int routeno1;
		private int routeno2;
		private String bus_type;
		private int available_seats;
		private int startingpoint;
		private int endingpoint;
		private Date journey_date;
		private Long fare;
		public ArrayList<BusDetails> list;
		public ArrayList<BusDetails> getList() {
			return list;
		}
		public void setList(ArrayList<BusDetails> list) {
			this.list = list;
		}
		public Long getFare() {
			return fare;
		}
		public void setFare(Long long1) {
			this.fare = long1;
		}
		public Date getJourney_date() {
			return journey_date;
		}
		public void setJourney_date(Date date) {
			this.journey_date = date;
		}
		public int getJourney_id() {
			return journey_id;
		}
		public void setJourney_id(int journey_id) {
			this.journey_id = journey_id;
		}
		public int getBus_id() {
			return bus_id;
		}
		public void setBus_id(int bus_id) {
			this.bus_id = bus_id;
		}
		public int getRouteno1() {
			return routeno1;
		}
		public void setRouteno1(int routeno1) {
			this.routeno1 = routeno1;
		}
		public int getRouteno2() {
			return routeno2;
		}
		public void setRouteno2(int routeno2) {
			this.routeno2 = routeno2;
		}
		public String getBus_type() {
			return bus_type;
		}
		public void setBus_type(String bus_type) {
			this.bus_type = bus_type;
		}
		public int getAvailable_seats() {
			return available_seats;
		}
		public void setAvailable_seats(int available_seats) {
			this.available_seats = available_seats;
		}
		public int getStartingpoint() {
			return startingpoint;
		}
		public void setStartingpoint(int startingpoint) {
			this.startingpoint = startingpoint;
		}
		public int getEndingpoint() {
			return endingpoint;
		}
		public void setEndingpoint(int endingpoint) {
			this.endingpoint = endingpoint;
		}
		@Override
		public String toString() {
			return "BusDetails [journey_id=" + journey_id + ", bus_id=" + bus_id + ", routeno1=" + routeno1
					+ ", routeno2=" + routeno2 + ", bus_type=" + bus_type + ", available_seats=" + available_seats
					+ ", startingpoint=" + startingpoint + ", endingpoint=" + endingpoint + ", journey_date="
					+ journey_date + ", fare=" + fare + "]";
		}
		
		
		
}