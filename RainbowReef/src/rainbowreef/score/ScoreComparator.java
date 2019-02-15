package rainbowreef.score;

import java.util.Comparator;

public class ScoreComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1 == null || o2 == null)
			return 0;
		else if(Integer.parseInt(o1.split(":")[1]) > Integer.parseInt(o2.split(":")[1]))
			return -1;
		else if(Integer.parseInt(o1.split(":")[1]) < Integer.parseInt(o2.split(":")[1]))
			return 1;
		return 0;
	}

}
