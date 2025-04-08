package linkedLists;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode dummy = new ListNode(1);
        dummy.next= new ListNode(2);
        dummy.next.next= new ListNode(3);
        dummy.next.next.next= new ListNode(4);

        System.out.println("Original list: ");
        printLinkedList(dummy);

        ListNode afterRemoving = removeNthFromEnd(dummy,2);
        printLinkedList(afterRemoving);

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode front = dummy;
        ListNode back = dummy;

        for(int i=0;i<=n;i++) {
            front = front.next;
        }

        while(front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next; // deleting nth node
        return dummy.next; 
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
