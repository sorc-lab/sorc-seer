import java.util.Random;

public class Deck
{
	private Card[] cards;
	public static final Random rand = new Random();

	public Deck(int n) {
		this.cards = new Card[n];
	}

	public Deck() {
		this.cards = new Card[52];
		int index = 0;

		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}

	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	public static int randomInt(int low, int high) {
		return rand.nextInt((high - low) + 1);
	}

	/** ==================================================================== */
	// public Deck mergeSort() { (recursive)
	//		if the deck is 0 or 1 cards, return it
	//		divide the deck into two subdecks
	//		sort the subdecks using mergeSort
	//		merge the two halves and return the result
	// }

	// public Deck almostMergeSort() {
	//		divide the deck into two subdecks
	//		sort the subdecks using selectionSort
	//		merge the two havles and return the result
	// }

	// public static Deck merge(Deck d1, Deck d2) {
	// 		Create a new deck big enough for all the cards
	//		
	//		Use the index i to keep track of where we are at in
	//		the first deck, and in the index j for the second deck
	//		int i = 0;
	//		int j = 0;
	//
	//		the index k traverses the result deck
	//		for (int k = 0; k < result.cards.length; k++) {
	//
	//			if d1 is empty, d2 wins
	//			if d2 is empty, d1 wins
	//			otherwise, compare the two cards
	//
	//			add the winner to the new deck at position k
	//			increment either i or j
	//		}
	//		return the new deck
	// }
	
	// public void swapCards() {
	// 		for each index i {
	// 			Choose a random number between 1 and length -1
	// 			Swap the ith card and the randomly-chosen card
	// 		}
	// }

	// public void selectionSort() {
	//		for each index i {
	//			Find the lowest card at or to the right of i(method: indexLowest)
	//			Swap the ith card and the lowest card found
	// 		}
	// }
}

