import javax.swing.Timer;

import java.awt.event.*;
import java.lang.Math;
import java.util.Scanner;

public class RunStart {
	private int interval = 1000;
	private int interval1 = 125;
	private int num = 11;
	private int num1 = 0;
	private int deaths = 0;
	private String name1;
	private int score = 0, revive1, doublePoints1, slowTime1;
	private int points = 100;
	private boolean activeDP = false, activeST = false;
	private int temp;
	private String playerDecision;

	//A timer that is used to count down the players time.
	Timer t = new javax.swing.Timer(interval, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (deaths == 5) {
				System.out.println("You have 5 deaths, the game is over!");
				HighScore endGame = new HighScore(score, name1);
			}
			num--;
			System.out.println(num);
			if (num == 0) {
				t.stop();
				System.out.println("You smash into the object, falling over while the drug dealer kicks you in the face and kills a kitten.");
				fail();
			}

			if (activeST == true) {
				interval = 1500;
			}
		}
	});

	//The second timer used for only the last obstacle.
	Timer t1 = new javax.swing.Timer(interval1, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(num1);
			num1++;
			if (num1 == 3) {
				num1 = 1;
			} 
			if (activeST == true) {
				interval1 = 250;
			}
		}
	});
	/*
	 * Desc: The constructor method for the class RunStart.
	 * Pre: Imports Score1, revive, doublePoints and Slowtime and intializes them as integers. Imports name, and intializes it as a String.
	 * Pre: N/A
	 */
	public RunStart(int score1, int revive, int doublePoints, int slowTime, String name){
		score = score1;
		revive1 = revive;
		name1 = name;
		doublePoints1 = doublePoints;
		slowTime1 = slowTime;
		Scanner input = new Scanner(System.in);

		if (doublePoints1 > 0) {
			System.out.println("You currently have " + doublePoints1 + " double points in store.");
			System.out.println("Would you like to use one? 'yes' or 'no'?");
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("yes")){
				activeDP = true;
			} else {
				System.out.println("So be it.");
				activeDP = false;
			}
		}

		if (slowTime1 > 0) {
			System.out.println("You currently have " + slowTime1 + " slow time in store.");
			System.out.println("Would you like to use one? 'yes' or 'no'?");
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("yes")){
				activeST = true;
			} else {
				System.out.println("So be it.");
				activeDP = false;
			}
		}
		wallJump();
	}

	/*
	 * Desc: Initialize's a random number, imports a scanner and calls upon fence() when finished.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void pipe(){
		num = 11;
		int RandNum = (int)(10 * Math.random() + 1);
		Scanner input = new Scanner(System.in);


		System.out.println("You start to run away from the drug dealer, entering the city with a lot of obstacles.");
		System.out.println("You see a pole in front of you. Type 'jump' at " + RandNum + " seconds to jump the pole!");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			pipe();
		}

		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("jump") && (num == RandNum)){
			t.stop();
			if (activeDP == true) {
				score = score + 200;
				System.out.println("Since you had double points active, you gain double the points!!");
				System.out.println("You succesfully jump the pole, gaining 200 points and continue running at full speed.");
			} else if (activeDP == false) {
				score = score + 100;
				System.out.println("You succesfully jump the pole, gaining 100 points and continue running at full speed.");
			}

			fence();	
		} else {
			temp++;
			fail();
		}
	}
	/*
	 * Desc: Initialize's two random numbers, imports a scanner and calls upon roofTop() when finished.
	 * Desc: The second random number is used to give the user an option over which course of action they want to take.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void fence() {
		num = 11;
		int RandNum = (int)(((10-6)+1) * Math.random() + 6);
		int RandNum1 = (int)(((4-1)+1) * Math.random() + 1);

		Scanner input = new Scanner(System.in);
		System.out.println("You see a six foot fence in front of you, type 'climb' at " + RandNum + " seconds to climb the fence, or 'jump' at " 
				+ "\n" + RandNum + " seconds to jump the fence, and 'jump' again at " + RandNum1 + " seconds, because it takes 2 jumps!");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			fence();
		}

		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("climb") && (num == RandNum)) {
			t.stop();
			if (activeDP == true) {
				score = score + 200;
				System.out.println("Since you had double points active, you gain double the points!!");
				System.out.println("You succesfully climb the fence, gaining 200 points and continue running at full speed.");
			} else if (activeDP == false) {
				score = score + 100;
				System.out.println("You succesfully climb the fence, gaining 100 points and continue running at full speed.");
				roofTop();
			}
		} else if (playerDecision.equalsIgnoreCase("jump") && (num == RandNum))  {
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("jump")&& (num==RandNum1)) {
				if (activeDP == true) {
					score = score + 400;
					System.out.println("Since you had double points active, you gain double the points!!");
					System.out.println("The double jump over the fence, gaining 400 points and continue running at full speed.");
				} else if (activeDP == false) {
					score = score + 200;
					System.out.println("You succesfully jump the pole, and continue running at full speed gaining 200 points.");
				}
				t.stop();
				roofTop();
			}
		}	else  {
			temp++;
			fail();
		} 
	}

	/*
	 * Desc: Uses a while loop to determine when the player has typed in 'climb' 5 times and imports a scanner.
	 * Desc: A while loop was used to have a continuous input.nextLine(); and not have to put 5 seperate ones.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void roofTop() {
		num = 11;
		int climb=0;
		Scanner input = new Scanner(System.in);
		System.out.println("You come to a seemingly dead end,  and you can hear your pursuer's feet pounding behind you.");
		System.out.println("As he comes up behind you, you realize you can climb the wall to the roof!");
		System.out.println("Type 'climb' 5 times before the timer reaches 0 to climb the roof.");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			roofTop();
		}

		//This while loop is used to count all the times the user enters "climb".
		while (climb != 5) {	
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("climb")) {
				climb++;
				if (climb==5) {
					t.stop();
					System.out.println("You climb up the wall like a spider, while the drug dealer stuggles, you gain 500 points.");
					if (activeDP == true) {
						score = score + 1000;
						System.out.println("Since you had double points active, you gain double the points!!");
						System.out.println("You succesfully climb to the roof top, gaining 1000 points and continue running at full speed.");
					} else if (activeDP == false) {
						score = score + 500;
						System.out.println("You succesfully climb to the roof top, gaining 500 points and continue running at full speed.");
					}
					fourPole();
					temp++;
				}
			}

		}
	}
	/*
	 * Desc: Uses a series of if statements, to have the user jump over 4 consecutive poles that are 2 seconds between each other and imports a scanner.
	 * Desc: Tried using a for loop instead of 4 if statements, but game would not work.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void fourPole() {
		num = 11;
		Scanner input = new Scanner(System.in);
		System.out.println("Whilst on the roof, you see 4 poles that you need to jump to cross a gap!");
		System.out.println("Type 'jump' at 8 seconds, 6 seconds, 4 seconds, and 2 seconds to jump the 4 poles!!");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			fourPole();
		}

		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("jump")&&(num ==8)){
			System.out.println("You jump the first pole!");
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("jump")&&(num==6)){
				System.out.println("You jump the second pole!");
				playerDecision = input.nextLine();
				if (playerDecision.equalsIgnoreCase("jump")&&(num==4)){
					System.out.println("You jump the third pole!");
					playerDecision = input.nextLine();
					if (playerDecision.equalsIgnoreCase("jump")&&(num==2)){
						System.out.println("You jump the last pole, and complete the obstacle!");
						if (activeDP == true) {
							score = score + 800;
							System.out.println("Since you had double points active, you gain double the points!!");
							System.out.println("You succesfully climb the wall, gaining 800 points and continue running at full speed.");
							t.stop();
						} else if (activeDP == false) {
							score = score + 400;
							System.out.println("You succesfullyclimb the wall, gaining 400 points and continue running at full speed.");
							t.stop();
						}
						wallJump();
					}
				}
			}
			else {
				t.stop();
				temp++;
				fail();
			}

		}

	}
	/*
	 * Desc: Uses 2 seperate while loops to determine if the user enters 'right' and 'left' the correct amount of times.
	 * Desc: Tried to have the player enter left, and then right but would not work with current set up.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void wallJump(){
		num = 15;
		int right=0;
		int left=0;

		Scanner input = new Scanner(System.in);
		System.out.println("You approach two walls, one on either side of you. You must run up the left side, then run up the right side.");
		System.out.println("Type 'left' 4 times and then 'right' 4 times to shimmy up the wall in under 15 seconds!");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			wallJump();
		}

		// This while loops is used to determine if the user types 'left' and 'right' the correct amount of times.
		while (left != 4) {
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("left")){
				left++;
			}
		}
		if (left == 4){
			System.out.println("You have typed left 4 times, now start typing right!!");
		}
		while (right !=4) {
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("right")) {
				right++;
			}
		}


		if (left == 4 && right == 4) {
			t.stop();
			System.out.println("You struggle to the top and keep running. You look over the city, and you realise that you are on top of the tallest building.");
			if (activeDP == true) {
				score = score + 800;
				System.out.println("Since you had double points active, you gain double the points!!");
				System.out.println("You succesfully shimmy the double wall, gaining 800 points and continue running at full speed.");
				t.stop();
			} else if (activeDP == false) {
				score = score + 400;
				System.out.println("You succesfully shimmy the double wall, gaining 400 points and continue running at full speed.");
				t.stop();
			}
			System.out.println("There is a rail road bridge ahead of you, the only way to get away from the drug dealer is to hop on the train.");
			temp++;
			runAndJump();
		}

	}
	/*
	 * Desc: Uses another for loop to detect whether the user inputs 'run' enough times to jump.
	 * Desc: Imports an input scanner also. 
	 * Pre: N/A
	 * Post: N/A
	 */
	public void runAndJump(){
		num = 11;
		int run = 0;
		System.out.println("To get the train, you must run and jump from the top of the building to the bridge. You must gain speed first.");
		System.out.println("Type 'run' 4 times and then 'jump' to get over to the bridge. The faster you do this, the more points you get!");
		System.out.println("Type 'yes' when ready.");
		Scanner input = new Scanner(System.in);

		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t.start();
		} else {
			wallJump();
		}

		while (run!=4){
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("run")){
				run++;
				if (run==4&&(playerDecision.equalsIgnoreCase("jump")));
				System.out.println("You gain enough speed, and jump over the ravine just making the jump.");
				System.out.println("As your feet land on train tracks, you hear a noise in the background. A TRAIN IS COMING!!");
				if (activeDP == true) {
					score = score + 800;
					System.out.println("Since you had double points active, you gain double the points!!");
					System.out.println("You succesfully shimmy the double wall, gaining 500 points and continue running at full speed.");
					t.stop();
				} else if (activeDP == false) {
					score = score + 400;
					System.out.println("You succesfully shimmy the double wall, gaining 250 points and continue running at full speed.");
					t.stop();
				}
			}
		}


	}
	/*
	 * Desc: The final obstacle, which then calls on HighScore or restarts the game depending on the users decision.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void trainBoxCar() {

		Scanner input = new Scanner(System.in);
		System.out.println("A train comes barreling through, blowing your hair into your eyes.");
		System.out.println("You notice that every second boxcar on the train is open, so you must time your jump perfectly.");
		System.out.println("Type 'jump' at 1 second to get into the box car to get away from the drug dealer!!");
		System.out.println("Type 'yes' when ready.");
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			t1.start();
		} else {
			trainBoxCar();
		}
		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("jump")&&(num1==2)){
			t1.stop();
			System.out.println("You jump at the right time, sliding into the train care. You leave the drug dealer behind, going off to start another life.");
			System.out.println("CONGRATZ!!! You have completed the game, here are the high scores!!" );
			HighScore endGame = new HighScore(score, name1);
			endGame.readScore();
			endGame.bubbleSort();
			endGame.writeScore();
		} else {
			t1.stop();
			System.out.println("You miss your chance, jumping between the cars and getting thrown underneath the train. Game over.");
			System.out.println("To start a new game type 'run again', or if you want to go to the shop type 'shop");
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("run again")){
				pipe();
			} else if (playerDecision.equalsIgnoreCase("shop")) {
				Shop buyItems = new Shop(score, revive1, doublePoints1, slowTime1, name1);
			} else {
				System.out.println("I'm sorry, that is not a valid command. I will send you to the shop to improve!");
				Shop buyItems = new Shop(score, revive1, doublePoints1, slowTime1, name1);
			}
		}

	}
	/*
	 * Desc: If the player fails to complete an obstacle, this will be run.  Makes an instace of highScore if the requirements are met, or an instance
	 * of the shop class if the requirements are met.
	 * Desc: It is used to control the amount of code in the other methods.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void fail() {
		Scanner input = new Scanner(System.in);
		if (revive1 > 0) {
			t.stop();
			System.out.println("You have " + revive1 + " amount of revives, would you like to use one? 'yes' or 'no'");
			playerDecision = input.nextLine();
			if (playerDecision.equalsIgnoreCase("yes")){
				revive1--;
				//Checks to see where the user has died, and where to revive them too.
				if (temp == 1) {
					System.out.println("You have " + revive1 + " revives left.");
					pipe();
				} else if (temp == 2) {
					System.out.println("You have " + revive1 + " revives left.");
					fence();
				} else if (temp == 3) {
					System.out.println("You have " + revive1 + " revives left.");
					roofTop();
				} else if (temp == 4) {
					System.out.println("You have " + revive1 + " revives left.");
					fourPole();
				} else if (temp == 5) {
					System.out.println("You have " + revive1 + " revives left.");
					wallJump();
				} else if (temp == 6) {
					System.out.println("You have " + revive1 + " revives left.");
					runAndJump();
				}
			}
		}
		t.stop();
		System.out.println("You fall and the drug dealer captures you. Type 'run again' to go back to the beginning, or 'shop' to go to the shop.");
		System.out.println("Remember, you have " + score + " to spend in the shop!");
		deaths++;
		temp=0;
		System.out.println("You currently have " + deaths + " deaths, remember the game ends at 5 deaths.");
		if (deaths == 5) {
			System.out.println("You have 5 deaths, the game is over!");
			HighScore endGame = new HighScore(score, name1);
			endGame.readScore();
			endGame.bubbleSort();
			endGame.writeScore();	
		}

		playerDecision = input.nextLine();
		if (playerDecision.equalsIgnoreCase("yes")) {
			pipe();	
		} else if (playerDecision.equalsIgnoreCase("no")) {
			Shop buyItems = new Shop(score, revive1, doublePoints1, slowTime1, name1);
		}
	}


}
