package models;

// Represents a choice on a given node/"screen"
public class GChoice {

	// Label for the button
	public String actionText;
	
	// Node to swap to on button press
	public int actionNode;
	
	// Alternative outcome node used in RNG choices
	public int altActionNode;
	
	// Probability element used in RNG choices
	public double rngFactor;
	
	// Item required for choice. Only used in Item-requiring choices
	public GItem[] dependentItems;
	
	// True: Item PREVENTS choice from showing / False: Item REQUIRED for choice to show
	public boolean isBarring;
	
	// The type of choice and how it is handled in-game
	public ChoiceType type;
	
	// Hack for final version
	public boolean barAlienDoll;
	
	// Helper static constants for readability
	public static final boolean BARRING = true;
	public static final boolean REQUIRED = false;
	
	// Special Constructor (One of a kind)
	public GChoice() {
		this.actionText = "Place the doll on the altar";
		this.actionNode = 77;
		this.type = ChoiceType.SPECIAL;
		this.dependentItems = new GItem[] {GItem.ALIEN_DOLL};
		this.isBarring = false;
	}
	
	// Restart Constructor
	public GChoice(String text) {
		this.actionText = text;
		this.actionNode = 0;
		this.type = ChoiceType.RESTART;
	}
	
	// Other Constructor (Eg. Monster Choice)
	public GChoice(String text, int actionNode, ChoiceType type) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = type;
	}
	
	// Generic Constructor
	public GChoice(String text, int actionNode) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.GENERIC;
	}
	
	// RNG-choice Constructor
	public GChoice(String text, int actionNode, int altActionNode, double rngFactor) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.RNG;
		this.altActionNode = altActionNode;
		this.rngFactor = rngFactor;
	}
	
	// Item-required Constructor (Assumes requirement of item)
	public GChoice(String text, int actionNode, GItem dependentItem) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.ITEM_DEPENDENT;
		this.dependentItems = new GItem[] {dependentItem};
		this.isBarring = false;
	}
	
	// Item-dependent Constructor (More flexible)
	public GChoice(String text, int actionNode, GItem dependentItem, boolean isBarring) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.ITEM_DEPENDENT;
		this.dependentItems = new GItem[] {dependentItem};
		this.isBarring = isBarring;
		this.barAlienDoll = false;
	}
	
	// Item-dependent Constructor (More flexible)
	public GChoice(String text, int actionNode, GItem dependentItem, boolean isBarring, boolean barAlienDoll) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.ITEM_DEPENDENT;
		this.dependentItems = new GItem[] {dependentItem};
		this.isBarring = isBarring;
		this.barAlienDoll = barAlienDoll;
	}
	
	// Item[s]-dependent Constructor (More flexible)
	public GChoice(String text, int actionNode, GItem[] dependentItems, boolean isBarring) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.ITEM_DEPENDENT;
		this.dependentItems = dependentItems;
		this.isBarring = isBarring;
	}
	
	// Item + RNG Constructor (defaults to item requirement)
	public GChoice(String text, int actionNode, int altActionNode,
			double rngFactor, GItem dependentItem) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.RNG_AND_ITEM;
		this.altActionNode = altActionNode;
		this.rngFactor = rngFactor;
		this.dependentItems = new GItem[] {dependentItem};
		this.isBarring = false;
	}
	
	// Item + RNG Constructor (More flexible)
	public GChoice(String text, int actionNode, int altActionNode,
			double rngFactor, GItem dependentItem, boolean isBarring) {
		this.actionText = text;
		this.actionNode = actionNode;
		this.type = ChoiceType.RNG_AND_ITEM;
		this.altActionNode = altActionNode;
		this.rngFactor = rngFactor;
		this.dependentItems = new GItem[] {dependentItem};
		this.isBarring = isBarring;
	}
	
	
}
