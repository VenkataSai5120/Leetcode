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
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String res = root.val + "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left.equals("") && right.equals("")) return  res;
        if (right.equals("")) return res + "(" + left + ")";
        if (left.equals("")) return res + "()" + "(" + right + ")";
        return res + "(" + left + ")" + "(" + right + ")";
    }
}