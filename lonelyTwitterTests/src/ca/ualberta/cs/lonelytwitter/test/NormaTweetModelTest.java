package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class NormaTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public NormaTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testEquals(){
		Date date = new Date();
		//NormalTweetModel tweet1 = new NormalTweetModel("Hi", date);
		//NormalTweetModel tweet2 = new NormalTweetModel("Hi", new Date(33232));
		
		//assertTrue("Same tweets are same", tweet1.equals(tweet2));
		
		ImportantTweetModel itm = new ImportantTweetModel("Check Nao");
		NormalTweetModel ntm = new NormalTweetModel("Check Nao");
		
		assertFalse( "These tweets are not equal", itm.equals(ntm) );
		
	}
}
