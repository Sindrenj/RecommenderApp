package net.sindrenj.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MovieConvert {
	private String filePathMovies; 
	private String filePathOut;
	private String filePathMoviesToRate;
	private String suffix; //Filetype
	private boolean appendToFile;
	
	public MovieConvert(String fpOut, String fpMoviesToRate, String fileEnding, boolean appendToFile) {
		filePathOut = fpOut;
		filePathMoviesToRate = fpMoviesToRate;
		suffix = fileEnding;
		this.appendToFile = appendToFile;
	}

	/**
	 * saveRatings()
	 * Writes the ratings to the movieLens-file.
	 * @param user
	 * @throws IOException
	 */
	public void saveRatings(User user) throws IOException {
		System.out.println("Writing to file");
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOut + suffix, appendToFile));
			for(Movie m : user.getRatings()) {
				//User, Movie, Score
				bw.write(user.getId() + "," + m.id + "," + m.score + "\n");
				System.out.println("== Debug-LOG ==\"Wrote:" + user.getId() + "," + m.id + "," + m.score + "\"\n");
			}
		bw.close();
	}
	
	
	/**
	 * searchForMovie()
	 * Searches for movie using the String id
	 * @param id
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public Movie searchForMovie(String id) throws NumberFormatException, IOException, Exception {
		BufferedReader br = new BufferedReader(new FileReader("data/u.item"));
		Movie mv = null;
		String line;
		System.out.print(id);
		boolean found = false;
		while((line = br.readLine()) != null && !found) {
			String[] values = line.split("\\|");
			//System.out.println("Just read:" + values[0]);
			if( values[0].equals(id) ){ //Found matching id
				mv = new Movie(Integer.parseInt(values[0]), values[1]);
				//Found the movie, no reason to proceed. Quit the loop:
				found = true;
			}
		}
		
		br.close();
		
		return mv;
	}
	
	/**
	 * readMoviesFromFile()
	 * Reads movies from a file and returns an arraylist of Movie-objects
	 * @param m_name_list
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Movie> readMoviesFromFile(String m_name_list) throws Exception {
		System.out.println("Reading from movielist");
		ArrayList<Movie> movies = new ArrayList<Movie>();
		BufferedReader br = new BufferedReader(new FileReader(filePathMoviesToRate + m_name_list +  suffix));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOut));
		String line;
		while((line = br.readLine()) != null ) {
			String[] values = line.split(",");
			movies.add(new Movie(Integer.parseInt(values[0]), values[1]));
			//bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
		}
		System.out.println("Done!");
		br.close();
		return movies;
		
	}	
	
	public int findMaxId() throws NumberFormatException, IOException {
		System.out.println("Reading from: " + filePathOut + suffix);
		BufferedReader br = new BufferedReader(new FileReader(filePathOut + suffix));
		
		String line;
		int max = 0;
		while((line = br.readLine()) != null ) {
			String[] values = line.split(",");
			int id = Integer.parseInt(values[0]);
			if(id > max) max = id;
		}
		
		return max;
	}
}
