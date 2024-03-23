class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> unique = new ArrayList<>();
        int maxLen = 0;

        for (String s : arr) {
            Integer bin = 0;
            for (char c : s.toCharArray()) {
                bin |= (1 << c);
            }
            if (Integer.bitCount(bin) == s.length()) {
                unique.add(bin);
            }
        }

        List<Integer> possibilities = new ArrayList<>();
        possibilities.add(0);

        for (Integer uni : unique) {
            for (int i = possibilities.size() - 1; i >= 0; i--) {
                if ((possibilities.get(i) & uni) == 0) {
                    Integer newPos = possibilities.get(i) | uni;
                    possibilities.add(newPos);
                    maxLen = Math.max(maxLen, Integer.bitCount(newPos));
                }
            }
        }

        return maxLen;
    }
}