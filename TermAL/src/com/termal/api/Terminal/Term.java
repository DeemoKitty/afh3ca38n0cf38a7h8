package com.termal.api.Terminal;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.termal.api.ui.UI;

public abstract class Term {
	protected int rows, columns;
	protected int resolution;
	public static final int DEFAULT_RES = 10;
	
	protected String[][] board;
	protected String[][] displayBoard;
	
	private ArrayList<UI> ui = new ArrayList<UI>();
	
	protected JFrame frame = null;
	protected JTextArea term = null;
	
	protected boolean fullscreen = false;
	protected boolean debug = false;
	
}
