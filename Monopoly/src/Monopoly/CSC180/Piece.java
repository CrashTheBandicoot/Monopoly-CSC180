package Monopoly.CSC180;

public class Piece {

	public int move(int numberToMove, int location) {
		// TODO Auto-generated method stub
		int newLocation = numberToMove + location;
		if(newLocation > Board.numberOfTiles){
			return newLocation - Board.numberOfTiles;
		}
		return newLocation;
	}
	
}
