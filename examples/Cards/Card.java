public class Card
{
	public static final String[] SUITS = {
		"Clubs", "Diamonds", "Hearts", "Spades"
	};

	public static final String[] RANKS = {
		null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
		"Queen", "King"
	};

	private final int rank;
	private final int suit;

	public static void main(String[] args)
	{
		Card[] cards = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++)
		{
			for (int rank = 1; rank <= 13; rank++)
			{
				cards[index] = new Card(rank, suit);
				index++;
			}
		}

		Card card = new Card(11, 0);
		System.out.println(binarySearch(cards, card));
		System.out.println(card);
	}

	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}


	public String toString()
	{
		String str = RANKS[this.rank] + " of " + SUITS[this.suit];
		return str;
	}

	public boolean equals(Card that)
	{
		return this.rank == that.rank && this.suit == that.suit;
	}

	public int compareTo(Card that)
	{
		if (this.suit < that.suit)
		{
			return -1;
		}

		if (this.suit > that.suit)
		{
			return 1;
		}

		if (this.rank < that.rank)
		{
			return -1;
		}

		if (this.rank > that.rank)
		{
			return 1;
		}

		return 0;
	}

	public static void printDeck(Card[] cards)
	{
		for (int i = 0; i < cards.length; i++)
		{
			System.out.println(cards[i]);
		}
	}

	// Sequential search (for unsorted array)
	public static int search(Card[] cards, Card target)
	{
		for (int i = 0; i < cards.length; i++)
		{
			if (cards[i].equals(target))
			{
				return i;
			}
		}

		return -1;
	}

	// Binary search (for sorted array)
	public static int binarySearch(Card[] cards, Card target)
	{
		int low = 0;
		int high = cards.length - 1;

		while (low <= high)
		{
			// trace
			System.out.println(low + ", " + high);

			int mid = (low + high) / 2;                               // step 1
			int comp = cards[mid].compareTo(target);

			if (comp == 0)                                            // step 2
			{
				return mid;
			}
			else if (comp < 0)                                        // step 3
			{
				low = mid + 1;
			}
			else                                                      // step 4
			{
				high = mid - 1;
			}
		}

		return -1;
	}

	// Recursive binary search
	public static int binarySearch
		(Card[] cards, Card target, int low, int high)
	{
		if (high < low) { return -1; }
		int mid = (low + high) / 2;                                   // Step 1
		int comp = cards[mid].compareTo(target);

		if (comp == 0)                                                // Step 2
		{
			return mid;
		}
		else if (comp < 0)                                            // Step 3
		{
			return binarySearch(cards, target, mid + 1, high);
		}
		else                                                          // Step 4
		{
			return binarySearch(cards, target, low, mid - 1);
		}
	}

	// TODO: Add makeDeck(), no parms, returns fully-populated array of Cards
	// TODO: Impliment 2D library, see 12-4 (173)

}

