package com.sorclab.magic;

import java.io.Console;
import java.util.ArrayList;

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
	
	@Override
	public int promptUserSelection()
	{
		System.out.println();
		Console console = System.console();
		int userInput = Integer.parseInt(console.readLine("Choose a card: "));
		return userInput;
	}
}
