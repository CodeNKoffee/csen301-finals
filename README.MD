# CSEN301 FINALS TRIVIA

## Clone a Linked List with next and Random Pointer

1. **Create a New Node for Each Original Node and Insert It Next to the Original Node:**
   - The linked list has nodes, and each node has two pointers: `next` points to the next node, and `arbit` points to any node in the list.
   - We want to create a clone of the linked list. To do this, we traverse the original linked list.
   - For each original node, we create a new node with the same data, and we insert it next to the original node. So, the structure becomes original_node -> copy_node -> original_node -> copy_node -> ...

2. **Assign Random Pointers for the Copied Nodes:**
   - Now, we need to set the `arbit` (random) pointers for the copied nodes.
   - While traversing the list again, for each original node, if its `arbit` pointer is pointing to some node, we set the `arbit` pointer of its corresponding copy node to the corresponding copy node.

3. **Separate the Original and Copied Linked Lists:**
   - The linked list now contains both original and copied nodes interleaved.
   - We need to separate the original and copied nodes into two separate linked lists.
   - We update the `next` pointers of the original and copied nodes accordingly.

Here's a step-by-step explanation:

- **Step 1:**
  ```
  Original: 1 -> 2 -> 3 -> 4
  After Step 1: 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4'
  ```

- **Step 2:**
  ```
  Original: 1 -> 2 -> 3 -> 4
  After Step 2: Set arbit pointers for copied nodes
  ```

- **Step 3:**
  ```
  Original: 1 -> 2 -> 3 -> 4
  Copied: 1' -> 2' -> 3' -> 4'
  After Step 3: Separate the original and copied linked lists
  ```

The final result is a cloned linked list with both `next` and `arbit` pointers, created in O(N) time complexity.

---