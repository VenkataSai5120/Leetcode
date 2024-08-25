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
        int[] fre1 = new int[10];
        int[] fre2 = new int[10];

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            fre1[s1.charAt(i) - '0']++;
            fre2[s2.charAt(i) - '0']++;
        }

        return diff <= 2 && Arrays.equals(fre1, fre2);
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
