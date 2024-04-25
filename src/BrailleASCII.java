import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Main class that takes two command-line parameters (target character set: braille, ascii, unicode,
 * source characters), and then translates the text.
 * @author Tim Yu
 */
public class BrailleASCII {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // set up BitTrees
    BitTree brailleAscii = new BitTree(6);
    BitTree brailleUnicode = new BitTree(6);
    BitTree asciiBraille = new BitTree(8);

    // open files
    try {
      FileInputStream brailleAsciiF = new FileInputStream(new File("./braille-ascii.txt"));
      FileInputStream brailleUnicodeF = new FileInputStream(new File("./braille-unicode.txt"));
      FileInputStream asciiBrailleF = new FileInputStream(new File("./ascii-braille.txt"));

      brailleAscii.load(brailleAsciiF);
      brailleUnicode.load(brailleUnicodeF);
      asciiBraille.load(asciiBrailleF);

      brailleAsciiF.close();
      brailleUnicodeF.close();
      asciiBrailleF.close();
    } catch (Exception e) {
      pen.println("Could not open file.");
      pen.println(e.getMessage());
      return;
    }

    // Add bit trees to BrailleASCIITables
    BrailleASCIITables.brailleToAsciiTree = brailleAscii;
    BrailleASCIITables.brailleToUnicodeTree = brailleUnicode;
    BrailleASCIITables.asciiToBrailleTree = asciiBraille;

    // read user input
    String targetCharSet = args[0];
    String source = args[1];
    String converted = "";
    
    // process user input
    try {
      if (targetCharSet.equals("braille")) {
        // ASCII -> Braille
        for (char c : source.toCharArray()) {
          converted += BrailleASCIITables.toBraille(c);
        }
      } else if (targetCharSet.equals("ascii")) {
        // Braille -> ASCII
        for (String bits : brailleArray(source)) {
          converted += BrailleASCIITables.toASCII(bits);
        }
        converted = converted.toLowerCase();
      } else if (targetCharSet.equals("unicode")) {
        // ASCII -> Braille -> Unicode
        for (char c : source.toCharArray()) {
          String brailleString = BrailleASCIITables.toBraille(c);
          converted += BrailleASCIITables.toUnicode(brailleString);
        }
      } else {
        pen.println("Invalid target character set. Must be braille, ascii, or unicode.");
        return;
      }
    } catch (Exception e) {
      pen.println("Invalid source input.");
      pen.println(e.getMessage());
    }

    // Print converted string
    pen.println(converted);
  }

  /**
   * Converts a string of continuous braille (in 6-bit binary representation) to
   * an array list of individual 6-bit braille strings.
   */
  public static ArrayList<String> brailleArray(String braille) {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < braille.length(); i += 6) {
      list.add(braille.substring(i, i + 6));
    }
    return list;
  }
}