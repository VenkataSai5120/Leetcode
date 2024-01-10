class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return find4Sum(nums, 0, 4, target);
    }

    public List<List<Integer>> find4Sum(int[] nums, int start, int k, long target) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;

        long avgVal = target / k;
        if (nums[start] > avgVal || avgVal > nums[nums.length - 1]) return res;
        if (k == 2) return find2Sum(nums, start, target);

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> sub : find4Sum(nums, i + 1, k - 1, target - nums[i])) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(sub);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> find2Sum(int[] nums, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();

        int low = start, high = nums.length - 1;

        while (low < high) {
            while (!res.isEmpty() && low < high && nums[low] == res.get(res.size() - 1).get(0)) low++;
            while (!res.isEmpty() && low < high && nums[high] == res.get(res.size() - 1).get(1)) high--;         

            if (low == high) return res;

            if (nums[low] + nums[high] == target) res.add(Arrays.asList(nums[low++], nums[high--]));
            else if (nums[low] + nums[high] > target) high--;
            else low++;
        }

        return res;
    }
}