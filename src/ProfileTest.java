import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProfileTest {
	
	//testing constructor declaration
	@Test
	public void constructorTest(){
		List<PointGrade> testGrades = new ArrayList<PointGrade>();
		int[] inputForPointGrades = {1,2,3,4};
		for(int i=0;i<4;i++)
		{
			testGrades.add(new PointGrade(inputForPointGrades[i]));
		}
		new Profile(testGrades);
	}
	
	//testing constructor declaration with wrong input (failing grades)
	@Test(expected = IllegalArgumentException.class)
	public void outConstructorTest(){
		List<PointGrade> testGrades = new ArrayList<PointGrade>();
		int[] inputForPointGrades = {1,2,3,19};
		for(int i=0;i<4;i++)
		{
			testGrades.add(new PointGrade(inputForPointGrades[i]));
		}
		new Profile(testGrades);
	}
	
	// testing classify method
	// classifications are the equivalence classes
	@Test
	public void classifyTest(){
		int[][] testGrades = {{1,1,2,5},{1,6,5,9},{5,9,9,9,9,9,9,15},{1,15,15,15}};
		Classification[] expectedClasses = {Classification.First,Classification.UpperSecond,Classification.LowerSecond,Classification.Third};
		for(int i=0;i<4;i++)
		{
			List<PointGrade> tempList = new ArrayList<PointGrade>();
			for(int j=0;j<testGrades[i].length;j++)
			{
				tempList.add(new PointGrade(testGrades[i][j]));
			}
			Profile testProfile = new Profile(tempList);
			assertEquals(expectedClasses[i],testProfile.classify());
		}
	}
	
	//testing isClear method
	//both true and false methods covered
	//all possible branches covered as well
	@Test
	public void isClearTest(){
		int[][] setOfGrades = {{1,1,1,1},{5,5,16,15},{10,10,10,10},{1,1,15,15},{5,5,5,5},{15,15,15,15}};
		boolean[] expected = {true,false,true,false,true,true};
		for(int i=0;i<6;i++)
		{
			List<PointGrade> listOfGrades = new ArrayList<PointGrade>();
			for(int j=0;j<setOfGrades[i].length;j++){
				listOfGrades.add(new PointGrade(setOfGrades[i][j]));
			}
			Profile testProfile = new Profile(listOfGrades);
			assertEquals(expected[i],testProfile.isClear());
		}
	}
	
}
