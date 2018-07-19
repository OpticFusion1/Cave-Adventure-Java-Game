package models;

// Represents a "screen" or area in the game
public class GNode {
	
	// Title text
	public String titleText;
	
	// Description text
	public String descText;
	
	// Choices available
	public GChoice[] choices;
	
	// Inventory items acquired
	public GItem[] items;
	
	// Inventory Items removed
	public GItem[] removedItems;
	
	// Path to the sound effect (default is null)
	public String soundPath = null;
	
	// Constructor for multi-item get/remove
	public GNode(String titleText, String descText, GChoice[] choices, GItem[] items, GItem[] removedItems) {
		this.titleText = titleText;
		this.descText = descText;
		this.choices = choices;
		this.items = items;
		this.removedItems = removedItems;
	}
	
	// Constructor for multi-item get
	public GNode(String titleText, String descText, GChoice[] choices, GItem[] items) {
		this.titleText = titleText;
		this.descText = descText;
		this.choices = choices;
		this.items = items;
		this.removedItems = new GItem[]{};
	}
	
	// Constructor for single-item get
	public GNode(String titleText, String descText, GChoice[] choices, GItem item) {
		this.titleText = titleText;
		this.descText = descText;
		this.choices = choices;
		this.items = new GItem[] {item};
		this.removedItems = new GItem[]{};
	}
	
	// Regular node constructor
	public GNode(String titleText, String descText, GChoice[] choices) {
		this(titleText, descText, choices, new GItem[] {});
	}
	
	// Regular node constructor
	public GNode(String titleText, String descText, GChoice[] choices, String soundPath) {
		this(titleText, descText, choices, new GItem[] {});
		this.soundPath = soundPath;
	}
}
