/*
 * MONSTER
 * Helper Class
 */

public class Monster extends GameChar implements Combatant {
	
	// FIELDS
	// level and name inherited from Game Char
	
	// CONSTRUCTOR
	public Monster(int level) {
		this.level = level; // monster level equal to room difficulty
		String lev1 = "Rat Goblin Skeleton Zombie";
		String lev2 = "Orc Wolf";
		String lev3 = "Bear Ogre";
		if (level == 1) {
			name = Dice.getRandToken(lev1);
		} else if (level == 2) {
			name = Dice.getRandToken(lev2);
		} else if (level == 3) {
			name = Dice.getRandToken(lev3);
		}
		maxHP = Dice.rollDice(level, 8);
		hp = maxHP;
	}
	
	// attack a player's character
	public void attack(GameChar playerChar) {
		// not yet implemented
	}

}
