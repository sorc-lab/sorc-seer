package com.sorclab.magic;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.shuffle();
		ArrayList<Card> cards = deck.getCards();
		
		PerformMagic perform = new PerformMagic(cards);
		perform.reduceCards();
		
		UI ui = new UI();
		ui.displayUserSelectOptions(cards);
		int userInput = ui.promptUserSelection();
		Card userCard = deck.getCard(userInput - 1);
		
		perform.plantUserCard(userInput);

		/** Print meta data ================================================= */
		/*CardMetaData cardMetaData = new CardMetaData(userCard);
		String[][] data = cardMetaData.getCardMetaData();
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j <data[i].length; j++)
				System.out.println(data[i][j]);*/
		/** ================================================================= */
		
		CardMetaData cardMetaData = new CardMetaData(userCard);
		String[][] data = cardMetaData.getCardMetaData();
		
		ui.displayCards(cards, userCard);
		
		perform.sortCards(0, data);
		ui.displayCards(cards, userCard);

	}
}
