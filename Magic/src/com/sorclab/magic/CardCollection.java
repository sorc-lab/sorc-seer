package com.sorclab.magic;

public interface CardCollection
{
	int size();
	void swapCards();
	void shuffle();
	Card get(int index);
}
