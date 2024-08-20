class Solution {
    public int[] resultsArray(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index1 = 0, index2 = 0;
        int[] res = new int[nums.length - k + 1];

        while (index1 < nums.length && index2 < res.length) {
            if (deque.isEmpty() || nums[index1] - deque.peekLast()  == 1) {
                deque.offer(nums[index1]);
            }
            else {
                while (index2 < res.length && !deque.isEmpty()) {
                    deque.pollFirst();
                    res[index2] = -1;
                    index2++;
                }
                deque.offer(nums[index1]);
            }

            if (deque.size() == k) {
                res[index2] = deque.peekLast();
                deque.pollFirst();
                index2++;
            }

            index1++;
        }

        return res;
    }
}