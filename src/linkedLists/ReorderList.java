package linkedLists;


public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Reorder the linked list
        reorderList(head);

        // Print the reordered linked list
        System.out.println("Reordered Linked List:");
        printLinkedList(head);
    }


    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, temp;

        while(curr!=null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // prev will be the reverse list
        ListNode first = head, second = prev;

        while(second.next != null) {

            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;

        }
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
