/*
 * SPELLCASTING CHARACTER
 * Helper Class
 * 
 * Represents rarer, powerful spellcasting characters
 */

public class SpellChar extends MainChar implements SpellCaster {
	
	// CONSTRUCTOR
	public SpellChar() {
		super();
		
		// generate name and gold
		name = Dice.nameGenerator(Dice.rollDice(1, 3) + 1, 0.3);
		gold = Dice.rollDice(10, 12);
		
		// boost stats and select class
		wis += 7;
		charType = Dice.getRandToken("Wizard Cleric Druid");
		
		// class specific benefits
		if (charType.equals("Wizard")) {
			wis += 5;
		} else if (charType.equals("Cleric")) {
			armorRank = 3;
			weapRank = 1;
			wis += 2;
			con += 1;
			str += 1;
		} else if (charType.equals("Druid")) {
			armorRank = 1;
			weapRank = 1;
			wis += 3;
			con += 2;
		}
	}
	
	// Cast a spell, used in combat
	// Not yet implemented
	public int castSpell() {
		return -1; // stub placeholder
	}
}
