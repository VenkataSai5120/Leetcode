class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] track = new int[26];
        int maxLen = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (track[c - 'a'] == 0) track[c - 'a'] = i + 1;
            else maxLen = Math.max(i - track[c - 'a'], maxLen);
        }

        return maxLen;
    }
}