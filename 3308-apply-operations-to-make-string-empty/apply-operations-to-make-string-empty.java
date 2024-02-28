class Solution {
    public String lastNonEmptyString(String s) {
        int[] fre = new int[26];
        int maxFre = 0;
        StringBuilder lastString = new StringBuilder();

        for (char c : s.toCharArray()) {
            fre[c - 'a']++;
            maxFre = Math.max(maxFre, fre[c - 'a']);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (fre[c - 'a'] == maxFre) {
                lastString.append(c);
                fre[c - 'a']--;
            }
        }

        return lastString.reverse().toString();
    }
}