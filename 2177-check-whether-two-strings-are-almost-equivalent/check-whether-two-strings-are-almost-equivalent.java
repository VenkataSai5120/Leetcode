class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] fre = new int[26];

        for (char c : word1.toCharArray()) {
            fre[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            fre[c - 'a']--;
        }

        for (int f : fre) {
            if (Math.abs(f) > 3) {
                return false;
            }
        }

        return true;
    }
}