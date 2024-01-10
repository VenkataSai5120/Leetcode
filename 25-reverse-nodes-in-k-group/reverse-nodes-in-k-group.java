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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;

        while (curr != null && count != k) {
            count++;
            curr = curr.next;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode node = head.next;
                head.next = curr;
                curr = head;
                head = node;
            }

            return curr;
        }

        return head;
    }
}