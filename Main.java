/*
 * MAIN
 * Client Class
 * 
 * Program Starts Here. This class only responsible for welcome message,
 * creating Game object, and ending message.
 * Created by Paul Mulvaney
 */
public class Main {

	// main method
	public static void main(String[] args) {
		welcome();
		Game newGame = new Game();
	}
	
	// welcome message to be printed in main method
	public static void welcome() {
		System.out.println("\n".repeat(50));
		System.out.println("Welcome adventurer!");
		System.out.println("The evil wizard Esmarelda rules these realms with cruelty");
		System.out.println("The people wait for a champion to rise up and defeat her");
		System.out.println("You are an adventurer. You must recruit others to your party");
		System.out.println("Together, you will fight monsters, discover magic items, and overthrow Esmarelda");
		System.out.println("...\n\n");
	}
	
	// ending message not yet implemented
}
