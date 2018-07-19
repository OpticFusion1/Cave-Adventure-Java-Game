package models;

// Types of choices in the game. The default choice is generic.
public enum ChoiceType {
	
	// Nothing special about the choice
	GENERIC,
	
	// A particular item is required to see the choice
	ITEM_DEPENDENT,
	
	// There is a random chance element to the branch
	RNG,
	
	// Random chance element that requires an item to see the choice
	RNG_AND_ITEM,
	
	// A restart choice, usually only available when you die
	RESTART,
	
	// One-of-a-kind special choice to start chaos
	SPECIAL,
	
	// Path of Monster
	MONSTER_PATH,
	
	// Safe from Monster
	MONSTER_SAFE

}
