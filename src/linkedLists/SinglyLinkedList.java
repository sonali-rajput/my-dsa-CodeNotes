package linkedLists;

public class SinglyLinkedList {

    // Node Class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head; // Head of the linked list

    // Insertion at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insertion at the beginning.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at a given position
    public void insertAtPosition(int data, int position) {
        if(position == 0){
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 0;

        while(current != null && count < position -1) {
            current = current.next;
            count++;
        }

        if(current == null){
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Deletion by value
    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Deletion by position.
    public void deleteAtPosition(int position) {
        if(head == null) {
            return;
        }
        if(position == 0){
            head = head.next;
            return;
        }

        Node current = head;
        int count = 0;

        while(current != null && count < position -1) {
            current = current.next;
            count++;
        }

        if(current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
    }


    //Traversal

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.traverse();
        list.delete(2);
        list.traverse();
        list.insertAtBeginning(0);
        list.traverse();
        list.insertAtPosition(2,2);
        list.traverse();
        list.deleteAtPosition((0));
        list.traverse();

    }

}
