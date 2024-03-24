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
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode first = head, second = mid.next;
        mid.next = null;
        second = reverse(second);
        head = new ListNode(0);
        ListNode temp = head;

        while (first != null || second != null) {
            if (first != null) {
                temp.next = first;
                temp = temp.next;
                first = first.next;
            }

            if (second != null) {
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }

        head = head.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null, next = null;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}