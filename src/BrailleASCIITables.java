/**
 * Static methods for converting between binary Braille, ASCII, and Unicode Braille.
 * 
 * @author Tim Yu
 */
public class BrailleASCIITables {
  /**
   * A bit tree for converting ASCII to Braille bits (using the cell numbering method).
   */
  static BitTree asciiToBrailleTree;

  /**
   * A bit tree for converting Braille bits to ASCII characters
   */
  static BitTree brailleToAsciiTree;

  /**
   * A bit tree for converting Braille bits to their corresponding Unicode characters.
   */
  static BitTree brailleToUnicodeTree;

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille
   * character.
   */
  public static String toBraille(char letter) throws Exception {
    String binaryString = Integer.toBinaryString((int) letter);
    // our tree handles binary strings of length 8
    if (binaryString.length() < 8) {
      binaryString = "0".repeat(8 - binaryString.length()) + binaryString;
    }
    return asciiToBrailleTree.get(binaryString);
  }

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character.
   */
  public static String toASCII(String bits) throws Exception {
    return brailleToAsciiTree.get(bits);
  }

  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille
   * character for those bits. This method only supports six-bit braille characters.
   */
  public static String toUnicode(String bits) throws Exception {
    return new String(Character.toChars(Integer.parseInt(brailleToUnicodeTree.get(bits), 16)));
  }
}