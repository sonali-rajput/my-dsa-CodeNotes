package linkedLists;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("list1: ");
        printLinkedList(list1);

        System.out.println("list2: ");
        printLinkedList(list2);

        System.out.println("Merge sorted list: ");

        ListNode mergedList = mergeTwoLists(list1, list2);
        printLinkedList(mergedList); 


    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;
        
        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        if (merge.next == list1 && list1 == null) {
            merge.next = list2;
        } else {
            merge.next = list1;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
