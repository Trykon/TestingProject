// Do not change anything in this file.

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentRecord {
	private List<List<PointGrade>> years =
			new ArrayList<List<PointGrade>>();
	
	public String toString() {
		String result = ""; 
		for(int i=0; i<3; i++) {
			result += "Year " + (i+1) + ": " + years.get(i).toString() + "\n";
		}
		
		return result;		
	}
	
	public StudentRecord() {
		for(int i=0; i<3; i++)
			years.add(new LinkedList<PointGrade>());
	}
	
	public List<PointGrade> getYear(int year) {
		return Collections.unmodifiableList(years.get(year-1));
	}
	
	public void addGradeToYear(PointGrade g, int year) {
		years.get(year-1).add(g);
	}
}
