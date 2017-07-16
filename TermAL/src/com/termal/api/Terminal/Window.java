package com.termal.api.Terminal;

import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public abstract class Window {
	protected int row;
	protected int column;
	protected int rows;
	protected int columns;
	
	public Window(int row, int column, int rows, int columns) {
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
	}
	
	public Window(TermPosition pos, TermSize size) {
		this.row = pos.getRow();
		this.column = pos.getColumn();
		this.rows = size.getRows();
		this.columns = size.getColumns();
	}
	
	public void draw() {
		
	}
	
	public int getRow() { return row; }
	public int getColumn() { return column; }
	public int getRows() { return rows; }
	public int getColumns() { return columns; }
}
