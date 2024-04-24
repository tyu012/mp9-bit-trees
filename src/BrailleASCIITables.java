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
    return asciiToBrailleTree.get(Integer.toBinaryString((int) letter));
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
  public String toUnicode(String bits) throws Exception {
    return new String(Character.toChars(Integer.parseInt(brailleToUnicodeTree.get(bits), 16)));
  }
}