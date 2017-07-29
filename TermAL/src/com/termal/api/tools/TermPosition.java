package com.termal.api.tools;

public class TermPosition {
	private int row;
	private int column;
	
	public TermPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() { return row; }
	public int getColumn() { return column; }
	
	@Override
	public String toString() {
		String output = "";
		output += "{ X: " + row + ", Y: " + column + " }";
		return output;
	}
}
