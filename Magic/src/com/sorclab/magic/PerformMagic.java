package com.sorclab.magic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

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

	@Override
	public void sortCards(int mode, String[][] cardMetaData)
	{
		System.out.println("\nSorting cards...");
		System.out.println("mode = " + mode);
		
		String[] data = cardMetaData[mode];
		System.out.println("data = " + Arrays.toString(data));		
		ArrayList<Card> pile = new ArrayList<Card>();
		for (int i = 0; i < data.length; i++) {
			pile.add(cards.get(i));
		}
		Collections.reverse(pile);
		
		System.out.println("\n=== SORT PILE ===");
		for (int i = 0; i < pile.size(); i++) {
			System.out.println(pile.get(i));
		}
		
		cards.subList(0, data.length).clear();
		
		System.out.println("\n=== MAIN PILE ===");
		for (int i = 0; i < cards.size(); i++) {
			System.out.println(cards.get(i));
		}
		
		System.out.println("\n Merging SORT PILE and MAIN PILE...");
		cards.addAll(pile);
	}
}
