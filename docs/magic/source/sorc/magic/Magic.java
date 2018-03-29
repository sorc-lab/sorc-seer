package sorc.magic;

import sorc.magic.Deck;

public class Magic {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();

		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i)); // TODO: Fix deck.shuffle()
		}
	}
}

// need a deck class that takes an array of Cards[]
// deck class: shuffle, divide deck

// UI class, prompts user and displays deck status and arrow pointing to user
// card



