class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        
        while (curr != null) {
            sum += curr.val;
            
            if (map.containsKey(sum)) {
                curr = map.get(sum).next;
                int s = curr.val + sum;
                
                while (s != sum) {
                    map.remove(s);
                    curr = curr.next;
                    s += curr.val;
                }
                
                map.get(sum).next = curr.next; 
            } else {
                map.put(sum, curr);
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
