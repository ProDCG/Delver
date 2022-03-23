/*
 * STRENGTH CHARACTER
 * Helper Class
 * 
 * Represents strong, tough, armed and armored characters
 */

public class StrChar extends MainChar {
	
	// CONSTRUCTOR
	public StrChar() {
		super();
		
		// generate name and gold
		// name = Dice.nameGenerator(Dice.rollDice(1, 2), 0.8);
		gold = Dice.rollDice(5, 12);
		
		// boost stats and select class
		str += 6;
		con += 3;
		charType = Dice.getRandToken("Fighter Barbarian");
		
		// class specific benefits
		if (charType.equals("Fighter")) {
			armorRank = 3;
			weapRank = 3;
		} else if (charType.equals("Barbarian")) {
			armorRank = 1;
			weapRank = 3;
			str += 1;
			con += 2;
		}
	}

}
