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
  int nBits;

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
    this.nBits = n;
    this.root = new BitTreeNode();
  }

  // +---------+------------------------------------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value.
   * 
   * @throws Exception if bits has incorrect length.
   */
  public void set(String bits, String value) throws Exception {
    if (bits.length() != nBits) {
      throw new Exception("set: invalid bits length");
    }
    set(bits, 0, value, root);
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end.
   * 
   * @throws Exception if there is no such path, or bits has incorrect length.
   */
  public String get(String bits) throws Exception {
    if (bits.length() != nBits) {
      throw new Exception("get: invalid length");
    }
    return get(bits, 0, root);
  }

  // +---------+------------------------------------------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Follows the path through the subtree starting from the ith character (left-to-right) of bits,
   * returning the value at the end.
   * 
   * If i >= bits.length(), then we return the subtree's value.
   * Note that checking for valid length is handled by caller.
   */
  public String get(String bits, int i, BitTreeNode subtree) throws Exception {
    // Base cases
    if (subtree == null) {
      throw new Exception("get: path not found");
    }

    if (i >= bits.length()) {
      return subtree.value;
    }

    // Recursive cases
    switch (Integer.valueOf(bits.charAt(i))) {
      case 0:
        return get(bits, i + 1, subtree.left);
      case 1:
        return get(bits, i + 1, subtree.right);
      default:
        throw new Exception("get: invalid bit");
    }
  }

  /**
   * Follows the path through the subtree starting from the ith character (left-to-right) of bits,
   * adding nodes if necessary and replacing the value at the end with given value.
   */
  public void set(String bits, int i, String value, BitTreeNode subtree) throws Exception {
    // Base cases
    if (subtree == null) {
      throw new Exception("set: cannot set from a null subtree");
    }

    if (i >= bits.length()) {
      subtree.value = value;
    }

    // Recursive cases

    // Determine traversal direction
    boolean leftTraversal;
    switch (Integer.valueOf(bits.charAt(i))) {
      case 0:
        leftTraversal = true;
        break;
      case 1:
        leftTraversal = false;
        break;
      default:
        throw new Exception("set: invalid bit");
    }

    // Determine if we need to create a tree node before we traverse
    boolean nextNodeIsLeaf = i >= bits.length() - 1;
    if (leftTraversal && subtree.left == null) {
      subtree.left = nextNodeIsLeaf ? new BitTreeLeaf(value) : new BitTreeNode();
    } else if (!leftTraversal && subtree.right == null) {
      subtree.right = nextNodeIsLeaf ? new BitTreeLeaf(value) : new BitTreeNode();
    }

    if (leftTraversal) {
      set(bits, i + 1, value, subtree.left);
    } else {
      set(bits, i + 1, value, subtree.right);
    }
  }


}