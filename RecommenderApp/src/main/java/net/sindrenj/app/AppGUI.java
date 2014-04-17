package net.sindrenj.app;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Panel;

import javax.swing.JRadioButton;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppGUI implements ActionListener {
	JPanel radioPanel;
	ButtonGroup radio_group;
	//Radiobuttons:
	JRadioButton rdbtnNotSeen;
	JRadioButton radBtn_1;
	JRadioButton radBtn_2;
	JRadioButton radBtn_3;
	JRadioButton radBtn_4;
	JRadioButton radBtn_5;
	//Moviename:
	JLabel lblMovieName;
	//Recommendationlist:
	List lstRecommendations;
	JFrame frame;	
	public AppGUI(String frameName) {
		frame = new JFrame(frameName);
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("data/bilder/movie_roll_icon.png").getImage());
		frame.setBounds(100, 100, 523, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie Recommender 3000 (Java Edition)");
		lblNewLabel.setBounds(0, 11, 436, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel);
		
		radioPanel = new JPanel();
		radio_group = new ButtonGroup();
		radioPanel.setBounds(28, 88, 454, 33);
		
		JRadioButton rdbtnNotSeen = new JRadioButton("0");
		radio_group.add(rdbtnNotSeen);
		
		rdbtnNotSeen.setSelected(true);
		radioPanel.add(rdbtnNotSeen);
		
		radBtn_1 = new JRadioButton("1");

		radio_group.add(radBtn_1);
		radioPanel.add(radBtn_1);
		
		radBtn_2 = new JRadioButton("2");
		radio_group.add(radBtn_2);
		radioPanel.add(radBtn_2);
		
		radBtn_3 = new JRadioButton("3");
		radio_group.add(radBtn_3);
		radioPanel.add(radBtn_3);
		
		radBtn_4 = new JRadioButton("4");
		radio_group.add(radBtn_4);
		radioPanel.add(radBtn_4);
		
		radBtn_5 = new JRadioButton("5");
		radio_group.add(radBtn_5);
		radioPanel.add(radBtn_5);
		
		radBtn_1.addActionListener(this);
		radBtn_2.addActionListener(this);
		radBtn_3.addActionListener(this);
		radBtn_4.addActionListener(this);
		radBtn_5.addActionListener(this);
		
		frame.getContentPane().add(radioPanel);
		
		lblMovieName = new JLabel("moviename");
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMovieName.setBounds(18, 63, 418, 28);
		frame.getContentPane().add(lblMovieName);
		
		JLabel lblRateTheMovie = new JLabel("Rate the movie:");
		lblRateTheMovie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRateTheMovie.setBounds(28, 40, 275, 14);
		frame.getContentPane().add(lblRateTheMovie);
		
		lstRecommendations = new List();
		lstRecommendations.setBounds(28, 161, 454, 181);
		frame.getContentPane().add(list);
		
		JLabel lblWeRecommend = new JLabel("We recommend:");
		lblWeRecommend.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeRecommend.setBounds(28, 141, 130, 14);
		frame.getContentPane().add(lblWeRecommend);
	}
	
	public void actionPerformed( ActionEvent e ) {
		
	}
	
	
	public int getRadioButtonValue() {
		
		return 0;
	}
}
