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

	public static void printMagicDeck
	(String[] magicDeck, MagicDeck magicDeckObj)
	{
		int size = magicDeckObj.MAGIC_DECK_SIZE;
		for (int i = 0; i < size; i++) {
			if (magicDeck[i].equals(magicDeckObj.usrCardVal.toString())) {
				System.out.println(i + ". " + "--> " + magicDeck[i] + " <--");
			}
			else {
				System.out.println(i + ". " + magicDeck[i]);
			}
		}
		System.out.println();
	}
	
	// TODO: refactor to not have to use the magicDeck
	public static void printSortedDeck (String[] deck, MagicDeck magicDeck)
	{
		int size = magicDeck.MAGIC_DECK_SIZE;
		for (int i = 0; i < size; i++) {
			if (deck[i].trim().equals(magicDeck.usrCardVal.toString())) {
				System.out.println(i + ". " + "--> " + deck[i] + " <--");
			}
			else {
				System.out.println(i + ". " + deck[i]);
			}
		}
		System.out.println();
	}

	/*public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}*/
}
