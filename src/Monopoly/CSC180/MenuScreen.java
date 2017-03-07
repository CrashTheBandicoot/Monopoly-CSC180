package Monopoly.CSC180;

import javax.swing.JFrame;

public class MenuScreen {
	public JFrame frame;
	public MenuScreen(int hight, int width){
		frame = new JFrame("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(hight, width);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}