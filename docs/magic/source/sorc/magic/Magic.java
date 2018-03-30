package sorc.magic;

import sorc.magic.Deck;
import sorc.magic.MagicDeck;
import sorc.magic.UI;

public class Magic {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		
		UI ui = new UI();
		ui.printCardSelection(deck);
		int usrCard = ui.getSelectedCard(deck);

		// create new deck w/ the top (n) cards + user selection
		// place user selection on the top
		
		System.out.println("\nDealing N cards w/ usr card on top...\n");

		Card usrCardVal = deck.get(usrCard);
		MagicDeck magicDeck = new MagicDeck(deck, usrCard);
		ui.printMagicDeck(magicDeck);

	}
}

// need a deck class that takes an array of Cards[]
// deck class: shuffle, divide deck

// UI class, prompts user and displays deck status and arrow pointing to user
// card



