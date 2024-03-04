class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1, res = 0, points = 0;
        
        while (i <= j){
            if (power >= tokens[i]){
                points++;
                res = Math.max(res, points);
                power -= tokens[i++];
            }
            else if (points > 0){
                power += tokens[j--];
                points--;
            }
            else break;
        }
        
        return res;
    }
}