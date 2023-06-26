package HW_4;

public class Main {
  public static void main(String[] args) {
    RedBlackBinTree<Integer> bin_tree = new RedBlackBinTree<>();
    bin_tree.add(2);
    bin_tree.add(7);
    bin_tree.add(1);
    bin_tree.add(10);
    bin_tree.add(-1);
    bin_tree.add(-10);
    bin_tree.add(8);
    bin_tree.add(16);
    bin_tree.print();
  }
}
