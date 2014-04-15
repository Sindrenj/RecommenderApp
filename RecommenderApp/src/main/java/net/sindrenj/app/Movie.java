package net.sindrenj.app;

public class Movie {
	int id;
	String name;
	String date;
	int score;
	
	public Movie(int id, String name) {
		this.id = id;
		this.name = name;
		this.score = 0;
	}
	
	public String toString() {
		return id + ", " + name + ", " + date; 
	}
}
