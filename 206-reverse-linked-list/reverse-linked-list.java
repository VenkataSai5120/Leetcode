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
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode nextNode=null;
        while(cur!=null){
            nextNode=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextNode;
        }
        return pre;
        
    }
}