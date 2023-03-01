package cse360hw1task1;
//import java.util.Scanner;

/* Task 1 - Encryption of Vigenère cipher
 * @author Alireza Farhangi
 */
public class Task1 {
	public static void main(String[] args) {
		/*
		Scanner scan = new Scanner(System.in);
		// encryption testing by getting input from the user
		System.out.println("Please enter a plaintext:");
		String plainText = scan.nextLine();
		System.out.println("Please enter a cipher key:");
		String cipherKey = scan.nextLine();
		System.out.println("ciphertext: " + "\n" + encrypt(plainText , cipherKey) + "\n");
		*/
		String plainText = "Hello world123!";
		String cipherKey = "SECURITY";
		String cipherText = encrypt(plainText, cipherKey);
	}
	
	/* encrypt --
	 * this function receives the plain text and the cipher key. It then uses the cipher key to encrypt the message.
	 * @returns a string that contains the encrypted message.
	 */
	public static String encrypt(String plainText, String cipherKey)
	{
		// stores the encrypted message
		String encryptedText = "";
		// stores the encrypted character
		char encryptedChar;
		// checks whether the character is upper letter or lower letter
		boolean isUpper;
		// stores the asci value of each character of the plaintext
		int asciValText = 0;
		// stores the asci value of each character of the cipherkey
		int asciValKey = 0;
		// stores the asci value of how much a character of the plaintext needs to be shifted
		int asciValShift = 0;
		// stores the new asci value
		int newAsciVal = 0;
		// stores the number of iteration through the cipherkey 
		int count = 0;
		// loops through the plaintext
		for(int i = 0; i < plainText.length(); i++)
		{
			// checks whether the character is a letter of alphabet
			if(isAlphabet(plainText.charAt(i)))
			{
				// gets the asci value of a character of the key
				asciValKey = cipherKey.charAt(count);
				// subtract 65 from the asci value to see how much the character of the plaintext needs to be shifted
				// A - Z asci values are 65 - 90
				asciValShift = cipherKey.charAt(count) - 65;
				// checks if a letter is an upper or lower letter
				isUpper = Character.isUpperCase(plainText.charAt(i));
				// upper letter
				if(isUpper)
				{
					// gets the asci value
					asciValText = plainText.charAt(i);
					// calculates the new asci value by adding the shifted asci value to a plaintext character. 
					// It needs to be added because it's encryption and it's moving forwards in alphabet.
					newAsciVal = asciValText + asciValShift;
					// checks if the new asci value is greater than 90 (Z) which is the end of the alphabet
					if(newAsciVal > 90)
					{
						// needs to wrap around the alphabet since we passed Z, so it subtracts 90 from new asci value and adds 64 to it. 64 is one asci value before A
						newAsciVal = newAsciVal - 90;
						newAsciVal += 64;
					}
					// converts the asci value to a character and adds it to the encryptedText
					encryptedChar = (char) newAsciVal;
					encryptedText += encryptedChar;
					// goes to the next character of the key
					count ++;
				}
				// lower letter
				else
				{
					asciValText = plainText.charAt(i);
					newAsciVal = asciValText + asciValShift;
					// checks if the new asci value is greater than 122 (z) which is the end of the alphabet
					if(newAsciVal > 122)
					{
						// needs to wrap around the alphabet since we passed z, so it subtracts 122 from new asci value and adds 96 to it. 96 is one asci value before a
						newAsciVal = newAsciVal - 122;
						newAsciVal += 96;
					}
					// converts the asci value to a character and adds it to the encryptedText
					encryptedChar = (char) newAsciVal;
					encryptedText += encryptedChar;
					// goes to the next character of the key
					count ++;
					
				}
				// checks whether it's at the end of the cipherkey. If it's true, It sets the count to 0.
				if(count == cipherKey.length())
				{
					count = 0;
				}
			}
			// if a character of the plaintext is not a letter, it just simply adds it to the encrypted message and does nothing to it.
			else
			{
				encryptedText += plainText.charAt(i);
			}
		}
		// returns the encrypted text
		return encryptedText;
	}
	
	/* isAlphabet --
	 * checks if a character is an alphabet letter
	 * @returns true or false
	 */
	public static boolean isAlphabet(char character)
	{
		if((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
			return true;
		else
			return false;
	}
}