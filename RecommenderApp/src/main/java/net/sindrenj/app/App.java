package net.sindrenj.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class App {
	//Filepaths:
	final static String filePathMovieList = "";
	final static String filePathIn = "data/movies.txt";
	final static String filePathOut = "data/movies.csv";
	//Movies:
	private static ArrayList<Movie> movies;
	//Userinput:
	private static Scanner input = new Scanner( System.in );
	//Fileoperations:
	private static MovieConvert mvC;
		
	public static void main( String[]args ) {
		System.out.println("Welcome to movie recommender 3000(Java Edition)");
		System.out.println("SVD Recommender(Mahout)");
		try {
//			//MvoieLens-file, Path to movielists, fileending, appendToFile?
			mvC = new MovieConvert("data/ratings", "data/movies_to_rate/", ".csv", true);
//			//Create an id from the last id in the dataset-file:
//			int newId = mvC.findMaxId() + 1;
//			System.out.println("Your ID will be:");
//			System.out.println(newId);
//			//Create the user with the id:
//			User user = new User(newId);
//			//Get the preference(Default: action):
//			String m_name_list = "action";
//			//Select the test-questions:
//			System.out.println("Select your preference:");
//			m_name_list = input.next();
//			//Get the list of movies:
//			movies = mvC.readMoviesFromFile(m_name_list);
//			System.out.println("Please rate the following movies:");
//			//Get the ratings:
//			for(Movie mv : movies) {
//				System.out.println("Rate " + mv.id + "," + mv.name);
//				//Get the score:
//				mv.score = Integer.parseInt(input.next());
//				//Add the movie to the userlist
//				user.addRating(mv);
//			}
//			//Append the ratings to the movielensfile:
//			mvC.saveRatings(user);
//			//Recommend some movies:
			User user = new User(50);
			recommend(user, 5);			
		} catch (IOException e) {
			System.out.println("Read/Write error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
}
	
	public static void recommend(User user, int nMovies) throws Exception {
		//Read ratings from file:
		DataModel m = new FileDataModel(new File("data/ratings.csv"));
		//Create a SVDRecommender:
		SVDRecommender svd = new SVDRecommender(m, new ALSWRFactorizer(m, 10, 0.05, 10));
		//Get recommendations:
		System.out.println("We recommend following films:");
		for (RecommendedItem recommendation : svd.recommend(user.getId(), nMovies)) 
		{ 
			//Get the recommended movie from u.item:
			Movie mv = mvC.searchForMovie( recommendation.getItemID() + "" );
			//Print the recommended films:
			System.out.println(mv.name + ", Score:" + mv.score);
		}
	}	
}










































//package net.sindrenj.app;
//
//import java.io.File;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
//import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
//import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
//import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
//import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
//import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
//import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
//import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
//import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
//import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
//import org.apache.mahout.cf.taste.model.DataModel;
//import org.apache.mahout.cf.taste.model.JDBCDataModel;
//import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
//import org.apache.mahout.cf.taste.recommender.RecommendedItem;
//import org.apache.mahout.cf.taste.recommender.Recommender;
//import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
//import org.apache.mahout.cf.taste.similarity.UserSimilarity;
//
//public class bullshit{
//	
//	private static final int cols = 2;
//	private static final int rows = 10;
//	private static Object[][] rec = new Object[rows][cols];
//
//	private static String[] kolonneNavn = new String[cols]; 
//	
//	
//	public static void doRecommending() {
//		
//		
////			System.out.println("Creating data.. (A table with " + rows + " rows and " + cols + " columns)");
////			// 1. Add the data:
////			for(int row = 0; row < rows; row++) {
////				for(int col = 0; col < cols; col++) {
////					rec[row][col] = (int )(Math.random() * 5);		
////				}
////			}
//			
//			App cmd = new App();
//		
////			
////			//2. Connect users to the data:
////			System.out.println("Connect the users to the recommendations");
////			//Define the users:
////			for(int col = 0; col < cols; col++ ) {
////				kolonneNavn[col] = "bruker" + ( col + 1 ); //Starter på 1.
////			}
//			
//			//Setup the model:
////			try {
////				//JDBCDataModel m = connect();
////				//2. Do the magic mahout shit here..
////				System.out.println("Running the recommender-engine..");
////				//Datamodel:
////				DataModel m = new FileDataModel(new File("data/movies.csv"));
////				
////				SVDRecommender svd = new SVDRecommender(m, new ALSWRFactorizer(m, 3, 0.05f, 50));
////				System.out.println(svd.recommend(3,1));
////				for (RecommendedItem recommendation : svd.recommend(3, 4)) 
////				{ 
////					 System.out.println(recommendation); 	 
////				}
////			} catch(Exception e) {
////				e.printStackTrace();
////			}
////			
////			
////			//SVDRecommender svdRec = new SVDRecommender();
////			//GenericDataModel dataModel = new GenericDataModel(dataModel);
////			
////			//3. Create the GUI and show the recommendations:
//////			System.out.println("Creating the gui..");
//////			GUI gui = new GUI(rec, kolonneNavn);
//////			
//////			//4. Create the table:
//////			gui.setupTable();
////	    	
//////	    	List<RecommendedItem> recommendations = recommender.recommend(1, 3);
//////	    	for (RecommendedItem recommendation : recommendations) {
//////	    	  System.out.println(recommendation);
//////	    	}
////			System.out.println("Finished..!");
//	}
//	
//	public static JDBCDataModel connect() throws SQLException{
//		System.out.println("Connecting");
//		//Get the datasource:
//		DataSource datasource = Database.getDatasource();
//		//Connect with db:
//		return new MySQLJDBCDataModel( datasource, 
//									"rating", "person", 
//									"film", "rate", "20.03.2014");
//	}
//}
