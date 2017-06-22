public class PointGrade {
	// you are free to add private variables/methods at will
	// as well as standard Java methods (equals, etc)

	private int points;
	private static final String suffix1 = " point";
	private static final String suffixn = suffix1 + "s";

	public String toString() {
		return Integer.toString(points) + (points == 1 ? suffix1 : suffixn);
	}

	public int getPoints() {
		return points;
	}

	// Methods to change/complete are below
	// do not change their signature/names

	public PointGrade(int p) throws IllegalArgumentException {
		this.points = p;
		if (p > 20 || p < 1)
			throw new IllegalArgumentException();
	}

	public Classification classify() {
		// int[] tier = {4,8,12,16,20};
		if (this.points <= 4)
			return Classification.First;
		else if (this.points <= 8)
			return Classification.UpperSecond;
		else if (this.points <= 12)
			return Classification.LowerSecond;
		else if (this.points <= 16)
			return Classification.Third;
		else
			return Classification.Fail;
	}

	public static PointGrade fromNumGrade(int g) throws IllegalArgumentException {
		if (g > 100 || g < -1)
			throw new IllegalArgumentException();
		int[] tier = { 79, 76, 73, 70, 67, 65, 62, 60, 57, 55, 52, 50, 47, 45, 42, 40, 35, 30, 0, -1 };
		PointGrade r = null;
		for (int i = 0; i < tier.length; i++) {
			if (g >= tier[i]) {
				r = new PointGrade(i + 1);
				break;
			}
		}
		return r;
	}
}
