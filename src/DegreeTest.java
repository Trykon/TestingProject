import static org.junit.Assert.*;

import org.junit.Test;

public class DegreeTest {

	// testing degree constructor 
	@Test
	public void testConstructorStandard() {
		int[][] gradeList = { { 1, 1, 1, 1 }, { 1, 1, 15, 15 }, { 1, 2, 3, 1 }, { 9, 9, 9, 9 }, { 15, 15, 15, 15 },
				{ 5, 5, 5, 5 } };

		// hard coded 5 for amount of tests, depending on gradeList size-1
		for (int i = 0; i < 5; i++) {
			StudentRecord testRecord = new StudentRecord();
			for (int j = 0; j < gradeList[i].length; j++) {
				testRecord.addGradeToYear(new PointGrade(gradeList[i][j]), 2);
				testRecord.addGradeToYear(new PointGrade(gradeList[i + 1][j]), 3);
			}
			new Degree(testRecord);
		}
	}

	// testing declaration exceptions with wrong amount of grades per year
	//2nd year not valid amount of grades
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorFail1() {
		int[] grades1 = { 1, 1, 1 };
		int[] grades2 = { 1, 1, 15, 14 };
		StudentRecord testRecord = new StudentRecord();
		for (int i = 0; i < grades1.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades1[i]), 2);
		for (int i = 0; i < grades2.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades2[i]), 3);
		new Degree(testRecord);
	}
	//3rd year not valid amount of grades
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorFail2() {
		int[] grades1 = { 15, 15, 1, 1 };
		int[] grades2 = { 1, 2, 3, 1, 5 };
		StudentRecord testRecord = new StudentRecord();
		for (int i = 0; i < grades1.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades1[i]), 2);
		for (int i = 0; i < grades2.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades2[i]), 3);
		new Degree(testRecord);
	}
	//both 2nd and 3rd year have not valid amount of grades
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorFail3() {
		int[] grades1 = { 9, 9, 9, 9, 15, 15 };
		int[] grades2 = { 5 };
		StudentRecord testRecord = new StudentRecord();
		for (int i = 0; i < grades1.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades1[i]), 2);
		for (int i = 0; i < grades2.length; i++)
			testRecord.addGradeToYear(new PointGrade(grades2[i]), 3);
		new Degree(testRecord);
	}

	// testing classify method
	// all possible branches covered
	//equivalence classes are chosen to cover all the possible methods of grading
	//also to cover all the possible classes
	@Test
	public void testClassify() {
		int[][] gradeList = { { 1, 1, 1, 1 }, { 1, 1, 15, 15 }, { 1, 2, 3, 1 }, { 1, 1, 1, 5 }, { 15, 15, 15, 15 },
				{ 5, 5, 5, 5 }, { 5, 5, 5, 15 }, { 5, 9, 15, 15 }, { 9, 9, 9, 9 }, { 1, 1, 1, 9 } };

		int[][] pairs = { { 0, 2 }, // first x4 + first x4 ___
									// lvl5(first)==lvl6(first)
				{ 0, 5 }, // first x4 + upperSecond x4 ___
							// lvl5(first)>lvl6(upperSecond)
				{ 4, 3 }, // third x4 + first x3,upperSecond x1 ___
							// lvl5(upperSecond)<lvl6(first)
				{ 4, 1 }, // third x4 + first x2,third x2 ___
							// lvl5(third)+lvl6(first.borderline)=>discretion
							// (this one is to cover all branches in
							// classToNumber method)
				{ 6, 7 }, // upperSecond x3,third +
							// upperSecond,lowerSecond,third x 2 __
							// lvl5(upperSecond.borderline)>lvl6(lowerSecond)
				{ 5, 1 }, // upperSecond x4 + first x2,third x2 ___
							// lvl5(upperSecond)<lvl6(first.borderline)
				{ 0, 8 }, // first x4 + lowerSecond x4 ___
							// lvl5(first)>lvl6(lowerSecond) => discretion
				{ 8, 9 }, // lowerSecond x4 + first x3,lowerSecond ___
							// lvl5(lowerSecond)<lvl6(first) => discretion
				{ 5, 5 }, // all upperSecond => upperSecond as result
				{ 8, 8 }, // all lowerSecond => lowerSecond as result
				{ 4, 4 }// all third => third as result
		};

		Classification[] testListGrades = { Classification.First, Classification.First, Classification.First,
				Classification.Discretion, Classification.Discretion, Classification.Discretion,
				Classification.Discretion, Classification.Discretion, Classification.UpperSecond,
				Classification.LowerSecond, Classification.Third };

		// hard coded 11 for amount of tests, depending on gradeList size-1
		for (int i = 0; i < 11; i++) {
			StudentRecord testRecord = new StudentRecord();
			// hard coded 4 as per number of grades a year
			for (int j = 0; j < 4; j++) {
				testRecord.addGradeToYear(new PointGrade(gradeList[pairs[i][0]][j]), 2);
				testRecord.addGradeToYear(new PointGrade(gradeList[pairs[i][1]][j]), 3);
			}
			assertEquals(testListGrades[i], new Degree(testRecord).classify());
		}
	}

}
