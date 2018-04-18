package com.sorclab.magic;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.shuffle();
		ArrayList<Card> cards = deck.getDeck();
		
		PerformMagic perform = new PerformMagic(cards);
		perform.reduceCards();
		
		UI ui = new UI();
		ui.displayUserSelectOptions(cards);
		int userInput = ui.promptUserSelection();
		Card userCard = deck.getCard(userInput - 1);
		
		perform.plantUserCard(userInput);
		ui.displayUserSelectOptions(cards);
	}
}
