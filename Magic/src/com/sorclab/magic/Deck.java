package com.sorclab.magic;

import java.util.ArrayList;
import java.util.Random;

public class Deck implements CardCollection, DeckAction
{
	public static final int SUIT_INDEX_MAX = 3;
	public static final int RANK_INDEX_MAX = 13;
	
	private ArrayList<Card> _cards;
	
	@SuppressWarnings("unused")
	private Card _card; // used in constructor...
	
	public Deck()
	{
		_cards = new ArrayList<Card>();	
		for (int suit = 0; suit <= SUIT_INDEX_MAX; suit++)
			for (int rank = 1; rank <= RANK_INDEX_MAX; rank++)
				_cards.add(_card = new Card(rank, suit));
	}
	
	@Override
	public int size() { return _cards.size(); }

	@Override
	public void swapCards(int i, int j)
	{
		Card tmp = getCard(i);
		_cards.set(i, getCard(j));
		_cards.set(j, tmp);
	}

	@Override
	public void shuffle()
	{
		Random rand = new Random();
		for (int i = size() - 1; i > 0; i--) {
			int j = rand.nextInt(i);
			swapCards(i, j);
		}
	}

	@Override
	public Card getCard(int index) { return _cards.get(index); }
	
	@Override
	public ArrayList<Card> getCards() { return _cards; }
}
