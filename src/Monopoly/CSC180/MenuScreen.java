package Monopoly.CSC180;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenuScreen {
	public JFrame frame;
	JPanel panel = new JPanel();
	public MenuScreen(int height, int width, String windowName){
		frame = new JFrame(windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		panel.setSize(width, height);
		panel.setLayout(null);
	}
	public void buildMainMenuWindow(Color color, String imagePath){
		JLabel label = new JLabel();
		ImageIcon image = new ImageIcon(imagePath);
		label.setIcon(image);
		label.setLocation(300, -50);
		label.setSize(400,300);
		panel.add(label);
		int[] playerOptions = {2,3,4,5,6,7,8};
		JComboBox<Integer> playerBox = new JComboBox<Integer>();
		for(int i = 0; i < playerOptions.length; i++){
			playerBox.addItem(playerOptions[i]);
		}
		playerBox.setFont(new Font("Cochin",1,24));
		playerBox.setSize(75, 50);
		playerBox.setLocation(300,500);
		panel.add(playerBox);
		JTextArea playerLabel = new JTextArea();
		playerLabel.setFont(new Font("Cochin",1,24));
		playerLabel.setSize(220,75);
		playerLabel.setLocation(225,450);
		playerLabel.setEditable(false);
		playerLabel.setText("Number of Players");
		playerLabel.setBackground(color);
		panel.add(playerLabel);
		JButton startButton = new JButton("Start Game");
		startButton.setFont(new Font("Cochin",1,24));
		startButton.setLocation(600, 475);
		startButton.setBackground(Color.WHITE);
		startButton.setSize(200,75);
		panel.add(startButton);
		panel.setBackground(color);
		frame.getContentPane().add(panel);
	}
	public void ShowWindow(){
		frame.setVisible(true);
	}
	public void hideWindow(){
		frame.setVisible(false);
	}
}