


public class EventDistance implements Comparable<EventDistance> {
	public int distance;
	public Event event;
	
	public EventDistance(int d, Event e) {
		this.distance = d;
		this.event = e;
	}
	
	public String toString() {
		return "Event " + event.getId() 
				+ " - $" + event.getCheapestTicket().getTicketPrice_usd() 
				+ ", Distance " + distance;
	}
	
	/**
	 * Compares 2 EventDistances by distance and then cheapest ticket price.
	 */
	@Override
    public int compareTo(EventDistance ed2) {
    	if (this.distance == ed2.distance) {
    		return Double.compare(this.event.getCheapestTicket().getTicketPrice_usd(),
    				ed2.event.getCheapestTicket().getTicketPrice_usd());
    	}
        return Integer.compare(this.distance, ed2.distance);
    }
}
