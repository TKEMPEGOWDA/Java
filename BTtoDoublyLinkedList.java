class TreeNodeDLL {
    int val;
    TreeNodeDLL left;
    TreeNodeDLL right;

    public TreeNodeDLL(int val) {
        this.val = val;
    }
}

class doublyListNode {
    int val;
    doublyListNode prev;
    doublyListNode next;

    public doublyListNode(int val) {
        this.val = val;
    }
}

public class BTtoDoublyLinkedList {
    private doublyListNode front;
    private doublyListNode back;

    public doublyListNode convertToDoublyLinkedList(TreeNodeDLL root) {
        front = null;
        back = null;
        inorderTraversal(root);
        return front;
    }

    private void inorderTraversal(TreeNodeDLL node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        doublyListNode doublyNode = new doublyListNode(node.val);

        
        if (front == null) {
            front = doublyNode;
        }

        
        if (back != null) {
            back.next = doublyNode;
            doublyNode.prev = back;
        }

       
        back = doublyNode;

       
        inorderTraversal(node.right);
    }

    public static void printList(doublyListNode front) {
        doublyListNode current = front;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNodeDLL root = new TreeNodeDLL(4);
        root.left = new TreeNodeDLL(2);
        root.right = new TreeNodeDLL(5);
        root.left.left = new TreeNodeDLL(1);
        root.left.right = new TreeNodeDLL(3);

        BTtoDoublyLinkedList converter = new BTtoDoublyLinkedList();
        doublyListNode front = converter.convertToDoublyLinkedList(root);

        System.out.println("Doubly Linked List :");
        printList(front);
    }
}
