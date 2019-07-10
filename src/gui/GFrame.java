package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import helpers.SoundPlayer;
import models.GChoice;
import models.GItem;
import models.GMap;
import models.GNode;

public class GFrame extends JFrame {

	// Prevents warnings
	private static final long serialVersionUID = 1L;
	
	// Width and Height of the frame
	private int fWidth = 800;
	private int fHeight = 400;
	
	// Current node
	public GNode currentNode;
	
	// Title of current node
	public JLabel nodeTitle = new JLabel("Situation");
	
	// Description (Main text) of the current node
	public JTextArea nodeText = new JTextArea("Description");
	
	// Button you push to restart the adventure
	public JButton restartButton = new JButton("Retry");
	
	// List of Buttons that can be pressed
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	// Current Inventory
	private ArrayList<GItem> inventory = new ArrayList<GItem>();
	
	// If this gets to or past maxAggro, then you die
	private int monsterAggro = 0;
	private final int maxAggro = 2;
	
	// Constructor
	public GFrame() {
		super();
		
		// Set default size for frame
		Dimension size = new Dimension(this.fWidth, this.fHeight);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		
		// Set Layout to allow for exact content positioning
		this.setLayout(null);
		
		// Get rid of Java icon
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		this.setIconImage(icon);
		
		// Change font for nodeTitle
		Font titleFont = this.nodeTitle.getFont();
		this.nodeTitle.setFont(new Font(titleFont.getName(), Font.BOLD, 16));
		
		// Set bounds/properties of nodeTitle and add to frame
		this.nodeTitle.setBounds(100, 20, 600, 30);
		this.nodeTitle.setBackground(Color.lightGray);
		this.nodeTitle.setOpaque(true);
		this.nodeTitle.setVisible(true);
		this.add(this.nodeTitle);
		
		// Change font for nodeText
		Font textFont = this.nodeText.getFont();
		this.nodeText.setFont(new Font(textFont.getName(), Font.PLAIN, 14));
		
		// Set bounds/properties of nodeText and add to frame
		this.nodeText.setBounds(100, 50, 600, 150);
		this.nodeText.setBackground(Color.cyan);
		this.nodeText.setLineWrap(true);
		this.nodeText.setWrapStyleWord(true);
		this.nodeText.setEditable(false);
		this.nodeText.setOpaque(true);
		this.nodeText.setVisible(true);
		this.add(this.nodeText);
		
		// Set bound/properties of restartButton and add to frame
		this.restartButton.setBounds(10, 20, 80, 30);
		this.restartButton.setBackground(new Color(255, 128, 128));
		this.restartButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GFrame.this.inventory.clear();
			    GFrame.this.selectNode(0);
			  } 
		});
		this.restartButton.setFocusPainted(false);
		this.restartButton.setVisible(true);
		this.add(this.restartButton);
		
		// Load up the first node
		this.loadNode(GMap.nodes[0]);
		
		// Start the music
		SoundPlayer.playMidi("sounds/d_e2m4.mid");
		
		// Prepare frame for viewing
		this.setTitle("Text Adventure");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	// Loads up a new node
	public void loadNode(GNode node) {
		// Start by clearing the list of current buttons
		for(JButton button : this.buttons) {
			this.remove(button);
		}
		this.buttons.clear();
		
		// Set node as current node
		this.currentNode = node;
		
		boolean itemAdded = false;
		// For each item at node, add to inventory if we don't have it
		for(int i = 0; i < this.currentNode.items.length; i++) {
			if(!this.inventory.contains(this.currentNode.items[i])) {
				this.inventory.add(this.currentNode.items[i]);
				itemAdded = true;
			}
		}
		
		// Play "ding" sound if new 'item' acquired
		if(itemAdded) {
			SoundPlayer.playWAV("sounds/ding.wav");
		}
		
		// Play sound on delay if exists in node
		if(node.soundPath != null) {
			SoundPlayer.playWAV(node.soundPath, -10 + (GFrame.this.monsterAggro * 15));
		}
		
		// For each item removed at node, removed from inventory if we have it
		for(int i = 0; i < this.currentNode.removedItems.length; i++) {
			if(this.inventory.contains(this.currentNode.removedItems[i])) {
				this.inventory.remove(this.currentNode.removedItems[i]);
			}
		}
		
		// Set new title and description
		this.nodeTitle.setText(this.currentNode.titleText);
		this.nodeText.setText(this.currentNode.descText);
		
		// Add each choice to the screen as a unique button
		int yPos = 0;
		for(int i = 0; i < this.currentNode.choices.length; i++) {
			// Grab the choice
			GChoice c = this.currentNode.choices[i];
			// Check the type of choice and initialize accordingly
			switch(c.type) {
				case GENERIC:
					// Initialize the button
					this.initializeButton(c, yPos);
					
					// Increment position counters
					yPos += 1;
					break;
				case ITEM_DEPENDENT:
					if(c.barAlienDoll && this.inventory.contains(GItem.ALIEN_DOLL)) {
						// Do nothing
					} else {
						boolean isValid = true;
						for(int x = 0; x < c.dependentItems.length; x++) {
							// Only initialize button based on item condition
							boolean containsItem = this.inventory.contains(c.dependentItems[x]);
							if(((!c.isBarring) && containsItem)
									|| (c.isBarring && (!containsItem))) {
								// Do nothing
							} else {
								isValid = false;
							}
						}
		
						if(isValid) {
							// Initialize the button
							this.initializeButton(c, yPos);
							
							// Increment position counters
							yPos += 1;
						}
					}
					break;
				case RNG:
					// Initialize random-chance button
					this.initializeRNGButton(c, yPos, new Color(255, 255, 0));
					
					// Increment position counters
					yPos += 1;
					break;
				case RNG_AND_ITEM:
					boolean isValidRNG = true;
					for(int x = 0; x < c.dependentItems.length; x++) {
						// Only initialize button based on item condition
						boolean containsItem = this.inventory.contains(c.dependentItems[x]);
						if(((!c.isBarring) && containsItem)
								|| (c.isBarring && (!containsItem))) {
							// Do nothing
						} else {
							isValidRNG = false;
						}
					}

					if(isValidRNG) {
						// Initialize the button
						this.initializeRNGButton(c, yPos, new Color(255, 255, 0));
						
						// Increment position counters
						yPos += 1;
					}
					break;
				case RESTART:
					// Initialize the button
					this.initializeRestartButton(c, yPos);
					
					// Increment position counters
					yPos += 1;
					break;
				case SPECIAL:
					if(this.inventory.contains(c.dependentItems[0])) {
						// Initialize the special button
						this.initializeSpecialButton(c, yPos, new Color(230, 153, 255));
						
						// Increment position counters
						yPos += 1;
					}
					break;
				case MONSTER_PATH:
					// Create button
					this.initializeMonsterButton(c, yPos);
					
					// Increment position counters
					yPos += 1;
					break;
				case MONSTER_SAFE:
					// Create button
					this.initializeSafeButton(c, yPos);
					
					// Increment position counters
					yPos += 1;
					break;
			}
			
		}
		
		// Refresh the whole screen
		this.repaint();
	}
	
	// Selects the node to be loaded
	public void selectNode(int index) {
		GNode node = GMap.nodes[index];
		this.loadNode(node);
	}
	
	// Selects between two nodes based on random chance
	public void rngSelectNode(int index, int altIndex, double rngFactor) {
		Random r = new Random();
		double randomChance = r.nextDouble();
		if(randomChance < rngFactor) {
			this.selectNode(index);
		} else {
			this.selectNode(altIndex);
		}
	}
	
	// Initialize a button on the screen
	public void initializeButton(GChoice c, int yPos, Color color) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		
		// Set background color if specified
		if(color != null) {
			choiceButton.setBackground(color);
		}
			
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
			    GFrame.this.selectNode(c.actionNode);
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Overload with no selected color
	public void initializeButton(GChoice c, int yPos) {
		this.initializeButton(c, yPos, null);
	}
	
	// Initialize random-chance button on the screen
	public void initializeRNGButton(GChoice c, int yPos, Color color) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		
		// Set background color if specified
		if(color != null) {
			choiceButton.setBackground(color);
		}
		
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
			    GFrame.this.rngSelectNode(c.actionNode, c.altActionNode, c.rngFactor);
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Overload with no selected color
	public void initializeRNGButton(GChoice c, int yPos) {
		this.initializeRNGButton(c, yPos, null);
	}
	
	// Initialize restart button on the screen
	public void initializeRestartButton(GChoice c, int yPos) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		choiceButton.setBackground(new Color(255, 128, 128));
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GFrame.this.inventory.clear();
			    GFrame.this.selectNode(c.actionNode);
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Initialize monster button on the screen
	public void initializeMonsterButton(GChoice c, int yPos) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GFrame.this.monsterAggro += 1;
				if(GFrame.this.monsterAggro >= GFrame.this.maxAggro) {
					GFrame.this.createPopup();
				} else {
					GFrame.this.selectNode(c.actionNode + GFrame.this.rand3());
				}
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Initialize monster button on the screen
	public void initializeSafeButton(GChoice c, int yPos) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GFrame.this.selectNode(c.actionNode + GFrame.this.rand3());
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Initialize a button on the screen
	public void initializeSpecialButton(GChoice c, int yPos, Color color) {
		// Initialize button with text and listener
		JButton choiceButton = new JButton(c.actionText);
		
		// Set background color if specified
		if(color != null) {
			choiceButton.setBackground(color);
		}
			
		choiceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				GFrame.this.spookify();
			    GFrame.this.selectNode(c.actionNode);
			  } 
		});
		
		// Set bounds correctly
		choiceButton.setBounds(100, 210 + (yPos * 35), 600, 30);
		
		// Add button to references and to screen
		this.buttons.add(choiceButton);
		this.add(choiceButton);
	}
	
	// Creates a pop-up that lasts for a small period and disappears,
	// closing the game with it
	public void createPopup() {
		// Create new frame and initialize settings
		JFrame testFrame = new JFrame();
		Dimension testSize = new Dimension(GFrame.this.fWidth, GFrame.this.fHeight);
		testFrame.setMinimumSize(testSize);
		testFrame.setResizable(false);
		testFrame.setLayout(null);
		testFrame.setUndecorated(true);
		
		// Make pop-up frame appear at location of main frame
		Point location = GFrame.this.getLocation();
		testFrame.setLocation(location);
		
		// Create panel within frame
		JPanel testPanel = new JPanel(new BorderLayout());
		testPanel.setVisible(true);
		testPanel.setBounds(0, 0, GFrame.this.fWidth, GFrame.this.fHeight);
		
		// Load image
		ImageIcon image;
		try {
			File file = new File("images/popup.png");
			URL url = file.toURI().toURL();
			image = new ImageIcon(url);
			JLabel label = new JLabel("", image, JLabel.CENTER);
			testPanel.add(label, BorderLayout.CENTER );
			testFrame.add(testPanel);
		} catch (Exception e) {
			System.out.println("'images/popup.png' not found.");
			e.printStackTrace();
		}
		
		// Set frame to be visible
		testFrame.setVisible(true);
		testFrame.pack();
		
		// Play creepy sound
		SoundPlayer.playWAV("sounds/CreepyBreath_GOTCHA.wav");
		
		// Create timer for small period that closes pop-up on finish
		int delay = 400; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          testFrame.dispose();
		          GFrame.this.dispatchEvent(new WindowEvent(GFrame.this, WindowEvent.WINDOW_CLOSING));
		      }
		};
		new Timer(delay, taskPerformer).start();
	}
	
	// Makes background scary and stop music
	public void spookify() {
		this.getContentPane().setBackground(Color.black);
		this.nodeText.setBackground(new Color(255, 100, 100));
		this.restartButton.setVisible(false);
		SoundPlayer.stopMidi();
	}
	
	public int rand3() {
		Random r = new Random();
		return r.nextInt(3);
	}
	
}
