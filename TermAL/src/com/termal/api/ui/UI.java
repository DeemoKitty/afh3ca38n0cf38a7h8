package com.termal.api.ui;

import java.util.ArrayList;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public abstract class UI {
	protected String name;
	protected int row;
	protected int column;
	protected int rows;
	protected int columns;
	protected TermPosition pos;
	protected TermSize size;
	protected Terminal terminal;
	protected boolean changed;
	
	protected String[][] display;
	
	protected ArrayList<UI> components = new ArrayList<UI>();
	
	public UI(Terminal terminal, String name, int row, int column, int rows, int columns) {
		this.terminal = terminal;
		this.name = name;
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
		
		display = new String[row+rows][column+columns];
		
		CreateBoard();
		
		pos = new TermPosition(row, column);
		size = new TermSize(rows, columns);
	}
	
	public UI(Terminal terminal, String name, TermPosition pos, TermSize size) {
		this.terminal = terminal;
		this.name = name;
		this.row = pos.getRow();
		this.column = pos.getColumn();
		this.rows = size.getRows();
		this.columns = size.getColumns();
		
		display = new String[row+rows][column+columns];
		
		CreateBoard();
		
		this.pos = pos;
		this.size = size;
	}
	
	public abstract void update();
	public void AddComponent(UI ui) {
		components.add(ui);
	}
	
	public void RemoveComponent(UI ui) {
		components.remove(ui);
	}
	
	protected abstract void Dump();
	
	protected void CreateBoard() {
		for(int y = 0; y <= rows; y++) {
			for(int x = 0; x <= columns; x++) {
				if(x > 0 && x < columns - 1 && y > 0 && y < rows - 1)
					display[y][x] = " ";
				else
					display[y][x] = "&";
			}
		}
	}
	
	public int getRow() { return row; }
	public int getColumn() { return column; }
	public int getRows() { return rows+row; }
	public int getColumns() { return columns+column; }
	public String getName() { return name; }
	
	public String getBounds() {
		return (name + " Start Pos: { " + getRow() + ", " + getColumn() + "}, Size: { " + getRows() + ", " + getColumns() + "}");
	}
	
	public void setRow(int row) { this.row = row; this.changed = true; }
	public void setColumn(int column) { this.column = column; this.changed = true; }
	public void setRows(int rows) { this.rows = rows; this.changed = true; }
	public void setColumns(int columns) { this.columns = columns; this.changed = true; }
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
