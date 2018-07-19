package models;

// List of inventory items that can be acquired
public enum GItem {
	
	// Used to light the shrine
	LANTERN,
	
	// If supplies are looted, we can't loot again
	SUPPLIES_LOOTED,
	
	// Used to open the shrine
	ALIEN_KEY,
	
	// Used to activate the shrine
	ALIEN_DOLL,
	
	// Gotten if you try to kick the door twice in a row
	BROKEN_FOOT,
	
	// Gotten if you stare at the fish too long
	FISH_HATRED,
	
	// Gotten from killing the fish
	FISH_DEAD,
	
	// Gotten if you agree with the crooked man
	COIN,
	
	// Gotten by asking for a tune from the skeleton
	PROMISE,
	
	// Gotten by paying back the skeleton
	PROMISE_KEPT,
	
	// Gotten from the skeleton
	BONE,
	
	// Gotten from escaping the crooked man
	SOCIAL_AWKWARDNESS,
	
	// Gotten if Cyclops is dead
	CYCLOPS_DEAD

}
