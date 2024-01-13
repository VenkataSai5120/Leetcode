class Solution {
    public int minSteps(String s, String t) {
        int[] fre = new int[26];
        for (char c : t.toCharArray()) fre[c - 'a']++;
        for (char c : s.toCharArray()) fre[c - 'a']--;
        int minSteps = 0;

        for (int f : fre) {
            if (f > 0) minSteps += f;
        }

        return minSteps;
    }
}