package net.sindrenj.app;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class App{
	
	private static final int cols = 2;
	private static final int rows = 10;
	private static Object[][] rec = new Object[rows][cols];

	private static String[] kolonneNavn = new String[cols]; 
	
	public static void main(String[]args) {
		System.out.println("Welcome to the recommending-system that uses SVD for recommending.");
		doRecommending();
	}
	
	public static void doRecommending() {
//			System.out.println("Creating data.. (A table with " + rows + " rows and " + cols + " columns)");
//			// 1. Add the data:
//			for(int row = 0; row < rows; row++) {
//				for(int col = 0; col < cols; col++) {
//					rec[row][col] = (int )(Math.random() * 5);		
//				}
//			}
//			
//			//2. Connect users to the data:
//			System.out.println("Connect the users to the recommendations");
//			//Define the users:
//			for(int col = 0; col < cols; col++ ) {
//				kolonneNavn[col] = "bruker" + ( col + 1 ); //Starter på 1.
//			}
			
			//Setup the model:
			try {
				//JDBCDataModel m = connect();
				//2. Do the magic mahout shit here..
				System.out.println("Running the recommender-engine..");
				//Datamodel:
				DataModel m = new FileDataModel(new File("data/movies.csv"));
				
				SVDRecommender svd = new SVDRecommender(m, new ALSWRFactorizer(m, 3, 0.05f, 50));
				System.out.println(svd.recommend(3,1));
				for (RecommendedItem recommendation : svd.recommend(3, 4)) 
				{ 
					 System.out.println(recommendation); 	 
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
			//SVDRecommender svdRec = new SVDRecommender();
			//GenericDataModel dataModel = new GenericDataModel(dataModel);
			
			//3. Create the GUI and show the recommendations:
//			System.out.println("Creating the gui..");
//			GUI gui = new GUI(rec, kolonneNavn);
//			
//			//4. Create the table:
//			gui.setupTable();
	    	
//	    	List<RecommendedItem> recommendations = recommender.recommend(1, 3);
//	    	for (RecommendedItem recommendation : recommendations) {
//	    	  System.out.println(recommendation);
//	    	}
			System.out.println("Finished..!");
	}
	
	public static JDBCDataModel connect() throws SQLException{
		System.out.println("Connecting");
		//Get the datasource:
		DataSource datasource = Database.getDatasource();
		//Connect with db:
		return new MySQLJDBCDataModel( datasource, 
									"rating", "person", 
									"film", "rate", "20.03.2014");
	}
}
