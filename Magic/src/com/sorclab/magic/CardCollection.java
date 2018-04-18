package com.sorclab.magic;

import java.util.ArrayList;

public interface CardCollection
{
	int size();
	void swapCards(int i, int j);
	void shuffle();
	Card getCard(int index);
	ArrayList<Card> getDeck();
}
