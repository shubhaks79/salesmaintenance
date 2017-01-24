package com.sales.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ApplicationPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ApplicationPanel(){
		initialize();
	}

	private void initialize() {
		setSize(724, 240);
		this.add(getTabs());
	}

	private JPanel  getTabs(){
	    	JPanel tabPanel=new JPanel();
	    	tabPanel.setPreferredSize(new Dimension(1000, 850));
	    	tabPanel.setLayout(new GridLayout(1, 1));
	    	JTabbedPane tabbedPane = new JTabbedPane();
//	    	tabbedPane.setPreferredSize(new Dimension(1400, 80));
	    	ImageIcon icon = createImageIcon("images/middle.gif");

	    	JComponent panel1 = new CreatePanel();
	    	tabbedPane.addTab("Create", icon, panel1, "Create");
	    	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

	    	JComponent panel2 = new SearchPanel();
	    	tabbedPane.addTab("Search", icon, panel2, "Search");
	    	tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	    	
	    	tabPanel.add(tabbedPane);
	    	return tabPanel;
	    }
	    
	     
	    /** Returns an ImageIcon, or null if the path was invalid. */
	    protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = ApplicationFrame.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }
}
