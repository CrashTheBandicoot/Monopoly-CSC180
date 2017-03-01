package Monopoly.CSC180;

public class Piece {
	private String name;
	//should have an image not sure how to save it yet
	public Piece(String name){
		this.name = name;
	}
	public int move(int numberToMove, int location) {
		// TODO Auto-generated method stub
		int newLocation = numberToMove + location;
		if(newLocation > Board.numberOfTiles){
			return newLocation - Board.numberOfTiles;
		}
		return newLocation;
	}
	public String getName(){
		return name;
	}
}
