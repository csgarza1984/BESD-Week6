package GameOfWar;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Spades", "Clubs"));
	private List<String> ranks = new ArrayList<String>(Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"));
		
	private List<Card> cards = new ArrayList<>();
		
	public Deck() {
		
		int value;
		System.out.println("New Deck:");
		for (String suit : suits) {
			for (String rank : ranks) {
				value = ranks.indexOf(rank);
				Card card = new Card(value + 2, suit, rank);
				card.describe();
				cards.add(card);
			}
		}		
	}
	
	public void shuffle() {
		Random random = new Random();
		List<Card> randomList = new ArrayList<>();
		
		while(cards.size() > 0) {
			int position = random.nextInt(cards.size());  //generate a position from 0 to length of cards list
			Card card = cards.remove(position); // removes card at the position given and returns the card while shortening the list
			randomList.add(card); //put card in new temporary list
		}
		cards = randomList;
		
//		Collections.shuffle(cards); //much simpler option
		
//		cards = new ArrayList<>(new HashSet<>(cards)); //tried feeding a list into a set to create an unordered list, but it isn't really random
	}
	
	public Card draw() {
		if (cards.isEmpty()) {
			throw new IllegalStateException("Deck is empty!");
		}
		
		return cards.remove(0); //takes one card off deck
	}
	
	public int size() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deck:  \n"); //initialize builder
		
		for (Card card : cards) {
			builder.append("   ").append(card).append("\n"); //call the toString method in card.
		}
		
		return builder.toString();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	

//temporary way to test	
//	public static void main(String[] args) {
//		Deck deck = new Deck();
//		deck.shuffle();
//		
//		System.out.println(deck);
//	}
	
} //class
