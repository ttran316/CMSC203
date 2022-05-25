public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		int total = 0;
		int needed = plainText.length();
		char checker;
		for(int i = 0; i < plainText.length(); i++) {
			//Check each char in plainText and run it through to see if between bounds
			checker = plainText.charAt(i);
			if(checker >= LOWER_BOUND && checker <= UPPER_BOUND) {
				total++;
			}
		}
		//Needed is number of trues we need which is every char in plainText
		if(total == needed) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		int shift;
		char plain, secret;
		String secretText = "";
		for(int i = 0; i < plainText.length(); i++) {
			plain = plainText.charAt(i);
			shift = (int)plain + key;
			while(shift > UPPER_BOUND) {
				shift -= RANGE;
			}
			secret = (char)shift;
			secretText += secret;
		}
		return secretText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		int shift, plain; 
		char secret;
		String secretText = "";
		for(int i = 0; i < plainText.length(); i++) {
			plain = (int)plainText.charAt(i);
			shift = plain + (int)bellasoStr.charAt(i%bellasoStr.length());
			while(shift > UPPER_BOUND) {
				shift -= RANGE;
			}
			secret = (char)shift;
			secretText += secret;
		}
		return secretText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		int shift;
		char plain, secret;
		String plainText = "";
		for(int i = 0; i < encryptedText.length(); i++) {
			secret = encryptedText.charAt(i);
			shift = (int)secret - key;
			while(shift < LOWER_BOUND) {
				shift += RANGE;
			}
			plain = (char)shift;
			plainText += plain;
		}
		return plainText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		int shift, secret; 
		char plain;
		String plainText = "";
		for(int i = 0; i < encryptedText.length(); i++) {
			secret = (int)encryptedText.charAt(i);
			shift = secret - (int)bellasoStr.charAt(i%bellasoStr.length());
			while(shift < LOWER_BOUND) {
				shift += RANGE;
			}
			plain = (char)shift;
			plainText += plain;
		}
		return plainText;
	}
}