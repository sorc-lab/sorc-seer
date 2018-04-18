package com.sorclab.magic;

import java.util.ArrayList;

public interface Display
{
	void displayUserSelectOptions(ArrayList<Card> cards);
	int promptUserSelection();
	void displayCards(ArrayList<Card> cards, Card userCard);
}
