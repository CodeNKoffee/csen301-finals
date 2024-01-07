class Node {
  int data;
  Node left, right;

  Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }
}

class BTree {
  Node root1;
  Node root2;

  public void mergeBSTs(StackObj stack) {
    mergeBSTs(root1, root2);
  }

  private static void mergeBSTs(Node root1, Node root2) {
    ArrayStack s1 = new ArrayStack(99);
    ArrayStack s2 = new ArrayStack(99);

    while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
      while (root1 != null) {
        s1.push(root1.data);
        root1 = root1.left;
      }
      while (root2 != null) {
        s2.push(root2.data);
        root2 = root2.left;
      }

      if (s2.isEmpty() || (!s1.isEmpty() && s1.top() <= s2.top())) {
        int value = s1.top();
        s1.pop();
        System.out.print(value + " ");
        root1 = new Node(value);
        root1.right = null;  // Set right child to null to avoid infinite loop
        root1.left = null;   // Set left child to null to avoid infinite loop
        root1 = root1.right;
      } else {
        int value = s2.top();
        s2.pop();
        System.out.print(value + " ");
        root2 = new Node(value);
        root2.right = null;  // Set right child to null to avoid infinite loop
        root2.left = null;   // Set left child to null to avoid infinite loop
        root2 = root2.right;
      }
    }
  }

  public static void main(String[] args) {
    Node root1 = null, root2 = null;

    root1 = new Node(3);
    root1.left = new Node(1);
    root1.right = new Node(5);
    root1.right = new Node(7);

    root2 = new Node(4);
    root2.left = new Node(2);
    root2.right = new Node(6);
    root2.right = new Node(8);

    mergeBSTs(root1, root2);
  }
}
