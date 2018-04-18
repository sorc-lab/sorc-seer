package com.sorclab.magic;

public class Main
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		Card card = deck.get(21);
		System.out.println(card);
	}
}
