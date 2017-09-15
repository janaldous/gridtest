import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Grid {
	private List<Event> events;
	private int length, width;
	
	public Grid(int x, int y) {
		events = new ArrayList<Event>();
		length = x;
		width = y;
	}
	
	/**
	 * Populates events list with seed data including tickets
	 * @param noOfEvents
	 */
	public void makeSeedData(int noOfEvents) {
		//create seed data
		Random r = new Random();
		for(int i = 0; i < noOfEvents; i++) {
			int x = r.nextInt(length+length) - length;
			int y = r.nextInt(width+width) - width;
			List<Ticket> tickets = new ArrayList<Ticket>();
			// assumes there are 4 types of tickets with different prices
			// and different numbers of tickets each.
			for (int j = 0; j < 4; j++) {
				int n = r.nextInt(40);
				double price = r.nextInt(1000) + (r.nextInt(99)/100) + 1;
				Ticket t = new Ticket(n, price);
				tickets.add(t);
			}
			
			Point p = new Point(x, y);
			// creation of event
			Event e = new Event(p, tickets);
			if (events.contains(e)) {
				i++;
				continue;
			}
			// event added to events list
			events.add(e);
			System.out.println(e);
		}
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	/**
	 * Finds 5 nearest events to inputed coordinate. Calculates Manhattan distance
	 * between the input to each event. Events are sorted according to distance to
	 * input and then cheapest price of event. Returns and prints 5 events with the 
	 * shortest distances.
	 * @param x
	 * @param y
	 * @return
	 */
	public List<EventDistance> findNearestEvents(int x, int y) {
		//calculate distance for all events
		EventDistance[] distances = new EventDistance[events.size()];
		for(int i = 0; i < events.size(); i++) {
			Event e = events.get(i);
			int d = e.calculateDistance(new Point(x, y));
			distances[i] = new EventDistance(d, e);
		}
		
		//sort distances
		Arrays.sort(distances);
		
		//set output to first 5 events in the array
		List<EventDistance> output = new ArrayList<EventDistance>();
		for(int i = 0; i < 5; i++) {
			output.add(distances[i]);
		}
		return output;
	}
}
