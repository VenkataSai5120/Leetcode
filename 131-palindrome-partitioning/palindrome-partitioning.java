class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        find(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void find(String s, List<List<String>> res, List<String> ds, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                find(s, res, ds, i + 1);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }

        return true;
    }
}