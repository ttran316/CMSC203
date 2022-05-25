import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook grades1;
	GradeBook grades2;
	
	@BeforeEach
	void setUp() throws Exception {
		grades1 = new GradeBook(5);
		grades1.addScore(50);
		grades1.addScore(75);
		grades2 = new GradeBook(5);
		grades2.addScore(10);
		grades2.addScore(100);
		grades2.addScore(55.7);
	}

	@AfterEach
	void tearDown() throws Exception {
		grades1= null;
		grades2= null;
	}

	@Test
	void testSum() {
		assertEquals(125, grades1.sum(), .0001);
		assertEquals(165.7, grades2.sum(), .0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(50, grades1.minimum(), .001);
		assertEquals(10, grades2.minimum(), .001);
	}
	
	@Test
	void addScoreTest() {
		assertTrue(grades1.toString().equals("50.0 75.0 "));
		assertTrue(grades2.toString().equals("10.0 100.0 55.7 "));
	}
	
	@Test
	void finalScoreTest() {
		assertTrue(grades1.finalScore() == (75.0));
		assertTrue(grades2.finalScore() == (155.7));
	}
}
