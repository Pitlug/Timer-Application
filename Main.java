import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Main {
    public static void main(String[] args) {
    	System.out.println("The time taken in milliseconds is: "+timerbutton());
    }
    static long timerbutton() {
    	long start = System.currentTimeMillis();
    	// when button is clicked the rest of the function will execute
    	
    	long end = System.currentTimeMillis() - start;
    	return end;
    	}
    
}
