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

    public int sumEvenGrandparent(TreeNode root) {
        return findSum(root);
    }

    private int findSum(TreeNode root) {
        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) sum += root.left.left.val;
                if (root.left.right != null) sum += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null) sum += root.right.left.val;
                if (root.right.right != null) sum += root.right.right.val;
            }
        }

        if (root.left != null) sum += findSum(root.left);
        if (root.right != null) sum += findSum(root.right);
        return sum;
    }
}