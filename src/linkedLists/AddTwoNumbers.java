package linkedLists;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Final sum of lists: ");
        ListNode addition = addTwoNumbers(l1,l2);
        printLinkedList(addition);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){

            int x = (l1 !=null)? l1.val: 0;
            int y = (l2 !=null)? l2.val: 0;
            int sum = carry + x + y;

            carry = sum/10; // carry = sum / 10 (e.g., if sum is 17, carry = 1)

            ans.next = new ListNode(sum%10);  // Create a new node with the value sum % 10 (e.g., 7)
            ans = ans.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
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
