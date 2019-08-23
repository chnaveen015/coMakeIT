package bean;

public class Details {
	String date;
	int bus_id;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	@Override
	public String toString() {
		return "Details [date=" + date + ", bus_id=" + bus_id + "]";
	}
	
}
