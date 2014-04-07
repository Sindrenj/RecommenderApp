package net.sindrenj.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MovieConvert {
	final static String filePathIn = "data/movies.txt";
	//final static String filePathOut = "data/movies.csv";
	
	public ArrayList<Movie> movies = new ArrayList<Movie>();
	
	public MovieConvert() throws Exception {
		System.out.println("Reading from movielist");
		BufferedReader br = new BufferedReader(new FileReader(filePathIn));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOut));
		System.out.println("Converting files..");
		String line;
		while((line = br.readLine()) != null ) {
			String[] values = line.split("\\t", - 1);
			movies.add(new Movie(values[0], values[1]));
			//bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
		}
		System.out.println("Finished!");
		br.close();
		//bw.close();
	}
}
