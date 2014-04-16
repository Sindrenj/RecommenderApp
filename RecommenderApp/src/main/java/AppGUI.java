import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Panel;

import javax.swing.JRadioButton;

import java.awt.List;


public class AppGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI window = new AppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("images/movie_roll_icon.png");
		frame.setIconImage(img.getImage());
		frame.setBounds(100, 100, 454, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie Recommender 3000 (Java Edition)");
		lblNewLabel.setBounds(0, 11, 436, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBounds(78, 97, 275, 33);
		frame.getContentPane().add(panel);
		
		JRadioButton rdbtnNotSeen = new JRadioButton("Not yet seen");
		rdbtnNotSeen.setSelected(true);
		panel.add(rdbtnNotSeen);
		
		JRadioButton radioButton_1 = new JRadioButton("1");
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("4");
		panel.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("5");
		panel.add(radioButton_5);
		
		JLabel lblDieHard = new JLabel("Die Hard (1995)");
		lblDieHard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDieHard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDieHard.setBounds(18, 63, 418, 28);
		frame.getContentPane().add(lblDieHard);
		
		JLabel lblRateTheMovie = new JLabel("Rate the movie:");
		lblRateTheMovie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRateTheMovie.setBounds(78, 49, 275, 14);
		frame.getContentPane().add(lblRateTheMovie);
		
		List list = new List();
		list.setBounds(78, 170, 275, 181);
		frame.getContentPane().add(list);
		
		JLabel lblWeRecommend = new JLabel("We recommend:");
		lblWeRecommend.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeRecommend.setBounds(78, 150, 130, 14);
		frame.getContentPane().add(lblWeRecommend);
	}
}
