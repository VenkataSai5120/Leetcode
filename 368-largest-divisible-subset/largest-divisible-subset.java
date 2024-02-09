class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] find = new int[n];
        int[] hash = new int[n];
        int max = 1, maxIndex = 0;

        for (int i = 0; i < n; i++) {
            find[i] = 1;
            hash[i] = i;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && find[i] < 1 + find[j]) {
                    find[i] = 1 + find[j];
                    hash[i] = j;
                }
            }

            if (find[i] > max) {
                max = find[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[maxIndex]);

        while (maxIndex != hash[maxIndex]) {
            maxIndex = hash[maxIndex];
            res.add(nums[maxIndex]);
        }
        Collections.reverse(res);
        return res;
    }
}