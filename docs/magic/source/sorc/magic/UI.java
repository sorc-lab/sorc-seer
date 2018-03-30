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
		Card usrCard = magicDeck.getUsrCard();

		int size = magicDeck.MAGIC_DECK_SIZE;
		for (int i = 0; i < size; i++) {
			Card card = magicDeck.get(i);

			if (card.equals(magicDeck.usrCardVal)) {
				System.out.println(i + ". " + "--> " + card + " <--");
			}
			else {
				System.out.println(i + ". " + card);
			}
		}
	}
}
