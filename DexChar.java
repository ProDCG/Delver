/*
 * DEXTERITY CHARACTER
 * Helper Class
 * 
 * Represents fast, sneaky, cunning characters
 */

public class DexChar extends MainChar {

	// CONSTRUCTOR
	public DexChar() {
		super();
		
		// generate name and gold
		name = Dice.nameGenerator(Dice.rollDice(1, 2) + 1, 0.5);
		gold = Dice.rollDice(8, 12);
		
		// boost stats and select class
		dex += 6;
		con += 4;
		charType = Dice.getRandToken("Rogue Ranger");
		
		// class specific benefits
		if (charType.equals("Rogue")) {
			armorRank = 1;
			weapRank = 2;
			dex += 3;
		} else if (charType.equals("Ranger")) {
			armorRank = 2;
			weapRank = 2;
			con += 2;
		}
	}
}
