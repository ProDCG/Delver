/*
 * MAIN
 * Client Class
 * 
 * Program Starts Here. This class only responsible for welcome message,
 * creating Game object, and ending message.
 * Created by Paul Mulvaney & Mason Stuart
 */

import java.security.Timestamp;
import java.util.concurrent.TimeUnit;

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
		sleep(2000);
		System.out.println("The evil wizard Esmarelda rules these realms with cruelty");
		sleep(2000);
		System.out.println("The people wait for a champion to rise up and defeat her");
		sleep(2000);
		System.out.println("You are an adventurer. You must recruit others to your party");
		sleep(2000);
		System.out.println("Together, you will fight monsters, discover magic items, and overthrow Esmarelda");
		sleep(2000);
		dots();
	}
	
	// ending message not yet implemented
	public static void ending() {
		System.out.println("\n".repeat(50));
		System.out.println("Congratulations adventurer!");
		System.out.println("You have successfully defeated the evil wizard Esmarelda");
		System.out.println("The people rejoice in your name!");
		System.out.println("You are an inspirer. A warrior. A great adventurer");
		System.out.println("The monsters crumble at your name, as the realms fall back into peace");
		dots();
	}

	private static void sleep(int time) {
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void dots() {
		System.out.print(".");
		sleep(1000);
		System.out.print(".");
		sleep(1000);
		System.out.print(".");
		sleep(1000);
		System.out.print(".");
		sleep(1000);
		System.out.print(".");
		sleep(5000);
	}
}
