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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preRight = dummy, preLeft = dummy;
        ListNode right = head, left = head;
        
        for (int i = 0; i < k - 1; i++) {
            preLeft = left;
            left = left.next;
        }
        
        ListNode nullChecker = left;
        
        while (nullChecker.next != null) {
            preRight = right;
            right = right.next;
            nullChecker = nullChecker.next;
        }
        
        if (left == right) {
            return head;
        }
        
        preLeft.next = right;
        preRight.next = left;
        
        ListNode temp = left.next;
        left.next = right.next;
        right.next = temp;
        
        return dummy.next;
    }
}
