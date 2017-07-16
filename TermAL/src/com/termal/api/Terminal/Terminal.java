package com.termal.api.Terminal;

import com.termal.api.tools.TermSize;

public class Terminal {

	private int rows, columns;
	@SuppressWarnings("unused")
	private boolean debug = false;

	private char[][] board;
	private char[][] displayBoard;

	public Terminal(int columns, int rows) {
		this.rows = rows;
		this.columns = columns;
		this.board = new char[rows][columns];
	}

	public Terminal(TermSize size) {
		this.rows = size.getRows();
		this.columns = size.getColumns();
		this.board = new char[rows][columns];
	}

	public void display() {
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				System.out.print(displayBoard[i][k]);
			}
			System.out.println();
		}
	}

	public void buildBoard() {
		if (debug) {
			for (int i = 0; i < rows; i++) {
				for (int k = 0; k < columns; k++) {
					board[i][k] = '.';
				}
			}
		}else {
			System.err.println("Debug not enabled. Not drawing the board. To enable it use enableDebug(flag)");
		}
	}
	
	public void flush() {
		displayBoard = null;
	}
	
	public void refresh() {
		displayBoard = board.clone();
	}

	public void putCharacter(int column, int row, char character) {
		board[row][column] = character;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public void enableDebug(boolean flag) {
		debug = flag;
	}

}
