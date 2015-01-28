package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TwitterListModel {
	
	private int count;
	private ArrayList<LonelyTweetModel> tweets;
	
	public TwitterListModel() {
		// TODO Auto-generated constructor stub
		count = 0;
		tweets = new ArrayList<LonelyTweetModel>();
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	public ArrayList<LonelyTweetModel> getList() {
		// TODO Auto-generated method stub
		return tweets;
	}
	
	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		for ( int i = 0; i < tweets.size(); i++ ){
			if ( tweets.get(i).equals( tweet ) ){
				throw new IllegalArgumentException();
			}
		}
		
		tweets.add(tweet);
		count++;
	}

}
