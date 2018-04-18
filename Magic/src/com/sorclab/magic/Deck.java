package com.sorclab.magic;

import java.util.ArrayList;

public class Deck implements CardCollection
{
	public static final int SUIT_INDEX_MAX = 3;
	public static final int RANK_INDEX_MAX = 13;
	
	private ArrayList<Card> _deck;
	
	@SuppressWarnings("unused")
	private Card _card; // used in constructor...
	
	public Deck()
	{
		_deck = new ArrayList<Card>();	
		for (int suit = 0; suit <= SUIT_INDEX_MAX; suit++)
			for (int rank = 1; rank <= RANK_INDEX_MAX; rank++)
				_deck.add(_card = new Card(rank, suit));
	}
	
	@Override
	public int size() { return _deck.size(); }

	@Override
	public void swapCards() {}

	@Override
	public void shuffle() {}

	@Override
	public Card get(int index) { return _deck.get(index); }
}
