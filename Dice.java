/*
 * DICE
 * Helper Class
 * 
 * Contains static methods
 * Used to randomly generate numbers and characters
 */

// Import Statements
import java.util.Random;

public class Dice {

	// simulated rolling numDsides dice
	public static int rollDice(int num, int sides) {
		Random rand = new Random();
		int sum = 0;
		//System.out.printf("Rolling %dd%d:", num, sides);
		for (int i = 0; i < num; i++) {
			int roll = rand.nextInt(sides) + 1;
			//System.out.print(" " + roll);
			sum += roll;
		}
		//System.out.println(" = " + sum);
		return sum;
	}

	// Allows random slection of a token from a space delimited String
	public static String getRandToken(String tokens) {
		String[] arrTokens = tokens.split(" ");
		Random rand = new Random();
		int randIndex = rand.nextInt(arrTokens.length);
		return arrTokens[randIndex];
	}
	
	// Creates names using random letters
	// I should probably make sure it is impossible to accidentily generate something vulgar
	public static String nameGenerator(int length, double hard) {
		// length of name
		// hard is how hard syllable should be
		// 1.0 is all hard, 0.0 is all soft, 0.5 is even split

		String out = "";

		// runs once per syllable
		for (int i = 0; i < length; i++) {

			// 80% of time, starts with con
			if (Math.random() < 0.8) {
				// Starts with consonant
				if (Math.random() < hard) {
					out += getLet('h');
				} else {
					// Soft Consonant
					out += getLet('s');
				}

				// 30% of time, softCon follows starting letter
				if (Math.random() < 0.3) {
					out += getLet('s');
				}
			}

			// Vowel
			out += getLet('v');
			
			// 90% of time, syllable ends with consonant(s)
			if (Math.random() < 0.9) {
				if (Math.random() < 0.8) {
					out += getLet('s');
				} else {
					out += getLet('h');
				}
			}

		}

		return out;
	}

	// gets random letter, vowel, hard, soft
	public static String getLet(char type) {
		String vowels = "A E I O U";
		String softCon = "R L N M S";
		String hardCon = "G T W P D G K C X Z B V";
		if (type == 'v') {
			return getRandToken(vowels);
		} else if (type == 's') {
			return getRandToken(softCon);
		} else if (type == 'h') {
			return getRandToken(hardCon);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// generates random character
	public static MainChar getRandChar() {
		int type = Dice.rollDice(1, 10);
		if (type < 6) {
			return new StrChar();
		} else if (type < 9){
			return new DexChar(); 
		} else {
			return new SpellChar();
		}
	}

}
