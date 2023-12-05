class Solution {
    public int numberOfMatches(int n) {
        int countMatches = 0;

        while (n > 1) {
            countMatches += n / 2;
            n++;
            n /= 2;
        }

        return countMatches;
    }
}