package com.sorclab.magic;

import java.util.ArrayList;

public class Main
{
	public static final int LOOP_CNT = 4;
	public static final int RUN_CNT = 10;
	
	public static void main(String[] args)
	{
		for (int i = 0; i < RUN_CNT; i++) {
			System.out.println();
			System.out.println(",-------------------------------------------.");
			System.out.println("|                                           |");
			System.out.println("|           START ROUND: " + i + "          |");
			System.out.println("|                                           |");
			System.out.println("`-------------------------------------------'");
			
			Deck deck = new Deck();
			deck.shuffle();
			ArrayList<Card> cards = deck.getCards();
			
			PerformMagic perform = new PerformMagic(cards);
			perform.reduceCards();
			
			UI ui = new UI();
			ui.displayUserSelectOptions(cards);
			int userInput = ui.promptUserSelection();
			Card userCard = deck.getCard(userInput - 1);
			
			System.out.println("\nCard chosen: " + userCard);
			perform.plantUserCard(userInput);
			
			CardMetaData cardMetaData = new CardMetaData(userCard);
			String[][] data = cardMetaData.getCardMetaData();
			
			ui.displayCards(cards, userCard);
			
			for (int j = 0; j < LOOP_CNT; j++) {
				perform.sortCards(j, data);
				ui.displayCards(cards, userCard);
			}
			System.out.println();
			System.out.println(",-------------------------------------------.");
			System.out.println("|                                           |");
			System.out.println("|             END ROUND: " + i + "          |");
			System.out.println("|                                           |");
			System.out.println("`-------------------------------------------'");
		}
	}
}
