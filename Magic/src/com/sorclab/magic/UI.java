package com.sorclab.magic;

import java.util.ArrayList;
import java.util.Random;

public class UI implements Display
{
	@Override
	public void displayUserSelectOptions(ArrayList<Card> cards)
	{
		// needs exception handling--consumes cards
		int index = 1;
		for (Card card : cards) {
			System.out.println(index + ". " + card);
			index++;
		}
	}
	
	// automated in order to run program in loop for reports
	@Override
	public int promptUserSelection() { return new Random().nextInt(1) + 9; }
	
	@Override
	public void displayCards(ArrayList<Card> cards, Card userCard)
	{
		System.out.println();
		
		// violates DRY
		int index = 1;
		for (Card card: cards) {
			if (card.toString().equals(userCard.toString()))
				System.out.println(index + ". " + "->> " + card + " <<-");
			else
				System.out.println(index + ". " + card);
			index++;
		}
	}
}
