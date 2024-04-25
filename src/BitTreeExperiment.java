import java.io.PrintWriter;

/**
 * Experiments for the BitTree class
 * 
 * @author Tim Yu
 */
public class BitTreeExperiment {
  public static void expt1(PrintWriter pen) throws Exception {
    BitTree tree = new BitTree(3);

    pen.println("Starting experiment");
    tree.dump(pen);

    pen.println("Adding values");
    tree.set("000", "a");
    tree.set("001", "b");
    tree.set("010", "c");
    tree.set("011", "d");
    tree.set("100", "e");
    tree.set("101", "f");
    tree.set("110", "g");
    tree.set("111", "h");

    pen.println("Printing tree");
    tree.dump(pen);

    pen.println("Setting 000 to A");
    tree.set("000", "A");
    pen.println("Setting 101 to F");
    tree.set("101", "F");

    pen.println("Printing tree");
    tree.dump(pen);
  }

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    expt1(pen);
  }
}
