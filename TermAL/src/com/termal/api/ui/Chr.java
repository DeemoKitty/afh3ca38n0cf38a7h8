package com.termal.api.ui;

public class Chr {
	
	private String character;
	private int column, row;
	
	public Chr(int row, int column, String ch) {
		this.character = ch;
		this.row = row;
		this.column = column;
	}
	
	public String getChar() {
		return character;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
}
