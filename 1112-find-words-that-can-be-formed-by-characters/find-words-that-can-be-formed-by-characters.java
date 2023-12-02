class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        int res = 0;

        for (char ch : chars.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (String w : words) {
            int[] cnt1 = new int[26];
            boolean match = true;

            for (char ch : w.toCharArray()) {
                cnt1[ch - 'a']++;
                if (cnt1[ch - 'a'] > cnt[ch - 'a']) {
                    match = false;
                    break;
                }
            }

            if (match) {
                res += w.length();
            }
        }

        return res;
    }
}
