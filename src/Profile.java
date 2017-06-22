import java.util.Arrays;
import java.util.List;

public class Profile {
	// you are free to add private variables/methods at will
	// as well as standard Java methods (equals, toString, etc)	
	private List<PointGrade> grades;
	
	public String toString() {
		return Arrays.toString(grades.toArray());
	}
	
	// Methods to change/complete are below
	// do not change their signature/names
	
	
	//number of certain grades achieved
	private int firsts = 0;
	private int uSeconds = 0;
	private int lSeconds = 0;
	private int thirds = 0;
	
	
	//method to count grades in given profile
	private void countGrades(){
		firsts = 0;
		uSeconds = 0;
		lSeconds = 0;
		thirds = 0;
		for(int i=0;i<grades.size();i++)
		{
			if(grades.get(i).classify() == Classification.First)
				firsts++;
			else if(grades.get(i).classify() == Classification.UpperSecond)
				uSeconds++;
			else if(grades.get(i).classify() == Classification.LowerSecond)
				lSeconds++;
			else
				thirds++;
		}
	}
	
	public Profile(List<PointGrade> g) {
		this.grades = g;
		for(int i=0;i<grades.size();i++)
		{
			if(grades.get(i).classify()==Classification.Fail)
				throw new IllegalArgumentException();
			}
	}
	
	
	public boolean isClear() {
		countGrades();
		if(classify()==Classification.First||classify()==Classification.UpperSecond)
			if(thirds>(grades.size()/4))
				return false;
		return true;
	}
	
	public Classification classify() {
		countGrades();
		if(firsts>=grades.size()/2)
			return Classification.First;
		else if(firsts+uSeconds>=grades.size()/2)
			return Classification.UpperSecond;
		else if(firsts+uSeconds+lSeconds>=grades.size()/2)
			return Classification.LowerSecond;
		else
			return Classification.Third;
	}
}
