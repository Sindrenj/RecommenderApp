package net.sindrenj.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Cmd {
	//Filepaths:
	final String filePathIn = "data/movies.txt";
	final String filePathOut = "data/movies.csv";
	//Movies:
	public ArrayList<Movie> movies = new ArrayList<Movie>();
	//Userinput:
	Scanner input = new Scanner( System.in );
		
	public Cmd() {
		System.out.println("Starting up..");
		System.out.println("Lets get the movies..");
		try {
			readMoviesFromFile();
			System.out.println("Print the movies..!");
			for(Movie mv : movies) {
				System.out.println("Rate " + mv.name);
				//Get the score:
				mv.score = Double.parseDouble(input.next());
				System.out.println("Done!");
			}
		} catch (Exception e) {
			System.out.println("ERRORS!");
			e.printStackTrace();
		}
		System.out.println("Welcome to the recommenderapp! Please start your recommendations:");
//		for(String movie : movies) {
//			System.out.println("Put your score on:"
//		}
	}
	
	public void readScores() {
		
		
		
	}
	
		
	public void readMoviesFromFile() throws Exception {
		System.out.println("Reading from movielist");
		BufferedReader br = new BufferedReader(new FileReader(filePathIn));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOut));
		String line;
		while((line = br.readLine()) != null ) {
			
			String[] values = line.split(",");
			movies.add(new Movie(values[0], values[1]));
			//bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
		}
		System.out.println("Done!");
		br.close();
		//bw.close();
	}
	
	
	
	
	
	
	
}
