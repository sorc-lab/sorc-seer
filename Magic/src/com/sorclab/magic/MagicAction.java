package com.sorclab.magic;

public interface MagicAction
{
	void reduceCards();
	void plantUserCard(int userInput);
	void sortCards(int mode, String[][] cardMetaData);
}
