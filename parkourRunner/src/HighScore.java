import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;



public class HighScore {
	private String name1;
	private int score1;
	private String tempName;
	private int tempScore;
	private String arrayName;
	private int arrayScore;
	private String[][] parkourScore = new String[5][2];
	/*
	 * Desc: The constructor of the class HighScore.
	 * Pre: Imports score intializes it as an integers. Imports name as String.
	 * Post: N/A
	 */
	public HighScore(int score, String name) {
		name1 = name;
		score1 = score;
		String stringScore;
		stringScore = Integer.toString(score1);
		parkourScore[0][0] = "1000";
		parkourScore[0][1] = "Jim";
		parkourScore[1][0] = "950";
		parkourScore[1][1] = "Bob";
		parkourScore[2][0] = "450";
		parkourScore[2][1] = "Amir";
		parkourScore[3][0] = "100";
		parkourScore[3][1] = "Evan";
		parkourScore[4][1] = name;
		parkourScore[4][0] = stringScore;
	}
	/*
	 * Desc: Reads the score from the text file and puts it into a 2D array.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void readScore(){
		File dataFile = new File("F:\\ParkourRunnerScores.txt");
		FileReader in;
		BufferedReader readFile;
		String score;
		try{
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
			int i=0;
			int j=0;

			for (i = 0; i <=5; i++) {
				score = readFile.readLine();
				//Checks to see what row the next line should go in.
				if (i%2 == 0) {
					parkourScore[j][0] = score;
				} else if (i%2 == 1) {
					parkourScore[j][1] = score;
					j++;
				}
			}
			readFile.close();
			in.close();
		}

		catch(FileNotFoundException a ) {
			System.out.println("File does not exist or could not be found");
		}
		catch (IOException a) {
			System.out.println("Problem reading file");
		}

	}
	/*
	 * Desc: Writes the score into a text file from the 2D array.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void writeScore(){
		File dataFile = new File("F:\\ParkourRunnerScores.txt");
		FileWriter out;
		BufferedWriter writeFile;

		try {
			out = new FileWriter(dataFile);
			writeFile = new BufferedWriter(out);

			for(int i = 0; i < 5; i++){
				writeFile.write(String.valueOf(parkourScore[i][0]));
				writeFile.newLine();
				writeFile.write(String.valueOf(parkourScore[i][1]));
				writeFile.newLine();
			}

			writeFile.close();
			out.close();
			System.out.println("Your high score has been saved!!");
		}

		catch (IOException a){
			System.out.println("Problem writing to file!");
		}
	}
	/*
	 * Desc: Sorts the 2D array from highest to lowest score using a for loop.
	 * Pre: N/A
	 * Post: N/A
	 */
	public void bubbleSort() {
		String temp;
		String temp1;
		int i;
		int j;



		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if ((Integer.parseInt(parkourScore[j][0]) < Integer.parseInt(parkourScore[j+1][0]))){
					temp = parkourScore[j][0];
					parkourScore[j][0] = parkourScore[j+1][0];
					parkourScore[j+1][0] = temp;
					temp1 = parkourScore[j][1];
					parkourScore[j][1] = parkourScore[j+1][1];
					parkourScore[j+1][1] = temp1;
				}
			}
		}
		//Prints out the newly sorted 2D array.
		for (i = 0; i < 5; i++){
			for (j = 0; j < 2; j++){
				System.out.print(parkourScore[i][j] + "\t");
			}
			System.out.println("");
		}
	}


}
