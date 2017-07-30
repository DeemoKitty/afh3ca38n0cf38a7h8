package com.termal.api.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public class Test {

	Terminal terminal;

	public Test() {
		terminal = new Terminal(true, Terminal.DEFAULT_RES);

		System.out.println("Size X: " + terminal.getColumns() + " ; Size Y: " + terminal.getRows());

		terminal.enableDebug(false);

		Win win = new Win(terminal, "Test Window", new TermPosition(2, 2), new TermSize(5, 10));
		Win window = new Win(terminal, "Window D", 6, 30, 10, 20);

		// System.out.println("Window created with dimentions of: " +
		// window.getPosition().toString() + "\n" + window.getSize().toString());

		terminal.AddWindow(window);
		terminal.AddWindow(win);
		terminal.display();
		
		terminal.setKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.isControlDown())
					terminal.Dispose();
				if(arg0.isShiftDown()) {
					window.setColumn(100);
					terminal.display();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		terminal.setMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				for(int i = 0; i < terminal.getWindows(); i++) {
					int x = terminal.getCaretPos().getColumn();
					int y = terminal.getCaretPos().getRow();
					if(terminal.getWindow(i).checkBounds(y, x)) {
						terminal.RemoveWindow(i);
						terminal.display();
						break;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
