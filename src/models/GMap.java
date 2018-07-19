package models;

// "Map" of all the defined nodes in the game
public class GMap {

	public static GNode[] nodes = new GNode[] {
	
	// N0: Starting point
	new GNode("The Journey Begins...",
			"You wake up from a daze in the middle of a forest. As your vision adjusts,"
			+ " you see a cave entrance ahead.",
			new GChoice[] {
					new GChoice("On your feet!", 1)
					}),
	
	
	// N1: (First) Cave Entrance
	new GNode("Cave Entrance",
			"You stumble back onto your feet, glaring at the dark cave entrance in front of you."
			+ " The only sound that answers from its midst is the drip of murky water"
			+ " from its pointed ceiling that pools at the rocky floor below. To the side of the cave"
			+ " lies a stagnant pond covered in algae.",
			new GChoice[] {
					new GChoice("Enter the cave", 3),
					new GChoice("Search the pond", 6, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Check the cave's perimeter", 17, GItem.SOCIAL_AWKWARDNESS, GChoice.BARRING),
					new GChoice("Check the cave's perimeter", 52, GItem.SOCIAL_AWKWARDNESS, GChoice.REQUIRED)
					}),
	
	// N2: (Repeat) Cave Entrance
	new GNode("Cave Entrance",
			"You find yourself at the entrance to the cave once again. What do you do?",
			new GChoice[] {
					new GChoice("Enter the cave", 3),
					new GChoice("Search the pond", 6, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Check the cave's perimeter", 17, GItem.SOCIAL_AWKWARDNESS, GChoice.BARRING),
					new GChoice("Check the cave's perimeter", 52, GItem.SOCIAL_AWKWARDNESS, GChoice.REQUIRED)
					}),
	
	// N3: Cave Traversal
	new GNode("Cave Tunnels",
			"The cave is even darker on the inside. You feel yourself nearly slipping on the"
			+ " floor as you tread deeper and deeper. As if it weren't unpleasant enough already,"
			+ " the ceiling has also gotten progressively lower.",
			new GChoice[] {
					new GChoice("On second thought, I hate spelunking", 2),
					new GChoice("Trek onwards", 4)
					}),
	
	// N4: Cave Terminal
	new GNode("Cave Terminal",
			"At the end of the cave, you find yourself standing in front of a large locked"
			+ " wooden door. To the side of the door is a steep rocky descent. You're glad"
			+ " the cave doesn't go any further, as the stalactites are low enough to poke"
			+ " your head.",
			new GChoice[] {
					new GChoice("Leave the cave", 2),
					new GChoice("Kick the door", 10, GItem.BROKEN_FOOT, GChoice.BARRING),
					new GChoice("Open the door with the key", 9, GItem.ALIEN_KEY),
					new GChoice("Scale the descent", 29, GItem.BROKEN_FOOT, GChoice.REQUIRED),
					new GChoice("Scale the descent", 31, GItem.BROKEN_FOOT, GChoice.BARRING)
					}),
	
	// N5: Disturbing Shrine
	new GNode("Disturbing Shrine",
			"The light of your lantern barely reaches through the ominous darkness that lingers"
			+ " inside the room. From what you can see, you notice the walls are stained red and"
			+ " decorated in strange carvings of creatures you've never seen before. At the center"
			+ " of the room is an empty altar surrounded by pale marble statues of men and women,"
			+ " all with bizarre looks of pure terror frozen on their faces. This doesn't seem"
			+ " right at all...",
			new GChoice[] {
					new GChoice("Leave this wretched place", 4),
					new GChoice() // Special choice
					}),
	
	// N6: Outside Pond
	new GNode("Stagnant Pond",
			"Tall grass and cattails spring up from the pond's edge, which can't be much"
			+ " wider than an average indoor pool. While the water is fairly murky,"
			+ " you can still see some small aquatic wildlife swimming below the surface.",
			new GChoice[] {
					new GChoice("Back to the cave entrance", 2),
					new GChoice("Peer closer to the surface", 8),
					new GChoice("Dive in", 7, GItem.ALIEN_KEY, GChoice.BARRING)
					}),
	
	// N7: Pond Diving
	new GNode("Pond Underwater",
			"You startle the poor wildlife with a brave leap into the pond. Your eyes"
			+ " cloud with sediment, but you still somehow manage to spot a glimmer at"
			+ " the bottom of the water. You swim a small ways down and grab a strange"
			+ " looking key before darting back to the surface and climbing out of the pond.",
			new GChoice[] {
					new GChoice("Fascinating...", 6)
					},
			GItem.ALIEN_KEY),
	
	// N8: Pond Gazing
	new GNode("Gazing into the Pond",
			"You peer closer to the water. The fish and other critters don't seems to"
			+ " mind, at first. You peer even closer, and the fish start to swim away."
			+ " Now you're peering so close your nose is grazing the water. The fish are"
			+ " begging you to go away. This needs to stop.",
			new GChoice[] {
					new GChoice("Stop admiring the fish", 6),
					new GChoice("Keep staring", 12)
					}),
	
	// N9: Shrine Opening
	new GNode("Pitch-black Room Entrance",
			"The now-opened door reveals a room steeped in the thickest darkness you've seen yet."
			+ " You find it strangely fascinating how your hand disappears and reappears"
			+ " before your eyes as you draw it in and out of door frame. Unlike the rest"
			+ " of the cave, you're really going to need a light source before you enter here.",
			new GChoice[] {
					new GChoice("Turn back", 4),
					new GChoice("Light the room with the lantern", 5, GItem.LANTERN)
					}),
	
	// N10: Door Kick
	new GNode("Stupid Door",
			"You kick the door with all your might. This creates a loud thud and causes"
			+ " the door to sway a little. Pointless, yet satisfying.",
			new GChoice[] {
					new GChoice("Stop kicking", 4),
					new GChoice("Kick again", 11)
					}),
	
	// N11: Door Kick
	new GNode("Ouch",
			"You kick the door with too much force for your own good. You end up hurting"
			+ " your foot in the process. Good job.",
			new GChoice[] {
					new GChoice("Never again", 4)
					},
			GItem.BROKEN_FOOT),
	
	// N12: Fish Staring Continued 1
	new GNode("It Continues...",
			"The fish have all swum to the bottom of the pond to avoid your gaze, yet"
			+ " you keep staring.",
			new GChoice[] {
					new GChoice("Stop admiring the fish", 6),
					new GChoice("Keep staring", 13)
					}),
	
	// N13: Fish Staring Continued 2
	new GNode("It Still Continues...",
			"The fish have started tunneling through the bottom of the pond to"
			+ " avoid your gaze, yet you keep staring.",
			new GChoice[] {
					new GChoice("Stop admiring the fish", 6),
					new GChoice("Keep staring", 14),
					new GChoice("Taunt the fish", 15)
					}),
	
	// N14: Fish Staring Finished
	new GNode("It is done",
			"The fish have now evacuated the pool, leaving a series of tunnels where"
			+ " they made their quick escape. This has drained the pond, turning it into"
			+ " an unclimbable pit of tar-like mud. This might come back to haunt you.",
			new GChoice[] {
					new GChoice("Nothing left to stare at", 2),
					new GChoice("Jump in the mud", 16)
					},
			GItem.FISH_HATRED),
	
	// N15: Fish Death
	new GNode("How rude",
			"A set of two red dots form in the water. Before you can react, a huge set of"
			+ " jaws emerges from the pond and drags you under. You really had this one coming.",
			new GChoice[] {
					new GChoice("Mind your manners and start over")
					}),
	
	// N16: Mud Death
	new GNode("A Sinking Sensation",
			"When I said 'unclimbable', I truly meant it. With the fish tunnels being too"
			+ " small to fit through, you slowly sink into the thick mud as you struggle"
			+ " in vain to scale the slippery sides of the now-empty pond. You eventually"
			+ " run out of energy and fall beneath the surface of the sticky mud, where you"
			+ " suffocate to death.",
			new GChoice[] {
					new GChoice("Try again, and don't be so rash next time")
					}),
	
	// N17: Cave Perimeter
	new GNode("Perimeter Path",
			"A winding path through the woods begins at a hidden corner of the cave perimeter."
			+ " Along the path, you spot a variety of colorful forest fauna and critters."
			+ " At the path's end you see a crooked looking man standing in front of a long"
			+ " staircase that crawls up the side of the jagged cave's exterior. For some reason"
			+ " there's an excess amount of dead fish in the area.",
			new GChoice[] {
					new GChoice("Return to cave entrance", 2),
					new GChoice("Approach the man", 18),
					new GChoice("Climb around the man to avoid detection", 24, GItem.BROKEN_FOOT, GChoice.BARRING)
					}),
	
	// N18: Talk to man
	new GNode("The Crooked Man",
			"'Greetings,' croaks the man. 'My name is Jeff.' Before you can respond, he goes"
			+ " into a long confusing rant and tries to get you to sign what looks some petition."
			+ " Needless to say, this is really boring and aggitating at the same time."
			+ " How do you handle this social interaction?",
			new GChoice[] {
					new GChoice("Sign the petition and get it over with", 19),
					new GChoice("Kick him", 20),
					new GChoice("Avoid eye contact and walk away", 23),
					new GChoice("Ask what the petition is about", 21)
					}),
	
	// N19: Petition Death
	new GNode("Opposing Party",
			"'How delightful,' pipes the crooked man (Jeff). 'That's the easiest signature I've"
			+ " ever gotten!' You feel a tremor in the earth beneath you. 'Uh oh,' mutters Jeff."
			+ " 'Not this shit again.' You see a giant mass of fish erupt in the distance. While"
			+ " you contemplate the absurdity of the current line of events, you fail to notice"
			+ " the flight path of the critters was aimed right at your location! You are absolutely"
			+ " smothered in fish.",
			new GChoice[] {
					new GChoice("Be careful what you sign. Try again")
					}),
	
	// N20: Kick man
	new GNode("The Crooked Man",
			"You lightly swing your foot repeatedly to hit the crooked man's shins. The man"
			+ " looks greatly confused and is still expecting a proper response. What do you do"
			+ " now?",
			new GChoice[] {
					new GChoice("Sign the petition and get it over with", 19),
					new GChoice("Avoid eye contact and walk away", 23),
					new GChoice("Ask what the petition is about", 21)
					}),
	
	// N21: Ask about petition
	new GNode("The Crooked Man",
			"Smiling, the man explains his vehement opposition to fish and what they stand for."
			+ " His petition is to help crowdfund a war declared upon all aquatic animals."
			+ " You aren't quite sure what to make of this.",
			new GChoice[] {
					new GChoice("Sign the petition and get it over with", 19),
					new GChoice("Kick him", 20),
					new GChoice("Avoid eye contact and walk away", 23),
					new GChoice("Explain you have a newfound hatred of fish as well", 22, GItem.FISH_HATRED)
					}),
	
	// N22: Mutual Hatred
	new GNode("The Crooked Man: Partners?",
			"'You agree!' cheers the crooked man, almost in disbelief. 'Screw the petition,"
			+ " we're going to be partners! Take this coin as a symbol of our friendship,' the"
			+ " man chortles, tossing a dusty coin into your hand. The crooked fellow waves you"
			+ " out, reminding you to 'spread the word'.",
			new GChoice[] {
					new GChoice("Continue up to the top of the stairs", 25)
					},
			GItem.COIN),
	
	// N23: No Eye Contact
	new GNode("The Crooked Man",
			"As the man continues to elicit a response, you slowly inch by him up the staircase"
			+ " with your eyes aimed directly at your feet. He looks sad, but also disappointed"
			+ " in you.",
			new GChoice[] {
					new GChoice("Continue up to the top of the stairs", 25)
					}),
	
	// N24: Scale the Cave
	new GNode("Avoid Contact",
			"You painstakingly climb up the near-vertical rocky side of the cave. Beads of sweat"
			+ " pour down your forehead and your hands nearly slip multiple times, yet you are"
			+ " still determined to avoid any form of social interaction. Down below, the man"
			+ " can clearly see you are trying to avoid him. You eventually reach the staircase"
			+ " and begin to book it upwards.",
			new GChoice[] {
					new GChoice("Continue", 25)
					}),
	
	// N25: Top of staircase
	new GNode("Staircase Top",
			"The top of the staircase sets you at the top of the cave. There's a nice view of the"
			+ " forest and surrounding mountainous regions from here. You see a small pit here"
			+ " that leads into cave interior as well as some weird writing on the wall. All of the"
			+ " parts of your brain mutually agree that going back and dealing with the man again is"
			+ " not an option.",
			new GChoice[] {
					new GChoice("Plunge down the pit", 27, GItem.BROKEN_FOOT, GChoice.BARRING),
					new GChoice("Plunge down the pit", 28, GItem.BROKEN_FOOT, GChoice.REQUIRED),
					new GChoice("Read writings", 26)
					},
			GItem.SOCIAL_AWKWARDNESS),
	
	// N26: Wall writing
	new GNode("Cave Scrawlings",
			"The carvings in the wall show what looks to be a pedestal with a doll on top of it."
			+ " Surrounding it are a set of additional crude sketchings: A key, a light, some"
			+ " money, and a bone. Is this a code of some sort?",
			new GChoice[] {
					new GChoice("Continue", 25)
					}),
	
	// N27: Fall down pit (Normal)
	new GNode("Pitfall",
			"You jump into the pit. You tumble down for a bit and then shoot out the opening of a wall"
			+ ", landing on your feet when you hit the ground. This was a surprisingly painless outcome.",
			new GChoice[] {
					new GChoice("Continue", 32, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Continue", 33, GItem.FISH_HATRED, GChoice.REQUIRED)
					}),
	
	// N28: Fall down pit (Broken Foot)
	new GNode("Painful Pitfall",
			"You jump into the pit. You tumble down for a bit and then shoot out the opening of a wall"
			+ ", landing on your feet when you hit the ground. This really hurts, and you decide to roll"
			+ " around and cry for 20 minutes.",
			new GChoice[] {
					new GChoice("Continue", 32, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Continue", 33, GItem.FISH_HATRED, GChoice.REQUIRED)
					}),
	
	// N29: Scale Descent (Broken Foot)
	new GNode("This looks impossible",
			"You look down the harshly-angled descent, accidentally kicking a few pebbles"
			+ " which tumble down to the bottom and shatter. With your newly broken foot,"
			+ " scaling down something this steep seems like a REALLY bad idea. Maybe"
			+ " there's another way around?",
			new GChoice[] {
					new GChoice("Not happening", 4),
					new GChoice("Try anyways", 30, 32, 0.6, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Try anyways", 30, 33, 0.6, GItem.FISH_HATRED, GChoice.REQUIRED)
					}),
	
	// N30: Descent Death
	new GNode("Now you're all broken",
			"You trip and fall after losing your (broken) footing on the first step you take."
			+ " Like the pebbles you just mercilessly slaughtered, you too tumble to the bottom"
			+ " of the descent and shatter.",
			new GChoice[] {
					new GChoice("Broken hearts, broken dreams, broken bodies")
					}),
	
	// N31: Scale Descent (Normal)
	new GNode("Scaling the descent",
			"With some well placed footholds, you slowly work your way downwards. Good thing"
			+ " you've kept in shape all these years, or this could have been quite a bit"
			+ " more challenging.",
			new GChoice[] {
					new GChoice("Continue", 32, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Continue", 33, GItem.FISH_HATRED, GChoice.REQUIRED)
					}),
	
	// N32: Cave Landing (Normal)
	new GNode("Cave Landing",
			"You find yourself in a large pitted dirt room. Various size granite rocks cover"
			+ " the floor and water drips from the ceiling, dampening the soil. There's an opening"
			+ " on the wall next to you high above your head and a rocky ascent behind you."
			+ " Ahead of you is large ornate archway that appears to lead deeper into the cave."
			+ " To the right of the archway sits a jazzy looking skeleton.",
			new GChoice[] {
					new GChoice("Climb up the ascent", 4),
					new GChoice("Try to reach opening", 34),
					new GChoice("Approach skeleton", 35, GItem.PROMISE, GChoice.BARRING),
					new GChoice("Approach skeleton", 36, GItem.PROMISE, GChoice.REQUIRED),
					new GChoice("Go through the archway", 50)
					}),
	
	// N33: Cave Landing (Flooded)
	new GNode("Flooded Cave Landing",
			"You find yourself on a small dirt platform in the middle of an otherwise flooded"
			+ " room. A series of tiny openings mark the ceiling in a peculiar pattern."
			+ " There's an opening on the wall next to you high above your head and a rocky"
			+ " ascent behind you. Across the water is a large ornate archway that appears"
			+ " to lead deeper into the cave.",
			new GChoice[] {
					new GChoice("Climb up the ascent", 4),
					new GChoice("Try to reach opening", 34),
					new GChoice("Peer into the water", 39, GItem.FISH_DEAD, GChoice.BARRING),
					new GChoice("Peer into the water", 40, GItem.FISH_DEAD, GChoice.REQUIRED),
					new GChoice("Swim to the archway", 46, GItem.FISH_DEAD, GChoice.BARRING),
					new GChoice("Swim to the archway", 50, GItem.FISH_DEAD, GChoice.REQUIRED),
					}),
	
	// N34: Try to reach opening in Cave Landing
	new GNode("So close...",
			"You stretch your arms as far as they can go, but the opening is too far away."
			+ " You feel jumping would not help solve this problem either.",
			new GChoice[] {
					new GChoice("Resume", 32, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Resume", 33, GItem.FISH_HATRED, GChoice.REQUIRED)
					}),
	
	// N35: Jazzy Skeleton (Normal)
	new GNode("Jazzy Skeleton",
			"You approach the slumped over skeleton. It has a shiny brass tuba hanging from"
			+ " a strap wrapped around its shoulders. It's head snaps towards you suddenly!"
			+ " 'Wanna pay for a tune, kid?' it chatters in a raspy voice.",
			new GChoice[] {
					new GChoice("Leave it be", 32),
					new GChoice("Promise future cash in exchange for a tune", 38)
					}),
	
	// N36: Jazzy Skeleton (After Promise)
	new GNode("Jazzy Skeleton",
			"You approach the slumped over skeleton. It's missing a femur, and is"
			+ " impatiently awaiting its payment that was promised.",
			new GChoice[] {
					new GChoice("Leave it be", 32),
					new GChoice("Offer your soul as payment", 37)
					}),
	
	// N37: Offer Skeleton Soul
	new GNode("Desperate Offering",
			"You offer your soul as payment, but the skeleton wants cold, hard cash."
			+ " 'Did you think this going to be a funny hidden death?' it jittered"
			+ " sarcastically. 'Beat it.'",
			new GChoice[] {
					new GChoice("Leave", 32)
					}),
	
	// N38: Skeleton Tune
	new GNode("A Jazzy Tune?",
			"You tell the skeleton that if it plays a tune, you'll pay it back"
			+ " later. It springs to action and makes a valiant attempt to play its"
			+ " tuba, but it has no lungs. It tries so hard that its femur explodes"
			+ " off its body. The femur ricochets off a wall and falls into your pocket."
			+ " The skeleton stops his attempts five seconds later gives you a toothy"
			+ " grin of pure pride.",
			new GChoice[] {
					new GChoice("Remember your promise and leave", 32)
					},
			new GItem[] {GItem.PROMISE, GItem.BONE}),
	
	// N39: Peer into Flooded Cave Landing [Normal]
	new GNode("Further Peering",
			"You peer into the water. You see a multitude of angry looking fish staring back."
			+ " Down on the bottom, you see several shiny granite rocks and a skeleton"
			+ " with a tuba.",
			new GChoice[] {
					new GChoice("Stop peering", 33),
					new GChoice("Flip dusty coin into water", 41, GItem.COIN)
					}),

	// N40: Peer into Flooded Cave Landing [Fish Dead]
	new GNode("Further Peering",
			"You peer into the water. You see a multitude of dead fish floating on the surface."
			+ " Down on the bottom, you see several shiny granite rocks and a skeleton"
			+ " with a tuba.",
			new GChoice[] {
					new GChoice("Stop peering", 33),
					new GChoice("Flip dusty coin into water", 41, GItem.COIN)
					}),
	
	// N41: Flip the Coin
	new GNode("Heads or Tails",
			"You decide to flip the coin into the water. It's not a well, but maybe"
			+ " now would be a good time to wish for something?",
			new GChoice[] {
					new GChoice("On second thought, keep the coin", 33),
					new GChoice("Wish for wealth", 42),
					new GChoice("Wish for a hearty meal", 43, GItem.FISH_DEAD, GChoice.BARRING),
					new GChoice("Wish for a hearty meal", 44, GItem.FISH_DEAD, GChoice.REQUIRED),
					new GChoice("Toss coin at skeleton", 45, GItem.PROMISE),
					}),
	
	// N42: Wish for Wealth
	new GNode("A wish for wealth",
			"You wish for wealth, tossing your only money into the water.",
			new GChoice[] {
					new GChoice("Realize your poor life choices", 33)
					},
			new GItem[]{},
			new GItem[] {GItem.COIN}),
	
	// N43: Wish for a Meal Death [Fish Alive]
	new GNode("Quite the bite",
			"You wish for a hearty meal. The fish collectively chuck a granite"
			+ " boulder into your stupid gaping mouth. You die instantly.",
			new GChoice[] {
					new GChoice("Wish for a second chance")
					}),

	// N44: Wish for a Meal [Fish Dead]
	new GNode("A wish for a meal",
			"You wish for a hearty meal, tossing your coin into the water."
			+ " Starving children could've eaten that coin, you know.",
			new GChoice[] {
					new GChoice("Continue", 33)
					},
			new GItem[]{},
			new GItem[] {GItem.COIN}),
	
	// N45: Toss Coin at Skeleton
	new GNode("Promise Kept",
			"You toss the coin in the general direction of the skeleton. The"
			+ " coin hits the surface of the water and then slowly drifts"
			+ " downwards, where it eventually falls into the mouth of the skeleton's"
			+ " tuba. You feel a weight lifted.",
			new GChoice[] {
					new GChoice("Continue", 33)
					},
			new GItem[] {GItem.PROMISE_KEPT},
			new GItem[] {GItem.COIN}),
	
	// N46: Swim to Archway
	new GNode("Perilous swim",
			"You jump into the water and start swimming towards the archway. When"
			+ " you are roughly halfway there, you spot a large formation of fish swimming"
			+ " right at you! There's nowhere close by to get up onto land. How do you"
			+ " handle this?",
			new GChoice[] {
					new GChoice("Swim back to shore", 47),
					new GChoice("Swim around the fish", 48),
					new GChoice("Swim under the fish", 49)
					}),
	
	// N47: Swim to Shore
	new GNode("Back to safety",
			"You decide to not chance things, and you swim hastily back to shore."
			+ " Luckily, you had just enough of a lead to avoid the swarm of fish.",
			new GChoice[] {
					new GChoice("Continue", 33)
					}),
	
	// N48: Swim Around
	new GNode("Around you go",
			"You decide to swim around the fish as you head towards the archway."
			+ " The swarm of fish has collectively amassed so much momentum that"
			+ " they cannot change direction fast enough to track your movements."
			+ " You arrive at the opposite shore just in time to look back and see"
			+ " the body of fish crash into a wall. They all die.",
			new GChoice[] {
					new GChoice("Continue", 50)
					},
			GItem.FISH_DEAD),
	
	// N49: Swim Under Death
	new GNode("Smashing",
			"You decide to swim under the swarm of fish. Unfortunately, you quickly"
			+ " realize that the body of fish extends all the way to the bottom of the"
			+ " water. Before you can act on another plan, you are caught up in"
			+ " swarm. You all collectively crash into the shore wall, where your"
			+ " lives end abruptly.",
			new GChoice[] {
					new GChoice("Try again")
					}),
	
	// N50: The Archway
	new GNode("The Archway",
			"The archway stands brilliantly in the middle of the otherwise dreary"
			+ " looking cave. It's decorated with carvings of various scenes of worship"
			+ " and animal sacrifice. There are some spelunking supplies behind the"
			+ " left pillar of the archway. Directly ahead of you is a small downward"
			+ " staircase that leads to a large empty lair.",
			new GChoice[] {
					new GChoice("Back to the landing", 32, GItem.FISH_HATRED, GChoice.BARRING),
					new GChoice("Back to the landing", 33, GItem.FISH_HATRED, GChoice.REQUIRED),
					new GChoice("Check out the supplies", 51, GItem.SUPPLIES_LOOTED, GChoice.BARRING),
					new GChoice("Go down the staircase", 53, GItem.CYCLOPS_DEAD, GChoice.BARRING),
					new GChoice("Go down the staircase", 71, GItem.CYCLOPS_DEAD, GChoice.REQUIRED)
					}),
	
	// N51: Spelunking Supplies
	new GNode("Supplies",
			"You look through the supplies. It's mostly just some illegible journal writings"
			+ " and sheet music, but you also spot a small lantern. You decide to keep it.",
			new GChoice[] {
					new GChoice("Continue", 50)
					},
			new GItem[] {GItem.LANTERN, GItem.SUPPLIES_LOOTED}),
	
	// N52: Return to the Cave Perimeter
	new GNode("Cave Perimeter",
			"There's no way you're going back this way again.",
			new GChoice[] {
					new GChoice("Back to cave entrance", 2)
					}),
	
	// N53: The Inner Chamber
	new GNode("The Inner Chamber",
			"You step into the inner chamber of the cave. There's a surprising amount of open"
			+ " space here, and you even catch a draft of air. Perhaps you are close to an exit?"
			+ " Before you can think any longer, a giant cyclops falls and lands behind you, blocking"
			+ " your escape! He looks rather hungry, and his eye is set right on you. What do you do?",
			new GChoice[] {
					new GChoice("Run for your life", 54, GItem.BROKEN_FOOT, GChoice.BARRING),
					new GChoice("Hide behind cover", 55),
					new GChoice("Toss your lantern", 67, GItem.LANTERN),
					new GChoice("Toss the femur", 70, GItem.BONE)
					}),
	
	// N54: Run from Cyclops
	new GNode("Run for your life",
			"You break into a sprint, trying to put as much distance as you can between yourself"
			+ " and the monster. Lucky for you, the oaf doesn't move too fast. You reach a"
			+ " bright entrance across the lair. Light! This could be the way out! However,"
			+ " you get an aching sensation in your brain, compelling you backwards. Was there"
			+ " some greater purpose here that you completely missed? You don't have too"
			+ " much time to think as the cyclops is still parading towards your location.",
			new GChoice[] {
					new GChoice("Break for the exit", 59),
					new GChoice("Hide and try to explore room", 55)
					}),
	
	// N55: Hide from Cyclops
	new GNode("Creeping around",
			"You hide from the monster, who is desperately looking for you. The rock you are behind"
			+ " won't veil you for much longer, you feel. Despite your rush of panic, your eyes seem"
			+ " to be drawn to a dark corner of the room by a mysterious force. You spot a lone"
			+ " wooden doll lying abandoned. Curious. The cyclops is now immediately next to your,"
			+ " position. At any moment he'll look down and notice you, and then it'll be over.",
			new GChoice[] {
					new GChoice("Hold position", 56),
					new GChoice("Change position", 57),
					new GChoice("Throw your lantern", 69, GItem.LANTERN),
					new GChoice("Throw your femur", 70, GItem.BONE)
					}),
	
	// N56: Stomp Death
	new GNode("Crushing defeat",
			"Unfortunately, just as you feared, the cyclops looks down as sees you hiding"
			+ " behind the rock. He stomps you without a moment of hesistation.",
			new GChoice[] {
					new GChoice("Flat out of options, so try again")
					}),
	
	// N57: Change Position
	new GNode("Repositioning",
			"You decide to swap positions to avoid detection. What should you do?",
			new GChoice[] {
					new GChoice("Sneak towards chamber exit", 58),
					new GChoice("Sneak towards doll", 65),
					new GChoice("Shift around the rock", 66)
					}),
	
	// N58: Sneak Exit
	new GNode("Alerted!",
			"You creep towards the opposite end of the cave without being seen. As the brightly lit"
			+ " exit comes into sight, the cyclops looks over and spots you! There's no hiding now.",
			new GChoice[] {
					new GChoice("Run for the exit", 59, GItem.BROKEN_FOOT, GChoice.BARRING),
					new GChoice("Hobble as fast as you can", 64, GItem.BROKEN_FOOT, GChoice.REQUIRED),
					new GChoice("Throw your lantern", 68, GItem.LANTERN),
					new GChoice("Throw your femur", 70, GItem.BONE)
					}),
	
	// N59: Exit Dash
	new GNode("Let there be light",
			"You dash for the opening, leaving the cyclops in the dust. The light from the exit"
			+ " is nearly blinding as it envelops you... ",
			new GChoice[] {
					new GChoice("Onwards", 61, GItem.PROMISE, GChoice.BARRING),
					new GChoice("Onwards", 60, GItem.PROMISE, GChoice.REQUIRED)
					}),
	
	// N60: Near Victory (Promise Made)
	new GNode("Beautiful Meadow",
			"There's a beautiful meadow overlooking your location. You catch your breath"
			+ " and take some time to lower your blood pressure after that stressful series"
			+ " of events. It's time for this adventure to end.",
			new GChoice[] {
					new GChoice("Let's finish this", 63, GItem.PROMISE_KEPT, GChoice.BARRING),
					new GChoice("Let's finish this", 62, GItem.PROMISE_KEPT, GChoice.REQUIRED)
					}),
	
	// N61: Near Victory (No Promise Made)
	new GNode("Beautiful Meadow",
			"There's a beautiful meadow overlooking your location. You catch your breath"
			+ " and take some time to lower your blood pressure after that stressful series"
			+ " of events. It's time for this adventure to end.",
			new GChoice[] {
					new GChoice("Let's finish this", 62)
					}),
	
	// N62: Regular Victory
	new GNode("YOU WIN!",
			"A gorgeous field of flowers and trees stretches out over the land in front of you."
			+ " It seems to keep going on and on for miles. You still can't believe you made it"
			+ " out alive. Guess it's time to relax and maybe have a nice picnic here, or even just"
			+ " take a long nap. However, you still get the nagging suspicion that you missed"
			+ " something REALLY important. Is it too late to rewind and do it again differently?",
			new GChoice[] {
					}),
	
	
	// N63: Skeleton Death 1
	new GNode("So close...",
			"As you admire the meadow and it's beauty, you neglect the angry-looking skeleton"
			+ " crawling out of the cave exit behind you. With a swift motion, the skeleton stabs"
			+ " you with his tuba, leaving you mortally wounded. You lay on the grass bleeding out,"
			+ " almost laughing to yourself about how such a seemingly small choice could affect the"
			+ " future so much. Everything goes dark...",
			new GChoice[] {
					new GChoice("Don't back down on a debt next time")
					}),
	
	// N64: Cyclops Hobble Death
	new GNode("Field goal",
			"You hobble towards the exit as fast as you can, but you're not fast enough."
			+ " The cyclops catches up to you and punts you ten feet deep into the ceiling."
			+ " How unfortunate.",
			new GChoice[] {
					new GChoice("Don't kick that door next time")
					}),
	
	// N65: Cyclops Doll Death
	new GNode("No bumpers needed",
			"You sneak towards the doll, but are easily spotted by the cyclops. While you"
			+ " freeze up in fear, completely cornered and without defense, the cyclops"
			+ " takes his time to grab a nearby boulder and line up a shot. He rolls the"
			+ " boulder towards you at breakneck speeds, picking up a spare.",
			new GChoice[] {
					new GChoice("Don't get greedy")
					}),
	
	// N66: Sneak Behind Rock
	new GNode("Nice moves",
			"You evade being spotted by pulling a fast one and simply shifting your way around"
			+ " the rock you were already hiding behind. The cyclops is scratching its head"
			+ " wondering where you went. You don't hesistate on the opportunity, and you"
			+ " sneak your way over to the exit without much difficulty. ",
			new GChoice[] {
					new GChoice("Leave this place behind", 61, GItem.PROMISE, GChoice.BARRING),
					new GChoice("Leave this place behind", 60, GItem.PROMISE, GChoice.REQUIRED)
					}),
	
	// N67: Lantern Throw (Early)
	new GNode("Too obvious",
			"You wind up and throw the lantern at the cyclops, but he sees it coming and steps"
			+ " to the side. What do you do now?",
			new GChoice[] {
					new GChoice("Run for your life", 54, GItem.BROKEN_FOOT, GChoice.BARRING),
					new GChoice("Hide behind cover", 55),
					new GChoice("Toss the femur", 70, GItem.BONE),
					},
			new GItem[] {},
			new GItem[] {GItem.LANTERN}),
	
	// N68: Lantern Throw (Late)
	new GNode("Red Hot",
			"You wind up and throw the lantern at the cyclops. It hits, but he was already"
			+ " sprinting at you full speed. The flaming cyclops trips and falls on you as"
			+ " you stand in the middle of the room like a deer in headlights.",
			new GChoice[] {
					new GChoice("You really threw that one")
					}),
	
	// N69: Lantern Throw (Perfect)
	new GNode("Nailed him!",
			"You toss the lantern at the cyclops when he's not expecting it. It sets his pants"
			+ " on fire, causing him to run away screaming. He slips out the exit of the cave,"
			+ " continuing his frantic screaming as he runs off into the distance, presumably"
			+ " looking for water. You're now free to explore the chamber!",
			new GChoice[] {
					new GChoice("Continue", 71)
					},
			new GItem[] {GItem.CYCLOPS_DEAD},
			new GItem[] {GItem.LANTERN}),
	
	// N70: Bone Throw
	new GNode("Okay..?",
			"You toss the femur high into the air. The cyclops sticks out his tongue and"
			+ " chases the bone like a dog. The femur comes to a stop in front of a wall,"
			+ " but the cyclops can't slow down fast enough. He runs head-first into the wall"
			+ " and dies instantly. Hurray? You're now free to explore the rest of the chamber!",
			new GChoice[] {
					new GChoice("Continue", 71)
					},
			GItem.CYCLOPS_DEAD),
	
	// N71: Empty Inner Chamber
	new GNode("Inner Chamber",
			"You stand in the center of the empty chamber. Without the threat of the cyclops,"
			+ " you look around and realize there's not a whole lot to see in here. There's"
			+ " a dark corner of the room you can't see into as well as some cave paintings"
			+ " on one of the larger walls. The most visualy stunning feature of the area is"
			+ " the brighly lit entrance which flickers invitingly at the other end of the chamber.",
			new GChoice[] {
					new GChoice("Back to the archway", 50),
					new GChoice("Let's get out of this cave", 61, GItem.PROMISE, GChoice.BARRING),
					new GChoice("Let's get out of this cave", 60, GItem.PROMISE, GChoice.REQUIRED),
					new GChoice("Check the paintings", 72),
					new GChoice("Check the corner", 73, GItem.PROMISE, GChoice.BARRING, true),
					new GChoice("Check the corner", 74, GItem.PROMISE, GChoice.REQUIRED, true)
					}),
	
	// N72: Cave Paintings
	new GNode("Directions?",
			"You observe the cave painting. It looks like a diagram or directions of some"
			+ " sort. In the middle is a crude drawing of a person. To the left of the"
			+ " person is a long line, and to the right of the person is a very short line."
			+ " On top of the person are the words 'Hah Hah' (weird), and located below the person"
			+ " is a giant, bleeding eyeball. The last part of that scares you.",
			new GChoice[] {
					new GChoice("Back", 71)
					}),
	
	// N73: Dark Corner [No Promise]
	new GNode("Dark Corner of Chamber",
			"You approach the dark corner. Despite the near complete lack of light,"
			+ " your eyes lock on an abandoned wooden doll sitting in the furthest"
			+ " reach of the corner.",
			new GChoice[] {
					new GChoice("Back", 71),
					new GChoice("Grab the doll", 75)
					}),
	
	// N74: Dark Corner [Promise Made]
	new GNode("Dark Corner of Chamber",
			"You approach the dark corner. Despite the near complete lack of light,"
			+ " your eyes lock on an abandoned wooden doll sitting in the furthest"
			+ " reach of the corner.",
			new GChoice[] {
					new GChoice("Back", 71),
					new GChoice("Grab the doll", 76, GItem.PROMISE_KEPT, GChoice.BARRING),
					new GChoice("Grab the doll", 75, GItem.PROMISE_KEPT, GChoice.REQUIRED),
					}),
	
	// N75: Dark Corner [Promise Made]
	new GNode("Strange...",
			"You grab the abandoned doll. On closer inspection, it's a figure of a little girl."
			+ " However, the more you stare at it, the less human it looks. You start"
			+ " noticing more and more disturbing features, like the fact that the doll has"
			+ " six fingers on each hand and blood around its mouth. You want to put it back"
			+ " down, but you're compelled to keep it by some unknown force.",
			new GChoice[] {
					new GChoice("Back", 71)
					},
			GItem.ALIEN_DOLL),
	
	// N76: Skeleton Death 2
	new GNode("Time's up",
			"As you approach the dark corner, you quickly spot a tuba frisbeeing towards you!"
			+ " Before you have time to act, it hits your neck, cutting off your head and"
			+ " leaving you lifeless on the cave floor. A jazzy looking skeleton pops out from"
			+ " behind a nearby boulder. 'NEVER default on my payments, kid!' he chatters,"
			+ " crawling off into the distance.",
			new GChoice[] {
					new GChoice("Pay first, investigate later")
					}),
	
	// N77: Special Event
	new GNode("The lights dim...",
			"You set the doll on the altar. After that, you don't remember much of what happens,"
			+ " but you wake up and it's incredibly dark. The lantern you previously were clutching"
			+ " tight in your hands has somehow disappeared.",
			new GChoice[] {
					new GChoice("Continue", 78, ChoiceType.MONSTER_SAFE)
					}),
	
	// N78: Special Node 1 (LEFT)
	new GNode("It's so dark",
			"...",
			new GChoice[] {
					new GChoice("Go left", 81, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 81, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 81, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N79: Special Node 1 (MIDDLE)
	new GNode("It's so dark",
			"...",
			new GChoice[] {
					new GChoice("Go left", 81, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 81, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 81, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N80: Special Node 1 (RIGHT)
	new GNode("It's so dark",
			"...",
			new GChoice[] {
					new GChoice("Go left", 81, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 81, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 81, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N81: Special Node 2 (LEFT)
	new GNode("I can't feel my legs",
			"...",
			new GChoice[] {
					new GChoice("Go left", 84, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 84, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 84, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N82: Special Node 1 (MIDDLE)
	new GNode("I can't feel my legs",
			"...",
			new GChoice[] {
					new GChoice("Go left", 84, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 84, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 84, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N83: Special Node 2 (RIGHT)
	new GNode("I can't feel my legs",
			"...",
			new GChoice[] {
					new GChoice("Go left", 84, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 84, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 84, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N84: Special Node 3 (LEFT)
	new GNode("My head is spinning...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 87, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 87, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 87, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N85: Special Node 3 (MIDDLE)
	new GNode("My head is spinning...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 87, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 87, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 87, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N86: Special Node 4 (RIGHT)
	new GNode("My head is spinning...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 87, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 87, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 87, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N87: Special Node 4 (LEFT)
	new GNode("My heart has stopped...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 90, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 90, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 90, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N88: Special Node 4 (MIDDLE)
	new GNode("My heart has stopped...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 90, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 90, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 90, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N89: Special Node 4 (RIGHT)
	new GNode("My heart has stopped...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 90, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 90, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 90, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N90: Special Node 5 (LEFT)
	new GNode("...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 93, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 93, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 93, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N91: Special Node 5 (MIDDLE)
	new GNode("...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 93, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 93, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 93, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N92: Special Node 5 (RIGHT)
	new GNode("...",
			"...",
			new GChoice[] {
					new GChoice("Go left", 93, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 93, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 93, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N93: Special Node 5 (LEFT)
	new GNode("",
			"",
			new GChoice[] {
					new GChoice("Go left", 96, ChoiceType.MONSTER_SAFE),
					new GChoice("Go straight", 96, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 96, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_LEFT.wav"),
	
	
	// N94: Special Node 5 (MIDDLE)
	new GNode("",
			"",
			new GChoice[] {
					new GChoice("Go left", 96, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 96, ChoiceType.MONSTER_SAFE),
					new GChoice("Go right", 96, ChoiceType.MONSTER_PATH),
					}, "CreepyBreath_FRONT.wav"),
	
	// N95: Special Node 5 (RIGHT)
	new GNode("",
			"",
			new GChoice[] {
					new GChoice("Go left", 96, ChoiceType.MONSTER_PATH),
					new GChoice("Go straight", 96, ChoiceType.MONSTER_PATH),
					new GChoice("Go right", 96, ChoiceType.MONSTER_SAFE),
					}, "CreepyBreath_RIGHT.wav"),
	
	// N96: Special Victory
	new GNode("True Victory",
			"You escape the inpenetrable darkness and arrive in a cosmic mist of swirling"
			+ " purple and brightly lit stars. They begin to spell out a message: 'Glad you"
			+ " saw this one through, friend. I didn't expect you to make it this far.'"
			+ " The memo from the unknown sender stills a strange sense of determination."
			+ " It's time to finish this. You step into the mist...",
			new GChoice[] {
					}),
	
	// N97: Special Victory
	new GNode("True Victory",
			"You escape the inpenetrable darkness and arrive in a cosmic mist of swirling"
			+ " purple and brightly lit stars. They begin to spell out a message: 'Glad you"
			+ " saw this one through, friend. I didn't expect you to make it this far.'"
			+ " The memo from the unknown sender stills a strange sense of determination."
			+ " It's time to finish this. You step into the mist...",
			new GChoice[] {
					}),
	
	// N98: Special Victory
	new GNode("True Victory",
			"You escape the inpenetrable darkness and arrive in a cosmic mist of swirling"
			+ " purple and brightly lit stars. They begin to spell out a message: 'Glad you"
			+ " saw this one through, friend. I didn't expect you to make it this far.'"
			+ " The memo from the unknown sender stills a strange sense of determination."
			+ " It's time to finish this. You step into the mist...",
			new GChoice[] {
					}),
	
	
	
	
	};
}
