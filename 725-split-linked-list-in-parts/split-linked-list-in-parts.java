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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr = root;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int partLength = size / k, extra = size % k;

        ListNode[] ans = new ListNode[k];
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(0), dup = head;

            for (int j = 0; j < partLength + (i < extra ? 1 : 0); j++) {
                dup = dup.next = new ListNode(curr.val);
                if (curr != null) curr = curr.next;
            }
            
            ans[i] = head.next;
        }
        return ans;
    }
}