package net.sindrenj.app;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI extends JFrame{
	
	private JTable tbl;
	private Object[][] data; //The recommendations
	private String[] columnNames; //The users(Divided in columns)
	
	public GUI(Object[][] data, String[] columnNames) {
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
	
	
	
	
}
