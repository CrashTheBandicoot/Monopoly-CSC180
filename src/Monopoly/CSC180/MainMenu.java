package Monopoly.CSC180;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

	public static void main(String[] args) {
		
		Board board = new Board();
		board.CreateBoardGame();
		Player player = new Player(null, 1500, board);
		cardCheck check = new cardCheck();
		check.checkMove(32, player, board);
	}
	public void clickStart() {
		
	}

}
