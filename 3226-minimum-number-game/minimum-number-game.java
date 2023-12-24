import java.util.PriorityQueue;

public class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }
        
        int[] ans = new int[nums.length];
        int ind = 0;
        while (pq.size() != 0) {
            int a = pq.poll();
            int b = pq.poll();
            ans[ind++] = b;
            ans[ind++] = a;
        }
        return ans;
    }
}
