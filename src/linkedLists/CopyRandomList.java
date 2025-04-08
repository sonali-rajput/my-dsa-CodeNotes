package linkedLists;

import java.util.HashMap;

public class CopyRandomList {


    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();


    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        if(this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }

        Node node = new Node(head.val,null,null); // Create a New Node
        this.visitedNode.put(head,node); //Store It in HashMap

        node.next = copyRandomList(head.next); // Recursive call for next and random
        node.random = copyRandomList(head.random);

        return node;
    }

    public static class  Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        // Create 3 nodes
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, null, null);

        // Connect next pointers
        node1.next = node2;
        node2.next = node3;

        // Set random pointers
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        // Clone the list
        CopyRandomList copier = new CopyRandomList();
        Node copiedHead = copier.copyRandomList(node1);

        // Print the copied list to verify
        System.out.println("Original and copied lists:");
        printList(node1, "Original");
        printList(copiedHead, "Copied");
    }

    // 👇 Helper to print list
    public static void printList(Node head, String label) {
        System.out.println(label + " list:");
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node val: " + temp.val + ", Random points to: " + randomVal);
            temp = temp.next;
        }
        System.out.println();
    }
}
