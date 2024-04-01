class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == ' ') index--;

        for (; index >= 0; index--) {
            if (s.charAt(index) != ' ') len++;
            else break;
        }

        return len;
    }
}