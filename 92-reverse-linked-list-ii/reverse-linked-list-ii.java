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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = head, pre = null, rightNode = head;
        
        for (int i = 1; i <= left - 1; i++){
            pre = leftNode;
            leftNode = leftNode.next;
        }
        
        for (int i = 1; i <= right; i++)
            rightNode = rightNode.next;
        
        ListNode curr = leftNode, p = null, next = null;
        
        while (curr != rightNode){
            next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        
       leftNode.next = rightNode;
        
        if (pre == null){
            return p;
        }
        pre.next = p;
        return head;
    }
}