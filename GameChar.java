/*
 * GAME CHARACTER
 * Helper Class
 * 
 * Represents top of inheritance hierarchy
 * Class is abstract because we will never create a GameChar object,
 * only subclass objects
 * 
 * Notable Subclasses: MainChar and Monster
 */

abstract public class GameChar {
	String name;
	String loc; // location
	String charType; // "class name" from Dnd
	int level;  // determines dungeon access in MainChar
	int gold; // spending money in MainChar, reward in Monster
	int maxHP; // maximum hitpoints
	int hp; // current hitpoints
}
