package Monopoly.CSC180;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.javafx.scene.control.skin.TitledPaneSkin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Board {
	static int numberOfTiles = 40;
	List<Player> playerArray = new ArrayList<Player>();
	List<Tile> tileArray = new ArrayList<Tile>();
	public List<Card> communityChestCards = new ArrayList<Card>();
	public List<Card> chanceCards = new ArrayList<Card>();
	Die die = new Die();
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
	private RandomAccessFile file;
	public void CreateBoardGame() {
		loadTiles();
		loadCards();
	}
	public void movePlayer(Player playerObject) {
		int firstRoll = die.roll();
		int secondRoll = die.roll();
		int moveAmount = firstRoll + secondRoll;
		if(firstRoll == secondRoll) {
			if(playerObject.snakeEyeAmount == 3) {
				sendToJail(playerObject);
			}
			else {
				playerObject.snakeEyeAmount++;
				playerObject.movePiece(moveAmount);
				checkTileOwner(playerObject, tileArray.get(playerObject.getLocation()));
			}
		}
	}
	public void sendToJail(Player playerObject) {
		playerObject.setLocation(10);
		playerObject.inJail = true;
	}
	public void taxPlayer(Player playerObject) {
		//The below code should be set to a specific number depending on what tax type the player selects
		int trialOption = (Integer)null;
		if(playerObject.getLocation() == 4 && tileArray.get(4).tileName.equals("Income Tax")) {
			if(trialOption == 0) {
				int percentage = (int)Math.round(playerObject.getMoney()/0.10);
				playerObject.setMoney(playerObject.getMoney(), percentage, (t,u) -> t-u);
			}
			else if(trialOption == 1) {
				playerObject.setMoney(playerObject.getMoney(), 200, (t,u) -> t-u);
			}
		}
		if(playerObject.getLocation() == 38 && tileArray.get(38).tileName.equals("Luxury Tax")) {
			playerObject.setMoney(playerObject.getMoney(), 75, (t,u) -> t-u);
		}
	}
	public void buyProperty(Player playerObject, Tile tileToBuy) {
		if(playerObject.getLocation() == tileArray.indexOf(tileToBuy)) {
			if(tileToBuy.tileOwner.equals("Board") && playerObject.getMoney() >= tileToBuy.tilePrice) {
				playerObject.setMoney(playerObject.getMoney(), tileToBuy.tilePrice, (t,u) -> t-u);
			}
			else {
				System.out.println("You cannot buy this tile, it is owned by " + tileToBuy.tileOwner);
			}
		}
	}
	public void buyImprovement(Player playerObject, Tile tileForHouse) {
		if(playerObject.getLocation() == tileArray.indexOf(tileForHouse)) {
			if(tileForHouse.houseCount == 0 && playerObject.getMoney() >= tileForHouse.houseCost && tileForHouse.tileOwner.equals(playerObject.getName())) {
				playerObject.setMoney(playerObject.getMoney(), tileForHouse.houseCost, (t,u) -> t-u);
				tileForHouse.houseCount = 1;
			}
			else if(tileForHouse.houseCount == 1 && playerObject.getMoney() >= tileForHouse.houseCost && tileForHouse.tileOwner.equals(playerObject.getName())) {
				playerObject.setMoney(playerObject.getMoney(), tileForHouse.houseCost, (t,u) -> t-u);
				tileForHouse.houseCount = 2;
			}
			else if(tileForHouse.houseCount == 2 && playerObject.getMoney() >= tileForHouse.houseCost && tileForHouse.tileOwner.equals(playerObject.getName())) {
				playerObject.setMoney(playerObject.getMoney(), tileForHouse.houseCost, (t,u) -> t-u);
				tileForHouse.houseCount = 3;
			}
			else if(tileForHouse.houseCount == 3 && playerObject.getMoney() >= tileForHouse.houseCost && tileForHouse.tileOwner.equals(playerObject.getName())) {
				playerObject.setMoney(playerObject.getMoney(), tileForHouse.houseCost, (t,u) -> t-u);
				tileForHouse.houseCount = 4;
			}
			else if(tileForHouse.houseCount == 4 && playerObject.getMoney() >= tileForHouse.hotelCost && tileForHouse.tileOwner.equals(playerObject.getName())) {
				playerObject.setMoney(playerObject.getMoney(), tileForHouse.hotelCost, (t,u) -> t-u);
				tileForHouse.hotelCount = 1;
				tileForHouse.houseCount = 0;
			}
		}
	}
	public void payRent(Player playerObject, Tile tileToPayRent) {
		if(!tileToPayRent.tileOwner.equals("Board") && !tileToPayRent.tileOwner.equals(playerObject.getName())) {
			if(tileToPayRent.houseCount == 0) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRentBase, (t,u) -> t-u);
			}
			if(tileToPayRent.houseCount == 1) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRent1House, (t,u) -> t-u);
			}
			if(tileToPayRent.houseCount == 2) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRent2House, (t,u) -> t-u);
			}
			if(tileToPayRent.houseCount == 3) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRent3House, (t,u) -> t-u);
			}
			if(tileToPayRent.houseCount == 4) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRent4House, (t,u) -> t-u);
			}
			if(tileToPayRent.hotelCount == 1) {
				playerObject.setMoney(playerObject.getMoney(), tileToPayRent.tileRentHotel, (t,u) -> t-u);
			}
		}
			
	}
	public void checkTileOwner(Player playerObject, Tile steppedOnTile) {
		if(playerObject.getLocation() == tileArray.indexOf(steppedOnTile)) {
			payRent(playerObject, steppedOnTile);
		}
	}
	public void loadTiles() {
		String tilefilePath = "src/Tiles.txt";
		String regexArgs = "TileName=([.&/a-zA-Z\\s?]+)\\nTileColor=([a-zA-Z0-9\\s?]+)\\nTilePrice=([0-9\\s?]+)\\nTileRentBase=([0-9\\s?]+)\\nTileRent1House=([0-9\\s?]+)\\nTileRent2House=([0-9\\s?]+)\\nTileRent3House=([0-9\\s?]+)\\nTileRent4House=([0-9\\s?]+)\\nTileRentHotel=([0-9\\s?]+)\\nMortgageValue=([0-9\\s?]+)\\nHouseCost=([0-9\\s?]+)\\nHotelCost=([0-9\\s?]+)";
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
		int i=0;
		for(Tile tile : tileArray) {
			System.out.println(tile.tileName);
			System.out.println(i++);
		}
	}
	public void loadCards() {
		String cardFilePath = "src/Cards.txt";
		List<String> cardLines;
		try {
			cardLines = Files.readAllLines(Paths.get(cardFilePath));
			String cardText = cardLines
					.stream()
					.map(s -> s.toString())
					.reduce((t,u) -> t + "\n" + u).get();
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
				System.out.println(lines);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void savePlayerNames() throws IOException {
		for(Player player : playerArray) {
			int index = generateIndex(player);
			file.seek(index);
			file.write(player.serialize().getBytes());
		}
	}
	public Player loadPlayerNames(Player player) throws IOException {
		int index = this.generateIndex(player);
		file.seek(index);
		byte[] buffer = new byte[255];
		file.read(buffer);
		String playerString = new String(buffer);
		Player p = new Player(null, index, this);
		p.deserialize(playerString);
		System.out.println("Load: " + index);
		return p;
	}
	public int generateIndex(Player player) {
		int index = Math.abs(player.hashCode());
		return index;
	}
	
	
}
