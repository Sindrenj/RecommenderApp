package net.sindrenj.app;

import javax.swing.JOptionPane;

public class RecommenderApp {
	static GUI2 gui;
	static final String TITLE = "Movie Recommender 3000";
	public static void main( String[]args ) {
		//Create the controller:
		try {
			App controller = new App();
			//Let's get this party started!
			gui = new GUI2(TITLE, controller);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,
			e.getMessage(),
			"Critical Error - The application will close.",
			JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
	}
}
