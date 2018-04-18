package com.sorclab.magic;

import java.util.ArrayList;

public class PerformMagic implements MagicAction
{
	public static final int START_IDX = 9;
	public static final int END_IDX = 52;
	public static final int MAGIC_IDX = 2; // where userCard needs to start
	
	ArrayList<Card> cards;
	
	public PerformMagic(ArrayList<Card> cards) { this.cards = cards; }
	
	@Override
	public void reduceCards() { cards.subList(START_IDX, END_IDX).clear(); }

	@Override
	public void plantUserCard(int userInput)
	{
		int userCardIdx = userInput - 1;
		Card tmp = cards.get(MAGIC_IDX);
		cards.set(MAGIC_IDX, cards.get(userCardIdx));
		cards.set(userCardIdx, tmp);
	}
}
