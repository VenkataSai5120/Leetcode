class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] alp = new int[26];
        for (int i = 0; i < t.length(); i++){
            alp[s.charAt(i) - 97]++;
            alp[t.charAt(i) - 97]--;
        }
        
        for (int i = 0; i < s.length(); i++){
            if (alp[t.charAt(i) - 97] != 0)
                return false;
        }
        
        return true;
    }
}