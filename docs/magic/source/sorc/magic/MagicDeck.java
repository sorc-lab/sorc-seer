package sorc.magic;

import java.util.ArrayList;
import sorc.magic.Card;
import sorc.magic.Deck;

public class MagicDeck
{
	public ArrayList<Card> magicDeck;
	public static final int MAGIC_DECK_SIZE = 13;
	public Card usrCardVal;
	
	// creates MagicDeck from original Deck (52 cards) & user selected card
	public MagicDeck(Deck origDeck, int usrCard)
	{
		magicDeck = new ArrayList<Card>();
		Card[] cards = new Card[MAGIC_DECK_SIZE];
		usrCardVal = origDeck.get(usrCard);
		magicDeck.add(usrCardVal); // usr card goes on top

		for (int i = 1; i < MAGIC_DECK_SIZE; i++) {
			magicDeck.add(origDeck.get(i));
		}
	}

	public Card get(int index)
	{
		return magicDeck.get(index);
	}

	public Card getUsrCard()
	{
		return usrCardVal;
	}
}
