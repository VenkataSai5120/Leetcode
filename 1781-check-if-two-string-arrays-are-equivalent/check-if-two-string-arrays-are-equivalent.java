class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length, n2 = word2.length, i = 0, j = 0;
        String s1 = "", s2 = "";
        
        while (i < n1 && j < n2) {
            s1 += word1[i++];
            s2 += word2[j++];
        }
        
        while (i < n1) s1 += word1[i++];
        
        while (j < n2) s2 += word2[j++];
        
        return s1.equals(s2);
    }
}
