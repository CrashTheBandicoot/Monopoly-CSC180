package Monopoly.CSC180;
import java.util.function.BiFunction;

public class Player {
	private Piece piece;
	private int moneyOwned;
	private int location;
	private Board board;
	private String name;
	public int ownedHouses;
	public int ownedHotels;
	public boolean inJail;
	public int snakeEyeAmount = 0;
	cardCheck checker = new cardCheck();
	public Player(Piece piece, int money, Board board){
		this.piece = piece;
		this.moneyOwned = money;
		this.board = board;
	}
	public Piece getPiece(){
		return piece;
	}
	public int getMoney(){
		return moneyOwned;
	}
	public <T> void setMoney(T getMoney, T modifier, BiFunction<T, T, T> equation) {
		T operand1 = getMoney;
		T operand2 = modifier;
		T result = equation.apply(operand1, operand2);
		moneyOwned = (int)result;
	}
	//For cards such as "Return to GO". And other specific move cards.
	public void setLocation(int newLocation) {
		this.location = newLocation;
	}
	public void movePiece(int numberToMove){
		location = piece.move(numberToMove, location);
		checker.checkMove(location, this, this.board);
	}
	public void takeTurn(){
		//roll dice;
		int numRolled = 0;
		movePiece(numRolled);
		//get tile
		//do action associated with that
	}
	public int getLocation() {
		return this.location;
	}
	public String getName() {
		return this.name;
	}
}