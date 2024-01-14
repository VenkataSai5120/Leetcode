class Solution {
    public boolean closeStrings(String word1, String word2) {
        var n1 = word1.length();
        var n2 = word2.length();

        if (n1 != n2) return false;

        var fre1 = new int[26];
        var fre2 = new int[26];

        for (var i = 0; i < n1; i++) 
        {fre1[word1.charAt(i) - 'a']++; fre2[word2.charAt(i) - 'a']++;}

        for (var i = 0; i < 26; i++) {
            if ((fre1[i] == 0 || fre2[i] == 0) && (fre1[i] > 0 || fre2[i] > 0)) return false;
        }

        Arrays.sort(fre1); Arrays.sort(fre2);

        for (var i = 0; i < 26; i++) if (fre1[i] != fre2[i]) return false;

        return true;
    }
}