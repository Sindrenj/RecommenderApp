package net.sindrenj.app;

import java.util.ArrayList;

public class User {
	private int id;
	private ArrayList<Movie> ratings = new ArrayList<Movie>();
	
	public User(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void addRating(Movie movie) {
		ratings.add(movie);
	}
	
	public ArrayList<Movie> getRatings() {
		return ratings;
	}
}
