package Monopoly.CSC180;

public class Tile {
	private String name;
	private int location;
	public Tile(String tileFile){
		FileReader.readFile(tileFile);
	}
}