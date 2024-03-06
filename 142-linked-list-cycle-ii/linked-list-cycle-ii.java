/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		Boolean isCycle = false;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				isCycle = true;
				break;
            }
        }

        if (!isCycle) {
            return null;
        }

        fast = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow == fast) {
            return slow;
        }

        return fast.next;
    }
}
