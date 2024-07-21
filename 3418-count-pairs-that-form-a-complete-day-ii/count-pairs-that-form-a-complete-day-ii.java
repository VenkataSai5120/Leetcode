class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        long pairs = 0;

        for (int hour : hours) {
            int val = map.getOrDefault(24 - hour % 24, 0);
            if (hour % 24 == 0) {
                val = map.getOrDefault(0, 0);
            }
            pairs += val;
            map.put(hour % 24, map.getOrDefault(hour % 24, 0) + 1);
        }

        return pairs;
    }
}
