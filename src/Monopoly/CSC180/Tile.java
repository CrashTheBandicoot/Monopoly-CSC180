package Monopoly.CSC180;

public class Tile {
	String tileName;
	String tileColor;
	String tileOwner;
	int tilePrice;
	int tileRentBase;
	int tileRent1House;
	int tileRent2House;
	int tileRent3House;
	int tileRent4House;
	int tileRentHotel;
	int mortgageCost;
	int houseCost;
	int houseCount;
	int hotelCost;
	int hotelCount;
	public Tile(String name, String color, String owner, int price, int costToRent, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int Mortgage, int housePrice, int houses, int hotelPrice, int hotels) {
		this.tileName = name;
		this.tileColor = color;
		this.tileOwner = owner;
		this.tilePrice = price;
		this.tileRentBase = costToRent;
		this.tileRent1House = rent1House;
		this.tileRent2House = rent2House;
		this.tileRent3House = rent3House;
		this.tileRent4House = rent4House;
		this.tileRentHotel = rentHotel;
		this.mortgageCost = Mortgage;
		this.houseCost = housePrice;
		this.houseCount = houses;
		this.hotelCost = hotelPrice;
		this.hotelCount = hotels;
	}
}