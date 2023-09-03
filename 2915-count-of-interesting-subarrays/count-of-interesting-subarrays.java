class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulus, int k) {
        Map<Long, Long> mp = new HashMap<>();
        long ans = 0, prefix = 0;
        int n = nums.size();
        mp.put(0L, 1L);

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulus == k)
                prefix++;
            prefix %= modulus;
            if (mp.containsKey((prefix - k + modulus) % modulus))
                ans += mp.get((prefix - k + modulus) % modulus);
            mp.put(prefix, mp.getOrDefault(prefix, 0L) + 1);
        }
        return ans;
    }
}
