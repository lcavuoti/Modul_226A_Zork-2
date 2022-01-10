package ch.bbw.zork;import java.util.ArrayList;import java.util.Arrays;import java.util.HashSet;import java.util.Stack;/** * Class Game - the main class of the "Zork" game. * * Author:  Michael Kolling, 1.1, March 2000 * refactoring: Rinaldo Lanza, September 2020 */public class Game {		private Parser parser;	private Room currentRoom;	private Room start, room1, room2, room3, room4, room5, room6, room7, death, end;	public Game() {				parser = new Parser(System.in);		start = new Room("Spawnpoint");		room1 = new Room("Fight against the monster");		room2 = new Room("Grab some truefruits smoothies, restoring 1 HP");		room3 = new Room("play \"rock paper scissors\""); // against the digital chind		room4 = new Room("the debögging-game");		room5 = new Room("the \"das wissen sie bereits game\"");		room6 = new Room("tictactoe");		room7 = new Room("guess a number between 1-100");		death = new Room("Who knows");		end = new Room("Istantaneous, horrific, gruesome, inexplicable Death.");		start.setExits(room1, null, room3, null);		room1.setExits(null, room2, null, null);		room2.setExits(null, room6, room5, room1);		room3.setExits(null, room4, death, null);		room4.setExits(null, room5, death, room3);		room5.setExits(null, null, room4, room2);		room6.setExits(null, room7, room2, start);		room7.setExits(room6, null, end, room5);		currentRoom = start; // start game outside	}	/**	 *  Main play routine.  Loops until end of play.	 */	public void play() {		printWelcome();		// Enter the main command loop.  Here we repeatedly read commands and		// execute them until the game is over.		boolean finished = false;		while (!finished) {			Command command = parser.getCommand();			finished = processCommand(command);		}		System.out.println("Thank you for playing.  Good bye.");	}	private void printWelcome() {		System.out.println();		System.out.println("Welcome to Zork!");		System.out.println("Zork is a simple adventure game.");		System.out.println("Type 'help' if you need help.");		System.out.println();		System.out.println(currentRoom.longDescription());	}	private boolean processCommand(Command command) {		if (command.isUnknown()) {			System.out.println("I don't know what you mean...");			return false;		}		String commandWord = command.getCommandWord();		if (commandWord.equals("help")) {			printHelp();		} else if (commandWord.equals("go")) {			goRoom(command);					} else if (commandWord.equals("quit")) {			if (command.hasSecondWord()) {				System.out.println("Quit what?");			} else {				return true; // signal that we want to quit			}		}		return false;	}	private void printHelp() {		System.out.println("You are lost. You are alone. You wander");		System.out.println("around at Monash Uni, Peninsula Campus.");		System.out.println();		System.out.println("Your command words are:");		System.out.println(parser.showCommands());	}	private void goRoom(Command command) {		if (!command.hasSecondWord()) {			System.out.println("Go where?");		} else {						String direction = command.getSecondWord();				// Try to leave current room.			Room nextRoom = currentRoom.nextRoom(direction);				if (nextRoom == null)				System.out.println("There is no door!");			else {				currentRoom = nextRoom;				System.out.println(currentRoom.longDescription());			}		}	}}