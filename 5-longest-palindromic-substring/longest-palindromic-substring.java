class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] newStr = new char[2 * n + 1];
        newStr[0] = '*';
        int i = 1;
        for (char c : s.toCharArray()) {
            newStr[i++] = c;
            newStr[i++] = '*';
        }
        
        int[] pl = new int[2 * n + 1];

        int longestLength = 0, longestCenter = 0;
        int center = 0, right = 0;

        for (i = 0; i < newStr.length; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                pl[i] = Math.min(pl[mirror], right - i);
            }

            int a = i + (pl[i] + 1);
            int b = i - (pl[i] + 1);

            while (a < newStr.length && b >= 0 && newStr[a] == newStr[b]) {
                a++;
                b--;
                pl[i]++;
            }

            if (pl[i] > longestLength) {
                longestLength = pl[i];
                longestCenter = i;
            }

            if (i + pl[i] > right) {
                center = i;
                right = i + pl[i];
            }
        }

        String str = new String(newStr);

        return str.substring(longestCenter - longestLength, longestCenter + longestLength).replace("*", "");
    }
}