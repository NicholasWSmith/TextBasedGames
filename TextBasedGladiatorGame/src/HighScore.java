import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class HighScore {
	String name;
	String tempName;
	int score;
	int tempScore;
	
	public HighScore() {
		String[][] scores = new String[3][2];
		scores[0][0] = "5000";
		scores[1][0] = "3000";
		scores[2][0] = "1000";
		scores[0][1] = "Joel";
		scores[1][1] = "Fork";
		scores[2][1] = "Phen";
	
	
	int i;
		File dataFile = new File("D:\\GameScores.txt");
		FileWriter out;
		BufferedWriter writeFile;
	
	
	try
			{
		out = new FileWriter(dataFile);
		writeFile = new BufferedWriter(out);
	for (i = 0; i < 3; i = i + 1)
	{
		writeFile.write(String.valueOf(scores[i]));
		writeFile.newLine();
	}
	writeFile.close();
	out.close();
	System.out.println("High Score Saved!");
	}
	
	catch (IOException a)
	{
	System.out.println("Problem writing to file!");
	}
	
	}
}




