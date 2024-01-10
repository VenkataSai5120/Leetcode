class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), res = 0;
        int low = 0, high = 0;

        while (high < n) {
            char c1 = s.charAt(high);
            map.put(c1, map.getOrDefault(c1, 0) + 1);

            while (map.get(c1) > 1) {
                // System.out.println(high);
                char c2 = s.charAt(low);
                map.put(c2, map.get(c2) - 1);
                low++;
            }
            // System.out.println();

            res = Math.max(res, high - low + 1);
            high++;
        }
        return res;
    }
}