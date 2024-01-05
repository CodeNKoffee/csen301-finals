package eleven;

class Node {
  public int key;
  public Node next;
}

class SList {
  private Node head;

  public boolean isSortAsc() {
    if (head == null) 
      return true;
    
    Node node = head;
    while (node.next != null) {
      if (node.key > node.next.key)
        return false;
      else
        node = node.next;
    }
    return true;
  }

  public boolean putInPlace(int x) {
    if (!isSortAsc())
      return false;

    Node newNode = new Node();
    newNode.key = x;

    if (head == null || x <= head.key) {
      newNode.next = head;
      head = newNode;
      return true;
    }

    Node node = head;
    while (node.next != null && x > node.next.key) 
      node = node.next;

    newNode.next = node.next;
    node.next = newNode;
    
    return true;
  }
}


// 5 - 1, 2, 3, 4, 5, 6