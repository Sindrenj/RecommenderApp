package net.sindrenj.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;

public class GUI2 extends JFrame {
	//Recommendationlist:
	List lstRecommendations;
	JFrame frame;	
	App controller;
	
	public GUI2(String frameTitle, App controller) {
		this.controller = controller;
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Movie Recommender 3000");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(0, 0, 584, 25);
		frame.getContentPane().add(label);
		
		JLabel lblWeRecommend = new JLabel("We recommend:");
		lblWeRecommend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeRecommend.setBounds(21, 36, 563, 14);
		frame.getContentPane().add(lblWeRecommend);
		
		JList<Movie> list = new JList<Movie>();
		list.setBounds(21, 247, 553, -185);
		frame.getContentPane().add(list);
		frame.getContentPane().add(list);
		frame.setVisible(true);
		//Start the recommendations:
		startRecommendations();
		//Add the movies to the list:
		//Show the ratings:
		ArrayList<Movie> recMovies;			
	
		try {
			//Model for the list:
			DefaultListModel<Movie> movieModel = new DefaultListModel<Movie>();
			recMovies = controller.getRecommendedMovies( controller.getUser() );		
			int nr = 0;
			for(Movie mv : recMovies) {
				movieModel.addElement(mv);
				System.out.println(mv);
			}
			list.setModel(movieModel);
			list.setSelectedIndex(0);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,
			e.getMessage(),
			"Error",
			JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}	
	}
	
	public void startRecommendations() {
		try {
			ArrayList<Movie> movies = controller.getListOfMoviesToRate("action");;
			for(Movie mv : movies) {
				new RateMovieGUI(controller, mv, this, "Rate " + mv.name);
			}
			//Save the ratings:
			controller.saveRatings( controller.getUser() );
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,
			e.getMessage(),
			"Error",
			JOptionPane.ERROR_MESSAGE);
		}
	}
}
