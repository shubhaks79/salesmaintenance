package com.sales.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreatePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel pnCreatePanel;
	JLabel lbLabel0;
	JLabel lbLabel1;
	JTextField tfNameTxt;
	JTextField tfAgeTxt;
	JButton btOkButn;
	JButton btClearBtn;
	JLabel lbAddLbl;
	JTextArea tfAddTxt;
	public CreatePanel() {
			pnCreatePanel = new JPanel();
			pnCreatePanel.setPreferredSize(new Dimension(800, 150));
		   GridBagLayout gbCreatePanel = new GridBagLayout();
		   GridBagConstraints gbcCreatePanel = new GridBagConstraints();
		   pnCreatePanel.setLayout( gbCreatePanel );

		   lbLabel0 = new JLabel( "Name"  );
		   gbcCreatePanel.gridx = 2;
		   gbcCreatePanel.gridy = 2;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.EAST;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 1;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( lbLabel0, gbcCreatePanel );
		   pnCreatePanel.add( lbLabel0 );

		   lbLabel1 = new JLabel( "Age"  );
		   gbcCreatePanel.gridx = 2;
		   gbcCreatePanel.gridy = 3;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.EAST;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 1;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( lbLabel1, gbcCreatePanel );
		   pnCreatePanel.add( lbLabel1 );

		   tfNameTxt = new JTextField( );
		   gbcCreatePanel.gridx = 4;
		   gbcCreatePanel.gridy = 2;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.HORIZONTAL;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 0;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( tfNameTxt, gbcCreatePanel );
		   pnCreatePanel.add( tfNameTxt );

		   tfAgeTxt = new JTextField( );
		   gbcCreatePanel.gridx = 4;
		   gbcCreatePanel.gridy = 3;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.HORIZONTAL;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 0;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( tfAgeTxt, gbcCreatePanel );
		   pnCreatePanel.add( tfAgeTxt );

		   getSaveButton();
		   gbcCreatePanel.gridx = 7;
		   gbcCreatePanel.gridy = 6;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.NONE;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 0;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbCreatePanel.setConstraints( btOkButn, gbcCreatePanel );
		   pnCreatePanel.add( btOkButn );

		   getClearButton();
		   gbcCreatePanel.gridx = 8;
		   gbcCreatePanel.gridy = 6;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.NONE;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 0;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbCreatePanel.setConstraints( btClearBtn, gbcCreatePanel );
		   pnCreatePanel.add( btClearBtn );

		   lbAddLbl = new JLabel( "Address"  );
		   gbcCreatePanel.gridx = 7;
		   gbcCreatePanel.gridy = 2;
		   gbcCreatePanel.gridwidth = 1;
		   gbcCreatePanel.gridheight = 1;
		   gbcCreatePanel.fill = GridBagConstraints.EAST;
		   gbcCreatePanel.weightx = 1;
		   gbcCreatePanel.weighty = 1;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( lbAddLbl, gbcCreatePanel );
		   pnCreatePanel.add( lbAddLbl );

		   tfAddTxt = new JTextArea( );
		   gbcCreatePanel.gridx = 8;
		   gbcCreatePanel.gridy = 2;
		   gbcCreatePanel.gridwidth = 2;
		   gbcCreatePanel.gridheight = 2;
		   gbcCreatePanel.fill = GridBagConstraints.BOTH;
		   gbcCreatePanel.weightx = 2;
		   gbcCreatePanel.weighty = 1;
		   gbcCreatePanel.anchor = GridBagConstraints.NORTH;
		   gbcCreatePanel.insets = new Insets( 5,5,5,5 );
		   gbCreatePanel.setConstraints( tfAddTxt, gbcCreatePanel );
		   pnCreatePanel.add( tfAddTxt );
		   
		   this.add(pnCreatePanel);
	}
	
	
	private JButton getSaveButton(){
		if(btOkButn==null){
			 btOkButn = new JButton( "Save"  );
			 btOkButn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						saveListenersAction();
					}

					
				});
			 btOkButn.addKeyListener(new java.awt.event.KeyAdapter() { 
					public void keyPressed(KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							saveListenersAction();
						}
					}
				});
		}
		return btOkButn;
	}
   
	private void saveListenersAction() {
		JOptionPane.showMessageDialog(this, "Save Action","Message",JOptionPane.INFORMATION_MESSAGE);
		return;
		
	}


	private JButton getClearButton(){
		if(btClearBtn==null){
			 btClearBtn = new JButton( "Clear"  );
			 btClearBtn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						clearListenersAction();
					}
					
				});
			 btClearBtn.addKeyListener(new java.awt.event.KeyAdapter() { 
					public void keyPressed(KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							clearListenersAction();
						}
					}
				});
		}
		return btClearBtn;
	}
	

	private void clearListenersAction() {
		JOptionPane.showMessageDialog(this, "Clear Action","Message",JOptionPane.INFORMATION_MESSAGE);
		return;
	}
}
