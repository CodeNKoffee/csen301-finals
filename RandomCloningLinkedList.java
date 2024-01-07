// SOURCE: GeeksForGeeks: (https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/)

class Node {
  int data;
  Node next, arbit;

  public Node(int data) {
    this.data = data;
    this.next = this.arbit = null;
  }
}

class ClonedLinkList {
  public static Node cloneLinkedList(Node head) {
    if (head == null)
      return null;

    // Step 1: Create a copy of each node and insert it next to the original node
    Node current = head;
    while (current != null) {
      Node copyNode = new Node(current.data);
      copyNode.next = current.next;
      current.next = copyNode;
      current = copyNode.next;
    }
    
    // Step 2: Assign random pointers for the copied nodes
    current = head;
    while (current != null) {
      if (current.arbit != null) 
        current.next.arbit = current.next;

      current = current.next.next;
    }

    // Step 3: Separate the original and copied linked lists
    Node original = head;
    Node copied = head.next;
    Node copiedHead = copied;
    
    while (original != null) {
      original.next = original.next.next;
      original = original.next;

      if (copied.next != null) {
        copied.next = copied.next.next;
        copied = copied.next;
      }
    }

    return copiedHead;
  }

  public static void printList(Node head) {
    System.out.print(head.data + "(" + head.arbit.data + ")");
    head = head.next;
    while (head != null) {
      System.out.print(" -> " + head.data + "(" + head.arbit.data + ")");
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Creating a linked list with random pointer
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.arbit = head.next.next;
    head.next.arbit = head;
    head.next.next.arbit = head.next.next.next.next;
    head.next.next.next.arbit = head.next.next;
    head.next.next.next.next.arbit = head.next;

    // Print the original list
    System.out.println("The original linked list:");
    printList(head);

    // Function call
    Node sol = cloneLinkedList(head);

    System.out.println("The cloned linked list:");
    printList(sol);
  }
}


