import java.util.Scanner;

public class ParkourRunner {
	
	
	public static void main(String[] args) {
		runStart();
		
	}
	/*
	 * Desc: Method used to start the game. This was created in another method than the main string method, because it needed to be called on.
	 * Pre: N/A
	 * Post: N/A
	 */
	public static void runStart() {
		String name;
		int score=10000;
		int revive=0;
		int doublePoints=0;
		int slowTime=0;
		String action;
			
		Scanner input = new Scanner(System.in);

		System.out.println("Hello there, and welcome to parkourRunner!");
		System.out.println("In this game you must escape the drug dealer chasin bg you, and your score is your currency.");
		System.out.println("What is your name, young ninja?");
		name = input.nextLine();
		
		//If the player has no score, giving them the option to go to the store would be pointless.
		if (score == 0) {
			System.out.println("Hello " + name + ", you currently have "+ score + " points, but you must escape! QUICK, RUN!");
			RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name);
		} else if (score > 500) {
			System.out.println("Hello " + name + ", you currently have " + score + " points, what would you like to do, 'run' or 'shop'?");
			action = input.nextLine();
			if (action.equalsIgnoreCase("shop")) {
				Shop buyItems = new Shop(score, revive, slowTime, doublePoints, name);
			} else if (action.equalsIgnoreCase("run")) {
				RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name);
			}
		}
	}
	
	

}
