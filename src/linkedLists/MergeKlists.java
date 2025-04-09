package linkedLists;

import java.util.PriorityQueue;

public class MergeKlists {

    public static void main(String[] args) {
    // Create k sorted linked lists
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));

    // Put them in an array
    ListNode[] lists = new ListNode[]{l1, l2, l3};

    // Call mergeKLists
    MergeKlists obj = new MergeKlists();
    ListNode result = obj.mergeKLists(lists);

    // Print merged list
    while (result != null) {
        System.out.print(result.val + " ");
        result = result.next;
    }
    }

    public ListNode mergeKLists(ListNode[] lists) {
     
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(ListNode list: lists) {
            while(list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        while (!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }

        return dummy.next;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
