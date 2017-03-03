package Monopoly.CSC180;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuScreen {
	public JFrame frame;
	public MenuScreen(){
		frame = new JFrame("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void DisplayScreen() {
		// TODO Auto-generated method stub
		JPanel contentPane = new JPanel(new BorderLayout());
		JButton button1 = new JButton();
		contentPane.add(button1, BorderLayout.CENTER);
	}
}