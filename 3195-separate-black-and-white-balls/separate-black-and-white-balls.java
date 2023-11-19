class Solution {
    public long minimumSteps(String s) {
        int len = s.length();
        int count = 0;
        long res = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                res += count;
            }
        }
        
        return res;
    }
}