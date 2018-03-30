package sorc.magic;

import sorc.magic.Deck;
import java.io.Console;

public class UI
{
	public static void printCardSelection(Deck deck)
	{
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(i + ". " + deck.get(i));
		}
	}

	public static int getSelectedCard(Deck deck) {
		Console console = System.console();
		System.out.println();
		int usrInput = Integer.parseInt(console.readLine("Choose a card: "));
		return usrInput;
	}

	public static void printMagicDeck(MagicDeck magicDeck)
	{
		int size = magicDeck.MAGIC_DECK_SIZE;
		for (int i = 0; i < size; i++) {
			System.out.println(magicDeck.get(i));
			// TODO: Add an arrow pointing to usr card
		}
	}
}
