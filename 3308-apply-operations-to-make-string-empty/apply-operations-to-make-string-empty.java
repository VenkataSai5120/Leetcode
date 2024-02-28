class Solution {
    public String lastNonEmptyString(String s) {
        int[] fre = new int[26];
        Set<Character> lastChars = new HashSet<>();
        int maxFre = 0;
        StringBuilder lastString = new StringBuilder();

        for (char c : s.toCharArray()) {
            fre[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (fre[i] == 0) {
                continue;
            }
            else if (fre[i] > maxFre) {
                maxFre = fre[i];
                lastChars.clear();
                lastChars.add((char)(i + 'a'));
            }
            else if (fre[i] == maxFre) {
                lastChars.add((char)(i + 'a'));
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (lastChars.contains(c)) {
                lastString.append(c);
                lastChars.remove(c);
            }
        }

        return lastString.reverse().toString();
    }
}