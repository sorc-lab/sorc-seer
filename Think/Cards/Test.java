public class Test
{
	//private static final Deck deck = new Deck();

	public static void main(String[] args) {

		Eights game = new Eights();
		game.playGame();

		/** mergeSort Perf. Test */
		/*deck.shuffle();
		
		System.out.println("Executing recursive mergeSort...");
		long startTime = System.currentTimeMillis();
		System.out.println("startTime = " + startTime);

		deck.mergeSort();

		long endTime = System.currentTimeMillis();
		System.out.println("DONE!");
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
		//deck.mergeSort().print();*/
	}
}
