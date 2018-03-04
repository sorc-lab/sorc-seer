public class Deck
{
	private Card[] cards;

	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.print();
	}

	public Deck()
	{
		this.cards = new Card[52];
		int index = 0;

		for (int suit = 0; suit <= 3; suit++)
		{
			for (int rank = 1; rank <= 13; rank++)
			{
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	public void print()
	{
		for (int i = 0; i < this.cards.length; i++)
		{
			System.out.println(this.cards[i]);
		}
	}
}

