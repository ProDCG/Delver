/*
 * ROOM
 * Helper Class
 * 
 * Represents one location in a dungeon
 * Can contain different challenges or evens
 */

public class Room {
	
	// FIELDS
	boolean isRevealed; // not yet implemented
	boolean hasStairs; // not yet implemented
	char display; // What character shows in printed dungeon
	String entranceMessage;
	int size; // larger rooms can scale a rooms effect
	Monster[] mons; // not used in all rooms
	String roomType; // Monster, Trap, Reward, Puzzle
	int difficulty;

	// CONSTRUCTOR
	public Room(int difficulty) {

		// set difficulty and room as hidden
		this.difficulty = difficulty;
		this.isRevealed = false;

		// generate random size
		size = Dice.rollDice(1, 3);

		// Room contents start a mystery
		display = '?';
	}
	
	//toString
	public String toString() {
		String out = "[";
		for (int i = 0; i < size; i++) {
			out += display;
		}
		return out + "]";
	}
	
	// print entrance message
	// Must be called AFTER room type generated
	// Returns gold earned
	public int enterRoom() {
		System.out.println(entranceMessage);
		
		// Determine room type
		if (display == 'M') {
			// generate monsters
			// INCOMPLETE: Needs work
			mons = new Monster[Dice.rollDice(1, size * 2)];
			for (int i = 0; i < mons.length; i++) {
				mons[i] = new Monster(difficulty);
			}
		} else if (display == 'T') {
			System.out.println("The traps part of this game hasn't been built yet, so don't worry about it");
		} if (display == 'P') {
			System.out.println("You solve a puzzle and get 100 gold!");
			return  100;
		} if (display == 'R') {
			int gold = Dice.rollDice(4 * size, 6);
			System.out.println("You find some treasure and get " + gold + " gold!");
			return gold;
		}
		return 0;
	}

	// Once a room is revealed, generate its room type
	public void genRoomType() {
		// Room types: Trap, Puzzle, Monster, Reward
		double randRoom = Math.random();
		
		// Monsters most common room type
		if (randRoom < 0.5) {
			// Monster
			// Generate random number of monsters
			roomType = "Monster";
			entranceMessage = "This room contains monsters!";
			display = 'M';
			mons = new Monster[Dice.rollDice(1, difficulty * 2)];

			// fill monster array with random monsters
			for (int i = 0; i < mons.length; i++) {
				mons[i] = new Monster(difficulty);
			}
		} else if (randRoom < 0.7) {
			// Trap
			display = 'T';
			entranceMessage = "This room is trapped!";
		} else if (randRoom < 0.9) {
			// Reward
			display = 'R';
			entranceMessage = "This room contains treasure";
		} else {
			// Puzzle
			display = 'P';
			entranceMessage = "This room contains a puzzle!";
		}
	}

}
