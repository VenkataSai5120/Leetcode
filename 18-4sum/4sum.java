class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return findQuads(nums, 0, 4, target);
    }

    private List<List<Integer>> findQuads(int[] nums, int index, int k, long tar) {
        List<List<Integer>> res = new ArrayList<>();
        if (index == nums.length) return res;
        int n = nums.length;
        long avgVal = tar / k;
        if (nums[index] > avgVal || avgVal > nums[n - 1]) return res;
        if (k == 2) return findPairs(nums, index, n - 1, tar);

        for (int i = index; i < n; i++) {
            if (i == index || nums[i - 1] != nums[i]) {
                for (List<Integer> sub : findQuads(nums, i + 1, k - 1, tar - nums[i])) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(sub);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> findPairs(int[] nums, int low, int high, long tar) {
        List<List<Integer>> res = new ArrayList<>();

        while (low < high) {
            while (!res.isEmpty() && low < high && nums[low] == res.get(res.size() - 1).get(0)) low++;
            while (!res.isEmpty() && low < high && nums[high] == res.get(res.size() - 1).get(1)) high--;
            if (low == high) return res;
            if (nums[low] + nums[high] == tar) {
                res.add(Arrays.asList(nums[low], nums[high]));
                low++;
                high--;
            }
            else if (nums[low] + nums[high] > tar) high--;
            else low++;
        }

        return res;
    }
}