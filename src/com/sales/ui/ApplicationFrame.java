package com.sales.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ApplicationFrame {
	 /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Search Engine");
        ApplicationPanel applicationPanel=new ApplicationPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1400, 950));
        frame.add(applicationPanel, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
   
 
    public static void main(String[] args) {
    	
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ApplicationFrame applicationFrame=new ApplicationFrame();
            	applicationFrame.createAndShowGUI();
            }
        });
    }
}
