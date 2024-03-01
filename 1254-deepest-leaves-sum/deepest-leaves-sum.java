/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxHeight = 0;
    int leaveSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        findDeepestLeaveSum(root, 0, null);
        return leaveSum / 2;
    }

    private void findDeepestLeaveSum(TreeNode root, int height, TreeNode par) {
        if (root == null) {
            if (height > maxHeight) {
                maxHeight = height;
                leaveSum = par.val;
            }
            else if (maxHeight == height) {
                leaveSum += par.val;
            }
            return;
        }

        findDeepestLeaveSum(root.left, height + 1, root);
        findDeepestLeaveSum(root.right, height + 1, root);
    }
}