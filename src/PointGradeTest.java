import static org.junit.Assert.*;

import org.junit.Test;

public class PointGradeTest {

	
	//testing equivalence classes in fromNumGrade method
	//equivalence classes are all grades
	@Test
	public void fromNumGradeTest(){
		int[] testNumGrade = { -1, 0, 34,36,41,42,45,47,51,53,55,58,60,63,65,68,71,74,77, 100 };
		int expectedValue = 20;
		for(int i=0;i<testNumGrade.length;i++){
			assertEquals(expectedValue,PointGrade.fromNumGrade(testNumGrade[i]).getPoints());
			expectedValue--;
		}
	}
	
	//testing equivalence classes in PointGrade
	//equivalence classes are all passing grades together with all failing grades
	//contains getPoints method
	@Test
	public void constructorDeclarationTest(){
		int[] pointsToTest = {2,7,9,16,17,18,19,20};
		for(int i=0;i<pointsToTest.length;i++)
		{
			assertEquals(pointsToTest[i],new PointGrade(pointsToTest[i]).getPoints());
		}
	}
	
	//testing equivalence classes in classify method
	//equivalence classes are all classifications
	@Test
	public void classifyTest(){
		Classification[] expectedClass = {Classification.First,Classification.UpperSecond,Classification.LowerSecond,Classification.Third,Classification.Fail};
		int[] pointGrades = {3,6,10,13,18};
		for(int i=0;i<pointGrades.length;i++)
		{
			assertEquals(expectedClass[i],new PointGrade(pointGrades[i]).classify());
		}
	}
	

	// out of boundary testing
	// checking for IllegalArgumentException
	
	//checking boundary near lowest possible fromNumGrade input
	@Test(expected = IllegalArgumentException.class)
	public void outfromNumGradeTest1(){
		PointGrade.fromNumGrade(-2);
	}
	
	//checking boundary near highest possible fromNumGrade input
	@Test(expected = IllegalArgumentException.class)
	public void outfromNumGradeTest2(){
		PointGrade.fromNumGrade(101);
	}
	
	//checking boundary near lowest possible input for constructor
	@Test(expected = IllegalArgumentException.class)
	public void outConstructorTest1(){
		new PointGrade(0);
	}
	
	//checking boundary near highest possible input for constructor
	@Test(expected = IllegalArgumentException.class)
	public void outConstructorTest2(){
		new PointGrade(21);
	}
	

}
