package GameOfWar;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> hand = new ArrayList<>();
	private int score = 0;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public int size() {
		return hand.size();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand for ").append(name).append(":\n");
		
		for (Card card : hand) {
			builder.append("   ").append(card).append("\n");
		}
		
		return builder.toString();
	}
	
	public Card flip() {
		if (hand.isEmpty()) {
			throw new IllegalStateException("Deck is empty!");
		}
		
		return hand.remove(0); 
	}
	
	public void draw(Deck deck) {
		hand.add(deck.draw()); //draw card from deck and put in player's hand
	}
	
	public void incrementScore() {
		score += 1;
	}
	
	public int getScore() {
		return score;
	}
	
}
