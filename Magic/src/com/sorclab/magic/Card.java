package com.sorclab.magic;

public class Card
{
	public static final String[] SUITS = {
		"Clubs", "Diamonds", "Hearts", "Spades"
	};
	
	public static final String[] RANKS = {
		null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
		"Queen", "King"
	};
	
	private final int _rank;
	private final int _suit;
	
	public Card(int rank, int suit)
	{
		this._rank = rank;
		this._suit = suit;
	}
	
	public String toString()
	{
		String str = RANKS[_rank] + " of " + SUITS[_suit];
		return str;
	}
}
