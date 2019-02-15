package rainbowreef.score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MaintainScore {

	private File scorefile;
	private FileReader readfile;
	private BufferedReader reader;
	private FileWriter writefile;
	private BufferedWriter writer;

	private static ArrayList<String> Scorelist;
	private String lastscore;

	public MaintainScore() {
		lastscore = null;
		scorefile = new File("./res/highscore.dat");
		Scorelist = new ArrayList<String>();

		if (!scorefile.exists()) {
			try {
				scorefile.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		getHighScore();
	}

	public void setScore(String score) {
		try {
			writefile = new FileWriter(scorefile, true);
			writer = new BufferedWriter(writefile);
			writer.newLine();
			writer.write(score);
			writer.close();
			Scorelist.add(score);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getHighScore() {
		try {
			readfile = new FileReader(scorefile);
			reader = new BufferedReader(readfile);
			if (lastscore == null) {
				String line = reader.readLine();
				while (line != null) {
					if (!line.equals("Score list"))
						Scorelist.add(line);
					line = reader.readLine();
				}
				if (Scorelist.size() != 0)
					lastscore = Scorelist.get(Scorelist.size() - 1);// reader.readLine();
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastscore;
	}

	public static String[] displayScore() {
		System.out.println("Scores");
		if (Scorelist.size() > 1)
			Collections.sort(Scorelist, new ScoreComparator());
		int i = 0;
		String topscores[] = new String[5];
		Iterator<String> sortedScore = Scorelist.iterator();
		while (sortedScore.hasNext()) {
			String s = sortedScore.next();
			topscores[i++] = s;
			if (i == 5)
				break;
			// System.out.println(s);
		}
		return topscores;
	}

}
