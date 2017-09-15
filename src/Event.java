import java.util.ArrayList;
import java.util.List;


public class Event {
	private static int no = 0;
	/**
	 * unique id for this event
	 */
	private String id;
	/**
	 * coordinate of this event
	 */
	private Point point;
	/**
	 * ticket price in US dollars and > US$ 0
	 */
	private double ticketPrice_usd;
	/**
	 * list of Tickets (assumes there are 4 types of differing prices and availability
	 */
	private List<Ticket> tickets;
	/**
	 * stores cheapest ticket from tickets list. numOfTickets != 0
	 */
	private Ticket cheapestTicket;
	
	
	public Event(Point p) {
		this.point = p;
		if (no > 999) {
			throw new IllegalArgumentException("Please enter an id greater than 999.");
		}
		
		tickets = new ArrayList<Ticket>();
		
		no++;
		id = String.format("%03d", no);
	}
	
	public Event(Point p, List<Ticket> tickets) {
		this(p);
		for(Ticket t: tickets) {
			addTicket(t);
		}
	}
	
	/**
	 * Adds a new ticket type to the ticket list. Also updates the cheapest ticket.
	 * Cheapest ticket must not have numOfTickets = 0.
	 * @param ticket
	 */
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		if ((cheapestTicket == null ||
				ticket.getTicketPrice_usd() < cheapestTicket.getTicketPrice_usd())
				&& ticket.getNumOfTickets() > 0) {
			cheapestTicket = ticket;
		}
	}
	
	public String toString() {
		return "id: " + id + "; " 
				+ point + "; " 
				+ "noOfTickets: " + tickets.toString();
	}
	
	/**
	 * Event is the same if the coordinates are the same. (Assumes one event per
	 * coordinate)
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Event 
				&& ((Event)obj).point.equals(this.point)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates Manhattan distance between events.
	 * @param e
	 * @return Manhattan distance between this event and event e
	 */
	public int calculateDistance(Event e) {
		return this.point.calculateDistance(e.point);
	}
	
	/**
	 * Calculates Manhattan distance between this event and a coordinate.
	 * @param point
	 * @return Manhattan distance between this event and a coordinate
	 */
	public int calculateDistance(Point point) {
		return this.point.calculateDistance(point);
	}
	
	public String getId() {
		return id;
	}
	
	public double getTicketPrice() {
		return ticketPrice_usd;
	}

	public Ticket getCheapestTicket() {
		return cheapestTicket;
	}
}
