class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];

        for (char c : letters) {
            count[c - 'a']++;
        }

        return findMaxScore(words, count, score, 0);
    }

    private int findMaxScore(String[] words, int[] count, int[] score, int index) {
        int maxScore = 0;

        for (int i = index; i < words.length; i++) {
            int currScore = 0;
            String word = words[i];
            boolean isValid = true;

            for (char c : word.toCharArray()) {
                count[c - 'a']--;
                currScore += score[c - 'a'];
                if (count[c - 'a'] < 0) isValid = false;
            }

            if (isValid) {
                currScore += findMaxScore(words, count, score, i + 1);
                maxScore = Math.max(maxScore, currScore);
            }

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            currScore = 0;
        }

        return maxScore;
    }
}