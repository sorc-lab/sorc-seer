public class Test
{
	private static final Deck deck = new Deck();

	public static void main(String[] args) {
		deck.shuffle();
		deck.mergeSort().print();


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
