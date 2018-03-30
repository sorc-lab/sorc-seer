package sorc.magic;

import java.util.Arrays;
import java.util.ArrayList;
import sorc.magic.Card;
import sorc.magic.Deck;

public class MagicDeck
{
	public ArrayList<Card> magicDeckList;
	public static final int MAGIC_DECK_SIZE = 13;
	public Card usrCardVal;
	public String[] magicDeck;
	
	// creates MagicDeck from original Deck (52 cards) & user selected card
	public MagicDeck(Deck origDeck, int usrCard)
	{
		magicDeckList = new ArrayList<Card>();
		Card[] cards = new Card[MAGIC_DECK_SIZE];
		usrCardVal = origDeck.get(usrCard);
		magicDeckList.add(usrCardVal); // usr card goes on top

		for (int i = 1; i < MAGIC_DECK_SIZE; i++) {
			magicDeckList.add(origDeck.get(i));
		}

		// convert ArrayList to String[] for custom sorting
		magicDeck = new String[MAGIC_DECK_SIZE];
		for (int i = 0; i < magicDeckList.size(); i++) {
			Card card = magicDeckList.get(i);
			magicDeck[i] = card.toString();
		}
	}

	public Card get(int index)
	{
		return magicDeckList.get(index);
	}

	public Card getUsrCard()
	{
		return usrCardVal;
	}
	
	public void sortDeck(String[] data)
	{
		int dataLength = data.length;
		String[] pile = new String[dataLength];

		for (int i = 0; i < pile.length; i++) {
			pile[i] = magicDeck[i];
		}
		
		// reverse pile
		for (int i = 0; i < pile.length / 2; i++) {
			String tmp = pile[i];
	  		pile[i] = pile[pile.length - i - 1];
			pile[pile.length - i - 1] = tmp;
		}

		magicDeck = Arrays.copyOfRange(
			magicDeck, dataLength, magicDeck.length
		);
		String[][] piles = {magicDeck, pile};
		magicDeck = concatPiles(piles);
		return;
	}

	static String[] concatPiles(String[][] arrays) {
		int length = 0;
		for (String[] array : arrays) {
			length += array.length;
		}

		String[] result = new String[length];
		int pos = 0;
		for (String[] array : arrays) {
			for (String element : array) {
				result[pos] = element;
				pos++;
			}
		}

		return result;
	}
}

