package ca.ualberta.cs.lonelytwitter.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSampleCode(){
		assertEquals("5 should be equal to 5",5,6);
		
		//assertFalse("This is not true", isGreaterEqual(7,6));
		// fail ("This is a failing test");
	
	}
	
	private boolean isGreaterEqual(int i, int j) {
		// TODO Auto-generated method stub
		return i >= j;
	}
	
}
