/************************************************
 /* File Name: MyTableModel.java
 * Part of package/module: gbbf.gcms.common.config.ui.utils
 * Purpose of the source file: Table Model Used in all UI of
 * 								Configuration Module
 * Original Author Name:Shubha
 * Date Created: Thursday September 27 2007
 * Last Modification Date: Monday November 19 2007
 * Last Modification made by: Shubha
 * Remarks:
 *
 * Copyright Notice: Software developed by TurningPoint Global Solutions under contract from ViaSat Inc.
 **************************************************/
package com.sales.ui;

import java.awt.Point;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class DataTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Hashtable<Point, Object> lookup;

	private int rows;

	private final int columns;

	private final String headers[];

	private int columnEditable= 0;
	
	private int columnNotEditable= -1;
	
	private int isColInteger=-1;
	
	private int isColTime=-1;

	private List<?> dateColList=null;
	
	public DataTableModel(int rows, String columnHeaders[], int coledit,int intColumn,int dtCol) {
		if ((rows < 0) || (columnHeaders == null)) {
			throw new IllegalArgumentException("Invalid row count/columnHeaders");
		}
		this.rows = rows;
		this.columns = columnHeaders.length;
		this.columnEditable = coledit;
		headers = columnHeaders;
		isColInteger=intColumn;		
		isColTime=dtCol;
		lookup = new Hashtable<Point, Object>();
	}
	public DataTableModel(int rows, String columnHeaders[], int coledit,int intColumn,List<?> dtCollst) {
		if ((rows < 0) || (columnHeaders == null)) {
			throw new IllegalArgumentException("Invalid row count/columnHeaders");
		}
		this.rows = rows;
		this.columns = columnHeaders.length;
		this.columnEditable = coledit;
		headers = columnHeaders;
		isColInteger=intColumn;		
		dateColList=dtCollst;
		lookup = new Hashtable<Point, Object>();
	}
	public DataTableModel(int colmnNoteditable ,int rows, String columnHeaders[]) {
		if ((rows < 0) || (columnHeaders == null)) {
			throw new IllegalArgumentException("Invalid row count/columnHeaders");
		}
		this.rows = rows;
		this.columns = columnHeaders.length;
		this.columnNotEditable = colmnNoteditable;
		headers = columnHeaders;
		lookup = new Hashtable<Point, Object>();
	}

	public DataTableModel(int rows, String columnHeaders[]) {
		if ((rows < 0) || (columnHeaders == null)) {
			throw new IllegalArgumentException("Invalid row count/columnHeaders");
		}
		this.rows = rows;
		this.columns = columnHeaders.length;
		headers = columnHeaders;
		lookup = new Hashtable<Point, Object>();
	}

	 public Class<?> getColumnClass(int column) {
		 if(isColInteger>-1){
	        if (column == isColInteger)   {             // n is column concerned
	            return Integer.class;
	        }
		 }
		 if(dateColList==null){
		if(isColTime>-1){
			if (column == isColTime)   {             // n is column concerned
	            return Calendar.class;
	        }
		}
		 }else{
			 if(dateColList.contains(new Integer(column))){
				 return Calendar.class;
			 }
		 }
        // repeat for any other non-String columns
        return String.class;   
    }

	public int getColumnCount() {
		return columns;
	}

	public int getRowCount() {
		return rows;
	}

	public String getColumnName(int column) {
		return headers[column];
	}

	public Object getValueAt(int row, int column) {
		return lookup.get(new Point(row, column));
	}

	public void setValueAt(Object value, int row, int column) {
		if ((rows < 0) || (columns < 0)) {
			throw new IllegalArgumentException("Invalid row/column setting");
		}
		if (row > rows) {
			this.rows = getRowCount() + 1;
		}
		if ((row < rows) && (column < columns)) {
			lookup.put(new Point(row, column), value);
		}
		fireTableDataChanged();
	}

	public boolean isCellEditable(int nRow, int nCol) {
		if (columnNotEditable == -1 && nCol == columnEditable) {
			return true;
		}else
		if(columnNotEditable == -1  && columnEditable == 0 ){
			return true;

		}else if (nCol == columnNotEditable) {
			return false;
		}else if(columnNotEditable != -1 && nCol != columnNotEditable){
			return true;
		}else
			return false;

		
	}

	public void removeRow(int row) {

		if (row < rows) {
			for (int colm = 0; colm < getColumnCount(); colm++) {
				Point pt = new Point(row, colm);
				lookup.remove(pt);
			}

			for (int shiftrow = row; shiftrow < (getRowCount() - 1); shiftrow++) {
				for (int cloumn = 0; cloumn < getColumnCount(); cloumn++) {
					Point oldPt = new Point((shiftrow + 1), cloumn);

					if (lookup.get(oldPt) != null) {
						Point newPt = new Point(shiftrow, cloumn);
						Object value = lookup.get(oldPt);
						lookup.put(newPt, value);
						lookup.remove(oldPt);
						fireTableDataChanged();
					}
				}
			}
			rows--;
			fireTableRowsDeleted(row, row);
		}

		fireTableDataChanged();

	}

	public void fireTableChanged(TableModelEvent e) {
		super.fireTableChanged(e);
	}

	public void clearAll() {
		lookup.clear();
		this.rows = 0;
		fireTableDataChanged();
	}

	public int getNonEmptyRowCount() {
		return lookup.size();
	}

	public void setRow(int r) {
		this.rows = this.rows + r;
	}

	public int getIsColTime() {
		return isColTime;
	}

	public void setIsColTime(int isColTime) {
		this.isColTime = isColTime;
	}
}
