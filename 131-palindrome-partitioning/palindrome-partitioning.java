class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        findValidPartitions(s, 0, res, new ArrayList<>());
        return res;
    }

    private void findValidPartitions(String s, int index, List<List<String>> res, List<String> dup) {
        if (index == s.length()) {
            res.add(new ArrayList<>(dup));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                dup.add(s.substring(index, i + 1));
                findValidPartitions(s, i + 1, res, dup);
                dup.remove(dup.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++; high--;
        }
        return true;
    }
}