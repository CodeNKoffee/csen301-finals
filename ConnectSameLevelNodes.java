@SuppressWarnings("rawtypes")

class Node {
  Comparable data;
  Node left, right;

  Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }
}

class BTree {
  Node root; 

  public int level(Comparable key) { 
    return level(root, key);
  }

  private int level(Node current, Comparable key) { 
    if(current == null)
      return -1; 
    
    if(((Comparable) current.data).compareTo(key) == 0)
      return 0;

    int leftDepth = level(current.left, key); 

    if(leftDepth != -1)
      return 1 + leftDepth;

    int rightDepth = level(current.right, key); 
    
    if(rightDepth != -1)
      return 1 + rightDepth; 
      
    return -1;
  }

  public LinkList nodesToLinkedList(Comparable key) {
    int targetLevel = level(key);
    LinkList nodesAtSameLevel = new LinkList();
    nodesToLinkedList(root, key, 0, nodesAtSameLevel, targetLevel);
    return nodesAtSameLevel;
  }

  private void nodesToLinkedList(Node current, Comparable key, int currentLevel, LinkList result, int targetLevel) {
    if (current == null) 
      return;

    if (currentLevel == targetLevel) {
      result.insertLast(current.data);
      return;
    }

    nodesToLinkedList(current.left, key, currentLevel + 1, result, targetLevel);
    nodesToLinkedList(current.right, key, currentLevel + 1, result, targetLevel);
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);

    LinkList result = tree.nodesToLinkedList(3);
    System.out.print(result.toString());
  }
}