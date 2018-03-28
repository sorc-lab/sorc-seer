public class Recurse
{

	/**
	 * 1. Write some code in main that tests each of these methods. Make sure
	 *    they work, and you understand what they do.
	 * 2. Using these methods, and without using any other String methods,
	 *    write a method called printString that takes a string as a parameter
	 *    and that displays the letters of the string, one on each line. It
	 *    should be a void method.
	 * 3. Again using only these methods, write a method called printBackward
	 *    that does the same thing as printString but that displays the string
	 *    backward (again, one character per line).
	 * 4. Now write a method called reverseString that takes a string as a
	 *    parameter and that returns a new string as a return value. The new
	 *    string should contain the same letters as the parameter, but in
	 *    reverse order.
	 *    String backwards = reverseString("coffee");
	 *    System.out.println(backwards);
	 *    The output of this example code should be:
	 *    	eeffoc
	 * 5. A palindrome is a word that reads the same both forward and backward,
	 *    like "otto" and "palindromeemordnilap". Here’s one way to test
	 *	  whether a string is a palindrome:
	 * 	  	A single letter is a palindrome, a two-letter word is a palindrome
	 *		if the letters are the same, and any other word is a palindrome if
	 *		the first letter is the same as the last and the middle is a
	 *		palindrome.
	 *	  Write a recursive method named isPalindrome that takes a String and
	 *	  returns a boolean indicating whether the word is a palindrome.
	 */
	public static void main(String[] args)
	{
		// test methods
		String test = "test";
		System.out.println(first(test));
		System.out.println(rest(test));
		System.out.println(middle(test));
		System.out.println(length(test));
	}
	
	/**
	 * Returns the first character of the given string.
	 */
	public static char first(String str)
	{
		return str.charAt(0);
	}
	
	/**
	 * Returns all but the first letter of the given string.
	 */
	public static String rest(String str)
	{
		return str.substring(1);
	}
	
	/**
	 * Returns all but the first and last letter of the given string.
	 */
	public static String middle(String str)
	{
		return str.substring(1, str.length() - 1);
	}
	
	/**
	 * Returns the length of the given string.
	 */
	public static int length(String str)
	{
		return str.length();
	}
}
