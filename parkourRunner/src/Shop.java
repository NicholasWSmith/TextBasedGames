import java.util.Scanner;


public class Shop {
	private String name1;

	/*
	 * Desc: The constructor of the class Shop.
	 * Pre: Imports sco, rev, sloTim, and doubP and intializes them as integers. Imports name as String.
	 * Post: N/A
	 */
	public Shop(int sco, int rev, int sloTim, int doubP, String name){	
		name1 = name;
		int score = sco;
		int revive = rev;
		int slowTime = sloTim;
		int doublePoints = doubP;

		System.out.println("Hi there, and welcome to the shop. What would you like to buy, keep in mind you have " + score + "\n" + " score useable!)");
		System.out.println("You can buy a 'revive' for 500 points.");
		System.out.println("You can buy a 'double points' for 1000 points.");
		System.out.println("You can buy a 'slow time' for 1500 points.");

		buyingItems(score, revive, slowTime, doublePoints);

	}
	/*
	 * Desc: The method used to buy items in the class Shop.
	 * Pre: Imports sco, rev, sloTim, and doubP and intializes them as integers.
	 * Post: Returns score as integer.
	 */ 
	public int buyingItems(int sco, int rev, int sloTim, int doubP){	
		System.out.println("What would you like to buy?");
		Scanner input = new Scanner(System.in);
		String action;
		int score = sco;
		int revive = rev;
		int slowTime = sloTim;
		int doublePoints = doubP;

		action = input.nextLine();

		if (action.equalsIgnoreCase("revive")&&(score <= 500)){
			revive++;
			score = score - 500;
			System.out.println("You buy a revive, and you currently have " + revive + " number of revives and " + score + " score left.");
			System.out.println("Would you like to 'run'? Or 'buy more'?");
			action = input.nextLine();
			if (action.equalsIgnoreCase("run")){
				RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name1);
			} else if (action.equalsIgnoreCase("buy more")) {
				buyingItems(score, revive, slowTime, doublePoints);
			}
		} else if (action.equalsIgnoreCase("double points")&&(score >= 1000)) {
			doublePoints++;
			score = score - 1000;
			System.out.println("You buy a double points, and you currently have " + doublePoints + " number of double points and " + score + " score left.");
			System.out.println("Would you like to 'run'? Or 'buy more'?");
			action = input.nextLine();
			if (action.equalsIgnoreCase("run")){
				RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name1);
			} else if (action.equalsIgnoreCase("buy more")) {
				buyingItems(score, revive, slowTime, doublePoints);
			}
		} else if (action.equalsIgnoreCase("slow time")&&(score >= 1500)) {
			slowTime++;
			score = score - 1500;
			System.out.println("You buy a slow time, and you currently have " + slowTime + " number of slowTimes and " + score + " score left.");
			System.out.println("Would you like to 'run'? Or 'buy more'?");
			action = input.nextLine();
			if (action.equalsIgnoreCase("run")){
				RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name1);
			} else if (action.equalsIgnoreCase("buy more")) {
				buyingItems(score, revive, slowTime, doublePoints);
			}
		} else {
			System.out.println("I'm sorry, that is an invalid option. Please 'try again', or type 'run' to start a new run.");
			action = input.nextLine();
			if (action.equalsIgnoreCase("try again")) {
				buyingItems(score, revive, slowTime, doublePoints);
			} else if (action.equalsIgnoreCase("run")){
				RunStart runner = new RunStart(score, revive, doublePoints, slowTime, name1);
			}

		}
		return(score);
	}

}
