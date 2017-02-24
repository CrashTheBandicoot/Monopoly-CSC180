package Monopoly.CSC180;

public class Player {
	private Piece piece;
	private int moneyOwned;
	private int location;
	public Player(Piece piece, int money){
		this.piece = piece;
		this.moneyOwned = money;
	}
	public Piece getPiece(){
		return piece;
	}
	public int getMoney(){
		return moneyOwned;
	}
	public void movePiece(int numberToMove){
		location = piece.move(numberToMove, location);
	}
}