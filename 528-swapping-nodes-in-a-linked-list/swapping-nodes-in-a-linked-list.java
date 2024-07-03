/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kthEnd = head, kthBeginning = head;
        
        for (int i = 1; i < k; i++) {
            kthEnd = kthEnd.next;
        }

        ListNode dup = kthEnd;
        System.out.println(kthEnd.val);

        while (dup.next != null) {
            dup = dup.next;
            kthBeginning = kthBeginning.next;
        }
        System.out.println(kthEnd.val);

        swap(kthEnd, kthBeginning);
        return head;
    }

    private void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}