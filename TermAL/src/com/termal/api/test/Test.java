package com.termal.api.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.termal.api.Terminal.Terminal;

public class Test {
	
	Terminal term;
	
	public Test() {
		term = new Terminal(true, Terminal.DEFAULT_RES);
		
		term.enableDebug(true);
		
		term.WriteString(2, 2, "Hello World!");
		term.display();
		
		term.setKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.isControlDown())
					term.Dispose();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
	}

	public static void main(String... args) {
		new Test();
	}
	
}
