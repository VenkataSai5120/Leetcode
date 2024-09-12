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
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curNode = head;
        while(curNode.next != null) {
            int gcd = gcd(curNode.val, curNode.next.val);
            ListNode node = new ListNode(gcd);
            node.next = curNode.next;
            curNode.next = node;
            curNode = curNode.next.next;
        }
        return head;
    }
}