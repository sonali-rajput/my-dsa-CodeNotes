package linkedLists;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(0);
        head2.next.next.next = new ListNode(-4);
        head2.next.next.next.next = head2.next; // Creates a cycle

        LinkedListCycle detector = new LinkedListCycle();

        System.out.println("Has Cycle (head2)? " + detector.hasCycle(head2));  // true
    }

    public boolean hasCycle(ListNode head) {
        
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {

            if(fast == slow) {
                return true;
            }

            slow = slow.next; // one step
            fast = fast.next.next; // two step  
        }

        return false;


    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
