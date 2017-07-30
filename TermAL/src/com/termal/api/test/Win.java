package com.termal.api.test;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;
import com.termal.api.ui.Window;

public class Win extends Window{

	public Win(Terminal terminal, String name, int row, int column, int rows, int columns) {
		super(terminal, name, row, column, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public Win(Terminal terminal, String name, TermPosition pos, TermSize size) {
		super(terminal, name, pos, size);
		
	}
}
