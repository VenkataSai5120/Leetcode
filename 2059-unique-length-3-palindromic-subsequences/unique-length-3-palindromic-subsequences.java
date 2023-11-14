class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, 1_000_007);
        int countPal = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            first[c - 'a'] = Math.min(i, first[c - 'a']);
            last[c - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                countPal += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }

        return countPal;
    }
}