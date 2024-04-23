/**
 * A node of a BitTree which either represents a bit or mapping of a bit sequence to string.
 * 
 * @author Tim Yu
 */
public class BitTreeNode {
  String value;
  BitTreeNode left;
  BitTreeNode right;

  /**
   * Constructs an empty BitTreeNode.
   */
  public BitTreeNode() {
    this.value = null;
    this.left = null;
    this.right = null;
  }
}
