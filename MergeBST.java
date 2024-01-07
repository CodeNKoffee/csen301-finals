// SOURCE: GeeksForGeeks: (https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/)
// DO NOT ATTEMPT TO USE THIS SOLUTION 100% AS IT HAS TYPE-CASTING ISSUE FROM INT TO NODE. WILL BE FIXED ASAP

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BTree {
  Node root1;
  Node root2;

  public void mergeBSTs(StackObj stack) {
    mergeBSTs(root1, root2);
  }

  private void mergeBSTs(Node root1, Node root2) {
    ArrayStack s1 = new ArrayStack(Integer.MAX_VALUE);
    ArrayStack s2 = new ArrayStack(Integer.MAX_VALUE);

    while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
      while (root1 != null) {
        // CHECK COMMENT AT THE TOP IF YOU HAVENT
        s1.push(root1);
        root1 = root1.left;
      }
      while (root2 != null) {
        s2.push(root2);
        root2 = root2.left;
      }

      if (s2.isEmpty() || (!s1.isEmpty() && s1.top().data <= s2.top().data)) {
        root1 = s1.top();
        s1.pop();
        System.out.print(root1.data + " ");
        root1 = root1.right;
      } else {
        root2 = s2.top();
        s2.pop();
        System.out.print(root2.data + " ");
        root2 = root2.right;
      }
    }
  }

  public static void main(String[] args) {
      Node root1 = null, root2 = null;

      root1 = new Node(3);
      root1.left = new Node(1);
      root1.right = new Node(5);

      root2 = new Node(4);
      root2.left = new Node(2);
      root2.right = new Node(6);

      mergeBSTs(root1, root2);
  }
}
