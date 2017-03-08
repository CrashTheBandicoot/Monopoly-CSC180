package Monopoly.CSC180;

import java.util.Random;

public class Die {
	public int Die() {
		Random rand = new Random();
		int roll = rand.nextInt(5);
		return roll;
	}
	
}
