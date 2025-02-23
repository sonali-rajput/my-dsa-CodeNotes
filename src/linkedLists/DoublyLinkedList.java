package linkedLists;

public class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail; // Keep track of the tail for efficient append


    // Insertion at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) { // empty list
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    // Insertion at the beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insertion at a given position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;
        while (current!= null && count < position-1){
            current = current.next;
            count++;
    
        }
        if (current == null) {
            System.out.println("Position out of boubds");
            return;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
    }


    // Deletion by value
    public void delete(int data){
        Node current = head;
        while(current!=null) {
            if(current.data == data) {
                if(current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Deletion by position
    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Node current = head;
        int count = 0;
        while( current != null && count < position) {
            if (count == position) {
                if (current.prev != null ) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if ( current.next != null){
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Position out of bounds");
    }


    // Traversal (forward) 
    public void traverseForward() {
        Node current = head;
        while(current!= null) {
            System.out.print(current.data + " <->");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traversal (backward)
    public void traverseBackward() {
        Node current = tail;
        while(current != null) {
            System.out.print(current.data + " <->");
            current = current.prev;
        }
        System.out.println("null");
        
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.traverseForward();
        list.traverseForward();
        list.delete(2);
        list.traverseForward();
        list.insertAtBeginning(0);
        list.traverseForward();
        list.insertAtPosition(2,2);
        list.traverseForward();
        list.deleteAtPosition(0);
        list.traverseForward();
    }

}
