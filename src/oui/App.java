package oui;

import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
	JTabbedPane tabPane;
	HomePanel homePanel;
	DataPanel dataPanel;
	IndexPanel indexPanel;
	QueryPanel queryPanel;
	
	public App() {
		tabPane = new JTabbedPane();
		tabPane.setFont(new Font("monospaced", 1, 15));
		tabPane.setBackground(Color.black);
		tabPane.setForeground(Color.white);
		
		homePanel = new HomePanel(tabPane);
		dataPanel = new DataPanel(tabPane);
		indexPanel = new IndexPanel(tabPane);
		queryPanel = new QueryPanel(tabPane);
		
		super.add(tabPane);
		
		pack();
		
		super.setTitle("Query Optimization through Indexing");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
}
