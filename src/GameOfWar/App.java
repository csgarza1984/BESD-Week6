package GameOfWar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class App {
	private Player player1;
	private Player player2;
	List<String> players = List.of("George Washington", "John Adams", "Thomas Jefferson", "Alexander Hamilton",
			"Aaron Burr", "Benjamin Franklin");
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		playerMatchUp();
	
		Deck deck = new Deck();		
		deck.shuffle();
		
		int numCards = deck.size();
		
		dealDeck(deck);
		beginWar(numCards);
		checkScore();
	}

	private void dealDeck(Deck deck) {
		for (int index = 1; index < 53; index++) {
			if (index % 2 == 1) {
				player1.draw(deck);
			}
			else if (index % 2 == 0) {
				player2.draw(deck);
			}
		}
		System.out.println();
		System.out.println(player1);
		System.out.println(player2);
	}
	
	private void beginWar(int numCards) {
		System.out.println();
		System.out.println("LET THE WAR BEGIN!");
		System.out.println();
		
		for (int index = 0; index < numCards / 2; index++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			
			System.out.println(player1.getName() + " played " + player1Card);
			System.out.println(player2.getName() + " played " + player2Card);
			System.out.println();
			
			if (player1Card.getValue() > player2Card.getValue()) {
				player1.incrementScore();
			}
			else if (player2Card.getValue() > player1Card.getValue()) {
				player2.incrementScore();
			}
		}
	}
	
	private void checkScore() {
		if (player1.getScore() > player2.getScore()) {
			reportVictor(player1, player2);
		}
		else if (player2.getScore() > player1.getScore()) {
			reportVictor(player2, player1);
		}
		else {
			System.out.println("It's a draw!");
		}
	}

	private void reportVictor(Player victor, Player vanquished) {
		System.out.println();
		System.out.println("***" + victor.getName() + " defeated " + vanquished.getName() + " with a score of "
				+ victor.getScore() + " to " + vanquished.getScore() + "!!");
	}

	private void playerMatchUp() {
		Set<String> tempPlayers = new TreeSet<>(); //TreeSet to sort alphabetically
		Random random = new Random();
		
		while (tempPlayers.size() < 2 ) {
			tempPlayers.add(players.get(random.nextInt(players.size()))); // get random player and add to temp Set which won't allow duplicates
		}
		
		List<String> result = new ArrayList<>(tempPlayers);
		player1 = new Player(result.get(0));
		player2 = new Player(result.get(1));

	}
}
