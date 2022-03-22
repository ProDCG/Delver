/*
 * COMBATANT
 * Interface
 * 
 * Any class that could be involved in combat should implement this interface
 */

public interface Combatant {
	// this character attacks another
	public void attack(GameChar opp);

}
