class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            int a = 1;
            List<Integer> add = new ArrayList<>();
            add.add(a);

            for (int j = 1; j <= i; j++) {
                a = a * (i - j + 1) / j;
                add.add(a);
            }

            res.add(add);
        }

        return res;
    }
}