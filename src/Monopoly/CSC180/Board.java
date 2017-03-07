package Monopoly.CSC180;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Board {
	static int numberOfTiles = 40;
	List<Tile> tileArray = new ArrayList<Tile>();
	List<Card> communityChestCards = new ArrayList<Card>();
	List<Card> chanceCards = new ArrayList<Card>();
	Tile tile;
	String name;
	String color;
	int price;
	int RentBase;
	int Rent1House;
	int Rent2House;
	int Rent3House;
	int Rent4House;
	int RentHotel;
	int MortgageValue;
	int HouseCost;
	int HotelCost;
	Card cards;
	public void CreateBoardGame() {
		loadCards();
	}
	public void movePlayer(Player playerObject) {
		
	}
	public void incomeTax() {
		
	}
	public void buyProperty(Player playerObject, Tile tileToBuy) {
		
	}
	public void buyImprovement(Player playerObject, Tile tileForHouse) {
		
	}
	public void loadTiles() {
		String tilefilePath = "C:\\Users\\Stein Muhlhauser\\git\\Monopoly-CSC180\\src\\Monopoly\\CSC180\\Tiles.txt";
		String regexArgs = "TileName=([.&a-zA-Z\\s?]+)\\nTileColor=([a-zA-Z0-9\\s?]+)\\nTilePrice=([0-9\\s?]+)\\nTileRentBase=([0-9\\s?]+)\\nTileRent1House=([0-9\\s?]+)\\nTileRent2House=([0-9\\s?]+)\\nTileRent3House=([0-9\\s?]+)\\nTileRent4House=([0-9\\s?]+)\\nTileRentHotel=([0-9\\s?]+)\\nMortgageValue=([0-9\\s?]+)\\nHouseCost=([0-9\\s?]+)\\nHotelCost=([0-9\\s?]+)";
		try {
			List<String> linesList = Files.readAllLines(Paths.get(tilefilePath));
			String textinfo = linesList
					.stream()
					.map(s -> s.toString())
					.reduce((t,u) -> t + "\n" + u).get();
			
			String[] splitTiles = textinfo.split("\\n\\n");
			Pattern pattern = Pattern.compile(regexArgs);
			for(int i=0;i<splitTiles.length;i++) {
				Matcher matcher = pattern.matcher(splitTiles[i]);
				while(matcher.find()) {
					this.name = matcher.group(1);
					this.color = matcher.group(2);
					String price = matcher.group(3);
					String RentBase = matcher.group(4);
					String Rent1House = matcher.group(5);
					String Rent2House = matcher.group(6);
					String Rent3House = matcher.group(7);
					String Rent4House = matcher.group(8);
					String RentHotel = matcher.group(9);
					String MortgageValue = matcher.group(10);
					String HouseCost = matcher.group(11);
					String HotelCost = matcher.group(12);
					this.price = Integer.parseInt(price);
					this.RentBase = Integer.parseInt(RentBase);
					this.Rent1House = Integer.parseInt(Rent1House);
					this.Rent2House = Integer.parseInt(Rent2House);
					this.Rent3House = Integer.parseInt(Rent3House);
					this.Rent4House = Integer.parseInt(Rent4House);
					this.RentHotel = Integer.parseInt(RentHotel);
					this.MortgageValue = Integer.parseInt(MortgageValue);
					this.HouseCost = Integer.parseInt(HouseCost);
					this.HotelCost = Integer.parseInt(HotelCost);
					tile = new Tile(this.name, this.color, "Board", this.price, this.RentBase, this.Rent1House, this.Rent2House, this.Rent3House, this.Rent4House, this.RentHotel, this.MortgageValue, this.HouseCost, 0, this.HotelCost, 0);
					tileArray.add(tile);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Tile tile : tileArray) {
			System.out.println(tile.tileName);
		}
	}
	public void loadCards() {
		String cardFilePath = "C:\\Users\\Stein Muhlhauser\\git\\Monopoly-CSC180\\src\\Monopoly\\CSC180\\Cards.txt";
		List<String> cardLines;
		try {
			cardLines = Files.readAllLines(Paths.get(cardFilePath));
			String cardText = cardLines
					.stream()
					.map(s -> s.toString())
					.reduce((t,u) -> t + "\n" + u).get();
			//System.out.println(cardText);
			String[] cardSeperation = cardText.split("\\n\\n");
			String[] communityChest = cardSeperation[0].split("\\n");
			String[] chanceCards = cardSeperation[1].split("\\n");
			for(String lines : communityChest) {
				cards = new Card(lines, "Community Chest");
				this.communityChestCards.add(cards);
			}
			for(String lines : chanceCards) {
				cards = new Card(lines, "Chance");
				this.chanceCards.add(cards);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
