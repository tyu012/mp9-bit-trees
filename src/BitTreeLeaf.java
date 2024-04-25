/**
 * A "leaf" of a BitTree, which represents a mapping of a bit sequence to string.
 * 
 * @author Tim Yu
 */
public class BitTreeLeaf extends BitTreeNode {
  /**
   * Constructs a BitTree leaf with specified value.
   */
  public BitTreeLeaf(String value) {
    super();
    this.value = value;
  }

  /**
   * Returns the value of this leaf.
   */
  public String getValue() {
    return this.value;
  }
}
