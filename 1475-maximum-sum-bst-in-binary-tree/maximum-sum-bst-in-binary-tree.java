class NewNode {
    int sum;
    int maxVal;
    int minVal;

    public NewNode(int sum, int maxVal, int minVal) {
        this.sum = sum;
        this.maxVal = maxVal;
        this.minVal = minVal;
    }
}

class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        findMaxSumBST(root);
        return maxSum;
    }

    private NewNode findMaxSumBST(TreeNode root) {
        if (root == null) {
            return new NewNode(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        NewNode left = findMaxSumBST(root.left);
        NewNode right = findMaxSumBST(root.right);

        if (left.maxVal < root.val && right.minVal > root.val) {
            maxSum = Math.max(left.sum + right.sum + root.val, maxSum);
            return new NewNode(left.sum + right.sum + root.val, Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal));
        }
        maxSum = Math.max(Math.max(left.sum, right.sum), maxSum);
        return new NewNode(Math.max(left.sum, right.sum), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
