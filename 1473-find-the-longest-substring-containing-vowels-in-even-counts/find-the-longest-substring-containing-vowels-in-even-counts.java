class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = Map.of('a', 0, 'e', 1, 'i', 2, 'o', 3, 'u', 4);
        Map<Integer, Integer> m = new HashMap<>();
        int n = s.length();
        int mask = 0;
        m.put(0, -1);
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) mask = mask ^ (1 << map.get(s.charAt(i)));
            if (m.containsKey(mask)) res = Math.max(res, i - m.get(mask));
            if (!m.containsKey(mask)) m.put(mask, i);
        }

        return res;
    }
}
