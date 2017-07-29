package com.termal.api.test;

import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;
import com.termal.api.ui.Window;

public class Win extends Window{

	public Win(String name, int row, int column, int columns, int rows) {
		super(name, row, column, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public Win(String name, TermPosition pos, TermSize size) {
		super(name, pos, size);
		
	}
}
