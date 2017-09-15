
public class Ticket {
	/**
	 * Number of tickets, can be 0
	 */
	private int numOfTickets;
	/**
	 * Ticket price in US dollars, cannot be 0
	 */
	private double ticketPrice_usd;
	
	public Ticket(int n, double p) {
		numOfTickets = n;
		if (p <= 0) {
			throw new IllegalArgumentException("Please enter a price greater than 0.");
		}
		ticketPrice_usd = p;
	}

	public double getTicketPrice_usd() {
		return ticketPrice_usd;
	}
	
	public int getNumOfTickets() {
		return numOfTickets;
	}
	
	public String toString() {
		return "{" + numOfTickets + ", " + ticketPrice_usd + "}";
	}
}
