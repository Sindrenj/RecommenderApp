package net.sindrenj.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;

public class GUI extends JFrame {
	//Recommendationlist:
	List lstRecommendations;
	JFrame frame;	
	App controller;
	
	public GUI(String frameTitle, App controller) {
		this.controller = controller;
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("data/bilder/movie_roll_icon.png").getImage());
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Movie Recommender 3000");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(0, 0, 584, 25);
		frame.getContentPane().add(label);
		
		JLabel lblWeRecommend = new JLabel("We recommend:");
		lblWeRecommend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeRecommend.setBounds(10, 36, 574, 14);
		frame.getContentPane().add(lblWeRecommend);
		
		JList<?> list = new JList<Object>();
		list.setBounds(20, 243, 554, -181);
		frame.getContentPane().add(list);
		setVisible(true);
		startRecommendations();
	}

	public void startRecommendations() {		try {
			ArrayList<Movie> movies = controller.getListOfMoviesToRate("action");;			for(Movie mv : movies) {				new RateMovieGUI(controller, mv, this, "Rate " + mv.name);
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,
			e.getMessage(),
			"Error",
			JOptionPane.ERROR_MESSAGE);
		}
	}
}
