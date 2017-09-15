import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
	public static void main(String args[]) {
		Grid grid = new Grid(10, 10);
		
		//make seed data
		grid.makeSeedData(20);
				
		//search 5 nearest events
		System.out.println("Please input coordinates:");
		System.out.print(">");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		sc.close();
		// check if input is in correct format (i.e. 10,10)
	    Pattern r = Pattern.compile("-?\\d+,-?\\d+");
	    Matcher m = r.matcher(input);
	    if(m.find()) {
	    	String[] coor = input.split(",");
			int x, y;
			x = Integer.parseInt(coor[0]);
			y = Integer.parseInt(coor[1]);
			//get 5 nearest events with their cheapest tickets
			List<EventDistance> output = grid.findNearestEvents(x, y);
			
			System.out.println("Closest event to (" + x + ", " + y + "):");
			for(int i = 0; i < 5; i++) {
				System.out.println(output.get(i));
			}
	    } else {
	    	System.out.println("Please enter coordinates in the correct format.");
	    }
		
		

		
	}
}
