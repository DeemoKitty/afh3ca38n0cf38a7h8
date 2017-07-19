package com.termal.api.Terminal;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.termal.api.tools.TermSize;

public class Terminal {

	private int rows, columns;
	@SuppressWarnings("unused")
	private boolean debug = false;

	private char[][] board;
	private char[][] displayBoard;
	
	private ProcessBuilder pb;
	
	private boolean flushCalled = false;

	private ArrayList<Window> windows = new ArrayList<Window>();
	
	private JFrame frame = null;
	private JTextArea term = null;

	public Terminal(int columns, int rows) throws IOException {
		this.rows = rows;
		this.columns = columns;
		this.board = new char[rows][columns];
		Setup();
	}

	public Terminal(TermSize size) throws IOException {
		this.rows = size.getRows();
		this.columns = size.getColumns();
		this.board = new char[rows][columns];
		Setup();
	}
	
	private void Setup() {
		frame = new JFrame("Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		} else {
			System.err.println("Debug not enabled. Not drawing the board. To enable it use enableDebug(flag)");
		}
	}

	public void AddWindow(Window window) {
		windows.add(window);
	}

	public void flush() throws IOException {
		board = new char[rows][columns];
		displayBoard = null;
		flushCalled = true;
	}

	public void refresh() throws IOException {
		while(!flushCalled) {
			flush();
		}
		if (!windows.isEmpty()) {
			for (int i = 0; i < windows.size(); i++) {
				for (int y = windows.get(i).getRow(); y <= windows.get(i).getRows(); y++) {
					for (int x = windows.get(i).getColumn(); x <= windows.get(i).getColumns(); x++) {
						putCharacter(x, y, '*');
					}
				}
			}
		}
		displayBoard = board.clone();
		flushCalled = false;
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
