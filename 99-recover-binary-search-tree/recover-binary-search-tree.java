/*
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
    TreeNode first, mid, last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (last != null) {
            first.val = first.val ^ last.val ^ (last.val = first.val);
        }
        else if (first != null && mid != null){
            first.val = first.val ^ mid.val ^ (mid.val = first.val);
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
                mid = root;
            }
            else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}