class Solution {
    public int firstUniqChar(String s) {
        int[] alp = new int[26];
        
        for (int i = 0; i < s.length(); i++){
            alp[s.charAt(i) - 97]++;
        }
        
        for (int i = 0; i < s.length(); i++){
            if (alp[s.charAt(i) - 97] == 1)
                return i;
        }
        
        return -1;
    }
}