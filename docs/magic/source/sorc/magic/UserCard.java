package sorc.magic;

public class UserCard
{
	public String usrCard;

	public UserCard(Card usrSelectedCard)
	{
		usrCard = usrSelectedCard.toString();
	}

	public String[] getSuit()
	{
		String[] arr = usrCard.split(" ");
		String[] suit = arr[2].split("");
		return suit;
	}

	public String[] getRank()
	{
		String[] arr = usrCard.split(" ");
		String rankStr = arr[0];
		
		switch(rankStr) {
			case ("2"):
				rankStr = "Two";
				break;
			case ("3"):
				rankStr = "Three";
				break;
			case ("4"):
				rankStr = "Four";
				break;
			case ("5"):
				rankStr = "Five";
				break;
			case ("6"):
				rankStr = "Six";
				break;
			case ("7"):
				rankStr = "Seven";
				break;
			case ("8"):
				rankStr = "Eight";
				break;
			case ("9"):
				rankStr = "Nine";
				break;
			case ("10"):
				rankStr = "Ten";
				break;
			default:
				rankStr = rankStr;
				break;
		}

		String[] rank = rankStr.split("");
		return rank;
	}

	public String[] getOf()
	{
		String[] of = {"o", "f"};
		return of;
	}

	public String[] getMagic()
	{
		String[] magic = {"m", "a", "g", "i", "c"};
		return magic;
	}

	public String[][] getUserCard()
	{
		String[] rank  = getRank();
		String[] of    = getOf();
		String[] suit  = getSuit();
		String[] magic = getMagic();

		String[][] usrCard = {rank, of, suit, magic};
		return usrCard;

	}
}








































