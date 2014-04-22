package net.sindrenj.app;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RateMovieGUI extends JDialog {
	JPanel radioPanel;
	ButtonGroup radio_group;
	//Radiobuttons:
	JRadioButton rdbtnNotSeen;
	JRadioButton radBtn_1;
	JRadioButton radBtn_2;
	JRadioButton radBtn_3;
	JRadioButton radBtn_4;
	JRadioButton radBtn_5;
	
	App controller;
	Movie movie;
	
	public RateMovieGUI(App controller, Movie mv, JFrame parent, String title) {
		super(parent, true);
		setTitle(title);        		
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(new JPanel(), BorderLayout.SOUTH);
		add(new JPanel(), BorderLayout.NORTH);
		RatePanel midten = new RatePanel(mv.name);
		add(midten, BorderLayout.CENTER);
		this.controller = controller;
		movie = mv;
		this.setSize(440, 200);
		this.show(true);
	}
	
	class RatePanel extends JPanel {
		public RatePanel(String movieName) {
			JLabel lblMovieName = new JLabel(movieName);
			lblMovieName.setBounds(0, 11, 436, 23);
			lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMovieName.setFont(new Font("Tahoma", Font.BOLD, 19));
			this.add(lblMovieName);
						
			radioPanel = new JPanel();
			radio_group = new ButtonGroup();
			radioPanel.setBounds(28, 88, 454, 33);
			
			JRadioButton rdbtnNotSeen = new JRadioButton("Not seen");
			rdbtnNotSeen.setActionCommand("0");
			radio_group.add(rdbtnNotSeen);
			radioPanel.add(rdbtnNotSeen);
			
			radBtn_1 = new JRadioButton("1");
			radBtn_1.setActionCommand("1");
			radio_group.add(radBtn_1);
			radioPanel.add(radBtn_1);
			
			radBtn_2 = new JRadioButton("2");
			radBtn_2.setActionCommand("2");
			radio_group.add(radBtn_2);
			radioPanel.add(radBtn_2);
			
			radBtn_3 = new JRadioButton("3");
			radBtn_3.setActionCommand("3");
			radio_group.add(radBtn_3);
			radioPanel.add(radBtn_3);
			
			radBtn_4 = new JRadioButton("4");
			radBtn_4.setActionCommand("4");
			radio_group.add(radBtn_4);
			radioPanel.add(radBtn_4);
			
			radBtn_5 = new JRadioButton("5");
			radBtn_5.setActionCommand("5");
			radio_group.add(radBtn_5);
			radioPanel.add(radBtn_5);
			//Add actionlisteners:
			rdbtnNotSeen.addActionListener(new radioButtonListener());
			radBtn_1.addActionListener(new radioButtonListener());
			radBtn_2.addActionListener(new radioButtonListener());
			radBtn_3.addActionListener(new radioButtonListener());
			radBtn_4.addActionListener(new radioButtonListener());
			radBtn_5.addActionListener(new radioButtonListener());

			this.add(radioPanel);
		}
	}
	
	public void close() {
		this.dispose();
	}
	
	
	class radioButtonListener implements ActionListener{
        
		public void actionPerformed(ActionEvent e) {
			//Assign the score:
			movie.score = Integer.parseInt(e.getActionCommand());
			//Add the rating:
			controller.addRating(movie);
			close();
		}
	}
	
}
