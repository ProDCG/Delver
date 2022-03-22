/*
 * GAME
 * Helper Class
 *
 * Manages Components of the Game
 * 
 * PSEUDOCODE
 * 
 * GAME START
 * 1. Greet User, Explain Game
 * 2. Select Main Character
 * 3. Recruit Party Members
 * 
 * DELVING
 * 1. Enter dungeons, overcome challenges
 * 2. Earn gold and items
 * 3. Return to town to rest, buy, and sell
 * 4. Return to dungeons
 * 
 * GAME END
 * When ready, enter final dungeon to defeat evil wizard
 */

// IMPORT STATEMENTS
// Scanner used to receive innput from user
import java.util.Scanner;

public class Game {

	// FIELDS
	MainChar player; // controlled by user
	MainChar[] party; // other characters in adventuring party
	Dungeon[] dungs; // dungeons available to explore
	Scanner user; // getting user input

	// CONSTRUCTOR
	public Game() {
		generateDungs();
		charSelect();
		adventure();
	}

	/*
	 * METHODS
	 */
	
	// Generates dungeons for player to visit
	// Players can only see dungeons they are high enough level to explore
	public void generateDungs() {
		dungs = new Dungeon[5];
		dungs[0] = new Dungeon(1, "The Dark Forest");
		dungs[1] = new Dungeon(2, "The Old Crypt");
		
		// COTID has variable difficulty from 2 - 4
		dungs[2] = new Dungeon(1 + Dice.rollDice(1, 3), "Cave of the Ice Dragon");
		// Later dungeons not yet implemented
		// fifth level should be Esmarelda
	}

	// User selects which character to play
	public void charSelect() {

		System.out.println("***STARTING CHARACTER***");

		// Now that we need user input, init Scanner
		user = new Scanner(System.in);

		System.out.println("Which character would you like to play as? Enter 1, 2, or 3\n");

		// generate three random characters
		MainChar[] starterChars = { Dice.getRandChar(), Dice.getRandChar(), Dice.getRandChar() };
		for (int i = 0; i < 3; i++) {
			System.out.println("Option " + (i + 1));
			System.out.println(starterChars[i] + "\n");
		}

		// player selects character
		int userSelect = user.nextInt();
		player = starterChars[userSelect - 1];
		System.out.println("\nYOU CHOSE: ");
		System.out.println(player);
		System.out.println("\n");

		// name character (add feature later)

		// Move to next phase of game
		recruit();
	}

	// add more characters to the party
	public void recruit() {
		System.out.println("***RECRUITING***");
		
		// The wiser a character, the bigger the party they can have
		int partySize = player.wis / 8 + 3;
		System.out.println("Your leader can support a party of " + partySize);
		party = new MainChar[partySize];
		
		// Explanation of rectruiting
		System.out.println("You can recruit new adventurers to your party");
		System.out.println("Hire adventurers by spending gold\n");
		System.out.println("Which of the following do you want to hire?");
		System.out.println("Type 0 when done hiring");

		// generate recruits
		MainChar[] recruitChars = { Dice.getRandChar(), Dice.getRandChar(), Dice.getRandChar(), Dice.getRandChar(),
				Dice.getRandChar() };

		// GOLD
		// The main character's gold field can be spent by user
		// The recruitable characters gold is the salary they cost
		
		// reduce price tag of players so a larger party is more affordable
		for (MainChar mc : recruitChars) {
			mc.gold /= 4;
			mc.gold += Dice.rollDice(1, 8);
		}

		// playerSelect is index of recruited character
		int playerSelect = -1;
		
		// The zero index is where the main character is stored
		party[0] = player; // player is first party member
		
		// Next character will go in next index
		int nextIndex = 1;
	
		// recruit adventurers until done
		do {
			// print recruits
			System.out.println("\n\nAVAILABLE RECRUITS");
			System.out.println("your remaining gold: " + player.gold + "\n");
			printParty(recruitChars);

			// get player choice
			playerSelect = user.nextInt();
			
			// 0 exits recruitment
			if (playerSelect == 0)
				break;

			// Check if player can afford recruit
			if (player.gold < recruitChars[playerSelect - 1].gold) {
				// Player can not afford
				System.out.println("You don't have enouigh gold. Make another selection or choose 0");
			} else {
				// Add recruit to party
				party[nextIndex] = recruitChars[playerSelect - 1];
				System.out.println("You hired: " + party[nextIndex].name);
				player.gold -= party[nextIndex].gold; // spend gold
				party[nextIndex].gold = 0; // new recruits have no gold
				recruitChars[playerSelect - 1] = null; // remove from recruit array
				nextIndex++; // next recruit goes in next index

				// print parry
				System.out.println("\n\nCURRENT PARTY\n");
				printParty(party);
			}

			// check if done recruiting or party is full
		} while (nextIndex < party.length);

		System.out.println("You are done recruiting!\n\n");
	}

	// Give players choices of going to town or delving
	public void adventure() {
		System.out.println("***ADVENTURING***");
		System.out.println("Time to go adventuring!");
		System.out.println("Your player's level determines which dungeons you can try");
		System.out.println("Each dungeon has a number of levels, and rooms per level");
		System.out.println("Each room could feature treasure or danger");
		System.out.println("You must find the room that leads to the next level in order to descend\n");
		System.out.println("Here are the current dungeons you could try\n");

		// display  dungeons
		for (int i = 0; i < dungs.length; i++) {
			
			// While some dungeons not built yet, 
			// don't reference null, indexes of array
			if (dungs[i] != null) {
				
				// players can only see dungeons they are high enough level for
				if (dungs[i].difficulty <= player.level) {
					System.out.println("Option " + (i + 1) + "\n");
					dungs[i].printDungeon();
				}

			}

		}

		// dungeon selection
		System.out.println();
		int dungSel = user.nextInt();
		user.nextLine(); // gets rid of extra space
		System.out.println();
		Dungeon curDung = dungs[dungSel - 1];
		
		// Start next phase of game: delving
		dungeonDelve(curDung);
	}

	// player adventures into dungeon
	public void dungeonDelve(Dungeon dung) {
		System.out.println("You have entered " + dung.name);
		System.out.println("After completing a room, you can type next to the next room,");
		System.out.println("down to go down to the next level (if you have found the stairs), or leave to leave the dungeon\n");
		int floor = 0; // current floor, higher number represents lower dungeon level
		int rm = 0; // current room
		boolean foundStairs = false; // to be implemented later

		// Assumed player wants to enter first room
		String cmd = "Next";
		
		// As long as user doesn't want to leave, keep adventuring
		while (!cmd.equalsIgnoreCase("Leave")) {
			
			// Encounter next room, announce its details
			System.out.printf("\nLevel %d, Room %d\n", floor + 1, rm + 1);
			Room curRoom = dung.rooms[floor][rm];
			curRoom.genRoomType();
			
			// Enter room will be important method later in implementation
			// Will trigger combats, puzzles, traps, and other dungeon events
			// Currently doesn't do much
			curRoom.enterRoom();
			
			// Once room is resolved, check if at end of a floor of dungeon
			if (rm + 1 == dung.rooms[floor].length) {
				// if our current index plus one is equal to the length of this floor
				// we are at end of level and should not proceed so as to not IOOB
				System.out.println("You have reached the end of this level: Down or Leave?");
			} else {
				// If not at end of row, present three choices
				System.out.println("Next, Down, or Leave?\n");
			}
			
			// Get user command after showing them dungeon
			dung.printDungeon();
			cmd = user.nextLine();
			
			// Handle next, down, or leave
			if (cmd.equalsIgnoreCase("Next")) {
				// This will cause IOOB if at end of row
				rm++;
			} else if (cmd.equalsIgnoreCase("Down")) {
				// check if at end of level
				// game does not currently check if stairs found
				floor++;
				rm = 0;
			}
		}
	}

	// prints party or other array of MainChars
	public void printParty(MainChar[] chars) {
		for (int i = 0; i < chars.length; i++) {
			System.out.println("Option " + (i + 1));
			if (chars[i] == null) {
				System.out.println("NONE\n");
			} else {
				System.out.println(chars[i] + "\n");
			}
		}
	}

}
