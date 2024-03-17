class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, map.get(s.charAt(i)));

            if (i == max) {
                res.add(i - prev);
                prev = i;
            }
        }

        return res;
    }
}