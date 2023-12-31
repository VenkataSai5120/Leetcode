class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            findLexOrder(i, n, res);
        }

        return res;
    }

    private void findLexOrder(int num, int n, List<Integer> res) {
        if (num > n) return;

        res.add(num);
        for (int i = 0; i <= 9; i++) {
            findLexOrder(num * 10 + i, n, res);
        }
    }
}