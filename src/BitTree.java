import java.util.NoSuchElementException;

/**
 * A tree data structure intended to store mappings from bits to values.
 * 
 * @author Tim Yu
 */
public class BitTree {
  // +--------+-------------------------------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The number of bits that will be mapped to values.
   */
  int bits;

  /**
   * The root node of the BitTree.
   */
  BitTreeNode root;

  // +--------------+-------------------------------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds a tree that will store mappings from strings of n bits to strings.
   */
  public BitTree(int n) {
    this.bits = n;
    this.root = null;
  }

  // +---------+------------------------------------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value.
   * 
   * @throws IllegalArgumentException if bits has incorrect length.
   */
  public void set(String bits, String value) throws IllegalArgumentException {
    throw new IllegalArgumentException("stub");
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end.
   * 
   * @throws NoSuchElementException if there is no such path, or bits has incorrect length.
   */
  public String get(String bits) throws NoSuchElementException {
    throw new NoSuchElementException("stub");
  }

  // +---------+------------------------------------------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Returns a subtree recursively from the last n digits of a string of bits.
   */
  public BitTreeNode subtree(String bits, int n) {
    return null; // STUB
  }

}