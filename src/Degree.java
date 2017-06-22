import java.util.ArrayList;
import java.util.List;

public class Degree {
	// you are free to add private variables/methods at will
	// as well as standard Java methods (equals, toString, etc)

	// Methods to change/complete are below
	// do not change their signature/names

	public Degree(StudentRecord r) {
		this.record = r;
		if (r.getYear(2).size() != 4 || r.getYear(3).size() != 4)
			throw new IllegalArgumentException();
	}

	public Classification classify() {
		Profile level6 = new Profile(record.getYear(3));
		List<PointGrade> tempList = new ArrayList<PointGrade>();
		for (int i = 0; i < 4; i++)
			tempList.add(record.getYear(2).get(i));
		for (int i = 0; i < 4; i++)
			tempList.add(record.getYear(3).get(i));
		Profile level5 = new Profile(tempList);
		int lvl5 = classToNumber(level5.classify());
		int lvl6 = classToNumber(level6.classify());

		if (lvl5 == lvl6)
			return level5.classify();
		else if (lvl5 > lvl6 && lvl5 - lvl6 <= 1) {
			if (level5.isClear())
				return level5.classify();
		} else if (lvl6 > lvl5 && lvl6 - lvl5 <= 1) {
			if (level6.isClear())
				return level6.classify();
		}
		return Classification.Discretion;
	}

	private int classToNumber(Classification c) {
		if (c == Classification.First)
			return 4;
		else if (c == Classification.UpperSecond)
			return 3;
		else if (c == Classification.LowerSecond)
			return 2;
		else
			return 1;
	}

	private StudentRecord record;
}
