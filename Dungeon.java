/*
 * DUNGEON
 * Helper Class
 * 
 * Maintains jagged array of rooms representing different challenges
 */
public class Dungeon {
	
	// FIELDS
	// rooms array is jagged
	Room[][] rooms; 
	int difficulty;
	String name;
	
	// CONSTRUCTOR
	// generate new random dungeon
	public Dungeon(int difficulty, String name) {
		this.difficulty = difficulty;
		this.name = name;
		
		// generate number of levels
		// jagged array to allow for lower levels to have more rooms
		int numLevels = Dice.rollDice(1, 4) + difficulty;
		rooms = new Room[numLevels][];
		
		int numRooms = Dice.rollDice(1,  2);
		// generate number of rooms in each level
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = new Room[numRooms];
			
			// fill level with rooms
			for (int j = 0; j < rooms[i].length; j++) {
				rooms[i][j] = new Room(difficulty);
			}
			
			// next level adds 0, 1, or 2 more rooms
			numRooms += Dice.rollDice(1, 3) - 1;
		}
		
		// decide a random room in each level to have the stairs down
		// Stairs location not yet a requirement for advancing to lower levels
		for (Room[] r : rooms) {
			int stairsIndex = Dice.rollDice(1, r.length) - 1;
			r[stairsIndex].hasStairs = true;
		}
	}
	
	// prints the dungeon so it is easy for player to tell where they are and what dungeon looks like
	public void printDungeon() {
		System.out.println(name);
		for (Room[] level : rooms) {
			for (Room r : level) {
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
