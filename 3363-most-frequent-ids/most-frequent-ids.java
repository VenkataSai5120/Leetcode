class Solution {
    class Pair {
        int id;
        long count;

        Pair(int i, long c) {
            id = i;
            count = c;
        }
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, Long> idFreq = new HashMap<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Long.compare(p2.count, p1.count));

        for (int i = 0; i < n; i++) {
            idFreq.put(nums[i], idFreq.getOrDefault(nums[i], 0L) + freq[i]);
            maxHeap.add(new Pair(nums[i], idFreq.get(nums[i])));

            Pair cur = maxHeap.peek();
            while (idFreq.get(cur.id) != cur.count) {
                maxHeap.remove();
                cur = maxHeap.peek();
            }

            ans[i] = maxHeap.peek().count;
        }

        return ans;
    }
}
