package chrismlong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// website with the data: https://www.scoreboard.com/nba/results/

public class NBAQuarterReactor {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\cml3t\\Desktop\\scoresQuarter.csv";
		readCsv(filePath);
	}

	public static void readCsv(String filePath) {
		BufferedReader reader = null;

		try {
			List<String> games = new ArrayList<String>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			line = reader.readLine();
					
			while (!line.isEmpty() && line != null) {
				String[] fields = line.split(",");
				if (fields.length > 0) {
					String value = fields[0];
					if(value.startsWith("Feb") || value.startsWith("Jan") || value.startsWith("Dec") || value.startsWith("Nov") || value.startsWith("Oct")) {
						System.out.println("");
					}
					if(!value.equals("AOT")) {
						System.out.print(fields[0] + ",");
					}
				}
				line = reader.readLine();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}