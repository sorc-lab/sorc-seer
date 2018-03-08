public class Test
{
	private static final Deck deck = new Deck();

	public static void main(String[] args) {
		/** Test merge() */
		// build and shuffle a deck
		// use subDeck() to form two small subdecks
		// use selectionSort on the two subdecks
		// pass the two subdecks into merge() and test
		
		deck.shuffle();

		Deck sub1 = deck.subdeck(0, 20);
		Deck sub2 = deck.subdeck(21, 51);

		System.out.println(sub1);
		System.out.println(sub2);

		sub1.print();
		System.out.println();
		sub2.print();

		System.out.println(sub1.checkDuplicateCards());
		System.out.println(sub2.checkDuplicateCards());





		/*
		System.out.println("Executing swapCards algorithm...");
		
		long startTime = System.currentTimeMillis();
		System.out.println("startTime = " + startTime);
		
		deck.shuffle();

		long endTime = System.currentTimeMillis();
		System.out.println("endTime = " + endTime);

		long duration = (endTime - startTime);
		System.out.println("duration = " + duration + " milliseconds" + "\n");

		System.out.println("Checking for card duplicates...");
		if (deck.checkDuplicateCards()) {
			System.out.println("ERROR: System found duplicate cards.");
		} else {
			System.out.println("No duplicates found.");
		}
		
		//System.out.println();
		//deck.print();
		*/
	}
}
