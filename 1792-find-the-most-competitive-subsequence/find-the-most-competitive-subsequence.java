class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int remove = n - k;

        for (int i = 0; i < n; i++) {
            // int rem = k - stack.size();
            
            // if (n - i == rem) {
            //     stack.push(nums[i]);
            //     continue;
            // }

            while (!stack.isEmpty() && remove > 0 &&  stack.peek() > nums[i]) {
                stack.pop();
                remove--;
            }
            stack.push(nums[i]);
        }

        while (stack.size() > k) stack.pop();

        for (int ele : stack) {
            res[index++] = ele;
        }

        return res;
    }
}