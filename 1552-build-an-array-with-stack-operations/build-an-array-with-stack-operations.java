class Solution {
    public List<String> buildArray(int[] target, int n) {
        int prev = 0;
        List<String> res = new ArrayList<>();
        int num = 1;

        for (int tar : target) {
            while (num != tar) {
                res.add("Push");
                num++;
            }

            int currNum = tar - 1;

            while (currNum > prev) {
                res.add("Pop");
                currNum--;
            }

            prev = tar;
            res.add("Push");
            num++;
        }

        return res;
    }
}