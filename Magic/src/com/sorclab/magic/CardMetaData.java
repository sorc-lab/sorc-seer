package com.sorclab.magic;

public class CardMetaData
{
	@SuppressWarnings("unused")
	private Card _card; // used in constructor
	
	private String[] _splitData;
	
	public CardMetaData(Card card)
	{
		this._card = card;
		String cardStr = card.toString();
		_splitData = cardStr.split(" ");
	}
	
	private String[] _getSuit()
	{
		String[] suit = _splitData[2].split("");
		return suit;
	}
	
	private String[] _getRank()
	{
		String rankStr = _splitData[0];	
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
				break;
		}
		String[] rank = rankStr.split("");
		return rank;
	}
	
	private String[] _getOf()
	{
		String[] of = {"o", "f"};
		return of;
	}
	
	private String[] _getMagic()
	{
		String[] magic = {"m", "a", "g", "i", "c"};
		return magic;
	}
	
	public String[][] getCardMetaData()
	{
		String[][] cardMetaData = {
			_getRank(), _getOf(), _getSuit(), _getMagic()
		};
		return cardMetaData;
	}
}
