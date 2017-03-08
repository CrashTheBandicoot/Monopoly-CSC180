package Monopoly.CSC180;

import java.util.Random;

public class cardCheck {
	Random rand = new Random();
	public void checkMove(int location, Player player, Board board) {
		switch(location) {
			case 2: 
			case 32:	
				int communityRand = rand.nextInt(17);
				Card randomCommunityChestCard = board.communityChestCards.get(communityRand);
				switch(randomCommunityChestCard.name) {
					case "Advance to Go": 
						player.setLocation(0);
						player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
						break;
					case "Bank error in your favor":
						player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
						break;
					case "Doctor's fees":
						player.setMoney(player.getMoney(), 50, (t,u) -> t-u);
						break;
					case "From sale of stock you get $50":
						player.setMoney(player.getMoney(), 50, (t,u) -> t+u);
						break;
					case "Get Out of Jail Free":
						player.inJail = false;
						break;
					case "Go to Jail":
						player.setLocation(10);
						break;
					case "Grand Opera Night":
						player.setMoney(player.getMoney(), board.playerArray.size()*50, (t,u) -> t+u);
						break;
					case "Holiday {Xmas} Fund matures":
						player.setMoney(player.getMoney(), 100, (t,u) -> t+u);
						break;
					case "Income tax refund":
						player.setMoney(player.getMoney(), 20, (t,u) -> t+u);
						break;
					case "It is your birthday":
						player.setMoney(player.getMoney(), board.playerArray.size()*10, (t,u) -> t+u);
						break;
					case "Life insurance matures":
						player.setMoney(player.getMoney(), 100, (t,u) -> t+u);
						break;
					case "Pay hospital fees of $100":
						player.setMoney(player.getMoney(), 100, (t,u) -> t-u);
						break;
					case "Pay school fees {tax} of $150":
						player.setMoney(player.getMoney(), 150, (t,u) -> t-u);
						break;
					case "Receive $25 consultancy fee":
						player.setMoney(player.getMoney(), 25, (t,u) -> t+u);
						break;
					case "You are assessed for street repairs":
						player.setMoney(player.getMoney(), player.ownedHouses*40, (t,u) -> t-u);
						player.setMoney(player.getMoney(), player.ownedHotels*115, (t,u) -> t-u);
						break;
					case "You have won second prize in a beauty contest":
						player.setMoney(player.getMoney(), 10, (t,u) -> t+u);
						break;
					case "You inherit $100":
						player.setMoney(player.getMoney(), 100, (t,u) -> t+u);
						break;
				}
			case 7:
			case 22:
				int chanceRand = rand.nextInt(16);
				Card randomChanceCard = board.chanceCards.get(chanceRand);
				switch(randomChanceCard.name) {
					case "Advance to Go":
						player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
						break;
					case "Advance to Illinois Ave.":
						player.setLocation(24);
						break;
					case "Advance to St. Charles Place":
						if(location > 11) {
							player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
							player.setLocation(11);
						}
						else {
							player.setLocation(11);
						}
						break;
					case "Advance token to nearest Utility":
						if(location > 12) {
							player.setLocation(28);
						}
						else if(location > 28) {
							player.setLocation(12);
							player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
						}
						break;
					case "Advance token to the nearest Railroad":
						if(location > 5) {
							player.setLocation(15);
						}
						else if(location > 15) {
							player.setLocation(25);
						}
						else if(location > 25) {
							player.setLocation(5);
							player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
						}
						break;
					case "Bank pays you dividend of $50":
						player.setMoney(player.getMoney(), 50, (t,u) -> t+u);
						break;
					case "Get out of Jail Free":
						player.inJail = false;
						break;
					case "Go Back 3 Spaces":
						player.setLocation(location-3);
						break;
					case "Go to Jail":
						player.setLocation(10);
						player.inJail = true;
						break;
					case "Make general repairs on all your property":
						player.setMoney(player.getMoney(), player.ownedHouses*25, (t,u) -> t-u);
						player.setMoney(player.getMoney(), player.ownedHotels*100, (t,u) -> t-u);
						break;
					case "Pay poor tax of $15":
						player.setMoney(player.getMoney(), 15, (t,u) -> t-u);
						break;
					case "Take a trip to the Reading Railroad":
						if(location > 5) {
							player.setMoney(player.getMoney(), 200, (t,u) -> t+u);
							player.setLocation(5);
						}
						break;
					case "Take a walk on the Boardwalk":
						if(location < 39) {
							player.setLocation(39);
						}
						break;
					case "You have been elected Chairman of the Board":
						player.setMoney(player.getMoney(), board.playerArray.size()*50, (t,u) -> t-u);
						break;
					case "Your building {and} loan matures":
						player.setMoney(player.getMoney(), 150, (t,u) -> t+u);
						break;
					case "You have won a crossword competition":
						player.setMoney(player.getMoney(), 100, (t,u) -> t+u);
						break;
				}
		}
	}
}
