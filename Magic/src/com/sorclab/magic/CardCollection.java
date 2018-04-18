package com.sorclab.magic;

import java.util.ArrayList;

public interface CardCollection
{
	int size();
	Card getCard(int index);
	ArrayList<Card> getDeck();
}
