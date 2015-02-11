package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderActivityTest extends
			ActivityInstrumentationTestCase2<IntentReaderActivity> {
			
			public IntentReaderActivityTest() {
				super(IntentReaderActivity.class);
			}
			
			protected void setUp() throws Exception {
				super.setUp();
			}
			
			public void testSendText() {
				String text = "Hello world";
				int code = IntentReaderActivity.NORMAL;
				IntentReaderActivity activity = startWithText( text, code );
	
				assertEquals("Is text correct?", text, activity.getText());
			}
			
			public void testDoubleText(){
				String text = "Hello";
				IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
				assertEquals("Double transform working?", text+text, activity.getText());
			}
			
			public void testReverseText(){
				String text = "Helloo";
				String rtext = "oolleH";
				IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
				assertEquals("Reverse text working?", rtext, activity.getText());
			}
			
			public void testDisplayText(){
				String text = "Hello world!";
				IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
				assertEquals( "correct text?", text, activity.getText() );
				
				TextView view = (TextView) activity.findViewById(R.id.intentText);
				assertEquals("displays correct text?", text, view.getText().toString());
			}
			
			public void testTextViewVisibility(){
				IntentReaderActivity activity = startWithText("sup", IntentReaderActivity.NORMAL);
				View origin = activity.getWindow().getDecorView();
				TextView tview = (TextView) activity.findViewById(R.id.intentText);
				ViewAsserts.assertOnScreen( origin, (View)tview );
			}
			
			public void testDisplayNoTextMessage(){
				String text = "";
				IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
				TextView tv = (TextView) activity.findViewById( R.id.intentText );
				assertEquals ("Message good?", IntentReaderActivity.NO_STRING_MESSAGE, tv.getText().toString());
			}
			
			private IntentReaderActivity startWithText(String text, int code){
				Intent intent = new Intent();
				intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
				intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, code);
				setActivityIntent(intent);
				return (IntentReaderActivity) getActivity();
			}
}
