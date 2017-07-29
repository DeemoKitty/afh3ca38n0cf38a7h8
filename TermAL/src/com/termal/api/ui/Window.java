package com.termal.api.ui;

import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public abstract class Window {
	protected String name;
	protected int row;
	protected int column;
	protected int rows;
	protected int columns;
	protected TermPosition pos;
	protected TermSize size;
	
	public Window(String name, int row, int column, int columns, int rows) {
		this.name = name;
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
		
		pos = new TermPosition(row, column);
		size = new TermSize(rows, columns);
	}
	
	public Window(String name, TermPosition pos, TermSize size) {
		this.name = name;
		this.row = pos.getRow();
		this.column = pos.getColumn();
		this.rows = size.getRows();
		this.columns = size.getColumns();
		
		this.pos = pos;
		this.size = size;
	}
	
	public int getRow() { return row; }
	public int getColumn() { return column; }
	public int getRows() { return rows+row; }
	public int getColumns() { return columns+column; }
	public String getName() { return name; }
	
	public String getBounds() {
		return (name + " Start Pos: { " + getRow() + ", " + getColumn() + "}, Size: { " + getRows() + ", " + getColumns() + "}");
	}
	
	public void setRow(int row) { this.row = row; }
	public void setColumn(int column) { this.column = column; }
	public void setRows(int rows) { this.rows = rows; }
	public void setColumns(int columns) { this.columns = columns; }
	public boolean checkBounds(int x, int y) {
		if(x >= getColumn() && x <= getColumns() && y >= getRow() && y <= getRows()) {
			return true;
		}else {
			return false;
		}
	}
	
	public TermPosition getPosition() { return pos; }
	public TermSize getSize() { return size; }
}
