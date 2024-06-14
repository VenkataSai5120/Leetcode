class Solution {
    int MOD = 1_000_000_007;

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : nums) {
            pq.add(ele);
        }
        
        while (k-- > 0) {
            int minEle = pq.poll();
            pq.add(++minEle);
        }

        long maxProd = 1;

        while (!pq.isEmpty()) {
            maxProd = (maxProd * pq.poll()) % MOD;
        }

        return (int)maxProd;
    }
}