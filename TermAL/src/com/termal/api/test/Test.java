package com.termal.api.test;

import java.io.IOException;

import com.termal.api.Terminal.Terminal;
import com.termal.api.tools.TermPosition;
import com.termal.api.tools.TermSize;

public class Test {

	Terminal terminal;

	public Test() {
		try {
			terminal = new Terminal(new TermSize(80, 20));

			System.out.println("Size X: " + terminal.getColumns() + " ; Size Y: " + terminal.getRows());

			terminal.enableDebug(true);

			Win win = new Win(new TermPosition(2, 2), new TermSize(10, 5));
			Win window = new Win(6, 30, 5, 10);

			// System.out.println("Window created with dimentions of: " +
			// window.getPosition().toString() + "\n" + window.getSize().toString());

			terminal.AddWindow(window);
			terminal.AddWindow(win);

			while (true) {
				terminal.refresh();
				terminal.display();
				Thread.sleep(15);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
