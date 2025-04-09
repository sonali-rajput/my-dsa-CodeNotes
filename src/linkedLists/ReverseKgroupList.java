package linkedLists;

public class ReverseKgroupList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
        new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

    ListNode result = reverseKGroup(head, 3);

    // Print result
    while (result != null) {
    System.out.print(result.val + " -> ");
    result = result.next;
    }
    System.out.println("null");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode ktail = null;
        ListNode prev = null;

        while ( curr != null) {
            int count = 0;
            curr = head;

            while (count<k && curr != null) {
                curr = curr.next;
                count++;
            }
            if(count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                
                if(prev == null){
                    prev = revHead;
                }

                if(ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = curr;
            }
        }

        if(ktail != null) {
            ktail.next = head;

        }

        return prev == null ? head: prev;

    }




    public static ListNode reverseLinkedList(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;

        while (k>0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

            k--;
        }

        return prev;
    }


    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
