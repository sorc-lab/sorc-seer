public class Test
{
	private static final Deck deck = new Deck();

	public static void main(String[] args) {
		System.out.println("Executing swapCards algorithm...");
		deck.swapCards();
		System.out.println("swapCards DONE.");

		System.out.println("Checking for card duplicates...");
		if (deck.checkDuplicateCards()) {
			System.out.println("ERROR: System found duplicate cards.");
		}

		deck.print();
	}
}
