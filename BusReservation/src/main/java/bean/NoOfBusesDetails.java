package bean;

public class NoOfBusesDetails {
		private String source;
		private String destination;
		private String startDate;
		private String endDate;
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
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		@Override
		public String toString() {
			return "NoOfBusesDetails [source=" + source + ", destination=" + destination + ", startDate=" + startDate
					+ ", endDate=" + endDate + "]";
		}
		
}
