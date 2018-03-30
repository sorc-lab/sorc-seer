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
		
		System.out.println("\nDealing N cards w/ usr card on top...\n");

		Card usrCardVal = deck.get(usrCard);
		MagicDeck magicDeck = new MagicDeck(deck, usrCard);
		ui.printMagicDeck(magicDeck);

		// parse usrCardVal, set suit and value as instance vars of UserCard
		// UserCard.getSuit (returns string
		// UserCard.getRank
		
		// proto UI
		// 3 of hearts
		//
		// three of hearts
		//
		// "three"
		// 12. [t] ...
		// 11. [h] ...
		// 10. [r] ...
		// 9.  [e] ...
		// 8.  [e] ...
		// 7. ...
		// 6. ...
		// 5. ...
		// 4. ...
		// 3. ...
		// 2. ...
		// 1. ...
		// 0. ...
		//
		// "of"
		// 12. [o] ...
		// 11. [f] ...
		// 10. ...
		// 9. ...
		// 8. ...
		// 7. ...
		// 6. ...
		// 5. ...
		// 4. ...
		// 3. ...
		// 2. ...
		// 1. ...
		// 0. ...
		//
		// "hearts"
		// 12. [h] ...
		// 11. [e] ...
		// 10. [a] ...
		// 9.  [r] ...
		// 8.  [t] ...
		// 7.  [s] ...
		// 6. ...
		// 5. ...
		// 4. ...
		// 3. ...
		// 2. ...
		// 1. ...
		// 0. ...
		//
		// "of"
		// 12. [m] ...
		// 11. [a] ...
		// 10. [g] ...
		// 9.  [i] ...
		// 8.  [c] ...
		// 7. ... <-- USER CARD
		// 6. ...
		// 5. ...
		// 4. ...
		// 3. ...
		// 2. ...
		// 1. ...
		// 0. ...
	}
}

