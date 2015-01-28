package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TwitterListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TwitterListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	TwitterListModel tweets;
	
	
	public TwitterListModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		tweets = new TwitterListModel();
	}
	
	public void testCounts(){
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweets.addTweet(tweet);
		assertEquals( "Count should be one", tweets.getCount(), 1 );
	}
	
	public void testAddTweets(){
		NormalTweetModel normalTweet = new NormalTweetModel("Hi");
		tweets.addTweet(normalTweet);
		assertEquals("There should be a tweet in the list", 1, tweets.getList().size() );
		assertNotNull( "The tweets list is not initialised", tweets.getList() );
	}
	
	public void testAddSameTweets(){
		NormalTweetModel tweet = new NormalTweetModel("Sup");
		ImportantTweetModel itweet = new ImportantTweetModel("Sup");
		
		tweets.addTweet(itweet);
		tweets.addTweet(tweet);
		
		boolean worked = false;
		try {
			tweets.addTweet(tweet);
		} catch (IllegalArgumentException e) {
			worked = true;
		}
		
		assertTrue("Should call a IllegalArgumentException", worked );
	
		worked = false;
		try {
			tweets.addTweet(itweet);
		} catch (IllegalArgumentException e) {
			worked = true;
		}
		
		assertTrue("Should call a IllegalArgumentException", worked );
	}
	
	public void testGetTweets(){
		for ( int i = 0; i < 30; i++ ){
			NormalTweetModel tweet = new NormalTweetModel("Sup" + i);

			tweets.addTweet(tweet);
		}

		boolean didnotwork = false;
		
		for ( int i = 0; i < tweets.getCount() - 1; i++ ){
			if ( tweets.getList().get(i).getTimestamp().after( tweets.getList().get(i+1).getTimestamp() ) ){
				didnotwork = true;
			}
		}
		
		assertFalse( "The list should be ordered", didnotwork ); 
	}
	
	public void testHasTweet(){
		NormalTweetModel tweet = new NormalTweetModel("Sup");
		
		tweets.addTweet(tweet);
		
		assertTrue("Should have this tweet", tweets.hasTweet(tweet));
	
		NormalTweetModel tweet2 = new NormalTweetModel("Sup");
		
		assertFalse("Should not have this tweet", tweets.hashTweet(tweet2));
	}
	
}
