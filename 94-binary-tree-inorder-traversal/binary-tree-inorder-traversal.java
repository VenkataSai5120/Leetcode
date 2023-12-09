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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                inOrder.add(root.val);
                root = root.right;
            }
            else {
                TreeNode rMost = root.left;

                while (rMost.right != null && rMost.right != root) {
                    rMost = rMost.right;
                }

                if (rMost.right == null) {
                    rMost.right = root;
                    root = root.left;
                }
                else {
                    rMost.right = null;
                    inOrder.add(root.val);
                    root = root.right;
                }
            }
        }

        return inOrder;
    }
}