package ca.ualberta.cs.lonelytwitter;

public class Author extends User {

	public Author() {
		super();
		name = "anonymous_author";
	}
	
	public Author(String string) {
		// TODO Auto-generated constructor stub
		this.setName( string );
	}

	public void setName( String name ) {
		this.name = name;
	}
}
