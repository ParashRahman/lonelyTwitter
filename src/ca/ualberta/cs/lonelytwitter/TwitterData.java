package ca.ualberta.cs.lonelytwitter;

/**
 * @author parash
 *
 */
public abstract class TwitterData {
	String person_interacted_with;
	String person_interacting;
	String tweet_in_question;
	
	public TwitterData( String piw, String pi, String tiq ){
		person_interacted_with = piw;
		person_interacting = pi;
		tweet_in_question = tiq;
	}

	public String getPerson_interacted_with() {
		return person_interacted_with;
	}

	public void setPerson_interacted_with(String person_interacted_with) {
		this.person_interacted_with = person_interacted_with;
	}

	public String getTweet_in_question() {
		return tweet_in_question;
	}

	public void setTweet_in_question(String tweet_in_question) {
		this.tweet_in_question = tweet_in_question;
	}

	public String getPerson_interacting() {
		return person_interacting;
	}

	public void setPerson_interacting(String person_interacting) {
		this.person_interacting = person_interacting;
	}
}
