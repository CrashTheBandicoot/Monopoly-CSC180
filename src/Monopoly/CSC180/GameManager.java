package Monopoly.CSC180;

import java.awt.Color;

public class GameManager {

	public static void main(String[] args) {
		MainMenu();
	}
	private static void MainMenu() {
		String windowName = "Monopoly";
		MenuScreen menuWindow = new MenuScreen(800, 1000, windowName);
		//background color, relative path for images,etc.
		String imagePath = "C:\\Users\\Kimberly Nicole\\Desktop\\SchoolStuff\\OpenSource Platform Dev\\Monopoly\\Monopoly-CSC180\\src\\images\\MonopolyLogo.png";
		menuWindow.buildMainMenuWindow(Color.GRAY, imagePath);
		menuWindow.ShowWindow();
		
		//Stuff for starting game
//		Board board = new Board();
//		board.CreateBoardGame();
//		Player player = new Player(null, 1500, board);
//		cardCheck check = new cardCheck();
//		check.checkMove(32, player, board);
	}
}
