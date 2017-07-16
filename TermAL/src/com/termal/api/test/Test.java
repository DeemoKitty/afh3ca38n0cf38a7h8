package com.termal.api.test;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermSize;

public class Test {

	Terminal terminal;
	
	public Test() {
		terminal = new Terminal(new TermSize(80,20));
		
		System.out.println("Size X: " + terminal.getColumns() + " ; Size Y: " + terminal.getRows());
		
		terminal.enableDebug(true);
		
		terminal.refresh();
		terminal.display();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
