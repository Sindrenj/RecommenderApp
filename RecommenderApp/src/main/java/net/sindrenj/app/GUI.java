package net.sindrenj.app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI extends JFrame{
	
	private JTable tbl;
	private Object[][] data; //The recommendations
	private String[] columnNames; //The users(Divided in columns)
	
	public GUI() {
		Object[] options = {1,2,3, 4, 5};
		
//		for()
//		int n = JOptionPane.showOptionDialog(frame,
//			    "Give a score between 1-5"
//			    + "with that ham?",
//			    "Rate movie" . mv.name,
//			    JOptionPane.YES_NO_CANCEL_OPTION,
//			    JOptionPane.QUESTION_MESSAGE,
//			    null,
//			    options,
//			    options[2]);
		
	}
	
	public void createTable(Object[][] data, String[] columnNames) {
		//Assign the data:
		this.data = data;
		this.columnNames = columnNames;
		//Title:
		setTitle("Movie recommendations");
		//Size:
	    setSize(600, 300);
	    setLocationRelativeTo(null);
	    //How to close:
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //Gjør vinduet synlig:
	    setVisible(true);
	}
	
	public void setupTable() {
		tbl = new JTable(data, columnNames);
		JScrollPane pane = new JScrollPane(tbl);
		add(pane);
	}
	
	public void rot() {
		

		
		
	}
	
	
	
	
}
