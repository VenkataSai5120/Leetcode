class Solution {
    private boolean almostEqual(int x, int y) {
        String s1 = Integer.toString(x), s2 = Integer.toString(y);
        int n = s1.length(), m = s2.length();
        int maxLen = Math.max(n, m);

        while (n != maxLen) {
            s1 = "0" + s1;
            n++;
        }
        while (m != maxLen) {
            s2 = "0" + s2;
            m++;
        }

        int diff = 0;
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0) + 1);
            mp2.put(s2.charAt(i), mp2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        return diff <= 2 && mp1.equals(mp2);
    }

    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (almostEqual(nums[i], nums[j])) {
                    count++;
                }
            }
        }

        return count;
    }
}
