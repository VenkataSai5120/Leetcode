class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        for(char ch: s.toCharArray()) count += (ch == c) ? 1 : 0;
        return count * (count + 1) / 2;
    }
}