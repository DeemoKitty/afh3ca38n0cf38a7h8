package com.termal.api.Terminal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;
import com.termal.api.ui.Window;

public class Terminal {

	// Size
	private int rows, columns;
	private int resolution;
	public static final int DEFAULT_RES = 10;
	// --------------------------//

	// Display
	private String[][] board;
	private String[][] displayBoard;
	// --------------------------------//

	// Window handler
	private ArrayList<Window> windows = new ArrayList<Window>();
	// -------------------------------------------------------------//

	// Frame and terminal
	private JFrame frame = null;
	private JTextArea term = null;
	// ------------------------------//

	// Control booleans
	private boolean fullscreen = false;
	private boolean debug = false;
	// ------------------------------------//

	// Listeners
	private KeyListener l;
	private MouseListener ml;
	// ------------------------//

	public Terminal(int columns, int rows, int resolution) {
		this.rows = rows;
		this.columns = columns;
		this.board = new String[rows][columns];
		this.resolution = resolution;
		Setup();
	}

	public Terminal(TermSize size, int resolution) {
		this.rows = size.getRows();
		this.columns = size.getColumns();
		this.board = new String[rows][columns];
		this.resolution = resolution;
		Setup();
	}

	public Terminal(int columns, int rows, boolean fullscreen, int resolution) {
		this.rows = rows;
		this.columns = columns;
		this.board = new String[rows][columns];
		this.fullscreen = fullscreen;
		this.resolution = resolution;
		Setup();
	}

	public Terminal(TermSize size, boolean fullscreen, int resolution) {
		this.rows = size.getRows();
		this.columns = size.getColumns();
		this.board = new String[rows][columns];
		this.fullscreen = fullscreen;
		this.resolution = resolution;
		Setup();
	}

	public Terminal(boolean fullscreen, int resolution) {
		this.fullscreen = fullscreen;
		this.resolution = resolution;
		Setup();
	}

	private void Setup() {

		int rows = 0;
		int y = 0;
		int columns = 0;
		int x = 0;
		int font_width = 0;
		int font_height = 0;

		Font font = new Font("monospaced", Font.PLAIN, resolution);

		frame = new JFrame("Grid");
		term = new JTextArea();

		term.setEditable(false);

		term.setBackground(Color.black);
		term.setForeground(Color.green);
		term.setFont(font);
		term.setDoubleBuffered(true);

		font_width = java.awt.Toolkit.getDefaultToolkit().getFontMetrics(font).charWidth('*');
		font_height = java.awt.Toolkit.getDefaultToolkit().getFontMetrics(font).getHeight();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (fullscreen) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);

		} else {
			frame.setSize(new Dimension(800, 600));
		}

		System.out.println(term.getWidth() + ", " + term.getHeight());

		frame.setBackground(Color.black);

		frame.add(term);
		frame.pack();

		frame.setVisible(true);
		

		if (fullscreen) {
			do {
				if (y < frame.getHeight()) {
					y += font_height;
					rows++;
				}else if(x < frame.getWidth()) {
					x += font_width;
					columns++;
				}else {
					this.rows = rows;
					this.columns = columns;
					break;
				}
			} while (true);
		}
	}

	public void display() {
		flush();
		buildBoard();
		refresh();

		String text = "";
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				text += displayBoard[i][k];
			}
			text += "\n";
		}
		term.setText(text);
	}

	private void buildBoard() {
		if (debug) {
			for (int i = 0; i < rows; i++) {
				for (int k = 0; k < columns; k++) {
					board[i][k] = ".";
				}
			}
		} else {
			System.err.println("Debug not enabled. Not drawing the board. To enable it use enableDebug(flag)");
			for (int i = 0; i < rows; i++) {
				for (int k = 0; k < columns; k++) {
					board[i][k] = " ";
				}
			}
		}
	}

	private void flush() {
		board = new String[rows][columns];
		displayBoard = null;
		term.setText(null);
	}

	private void refresh() {
		if (!windows.isEmpty()) {
			for (int i = 0; i < windows.size(); i++) {
				/*for (int y = windows.get(i).getRow(); y <= windows.get(i).getRows(); y++) {
					for (int x = windows.get(i).getColumn(); x <= windows.get(i).getColumns(); x++) {
						putCharacter(x, y, "*");
					}
				}*/
				windows.get(i).update();
			}
		}
		displayBoard = board.clone();
	}

	public void putCharacter(int column, int row, String character) {
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

	public TermPosition getCaretPos() {
		int x = term.getCaretPosition();
		int y = 0; 

		while (x > columns) {
			y += 1;
			x -= columns + 1;
		}

		return new TermPosition(x, y);
	}

	public Window getWindow(int i) {
		if (!windows.isEmpty()) {
			if (i < windows.size() && i >= 0)
				return windows.get(i);
			else
				return windows.get(windows.size() - 1);
		} else {
			return null;
		}
	}

	public int getWindows() {
		return windows.size();
	}

	public void setMouseListener(MouseListener ml) {
		this.ml = ml;
		term.addMouseListener(ml);
	}

	public void setKeyListener(KeyListener kl) {
		l = kl;
		term.addKeyListener(kl);
	}

	public void Dispose() {
		while (!windows.isEmpty()) {
			windows.remove(0);
		}
		if (l != null)
			term.removeKeyListener(l);
		if (ml != null)
			term.removeMouseListener(ml);

		flush();
		frame.removeAll();
		frame.dispose();
	}

	public void AddWindow(Window window) {
		windows.add(window);
	}

	public void RemoveWindow(Window window) {
		windows.remove(window);
	}

	public void RemoveWindow(int i) {
		if (i < windows.size())
			windows.remove(i);
		else
			throw new IndexOutOfBoundsException("Selected window does not exist. (Value either too big or negative)");
	}

	public void DrawToBoard(String[][] display, int row, int column, int rows, int columns) {
		int yy = 0;
		for(int y = row; y < rows; y++) {
			int xx = 0;
			for(int x = column; x < columns; x++) {
				board[y][x] = display[yy][xx];
				xx++;
			}
			yy++;
		}
	}
}
