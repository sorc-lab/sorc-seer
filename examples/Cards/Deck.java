import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

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
	
	// 36 milliseconds runtime
	public void swapCards() {
		ArrayList<Integer> tracker = new ArrayList<Integer>();
		int rand = this.randomInt(0, this.cards.length - 1);

		for (int i = 0; i < this.cards.length; i++) {
			if (i == 0)
				tracker.add(rand);

			while (tracker.contains(rand)) {
				rand = this.randomInt(0, this.cards.length - 1);

				if (!tracker.contains(rand)) {
					tracker.add(rand);
					break;
				} else if (tracker.size() == 52) {
					break;
				}
			}
		}
		
		Card[] newCards = new Card[52];
		int trackerNum;
		for (int i = 0; i < newCards.length; i++) {
			trackerNum = tracker.get(i);
			newCards[trackerNum] = this.cards[i];
		}

		this.cards = newCards;
	}
	
	// 34 milliseconds runtime
	public void swapCards(int i, int j) {
		Card tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}

	public void selectionSort() {
		for (int i = 0; i < cards.length - 1; i++) {
			swapCards(i, indexLowest(i, cards.length - 1));
		}
	}

	public int indexLowest(int low, int high) {
		int index = Math.min(low, high);

		for (int i = index + 1; i <= Math.max(low, high); i++) {
			if (cards[index].compareTo(cards[i]) == 1) {
				index = i;
			}
		}

		return index;
	}

	public boolean checkDuplicateCards() {
		boolean duplicates = false;
		for (int j = 0; j < this.cards.length; j++) {
			for (int k = j + 1; k < this.cards.length; k++) {
		    	if (k != j && this.cards[k].equals(this.cards[j])) {
					System.out.println(
						"DUPLICATE FOUND: "+this.cards[k]+" & "+this.cards[j]
					);
					return true;
			  	}
			}
		}
		
		return false;
	}

	public void shuffle() {
		for (int i = 0; i < this.cards.length; i++) {
			swapCards(i, randomInt(0, this.cards.length - 1));
		}
	}

	public Deck mergeSort() {
		int len = cards.length;
		if (len == 0 || len == 1) {
			return this;
		} else {
			int mid = len / 2;
			Deck d1 = subdeck(0, mid - 1).mergeSort();
			Deck d2 = subdeck(mid, len - 1).mergeSort();

			return merge(d1, d2);
		}

	}

	public Deck merge(Deck d1, Deck d2) {
		Card[] c1 = d1.getCards();
		Card[] c2 = d2.getCards();
		int c1Len = c1.length;
		int c2Len = c2.length;

		Card[] sorted = new Card[c1Len + c2Len];
		int i = 0; // d1 index
		int j = 0; // d2 index

		if (c1Len == 0) {
			sorted = c2;
		} else if (c2Len == 0) {
			sorted = c1;
		} else {
			for (int k = 0; k < sorted.length; k++) {
				// if d1 is empty, d2 wins
				// if d2 is empty, d1 wins
				// otherwise, compare the two cards
				if (j >= c2Len || i < c1Len && c1[i].compareTo(c2[j]) <= 0) {
					sorted[k] = c1[i];
					i++;
				} else {
					sorted[k] = c2[j];
					j++;
				}
			}
		}

		Deck deck = new Deck(c1Len + c2Len);
		deck.cards = sorted;

		return deck;
	}

	public Card[] getCards() {
		return this.cards;
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
	

}

