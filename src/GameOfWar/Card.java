package GameOfWar;

public class Card {

	private int value;
	private String suit;
	private String rank;
	
	public Card(int value, String suit, String rank) {
		this.value = value;
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Card " + rank + " of " + suit + " worth " + value + " points.";
	}

	public void describe() {
		System.out.println("Card " + rank + " of " + suit + " is " + value + " points.");
	}
	
	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}
	
}
