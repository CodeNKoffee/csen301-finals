package eleven;

public class ExerciseFour {
  class Node {
    int data;
    Node left, right;

    public Node(int newObj) {
      data = newObj;
      left = right = null;
    }
  }

  class BTree {
    Node root;
  }

  public static void mirror(BTree tree) {
    mirror(tree.root);
  }

  private static void mirror(Node node) {
    if (node != null) {
      mirror(node.left);
      mirror(node.right);
      Node temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
  }
}
