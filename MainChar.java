/*
 * MAIN CHARACTER
 * Helper Class
 * 
 * Represents the characters that comprise a player's adventuring party
 */


// Import Statements
import java.util.Arrays;
import java.util.Random;

// Class is abstract because only its children will be instantiated
abstract public class MainChar extends GameChar implements Combatant {

	// FIELDS
	// name, level, other fields inherited from GameChar
	int str; // strength: power
	int con; // constitution: toughness
	int dex; // dexterity: speed, agility
	int wis; // wisdom: intelligence
	int armorRank; // ability to wear armor
	int weapRank; // ability to use weapons
	int xp; // experience points
	Item[] inv; // inventory

	// CONSTRUCTORS
	public MainChar() {
		
		// these fields set in subclass constructors
		name = null;
		loc = null;
		charType = null;
		
		level = 1; // new characters start at level 1
		armorRank = weapRank = 0; // other classes will grant skills
		rollStats(); // sets str, con, dex, wis
		inv = new Item[str + 5]; // strength determines carrying capacity
		maxHP = con * 2 + 10; // constitution determines hit points
		hp = maxHP; // new characters start at max health
	}

	// METHODS

	// generates four random stats
	// checked to make sure they are balanced
	public void rollStats() {
		int[] stats = new int[4];

		// generate new stats rolling 2d6
		// more stats to be added later
		int sum = 0;
		
		// below 14 creates an underpowered char
		// above 42 creates an overpowered char
		while (sum < 14 || sum > 42) {
			for (int i = 0; i < 4; i++) {
				stats[i] = Dice.rollDice(2, 6);
				sum += stats[i];
			}
		}

		// Assign elements to fields
		this.str = stats[0];
		this.con = stats[1];
		this.dex = stats[2];
		this.wis = stats[3];
	}
	
	// toString method
	public String toString() {
		String out = name + " " + level + " : " + charType + " | ";
		out += "hp: " + hp + "/" + maxHP + " " + str + "/" + con + "/" + dex + "/" + wis + " | ";
		out += "gold: " + gold;
		return out;
	}
	
	// promised by the Combatant interface
	// attach an enemy character
	public void attack(GameChar enemyChar) {
		// not yet implemented
	}
}
