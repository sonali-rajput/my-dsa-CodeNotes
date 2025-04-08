package linkedLists;
public class ReverseLinkedList {

    public static void main(String[] args) {
        

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        // original linked list
        System.out.println("Original list:");
        printLinkedList(head);

        // reversed
        System.out.println("reversed linked list: ");
        ListNode reverseHead = reverseList(head);
        printLinkedList(reverseHead);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current!=null) {
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
