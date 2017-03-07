package Monopoly.CSC180;

import javax.swing.JFrame;

public class MenuScreen {
	public JFrame frame;
	public MenuScreen(int x, int y){
		frame = new JFrame("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
		frame.setSize(x, y);
		frame.setVisible(true);
	}
}