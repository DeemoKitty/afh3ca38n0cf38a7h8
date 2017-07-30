package com.termal.api.ui;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public abstract class Button extends UI {
	
	public Button(Terminal terminal, String name, int row, int column, int rows, int columns) {
		super(terminal, name, row, column, rows, columns);
		// TODO Auto-generated constructor stub
	}
	
	public Button(Terminal terminal, String name, TermPosition pos, TermSize size) {
		super(terminal, name, pos, size);
	}
	
	@Override
	public void update() {
		if(changed) {
			Dump();
			CreateBoard();
			changed = false;
		}
		terminal.DrawToBoard(display, row, column, getRows(), getColumns());
	}
	
	@Override
	public void Dump() {
		display = new String[getRows()][getColumns()];
	}
	
}
