package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name="Bus")
public class Bus {
		@Id
		private int bus_id;
		@NotNull
		private String bus_type;
		@NotNull
		private String source;
		@NotNull
		private String destination;
		@NotNull
		private int capacity;
		public int getBus_id() {
			return bus_id;
		}
		public void setBus_id(int bus_id) {
			this.bus_id = bus_id;
		}
		public String getBus_type() {
			return bus_type;
		}
		public void setBus_type(String bus_type) {
			this.bus_type = bus_type;
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
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		@Override
		public String toString() {
			return "Bus [bus_id=" + bus_id + ", bus_type=" + bus_type + ", source=" + source + ", destination="
					+ destination + ", capacity=" + capacity + "]";
		}
		
		
		
}
