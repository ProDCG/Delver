/*
 * COMBAT
 * Helper Class
 * 
 * Used by rooms to resolve combat
 */

public class Combat {
	
	// FIELDS
	GameChar[] party;
	GameChar[] mons;
	
	// CONSTRUCTOR (incomplete)
	public Combat(GameChar[] party, GameChar[] mons) {
		this.party = party;
		this.mons = mons;
		
		// each round of combat, the arrays are shuffled
		// players and monsters then get to attack in alternating order
	}
}
