package com.termal.api.tools;

public class TermSize {
	private int rows;
	private int columns;
	
	public TermSize(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public int getRows() { return rows; }
	public int getColumns() { return columns; }
	
	@Override
	public String toString() {
		String output = null;
		output += "{ Width: " + columns + ", Height: " + rows + " }"; 
		return output;
	}
}
