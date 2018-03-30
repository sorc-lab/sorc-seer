package sorc.magic;

import java.util.ArrayList;
import java.util.Random;
import sorc.magic.Card;

public class Deck
{
	public ArrayList<Card> deck;

	public Deck()
	{
		deck = new ArrayList<Card>();
		Card[] cards = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}

		for (int i = 0; i < cards.length; i++) {
			deck.add(cards[i]);
		}
	}

	public int size()
	{
		return deck.size();
	}

	public void swapCards(int i, int j) {
		Card tmp = deck.get(i);
		deck.set(i, deck.get(j));
		deck.set(j, tmp);
	}

	public void shuffle()
	{
		Random rand = new Random();
		for (int i = size() - 1; i > 0; i--) {
			int j = rand.nextInt(i);
			swapCards(i, j);

		}
	}

	public Card get(int index)
	{
		return deck.get(index);
	}
}
