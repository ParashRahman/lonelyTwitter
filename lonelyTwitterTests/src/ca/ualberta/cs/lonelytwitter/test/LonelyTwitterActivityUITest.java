package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testSetText(){
		final String text = "near or far!";
		instrumentation.runOnMainSync(new Runnable(){
			@Override
			public void run(){
				textInput.setText(text);
			}
		});
		
		instrumentation.waitForIdleSync();
		assertEquals("Does this work?", text, textInput.getText().toString());
	}
	
	public void testMakeTweet(){
		final String text = "what I want you to know";
		
		instrumentation.runOnMainSync(new Runnable(){
			@Override
			public void run(){
				makeTweet(text);
				
			}
		});
		
		instrumentation.waitForIdleSync();
		
		// Get listview array adapter
		// Get elements from array adapter
		// Check if size increased;
		// Get last element and see if it equls text String
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the acticlvity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
