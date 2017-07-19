package com.termal.api.test;

import com.termal.api.Terminal.Window;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public class Win extends Window{

	public Win(int row, int column, int columns, int rows) {
		super(row, column, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public Win(TermPosition pos, TermSize size) {
		super(pos, size);
		
	}
}
