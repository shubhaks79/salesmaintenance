package com.sales.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import com.sales.ui.util.UIApplicationConstants;

public class SearchPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JPanel pnSearch;
	JLabel lbName;
	JTextField tfNameTxt;
	JTable tbTable2;
	JButton btSearchBtn;
	JButton btClearBtn;
	JLabel lbAgeLbl;
	JTextField tfAgeTxt;
	JLabel lbAddLbl;
	JTextField tfAddTxt;
	private JScrollPane tableScrollPane = null;
	
	JButton btExportBtn;
	
	public SearchPanel(){
		pnSearch = new JPanel();
		pnSearch.setPreferredSize(new Dimension(800, 400));
		   GridBagLayout gbLayout = new GridBagLayout();
		   GridBagConstraints gbcAddTxt = new GridBagConstraints();
		   pnSearch.setLayout( gbLayout );

		   lbName = new JLabel( "Name"  );
		   lbName.setToolTipText( "Name" );
		   gbcAddTxt.gridx = 1;
		   gbcAddTxt.gridy = 1;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 1;
		   gbcAddTxt.anchor = GridBagConstraints.CENTER;
		   gbLayout.setConstraints( lbName, gbcAddTxt );
		   pnSearch.add( lbName );

		   tfNameTxt = new JTextField( );
		   gbcAddTxt.gridx = 1;
		   gbcAddTxt.gridy = 2;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 0;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbcAddTxt.insets = new Insets( 5,5,5,5 );
		   gbLayout.setConstraints( tfNameTxt, gbcAddTxt );
		   pnSearch.add( tfNameTxt );

		   JPanel alertSummPanel=new JPanel(new BorderLayout());
		   alertSummPanel.setPreferredSize(new Dimension(alertSummPanel.getPreferredSize().width, 200));
		   alertSummPanel.setBorder(new TitledBorder(new javax.swing.border.LineBorder(new Color(-16777216), 1), "Data", 0, 0, UIApplicationConstants.panelTitleFont, new Color(-13421773)));
		   alertSummPanel.add(getTableJScrollPane(), BorderLayout.CENTER);
		   alertSummPanel.add( getSouthPanel(), BorderLayout.SOUTH);
		   gbcAddTxt.gridx = 1;
		   gbcAddTxt.gridy = 5;
		   gbcAddTxt.gridwidth = 5;
		   gbcAddTxt.gridheight = 3;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 1;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbLayout.setConstraints( alertSummPanel, gbcAddTxt );
		   pnSearch.add( alertSummPanel );

		   getSearchButton();
		   gbcAddTxt.gridx = 4;
		   gbcAddTxt.gridy = 3;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 0;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbcAddTxt.insets = new Insets( 5,5,5,5 );
		   gbLayout.setConstraints( btSearchBtn, gbcAddTxt );
		   pnSearch.add( btSearchBtn );

		   getSearchClearButton();
		   gbcAddTxt.gridx = 5;
		   gbcAddTxt.gridy = 3;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 0;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbcAddTxt.insets = new Insets( 5,5,5,5 );
		   gbLayout.setConstraints( btClearBtn, gbcAddTxt );
		   pnSearch.add( btClearBtn );

		   lbAgeLbl = new JLabel( "Age"  );
		   gbcAddTxt.gridx = 2;
		   gbcAddTxt.gridy = 1;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 1;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbLayout.setConstraints( lbAgeLbl, gbcAddTxt );
		   pnSearch.add( lbAgeLbl );

		   tfAgeTxt = new JTextField( );
		   gbcAddTxt.gridx = 2;
		   gbcAddTxt.gridy = 2;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 0;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbcAddTxt.insets = new Insets( 5,5,5,5 );
		   gbLayout.setConstraints( tfAgeTxt, gbcAddTxt );
		   pnSearch.add( tfAgeTxt );

		   lbAddLbl = new JLabel( "Street"  );
		   gbcAddTxt.gridx = 3;
		   gbcAddTxt.gridy = 1;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.BOTH;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 1;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbLayout.setConstraints( lbAddLbl, gbcAddTxt );
		   pnSearch.add( lbAddLbl );

		   tfAddTxt = new JTextField( );
		   gbcAddTxt.gridx = 3;
		   gbcAddTxt.gridy = 2;
		   gbcAddTxt.gridwidth = 1;
		   gbcAddTxt.gridheight = 1;
		   gbcAddTxt.fill = GridBagConstraints.HORIZONTAL;
		   gbcAddTxt.weightx = 1;
		   gbcAddTxt.weighty = 0;
		   gbcAddTxt.anchor = GridBagConstraints.NORTH;
		   gbcAddTxt.insets = new Insets( 5,5,5,5 );
		   gbLayout.setConstraints( tfAddTxt, gbcAddTxt );
		   pnSearch.add( tfAddTxt );
		   

		   
		   this.add(pnSearch);
	}


	private JPanel getSouthPanel() {
		JPanel southPanel=new JPanel(new FlowLayout());
		   southPanel.add(getExportButton());
		   return southPanel;
	}


	private JScrollPane getTableJScrollPane() {
		if (tableScrollPane == null) {
			tableScrollPane = new JScrollPane();
			tableScrollPane.setViewportView(getTable());
		}
		return tableScrollPane;
	}
	
	private JTable getTable() {
		
		   if(tbTable2==null){
			   tbTable2 = new JTable();
			   tbTable2.setAutoCreateColumnsFromModel(true);
			   tbTable2.setCellSelectionEnabled(false);
			   tbTable2.setRowSelectionAllowed(false);
			   tbTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			   tbTable2.setBackground(new Color(-1));
			   tbTable2.setAutoCreateRowSorter(true);
			   tbTable2.setFont(UIApplicationConstants.applicationFont);
				//loadData();
		   }
		   
		   return tbTable2;
	}

	private DataTableModel alertTableModl=null;
	private void loadData() {
		String[][] dataTable2 = new String[][] { new String[] { "11", "21" },
				new String[] { "12", "22" }, new String[] { "13", "23" } };
		String[] colsTable2 = new String[] { "Id", "Name" };
		alertTableModl=new DataTableModel(0,colsTable2,-1,0,7);
		tbTable2.setModel(alertTableModl);
		tbTable2.getTableHeader().setFont(UIApplicationConstants.tableHdrFont);
		
		tbTable2.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		for(int i=0; i<dataTable2.length;i++){
			alertTableModl.setRow(1);
			String[] column=dataTable2[i];
			alertTableModl.setValueAt(column[0], i, 0);
			alertTableModl.setValueAt(column[1], i, 1);
		}
	}

	private JButton getSearchButton(){
		if(btSearchBtn==null){
			 btSearchBtn = new JButton( "Search"  );
			 btSearchBtn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						searchListenersAction();
					}

					
				});
			 btSearchBtn.addKeyListener(new java.awt.event.KeyAdapter() { 
					public void keyPressed(KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							searchListenersAction();
						}
					}
				});
		}
		return btSearchBtn;
	}

	protected void searchListenersAction() {
		loadData();
	}
	
	private JButton getSearchClearButton(){
		if(btClearBtn==null){
			 btClearBtn = new JButton( "Clear"  );
			 btClearBtn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						searchClearListenersAction();
					}
					
				});
			 btClearBtn.addKeyListener(new java.awt.event.KeyAdapter() { 
					public void keyPressed(KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							searchClearListenersAction();
						}
					}
				});
		}
		return btClearBtn;
	}
	

	private void searchClearListenersAction() {
		JOptionPane.showMessageDialog(this, "Clear Action","Message",JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
	private JButton getExportButton(){
		if(btExportBtn==null){
			btExportBtn = new JButton( "Export"  );
			btExportBtn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						exportListenersAction();
					}
					
				});
			btExportBtn.addKeyListener(new java.awt.event.KeyAdapter() { 
					public void keyPressed(KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							exportListenersAction();
						}
					}
				});
		}
		return btExportBtn;
	}
	

	private void exportListenersAction() {
		try {
			TableModel model = tbTable2.getModel();
			FileWriter excel = new FileWriter("C:/eclipseMaven/sample.xls");

			for (int i = 0; i < model.getColumnCount(); i++) {
				excel.write(model.getColumnName(i) + "\t");
			}

			excel.write("\n");

			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i, j).toString() + "\t");
				}
				excel.write("\n");
			}

			excel.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
