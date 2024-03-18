class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getKey().equals(b.getKey())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey() - b.getKey();
        });

        long sum = 0;
        long[] res = new long[queries.length];

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair<>(nums[i], i));
            sum += nums[i];
        }

        int i = 0;
        for (int[] query : queries) {
            int index = query[0];
            int k = query[1];
            sum -= nums[index];
            nums[index] = 0;

            while (!pq.isEmpty() && k > 0) {
                if (nums[pq.peek().getValue()] != 0) {
                    sum -= pq.peek().getKey();
                    nums[pq.peek().getValue()] = 0;
                    k--;
                }
                pq.poll();
            }

            res[i++] = sum;
        }

        return res;
    }
}